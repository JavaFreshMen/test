package com.njusoft.its.datasource.db.quartz;

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
import com.njusoft.its.domain.SystemConfig;
import com.njusoft.its.service.impl.SystemConfigServiceImpl;

/** 
* 系统配置定时更新定时器
* @author 作者 E-mail:857332533@qq.com 
* @date 创建时间：2017年10月25日 下午5:08:41 
* @version 1.0 
* @since JDK 1.7
*/
@Component
@QuartzTimerConfiguration(jobClass=SystemConfigDBTimer.class,
	cronExpression="0 0 0/3 * * ?",jobName="SystemConfigDBTimer")
@QuartzTimerBeanConfiguration(beanNames={SystemConfigServiceImpl.class})
public class SystemConfigDBTimer implements Job{
	
	private final static Logger logger = Logger.getLogger(SystemConfigDBTimer.class);
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		JobDetail jobDetail = context.getJobDetail();
		JobDataMap jobDataMap = jobDetail.getJobDataMap();
		SystemConfigServiceImpl service = (SystemConfigServiceImpl)jobDataMap.get("SystemConfigServiceImpl");
		try {
			//此处实现业务处理逻辑
			Map<String, List<SystemConfig>> map = service.loadSystemConfigsMap();
			logger.info("start to update systemConfigs: size: "+map.size());	
			DataSourceCenter.sysConfigMap.clear();
			//更新数据源
			for(Entry<String, List<SystemConfig>> entry:map.entrySet()){
				DataSourceCenter.sysConfigMap.put(entry.getKey(), entry.getValue());
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
	}
}
