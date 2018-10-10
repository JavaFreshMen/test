package com.njusoft.its.utils;
/** 
*
* @author 作者 E-mail:857332533@qq.com 
* @date 创建时间：2017年10月23日 上午11:20:47 
* @version 1.0 
* @since JDK 1.7
*/

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.fabric.xmlrpc.base.Array;
import com.njusoft.its.domain.websocket.WebSocketSend;

public class WebSocketReturnUtils {
	
	/**
	 * 返回指定类型
	 * @param type
	 * @return
	 */
	public static Map<String, Object> mapOk(String type){
		Map<String,Object> retMap = new HashMap<>();
		retMap.put("type", type);
		retMap.put("data", new Array());
		return retMap;
	}
	
	/**
	 * 返回指定类型的数据
	 * @param type
	 * @param datas
	 * @return
	 */
	public static Map<String, Object> mapOk(String type,List<? extends Object> datas){
		Map<String,Object> retMap = new HashMap<>();
		retMap.put("type", type);
		retMap.put("data", datas);
		return retMap;
	}
	
	/**
	 * 返回指定类型的数据
	 * @param type
	 * @param datas
	 * @return
	 */
	public static Map<String, Object> mapOk(String type,Map<String ,List<? extends Object>> datas){
		Map<String,Object> retMap = new HashMap<>();
		retMap.put("type", type);
		retMap.put("data", datas);
		return retMap;
	}
	

	/**
	 * 返回指定类型的数据
	 * @param type
	 * @param datas
	 * @return
	 */
	public static Map<String, Object> mapOk(String type,WebSocketSend sendData){
		Map<String,Object> retMap = new HashMap<>();
		retMap.put("type", type);
		retMap.put("data", sendData);
		return retMap;
	}
}
