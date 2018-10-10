package com.njusoft.its.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.njusoft.its.dao.LastLocationDao;
import com.njusoft.its.domain.LastLocation;
import com.njusoft.its.service.LastLocationService;

@Service
public class LastLocationServiceImpl implements LastLocationService{

	@Autowired
	private LastLocationDao lastLocationDao;
	@Transactional(readOnly = true)
	public List<LastLocation> loadLastLocation(String startWorkDate, String endWorkDate, String lineCode,
			String busCode) throws Exception {
		List<LastLocation> list=lastLocationDao.loadLastLocation(startWorkDate, endWorkDate, lineCode, busCode);
		return list;
	}
	@Transactional(readOnly = true)
	public List<String> loadLastLocationBusCodes(String startWorkDate, String endWorkDate, String lineCode,
			String busCode) throws Exception {
		List<String> list=lastLocationDao.loadLastLocationBusCodes(startWorkDate, endWorkDate, lineCode, busCode);
		return list;
	}


}
