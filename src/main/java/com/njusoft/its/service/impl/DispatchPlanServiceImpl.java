package com.njusoft.its.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.njusoft.its.dao.DispatchPlanDao;
import com.njusoft.its.domain.DispatchPlan;
import com.njusoft.its.service.DispatchPlanService;
@Service
public class DispatchPlanServiceImpl implements DispatchPlanService{
	@Autowired
	private DispatchPlanDao dao;

	@Override
	@Transactional(readOnly = true)
	public List<String> loadBusCodes(String workDate) throws Exception {
		return dao.loadBusCodes(workDate);
	}

	@Override
	public List<DispatchPlan> loadPlansOfCertainBusSomeDay(String workDate, String busCode) throws Exception {
		return dao.loadPlansOfCertainBusSomeDay(workDate, busCode);
	}

	@Override
	public Map<String, List<DispatchPlan>> getMapOfBusesPlans(String workDate, String busCode) throws Exception {
		List<DispatchPlan> list=dao.loadPlansOfCertainBusSomeDay(workDate, busCode);
		Map<String, List<DispatchPlan>>  map=new HashMap<String, List<DispatchPlan>>();
		for (DispatchPlan dispatchPlan : list) {
			String buscode=dispatchPlan.getBusCode();
			if (map.containsKey(buscode)) {
				map.get(buscode).add(dispatchPlan);
			}else {
				List<DispatchPlan> dispatchPlans=new ArrayList<>();
				dispatchPlans.add(dispatchPlan);
				map.put(buscode, dispatchPlans);
			}
			
		}
		return map;
	}


}
