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
import com.njusoft.its.dao.LocationDao;
import com.njusoft.its.domain.Location;
import com.njusoft.its.utils.DBConnectionUtils;
import com.njusoft.its.utils.Utils;

@Repository
public class LocationDaoImpl extends BaseDao implements LocationDao{
	private final static Logger logger = LoggerFactory.getLogger(LocationDaoImpl.class);

	
	public List<Location> loadBasicDataToBeAnalysed(String startRuntime, String endRuntime, String busCode)
			throws Exception {
		StringBuilder sqlBuilder=new StringBuilder();
		//单日、单车查询
		sqlBuilder.append("select l.workdate,l.buscode,l.occurtime,l.runmileage,l.busstate from t_location l where 1=1 ");
		if (Utils.validateStringNull(busCode)) {
			sqlBuilder.append("and l.buscode='").append(busCode).append("' ");
		}
		if (Utils.validateStringNull(startRuntime)) {
			sqlBuilder.append("and l.occurtime>=to_date('").append(startRuntime).append("','yyyy-mm-dd  hh24:mi:ss') ");
		}
		if (Utils.validateStringNull(endRuntime)) {
			sqlBuilder.append("and l.occurtime<=to_date('").append(endRuntime).append("','yyyy-mm-dd  hh24:mi:ss') ");
		}
		sqlBuilder.append("order by l.occurtime");
        Connection connection = null;
    	PreparedStatement preparedStatement = null;
    	ResultSet resultSet = null;
    	List<Location> locations=new ArrayList<>();
    	
    	try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(sqlBuilder.toString());
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				Location model=new Location();
				model.setWorkDate(resultSet.getDate("workDate"));
				model.setBusCode(resultSet.getString("busCode"));
				model.setOccurTime(resultSet.getTimestamp("occurTime"));
				model.setBusState(resultSet.getInt("busstate"));
				model.setRunMileage(resultSet.getInt("runMileage"));
				locations.add(model);
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
		return locations;
	}
}
