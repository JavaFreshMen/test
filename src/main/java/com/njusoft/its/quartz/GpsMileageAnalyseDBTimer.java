package com.njusoft.its.quartz;

import java.util.Arrays;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.njusoft.its.core.quartz.QuartzTimerBeanConfiguration;
import com.njusoft.its.core.quartz.QuartzTimerConfiguration;
import com.njusoft.its.gps.analyse.GPSMileageAnalyseMgr;
import com.njusoft.its.service.impl.GpsMileageServiceImpl;
import com.njusoft.its.service.impl.LastLocationServiceImpl;
import com.njusoft.its.utils.SystemDateUtils;

@Component
@QuartzTimerConfiguration(jobClass = GpsMileageAnalyseDBTimer.class, cronExpression = "*/20 * * * * ?", jobName = "GpsMileageAnalyseDBTimer")
@QuartzTimerBeanConfiguration(beanNames = { GpsMileageServiceImpl.class,LastLocationServiceImpl.class})
public class GpsMileageAnalyseDBTimer implements Job {
	private final static Logger logger = LoggerFactory.getLogger(GpsMileageAnalyseDBTimer.class);

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		long sMills=System.currentTimeMillis();
		JobDetail jobDetail = context.getJobDetail();
		JobDataMap jobDataMap = jobDetail.getJobDataMap();
		GpsMileageServiceImpl gpsMileageServiceImpl= (GpsMileageServiceImpl)jobDataMap.get("GpsMileageServiceImpl");
		LastLocationServiceImpl  lastLocationServiceImpl= (LastLocationServiceImpl)jobDataMap.get("LastLocationServiceImpl");
		try {
			//1.查询参数
			String workDate =SystemDateUtils.lastDate();
			List<String> busCodeList=lastLocationServiceImpl.loadLastLocationBusCodes(workDate, workDate, null, null);
			String[] busCodes=new String[busCodeList.size()];
			busCodeList.toArray(busCodes);
			//2.删除分析日期所有数据
			gpsMileageServiceImpl.delete(workDate, workDate, null,null);
			//3.分析
			try {
				GPSMileageAnalyseMgr.getInstance().analyseBusCodes(workDate, Arrays.asList(busCodes));
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				logger.info("【定时任务:gps里程分析（{}）】耗时 {}ms",workDate,(System.currentTimeMillis()-sMills));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
	}
}
