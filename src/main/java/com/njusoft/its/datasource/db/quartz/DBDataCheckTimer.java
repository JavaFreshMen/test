package com.njusoft.its.datasource.db.quartz;
/** 
* 主要负责DB数据是否存在检测
* 如果不存在则触发更新
* 保证基础静态数据一直存在
* @author 作者 E-mail:857332533@qq.com 
* @date 创建时间：2017年10月27日 上午11:00:10 
* @version 1.0 
* @since JDK 1.7
*/


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

import com.njusoft.its.core.quartz.QuartzTimerBeanConfiguration;
import com.njusoft.its.core.quartz.QuartzTimerConfiguration;
import com.njusoft.its.datasource.DataSourceCenter;
import com.njusoft.its.datasource.db.DBDataSourceTypes;
import com.njusoft.its.datasource.db.DBDataSourceUpdateMgr;
import com.njusoft.its.domain.Bus;
import com.njusoft.its.domain.SystemConfig;
import com.njusoft.its.service.SystemConfigService;
import com.njusoft.its.service.impl.BusServiceImpl;

@Component
@QuartzTimerConfiguration(jobClass=DBDataCheckTimer.class,
	cronExpression="0/2 * * * * ?",jobName="DBDataCheckTimer")
@QuartzTimerBeanConfiguration(beanNames={SystemConfigService.class,BusServiceImpl.class
		})
public class DBDataCheckTimer implements Job{
	private final static Logger logger = Logger.getLogger(DBDataCheckTimer.class);

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		JobDetail jobDetail = context.getJobDetail();
		JobDataMap jobDataMap = jobDetail.getJobDataMap();
		try {
			//检测系统配置
			checkSystemConfigsDataSource(jobDataMap);
			//检测车辆数据
			checkBusesDataSource(jobDataMap);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		
	}
	
	/**
	 * 检测系统配置
	 * @param jobDataMap
	 * @return
	 */
	private boolean checkSystemConfigsDataSource(JobDataMap jobDataMap){
		SystemConfigService service = (SystemConfigService)jobDataMap.get("SystemConfigService");
		try {
			if(DataSourceCenter.sysConfigMap.size() < 1){
				//此处实现业务处理逻辑
				Map<String, List<SystemConfig>> map = service.loadSystemConfigsMap();
				logger.info("start to update systemConfigs: size: "+map.size());	
				DataSourceCenter.sysConfigMap.clear();
				//更新数据源
				for(Entry<String, List<SystemConfig>> entry:map.entrySet()){
					DataSourceCenter.sysConfigMap.put(entry.getKey(), entry.getValue());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("更新系统配置数据异常! "+e.getMessage());
		}
		return true;
	}
	
	/**
	 * 检测车辆
	 * @param jobDataMap
	 * @return
	 */
	private boolean checkBusesDataSource(JobDataMap jobDataMap){
		BusServiceImpl busService = (BusServiceImpl)jobDataMap.get("BusServiceImpl");
		try {
			if(DataSourceCenter.busesMap.size() < 1){
				//此处实现业务处理逻辑
				Map<String, Bus> busesMap = busService.loadBusesMap();	
				//更新数据源
				for(Entry<String, Bus> entry:busesMap.entrySet()){
					DBDataSourceUpdateMgr.dealDBDatas(DBDataSourceTypes.DB_BUS, Arrays.asList(new Bus[]{entry.getValue()}));
				}
				logger.info("start to update buses size: "+busesMap.size());
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("更新车辆数据异常! "+e.getMessage());
		}
		return true;
	}
}
