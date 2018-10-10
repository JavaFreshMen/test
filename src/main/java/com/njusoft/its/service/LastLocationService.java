package com.njusoft.its.service;

import java.util.List;

import com.njusoft.its.domain.LastLocation;

public interface LastLocationService {
	public List<LastLocation> loadLastLocation(String startWorkDate,String endWorkDate,String lineCode,String busCode) throws Exception;
	public List<String> loadLastLocationBusCodes(String startWorkDate,String endWorkDate,String lineCode,String busCode) throws Exception;


}
