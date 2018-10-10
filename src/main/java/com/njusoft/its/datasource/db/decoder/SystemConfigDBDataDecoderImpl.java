package com.njusoft.its.datasource.db.decoder;

import java.util.List;

import org.apache.log4j.Logger;

import com.njusoft.its.datasource.DataSourceCenter;
import com.njusoft.its.datasource.db.DBDataDecoderAdapter;
import com.njusoft.its.domain.SystemConfig;
/**
 * 
 * @author Louise
 *
 */

public class SystemConfigDBDataDecoderImpl extends DBDataDecoderAdapter{

	private final static Logger logger = Logger.getLogger(SystemConfigDBDataDecoderImpl.class);
	private String lineCode = null;
	@Override
	public boolean decodeData(List<? extends Object> data) {
		try {
			//集合判断
			if(null == data || data.size() < 1){
				return false;
			}
			//记录当前处理的场站编号
			List<SystemConfig> systemConfigs = (List<SystemConfig>) data;
			//update common datasource
			DataSourceCenter.sysConfigMap.put(systemConfigs.get(0).getFuncNumber(),systemConfigs);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return false;
		}
	}

	@Override
	public String getLineCode() {
		return null;
	}

}
