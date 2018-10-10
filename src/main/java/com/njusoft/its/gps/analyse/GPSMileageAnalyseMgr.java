package com.njusoft.its.gps.analyse;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.njusoft.its.core.global.GlobalApplicationContext;
import com.njusoft.its.datasource.DataSourceCenter;
import com.njusoft.its.domain.Bus;
import com.njusoft.its.domain.DispatchPlan;
import com.njusoft.its.domain.GpsMileage;
import com.njusoft.its.domain.Location;
import com.njusoft.its.gps.analyse.loader.DefaultDispatchPlanLoader;
import com.njusoft.its.gps.analyse.loader.DefaultGPSLoader;
import com.njusoft.its.service.GpsMileageService;
import com.njusoft.its.service.impl.GpsMileageServiceImpl;
import com.njusoft.its.utils.DateUtil;
import com.njusoft.its.utils.SystemUtils;
import com.njusoft.its.utils.Utils;
public class GPSMileageAnalyseMgr {
	private Logger logger = LoggerFactory.getLogger(GPSMileageAnalyseMgr.class);
	private final static GPSLoader gpsLoader = new DefaultGPSLoader();
	private final static DispatchPlanLoader dispatchPlanLoader = new DefaultDispatchPlanLoader();
	private final static GpsMileageService gpsMileageService=  GlobalApplicationContext.applicationContext.getBean(GpsMileageServiceImpl.class);
	private final static GPSMileageAnalyseMgr gpsMileageAnalyseMgr = new GPSMileageAnalyseMgr();
	private double maxDistanceAllowed;
	private double maxSpeedAllowed;
	private GPSMileageAnalyseMgr() {
		 maxDistanceAllowed=Double.valueOf(SystemUtils.loadValidConfig("analyseGpsMileage","maxDistanceAllowed"));
		 maxSpeedAllowed=Double.valueOf(SystemUtils.loadValidConfig("analyseGpsMileage","maxSpeedAllowed"));
	}
	/**
	 * 单例 饿汉式
	 * 
	 * @return
	 */
	public static GPSMileageAnalyseMgr getInstance() {
		return gpsMileageAnalyseMgr;
	}
	

	/**
	 * 分析车辆GPS数据
	 * 
	 * @param busCodes
	 * @return
	 * @throws Exception 
	 */
	public boolean analyseBusCodes(String workDate, List<String> busCodes) throws Exception {
		Date curtime=new Date();
		//step1.校验参数集合有效性
		if (!Utils.validateStringNull(workDate)) {
			 logger.error("日期参数:"+workDate+"无效");
			 new Exception("日期参数:"+workDate+"无效");
			return false;
		}
		if (null == busCodes || busCodes.isEmpty()) {
			 logger.error(workDate+"的车辆编号参数:"+busCodes+"无效");
			 new Exception(workDate+"的车辆编号参数:"+busCodes+"无效");
			return false;
		}
		//按当日车分析
		for (String busCode : busCodes) {
			long startTime = System.currentTimeMillis();
			//加载对应日期、车辆的流水计划
			List<DispatchPlan> dispatchPlans=dispatchPlanLoader.getDispatchPlans(workDate, busCode).get(busCode);
			// 加载GPS数据
			List<Location> locations = gpsLoader.loadLocation(workDate, busCode);
			if(!(locations!=null&&locations.size()>0)){
				logger.info("分析日期【{}】车辆【{}】耗时【{}】:没有gps数据!!!",workDate,busCode,System.currentTimeMillis() - startTime);
				return true;
			}
			//辅助变量
			Location curLocation=null;
			//gps总里程相关
			double lastMileage=0.0;
			double curMileage=0.0;
			long lastOccurtimeMills=0L;
			long curOccurtimeMills=0L;
			//营运里程相关
			long sCurPlanMills=0L;
			long eCurPlanMills=0L;
			int  dispatchPlanPoint=0;
			if(dispatchPlans!=null&&dispatchPlans.size()>0){
				sCurPlanMills=dispatchPlans.get(dispatchPlanPoint).getRealRunTime().getTime();
				eCurPlanMills=dispatchPlans.get(dispatchPlanPoint).getRealArriveTime().getTime();
			}
			//统计值
			double totalMileage=0.0;
			double operationMileage=0.0;
			List<GpsMileage> results=new ArrayList<>();
			try {
				for (int i = 0; i < locations.size(); i++) {
					curLocation=locations.get(i);
					curMileage=curLocation.getRunMileage();
					curOccurtimeMills=curLocation.getOccurTime().getTime();
					//如果异常值出现在第一个点怎么办
					if (i==0) {
						//gps总里程
						totalMileage+=curMileage;
						//营运里程累计
						if (curOccurtimeMills>eCurPlanMills) {
							dispatchPlanPoint++;
							if(dispatchPlans!=null&&dispatchPlans.size()>dispatchPlanPoint){
								sCurPlanMills=dispatchPlans.get(dispatchPlanPoint).getRealRunTime().getTime();
								eCurPlanMills=dispatchPlans.get(dispatchPlanPoint).getRealArriveTime().getTime();
							}
						}
						if(curOccurtimeMills>=sCurPlanMills&&curOccurtimeMills<=eCurPlanMills){
							operationMileage+=curMileage;
						}
						//更新辅助值
						lastMileage=curMileage;
						lastOccurtimeMills=curOccurtimeMills;
					}else{
						//后一个gps里程小于前一个gps里程
						if((curMileage-lastMileage)<0){
							lastMileage=curMileage;
							lastOccurtimeMills=curOccurtimeMills;
							//System.out.println("后一个gps里程小于前一个gps里程"+curLocation);
							continue;
						}
						//后一个gps里程远大于前一个gps里程
						if((curMileage-lastMileage)>maxDistanceAllowed){
							//System.out.println("后一个gps里程远大于前一个gps里程"+curLocation);
							double realSpeed=((curMileage-lastMileage)/((curOccurtimeMills-lastOccurtimeMills)/1000))*60*60/1000;//km/h
							//System.out.println(realSpeed+"=(("+curMileage+"-"+lastMileage+")/(("+curOccurtimeMills+"-"+lastOccurtimeMills+")/"+1000+"))*"+60+"*"+60+"/"+1000);
							if (realSpeed>maxSpeedAllowed) {
								//更新辅助值
								lastMileage=curMileage;
								lastOccurtimeMills=curOccurtimeMills;
								continue;
							}else{
								//gps里程累计
								totalMileage+=curMileage-lastMileage;
								//营运里程累计
								if (curOccurtimeMills>eCurPlanMills) {
									dispatchPlanPoint++;
									if(dispatchPlans!=null&&dispatchPlans.size()>dispatchPlanPoint){
										sCurPlanMills=dispatchPlans.get(dispatchPlanPoint).getRealRunTime().getTime();
										eCurPlanMills=dispatchPlans.get(dispatchPlanPoint).getRealArriveTime().getTime();
									}
								}
								if(curOccurtimeMills>=sCurPlanMills&&curOccurtimeMills<=eCurPlanMills){
									operationMileage+=curMileage-lastMileage;
								}
								//更新辅助值
								lastMileage=curMileage;
								lastOccurtimeMills=curOccurtimeMills;
							}
						}
						//正常情况
						if((curMileage-lastMileage)>=0&&(curMileage-lastMileage)<=maxDistanceAllowed){
							//gps里程累计
							totalMileage+=curMileage-lastMileage;
							//营运里程累计
							if (curOccurtimeMills>eCurPlanMills) {
								dispatchPlanPoint++;
								if(dispatchPlans!=null&&dispatchPlans.size()>dispatchPlanPoint){
									sCurPlanMills=dispatchPlans.get(dispatchPlanPoint).getRealRunTime().getTime();
									eCurPlanMills=dispatchPlans.get(dispatchPlanPoint).getRealArriveTime().getTime();
								}
							}
							if(curOccurtimeMills>=sCurPlanMills&&curOccurtimeMills<=eCurPlanMills){
								operationMileage+=curMileage-lastMileage;
							}
							//
							lastMileage=curMileage;
							lastOccurtimeMills=curOccurtimeMills;
						}
					}
				}
				Bus bus = DataSourceCenter.busesMap.get(busCode);
				if (bus!=null) {
					GpsMileage model=new GpsMileage();
					//基础信息
					model.setLineCode(bus.getLineCode());
					model.setBusCode(bus.getBusCode());
					model.setBusBrandNo(bus.getBusBrandNo());
					model.setWorkDate(DateUtil.stringToDate(workDate));
					model.setTotalGpsMileage(new Double(totalMileage).intValue());
					model.setOperationMileage(new Double(operationMileage).intValue());
					model.setEmptyMileage(new Double(totalMileage-operationMileage).intValue());
					model.setCreateTime(curtime);
					//model.setCreator(creator);
					results.add(model);
				}
				
			} catch (Exception e) {
				logger.error("分析gps行驶里程异常", e);
			}finally {
				logger.info("分析日期【{}】车辆【{}】耗时【{}】",workDate,busCode,System.currentTimeMillis() - startTime);
			}
			gpsMileageService.saveOrUpdate(results);
		}
		return true;
	}
}
