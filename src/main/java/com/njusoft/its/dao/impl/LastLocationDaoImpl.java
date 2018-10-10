package com.njusoft.its.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.njusoft.its.dao.BaseDao;
import com.njusoft.its.dao.LastLocationDao;
import com.njusoft.its.domain.LastLocation;
import com.njusoft.its.utils.DBConnectionUtils;
import com.njusoft.its.utils.ModelUtils;
import com.njusoft.its.utils.Utils;

@Repository
public class LastLocationDaoImpl extends BaseDao implements LastLocationDao{
	private final static Logger logger = LoggerFactory.getLogger(LastLocationDaoImpl.class);

	@Override
	public List<LastLocation> loadLastLocation(String startWorkDate, String endWorkDate, String lineCode, String busCode)
			throws Exception {
		StringBuilder sqlBuilder=new StringBuilder();
		sqlBuilder.append("select g.* from t_lastlocation l where 1=1 ");
		if (Utils.validateStringNull(startWorkDate)) {
			sqlBuilder.append("and l.workDate>=to_date('").append(startWorkDate).append("','yyyy-mm-dd') ");
		}
		if (Utils.validateStringNull(endWorkDate)) {
			sqlBuilder.append("and l.workDate<=to_date('").append(endWorkDate).append("','yyyy-mm-dd') ");
		}
		if (Utils.validateStringNull(lineCode)) {
			sqlBuilder.append("and l.lineCode='").append(lineCode).append("' ");
		}
		if (Utils.validateStringNull(busCode)) {
			sqlBuilder.append("and l.buscode='").append(busCode).append("' ");
		}
		sqlBuilder.append("order by l.workDate,l.lineCode,l.buscode");
		Connection connection = null;
    	PreparedStatement preparedStatement = null;
    	ResultSet resultSet = null;
    	List<LastLocation> lastLocations=new ArrayList<>();
    	try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(sqlBuilder.toString());
			resultSet=preparedStatement.executeQuery();
			lastLocations = ModelUtils.buildListFromResultSet(LastLocation.class, resultSet);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				DBConnectionUtils.closeConnection(connection, preparedStatement, resultSet);
			} catch (Exception e2) {
				throw new SQLException("release connection error");
			}
		}
		return lastLocations;
	}
	@Override
	public List<String> loadLastLocationBusCodes(String startWorkDate, String endWorkDate, String lineCode, String busCode)
			throws Exception {
		StringBuilder sqlBuilder=new StringBuilder();
		sqlBuilder.append("select distinct l.buscode from t_lastlocation l where 1=1 ");
		if (Utils.validateStringNull(startWorkDate)) {
			sqlBuilder.append("and l.workDate>=to_date('").append(startWorkDate).append("','yyyy-mm-dd') ");
		}
		if (Utils.validateStringNull(endWorkDate)) {
			sqlBuilder.append("and l.workDate<=to_date('").append(endWorkDate).append("','yyyy-mm-dd') ");
		}
		if (Utils.validateStringNull(lineCode)) {
			sqlBuilder.append("and l.lineCode='").append(lineCode).append("' ");
		}
		if (Utils.validateStringNull(busCode)) {
			sqlBuilder.append("and l.buscode='").append(busCode).append("' ");
		}
		sqlBuilder.append("order by l.buscode");
		Connection connection = null;
    	PreparedStatement preparedStatement = null;
    	ResultSet resultSet = null;
    	List<String> busCodes=new ArrayList<>();
    	try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(sqlBuilder.toString());
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				busCodes.add(resultSet.getString("buscode"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				DBConnectionUtils.closeConnection(connection, preparedStatement, resultSet);
			} catch (Exception e2) {
				throw new SQLException("release connection error");
			}
		}
		return busCodes;
	}

}
