package com.njusoft.its.service;

import java.util.List;
import java.util.Map;

import com.njusoft.its.domain.SystemConfig;

/** 
*
* @author 作者 E-mail:857332533@qq.com 
* @date 创建时间：2017年11月9日 下午6:03:01 
* @version 1.0 
* @since JDK 1.7
*/
public interface SystemConfigService {
	
	/**
	 * 加载系统配置
	 * 功能编号
	 * @return
	 */
	Map<String, List<SystemConfig>> loadSystemConfigsMap();
}
