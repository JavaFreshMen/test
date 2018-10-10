package com.njusoft.its.datasource.db.push;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.njusoft.its.datasource.DataSourceCenter;
import com.njusoft.its.domain.Bus;
import com.njusoft.its.domain.SystemConfig;
import com.njusoft.its.domain.websocket.WebSocketSend;
import com.njusoft.its.domain.websocket.WebSocketUserInfo;
import com.njusoft.its.websocket.ExceptionMonitorWebSocket;
import com.njusoft.its.websocket.WebSocketDataTypes;

public class WebSocketDBDataPushMgr {
	private final static Logger logger = LoggerFactory.getLogger(WebSocketDBDataPushMgr.class);
	
	private static WebSocketDBDataPushMgr webSocketDBDataPushMgr;
	
	private WebSocketDBDataPushMgr(){}
	
	public static WebSocketDBDataPushMgr getInstance(){
		if(null == webSocketDBDataPushMgr){
			synchronized (WebSocketDBDataPushMgr.class) {
				if(null == webSocketDBDataPushMgr){
					webSocketDBDataPushMgr = new WebSocketDBDataPushMgr();
				}
			}
		}
		return webSocketDBDataPushMgr;
	}
	
	
	/**
	 * 推送车辆数据到web socket
	 * @param jobDataMap
	 * @return
	 */
	public synchronized boolean pushBusDBData(WebSocketUserInfo webSocketUserInfo,String sessionId){
		try {
			List<Bus> list = new ArrayList<>();
			for (Entry<String, Bus> entry : DataSourceCenter.busesMap.entrySet()) {
				list.add(entry.getValue());
			}
			Map<String, List<? extends Object>> map = new HashMap<>();
			map.put("allLines", list);
			ExceptionMonitorWebSocket.sendMessage(WebSocketDataTypes.REAL_BUS, sessionId, new WebSocketSend("allLines", list));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return false;
		}
		return true;
	}

	
	
	/**
	 * 推送系统配置数据到web socket
	 * @param jobDataMap
	 * @return
	 */
	public synchronized boolean pushSystemConfigDBData(WebSocketUserInfo webSocketUserInfo,String sessionId){
		try {
			List<SystemConfig> list = new ArrayList<>();
			for (Entry<String, List<SystemConfig>> entry : DataSourceCenter.sysConfigMap.entrySet()) {
				list.addAll(entry.getValue());
			}
			ExceptionMonitorWebSocket.sendMessage(WebSocketDataTypes.REAL_SYSTEMCONFIG, sessionId, new WebSocketSend("allLines", list));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return false;
		}
		return true;
	}
}
