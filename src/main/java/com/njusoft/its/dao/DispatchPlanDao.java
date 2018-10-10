package com.njusoft.its.dao;

import java.util.List;

import com.njusoft.its.domain.DispatchPlan;
/**
 * @author Louise
 *
 */
public interface DispatchPlanDao {
	/**
	 * 加载某天所有车辆自编号
	 * @param workDate
	 * @return
	 * @throws Exception
	 */
	List<String> loadBusCodes(String workDate) throws Exception;
	
	List<DispatchPlan> loadPlansOfCertainBusSomeDay(String workDate,String busCode) throws Exception;
	

}
