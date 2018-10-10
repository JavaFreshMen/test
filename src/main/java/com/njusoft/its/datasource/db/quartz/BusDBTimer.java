package com.njusoft.its.datasource.db.quartz;

import java.util.Arrays;
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
import com.njusoft.its.datasource.db.DBDataSourceTypes;
import com.njusoft.its.datasource.db.DBDataSourceUpdateMgr;
import com.njusoft.its.domain.Bus;
import com.njusoft.its.service.impl.BusServiceImpl;

/** 
* 更新线路基本信息任务
* @author 作者 E-mail:857332533@qq.com 
* @date 创建时间：2017年10月27日 上午10:44:32 
* @version 1.0 
* @since JDK 1.7
*/
@Component
@QuartzTimerConfiguration(jobClass=BusDBTimer.class,
	cronExpression="0 0/50 * * * ?",jobName="BusDBTimer")
@QuartzTimerBeanConfiguration(beanNames={BusServiceImpl.class})
public class BusDBTimer implements Job{
	private final static Logger logger = Logger.getLogger(BusDBTimer.class);

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		JobDetail jobDetail = context.getJobDetail();
		JobDataMap jobDataMap = jobDetail.getJobDataMap();
		BusServiceImpl busService = (BusServiceImpl)jobDataMap.get("BusServiceImpl");
		try {
			//此处实现业务处理逻辑
			Map<String, Bus> busesMap = busService.loadBusesMap();
			logger.info("start to update buses size: "+busesMap.size());	
			//更新数据源
			for(Entry<String, Bus> entry:busesMap.entrySet()){
				DBDataSourceUpdateMgr.dealDBDatas(DBDataSourceTypes.DB_BUS, Arrays.asList(new Bus[]{entry.getValue()}));
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		
	}

}
