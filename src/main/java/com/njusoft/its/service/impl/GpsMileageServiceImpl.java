package com.njusoft.its.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.njusoft.its.dao.GpsMileageDao;
import com.njusoft.its.domain.GpsMileage;
import com.njusoft.its.service.GpsMileageService;

@Service
public class GpsMileageServiceImpl implements GpsMileageService{

	@Autowired
	private GpsMileageDao gpsMileageDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<GpsMileage> loadGpsMileage(int start, int limit, String startWorkDate, String endWorkDate,
			String lineCode, String busCode) throws Exception {
		List<GpsMileage> list=gpsMileageDao.loadGpsMileage(start, limit, startWorkDate, endWorkDate, lineCode, busCode);
		return list;
	}

	@Override
	@Transactional
	public List<GpsMileage> saveOrUpdate(List<GpsMileage> list) throws Exception {
		List<GpsMileage> models=gpsMileageDao.saveOrUpdate(list);
		return models;
	}

	@Override
	@Transactional
	public boolean delete(String startWorkDate, String endWorkDate, String lineCode, String[] busCodes) throws Exception {
		gpsMileageDao.delete(startWorkDate, endWorkDate, lineCode, busCodes);
		return true;
	}
	

}
