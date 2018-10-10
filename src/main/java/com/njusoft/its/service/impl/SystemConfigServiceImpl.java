package com.njusoft.its.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.njusoft.its.dao.SystemConfigDao;
import com.njusoft.its.domain.SystemConfig;
import com.njusoft.its.service.SystemConfigService;

/** 
*
* @author 作者 E-mail:857332533@qq.com 
* @date 创建时间：2017年11月9日 下午6:04:04 
* @version 1.0 
* @since JDK 1.7
*/
@Service
public class SystemConfigServiceImpl implements SystemConfigService {
	private final static Logger logger = Logger.getLogger(SystemConfigServiceImpl.class);

	@Autowired
	private SystemConfigDao systemConfigDao;

	@Override
	public Map<String, List<SystemConfig>> loadSystemConfigsMap() {
		Map<String, List<SystemConfig>> map = new HashMap<>();
		try {
			for(SystemConfig model:systemConfigDao.loadSystemConfigs()){
				if (!map.containsKey(model.getFuncNumber())){
					map.put(model.getFuncNumber(), new ArrayList<SystemConfig>());
				}
				map.get(model.getFuncNumber()).add(model);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		return map;
	}

}
