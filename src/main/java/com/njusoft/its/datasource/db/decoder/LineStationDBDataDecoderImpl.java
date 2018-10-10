package com.njusoft.its.datasource.db.decoder;

import java.util.List;

import org.apache.log4j.Logger;

import com.njusoft.its.datasource.DataSourceCenter;
import com.njusoft.its.datasource.db.DBDataDecoderAdapter;
import com.njusoft.its.domain.Station;
/**
 * 线路站点
 * @author yxx 
 * @date 2018年4月25日
 */
public class LineStationDBDataDecoderImpl extends DBDataDecoderAdapter{

	private final static Logger logger = Logger.getLogger(LineStationDBDataDecoderImpl.class);
	
	private String lineCode = null;
	
	@Override
	public boolean decodeData(List<? extends Object> data) {
		try {
			//集合判断
			if(null == data || data.size() < 1){
				return false;
			}
			//记录当前处理的场站编号
			List<Station> lineStations = (List<Station>) data;
			//update common datasource
			DataSourceCenter.lineStationsMap.put(lineStations.get(0).getLineCode(),lineStations);
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
