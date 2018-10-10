package com.njusoft.its.datasource;
/** 
* 实时数据中心
* 用户不直接访问数据库  用户从此处获取数据的备份
* 由其他服务负责数据的实时更新
* @author 作者 E-mail:857332533@qq.com 
* @date 创建时间：2017年10月20日 上午11:13:58 
* @version 1.0 
* @since JDK 1.7
*/

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import com.njusoft.its.domain.Bus;
import com.njusoft.its.domain.Line;
import com.njusoft.its.domain.Station;
import com.njusoft.its.domain.SystemConfig;
import com.njusoft.its.domain.returnmodel.LineLike;
public class DataSourceCenter {
	
	public final static String SPLIT_FLAG = "-";
	private DataSourceCenter(){}
	
	/**
	 * 线路信息 key:lineCode
	 */
	public static Map<String, Line> linesMap = new ConcurrentHashMap<>();
	
	/**
	 * 线路信息 key:lineCode
	 */
	public static Map<Integer, List<LineLike>> lineOpenTypesMap = new ConcurrentHashMap<>();
	
	/**
	 * 线路站点信息 key:lineCode value:值为站点信息(
	 */
	public static Map<String, List<Station>> lineStationsMap = new ConcurrentHashMap<>();
	/**
	 * 系统配置项  以系统功能编号为主键  系统配置集合为值
	 */
	public static Map<String, List<SystemConfig>> sysConfigMap = new ConcurrentHashMap<>();
	/**
	 * 车辆信息
	 */
	public static Map<String, Bus> busesMap = new ConcurrentHashMap<>();
}
