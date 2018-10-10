package com.njusoft.its.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.njusoft.its.dao.BaseDao;
import com.njusoft.its.dao.BusDao;
import com.njusoft.its.domain.Bus;
import com.njusoft.its.utils.DBConnectionUtils;
import com.njusoft.its.utils.ModelUtils;
import com.njusoft.its.web.exception.SystemInnerException;

@Repository
public class BusDaoImpl extends BaseDao implements BusDao{
	private final static Logger logger = Logger.getLogger(BusDaoImpl.class);

	@Override
	public List<Bus> loadAllBuses() throws Exception {
		StringBuilder sqlBuilder=new StringBuilder();
		sqlBuilder.append("select b.* from t_bus b where 1=1 ");
		
        Connection connection = null;
    	PreparedStatement preparedStatement = null;
    	ResultSet resultSet = null;
    	List<Bus>  list=new ArrayList<>();
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sqlBuilder.toString());
            resultSet = preparedStatement.executeQuery();
            list= ModelUtils.buildListFromResultSet(Bus.class, resultSet);
		} catch (Exception e) {
			logger.info("获取所有车辆信息失败！");
			throw new SQLException(e.getMessage());
		}finally {
			try {
				DBConnectionUtils.closeConnection(connection, preparedStatement, resultSet);
			} catch (Exception e2) {
				throw new SQLException("release connection error");
			}
		}
		return list;
	}

	@Override
	public List<Bus> loadBuses() {
		StringBuilder sqlBuilder=new StringBuilder();
		sqlBuilder.append("select b.* from t_bus b where 1=1 ");
		
        Connection connection = null;
    	PreparedStatement preparedStatement = null;
    	ResultSet resultSet = null;
    	List<Bus>  list=new ArrayList<>();
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sqlBuilder.toString());
            resultSet = preparedStatement.executeQuery();
            list= ModelUtils.buildListFromResultSet(Bus.class, resultSet);
		} catch (Exception e) {
			logger.info("获取所有车辆信息失败！");
			try {
				throw new SQLException(e.getMessage());
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			try {
				DBConnectionUtils.closeConnection(connection, preparedStatement, resultSet);
			} catch (Exception e2) {
				try {
					throw new SQLException("release connection error");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}
	public List<Bus> queryGlobalList() throws Exception{
        try {
            final StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("select t.* from t_bus t where t.isdisable <> '1' ");
        	Connection connection = null;
        	PreparedStatement preparedStatement = null;
        	ResultSet resultSet = null;
            List<Bus> list = new LinkedList<>();
        	try {
                connection = getConnection();
                preparedStatement = connection.prepareStatement(sqlBuffer.toString());
                resultSet = preparedStatement.executeQuery();
                list = ModelUtils.buildListFromResultSet(Bus.class,resultSet);
			} catch (Exception e) {
				throw new SQLException(e.getMessage());
			}finally {
				try {
					DBConnectionUtils.closeConnection(connection, preparedStatement, resultSet);
				} catch (Exception e2) {
					throw new SQLException("release connection error");
				}
			}
            return list;
        }catch (Exception e){
			logger.error("车辆信息列表获取异常",e);
            throw new SystemInnerException("车辆信息查询异常！");
        }
    }
}
