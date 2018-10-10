package com.njusoft.its.service;

import java.util.List;
import com.njusoft.its.domain.Location;

public interface LocationService {
	/**
	 * 加载待分析数据
	 * @param startRuntime yyyy-MM-dd HH:mm:ss
	 * @param endRuntime
	 * @param busCode
	 * @return
	 * @throws Exception
	 */
	public List<Location> loadBasicDataToBeAnalysed(String startRuntime,String endRuntime,String busCode) throws Exception;


}
