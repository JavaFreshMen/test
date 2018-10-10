package com.njusoft.its.service;

import java.util.List;
import java.util.Map;


import com.njusoft.its.domain.Bus;


public interface BusService {
	
	public List<Bus> loadAllBuses() throws Exception;


	/**
	 * 加载车辆map数据
	 * 以车辆编号为主键
	 * @return
	 */
	public Map<String, Bus> loadBusesMap();
	
	
    public List<Bus> queryGlobalList()throws Exception;
}
