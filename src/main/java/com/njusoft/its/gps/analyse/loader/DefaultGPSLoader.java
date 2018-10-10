package com.njusoft.its.gps.analyse.loader;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeansException;

import com.njusoft.its.core.global.GlobalApplicationContext;
import com.njusoft.its.domain.Location;
import com.njusoft.its.gps.analyse.GPSLoader;
import com.njusoft.its.service.impl.LocationServiceImpl;

public class DefaultGPSLoader implements GPSLoader{

	@Override
	public List<Location> loadLocation(String workDate,String busCode) {
		List<Location> locations = new ArrayList<>(0);
		try {
			LocationServiceImpl deviceOffLineService = GlobalApplicationContext.applicationContext.getBean(LocationServiceImpl.class);
			String startRuntime=workDate+" 00:00:00";
			String endRuntime  =workDate+" 23:59:59";
			try {
				locations=deviceOffLineService.loadBasicDataToBeAnalysed(startRuntime, endRuntime, busCode);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (BeansException e) {
			e.printStackTrace();
		}
		return locations;
	}

}
