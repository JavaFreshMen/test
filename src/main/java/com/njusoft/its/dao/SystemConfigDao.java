package com.njusoft.its.dao;
/** 
* 系统配置Dao
* @author 作者 E-mail:857332533@qq.com 
* @date 创建时间：2017年11月9日 下午5:56:42 
* @version 1.0 
* @since JDK 1.7
*/

import java.util.List;

import com.njusoft.its.domain.SystemConfig;

public interface SystemConfigDao {
	
	/**
	 * 加载系统配置
	 * @return
	 * @throws Exception
	 */
	public List<SystemConfig> loadSystemConfigs() throws Exception;
}
