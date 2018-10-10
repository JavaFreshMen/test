package com.njusoft.its.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.njusoft.its.dao.LocationDao;
import com.njusoft.its.domain.Location;
import com.njusoft.its.domain.analyse.DeviceStateCalculate;
import com.njusoft.its.service.LocationService;

@Service
public class LocationServiceImpl implements LocationService{

	@Autowired
	private LocationDao dao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Location> loadBasicDataToBeAnalysed(String startRuntime, String endRuntime, String busCode)
			throws Exception {
		 List<Location> list=dao.loadBasicDataToBeAnalysed(startRuntime, endRuntime, busCode);
		return list;
	}
	

}
