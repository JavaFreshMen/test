package com.njusoft.its.service;

import java.util.List;

import com.njusoft.its.domain.GpsMileage;

public interface GpsMileageService {
	/**
	 * 查询车辆gps里程相关数据
	 * @param start
	 * @param limit
	 * @param startWorkDate
	 * @param endWorkDate
	 * @param lineCode
	 * @param busCode
	 * @return
	 * @throws Exception
	 */
	public List<GpsMileage> loadGpsMileage(int start,int limit , String startWorkDate,String endWorkDate,String lineCode,String busCode) throws Exception;
	/**
	 * 批量新增或更新
	 * @param list
	 * @return
	 * @throws Exception
	 */
	public List<GpsMileage> saveOrUpdate(List<GpsMileage> list) throws Exception;
	/**
	 * 批量删除
	 * @param startWorkDate
	 * @param endWorkDate
	 * @param lineCode
	 * @param busCode
	 * @return
	 * @throws Exception
	 */
	public boolean delete(String startWorkDate,String endWorkDate,String lineCode,String[] busCodes) throws Exception;
	 

}
