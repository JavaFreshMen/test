package com.njusoft.its.datasource.db.decoder;

import java.util.List;

import org.apache.log4j.Logger;

import com.njusoft.its.datasource.DataSourceCenter;
import com.njusoft.its.datasource.db.DBDataDecoderAdapter;
import com.njusoft.its.domain.Bus;

/** 
*
* @author 作者 E-mail:857332533@qq.com 
* @date 创建时间：2017年10月27日 上午10:54:49 
* @version 1.0 
* @since JDK 1.7
*/
public class BusDBDataDecoderImpl extends DBDataDecoderAdapter{

private final static Logger logger = Logger.getLogger(BusDBDataDecoderImpl.class);
	
	private String lineCode = null;
	
	@Override
	public boolean decodeData(List<? extends Object> data) {
		try {
			//集合判断
			if(null == data || data.size() < 1){
				return false;
			}
			//记录当前处理的线路编号
			Bus bus = (Bus) data.get(0);
			this.lineCode = bus.getLineCode();
			//update common datasource
			DataSourceCenter.busesMap.put(bus.getBusCode(), bus);
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
