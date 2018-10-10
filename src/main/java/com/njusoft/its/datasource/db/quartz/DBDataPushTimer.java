package com.njusoft.its.datasource.db.quartz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
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

import com.njusoft.its.core.quartz.QuartzTimerConfiguration;
import com.njusoft.its.datasource.DataSourceCenter;
import com.njusoft.its.domain.Bus;
import com.njusoft.its.domain.Line;
import com.njusoft.its.domain.Station;
import com.njusoft.its.domain.SystemConfig;
import com.njusoft.its.utils.Utils;

/** 
* 数据定时推送
* @author 作者 E-mail:857332533@qq.com 
* @date 创建时间：2017年10月26日 上午10:45:46 
* @version 1.0 
* @since JDK 1.7
*/
@Component
@QuartzTimerConfiguration(jobClass=DBDataPushTimer.class,
	cronExpression="0 0/10 * * * ?",jobName="DBDataPushTimer")
public class DBDataPushTimer implements Job{
	private final static Logger logger = Logger.getLogger(DBDataPushTimer.class);

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub
		
	}

	/*@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		JobDetail jobDetail = context.getJobDetail();
		JobDataMap jobDataMap = jobDetail.getJobDataMap();
		try {
			//推送车辆数据
			pushBusDBData(jobDataMap);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
	}*/

}
