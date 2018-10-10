package com.njusoft.its.gps.analyse.loader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeansException;

import com.njusoft.its.core.global.GlobalApplicationContext;
import com.njusoft.its.domain.DispatchPlan;
import com.njusoft.its.gps.analyse.DispatchPlanLoader;
import com.njusoft.its.service.impl.DispatchPlanServiceImpl;

public class DefaultDispatchPlanLoader implements DispatchPlanLoader{
	
	@Override
	public Map<String,List<DispatchPlan>>  getDispatchPlans(String workDate,String busCode) {
		Map<String,List<DispatchPlan>> busPlans = new HashMap<>();
		try {
			DispatchPlanServiceImpl service = GlobalApplicationContext.applicationContext.getBean(DispatchPlanServiceImpl.class);
			try {
				busPlans=service.getMapOfBusesPlans(workDate, busCode);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (BeansException e) {
			e.printStackTrace();
		}
		return busPlans;
	}

}
