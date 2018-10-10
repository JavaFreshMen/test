package com.njusoft.its.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.njusoft.its.dao.BusDao;
import com.njusoft.its.domain.Bus;
import com.njusoft.its.service.BusService;

@Service
public class BusServiceImpl implements BusService {
	private final static Logger logger = Logger.getLogger(BusServiceImpl.class);

	@Autowired
	private BusDao dao;

	@Override
	public Map<String, Bus> loadBusesMap() {
		Map<String, Bus> busesMap = new HashMap<>();
		try {
			for (Bus bus : dao.loadBuses()) {
				busesMap.put(bus.getBusCode(), bus);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		return busesMap;
	}

	@Override
	public List<Bus> loadAllBuses() throws Exception {
		return dao.loadAllBuses();
	}
	@Override
	@Transactional(readOnly = true)
	public List<Bus> queryGlobalList() throws Exception {
		return dao.queryGlobalList();
	}
}
