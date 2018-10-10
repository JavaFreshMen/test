package com.njusoft.its.datasource.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import com.njusoft.its.datasource.DataSourceCenter;
import com.njusoft.its.domain.Bus;
import com.njusoft.its.domain.websocket.WebSocketSend;
import com.njusoft.its.domain.websocket.WebSocketUserInfo;
import com.njusoft.its.websocket.ExceptionMonitorWebSocket;
import com.njusoft.its.websocket.WebSocketDataTypes;

/** 
* 数据库获取数据更新
* @author 作者 E-mail:857332533@qq.com 
* @date 创建时间：2017年10月25日 上午11:55:32 
* @version 1.0 
* @since JDK 1.7
*/
public class DBDataSourceUpdateMgr {
	private final static Logger logger = Logger.getLogger(DBDataSourceUpdateMgr.class);
	
	private DBDataSourceUpdateMgr(){}
	
	/**
	 * 处理数据库访问数据
	 * @param type
	 * @param datas
	 * @return
	 */
	public synchronized static boolean dealDBDatas(DBDataSourceTypes type,List<? extends Object> datas){
		try {
			//消息分类处理
			DBDataDecoderAdapter dbDataDecoder = type.getDataDecoder();
			if(null == dbDataDecoder){
				return false;
			}
			//业务数据处理
			String lineCode = dbDataDecoder.getLineCode();
			if(dbDataDecoder.decodeData(datas) && null != lineCode){
				if(type == DBDataSourceTypes.DB_BUS){
						//车辆信息
						List<Bus> list = new ArrayList<>();
						for (Entry<String, Bus> entry : DataSourceCenter.busesMap.entrySet()) {
							list.add(entry.getValue());
						}
						for(Entry<String, WebSocketUserInfo> entry:ExceptionMonitorWebSocket.WebSocketUserInfos().entrySet()){
							Map<String, List<? extends Object>> map = new HashMap<>();
							map.put("allLines", list);
							ExceptionMonitorWebSocket.sendMessage(WebSocketDataTypes.REAL_BUS, entry.getKey(), new WebSocketSend(lineCode, list));
						}
				}
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return false;
		}
	}

}
