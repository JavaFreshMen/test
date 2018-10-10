package com.njusoft.its.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.njusoft.its.dao.SystemConfigDao;
import com.njusoft.its.domain.SystemConfig;
import com.njusoft.its.utils.DBConnectionUtils;
import com.njusoft.its.utils.ModelUtils;
import com.njusoft.its.web.exception.SystemInnerException;

/** 
* 系统配置
* @author 作者 E-mail:857332533@qq.com 
* @date 创建时间：2017年11月9日 下午6:01:09 
* @version 1.0 
* @since JDK 1.7
*/
@Repository
public class SystemConfigDaoImpl implements SystemConfigDao {
	private final static Logger logger = Logger.getLogger(SystemConfigDaoImpl.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@SuppressWarnings("unchecked")
	@Override
	public List<SystemConfig> loadSystemConfigs() throws Exception {
		List<SystemConfig> list = new LinkedList<>();
		StringBuffer sqlBuffer = new StringBuffer();
		sqlBuffer.append("select * from sys_systemconfig t ");
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = jdbcTemplate.getDataSource().getConnection();
			preparedStatement = connection.prepareStatement(sqlBuffer.toString());
			resultSet = preparedStatement.executeQuery();
			list = ModelUtils.buildListFromResultSet(SystemConfig.class, resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			throw new SystemInnerException("获取系统配置:"+e.getMessage());
		}finally {
			DBConnectionUtils.closeConnection(connection, preparedStatement, resultSet);
		}
		return list;
	}

}
