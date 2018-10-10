package com.njusoft.its.gps.analyse;

import java.util.List;
import java.util.Map;

import com.njusoft.its.domain.DispatchPlan;

public interface DispatchPlanLoader {
	
	/**
	 * 加载GPS数据
	 * @param busCode
	 * @return
	 */
	public Map<String,List<DispatchPlan>>  getDispatchPlans(String workDate,String busCode);
}
