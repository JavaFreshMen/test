package com.njusoft.its.dao;

import java.util.List;

import com.njusoft.its.domain.LastLocation;

public interface LastLocationDao {
	/**
	 * 查询车辆上线情况
	 * @param startWorkDate
	 * @param endWorkDate
	 * @param lineCode
	 * @param busCode
	 * @return
	 * @throws Exception
	 */
	public List<LastLocation> loadLastLocation(String startWorkDate,String endWorkDate,String lineCode,String busCode) throws Exception;
	/**
	 * 查询上线车辆编号
	 * @param startWorkDate
	 * @param endWorkDate
	 * @param lineCode
	 * @param busCode
	 * @return
	 * @throws Exception
	 */
	public List<String> loadLastLocationBusCodes(String startWorkDate, String endWorkDate, String lineCode, String busCode) throws Exception;

}
