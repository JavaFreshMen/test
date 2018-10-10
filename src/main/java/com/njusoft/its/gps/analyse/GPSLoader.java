package com.njusoft.its.gps.analyse;

import java.util.List;

import com.njusoft.its.domain.Location;

public interface GPSLoader {
	
	/**
	 * 加载GPS数据
	 * @param busCode
	 * @return
	 */
	public List<Location> loadLocation(String workDate,String busCode);
}
