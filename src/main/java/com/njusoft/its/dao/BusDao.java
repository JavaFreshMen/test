package com.njusoft.its.dao;

import java.util.List;

import com.njusoft.its.domain.Bus;

public interface BusDao {
	/**
	 * 加载所有的车辆信息
	 * @return
	 * @throws Exception
	 */
	public List<Bus> loadAllBuses() throws Exception;

	public List<Bus> loadBuses();
	
	public List<Bus> queryGlobalList() throws Exception;
}
