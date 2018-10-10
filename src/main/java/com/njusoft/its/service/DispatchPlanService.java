package com.njusoft.its.service;

import java.util.List;
import java.util.Map;

import com.njusoft.its.domain.DispatchPlan;

public interface DispatchPlanService {
	
	public List<String> loadBusCodes(String workDate) throws Exception;
	
	public List<DispatchPlan> loadPlansOfCertainBusSomeDay(String workDate,String busCode) throws Exception;
	/**
	 * key:buscode
	 * @return
	 * @throws Exception
	 */
	public Map<String,List<DispatchPlan>> getMapOfBusesPlans(String workDate, String busCode) throws Exception;
	
}
