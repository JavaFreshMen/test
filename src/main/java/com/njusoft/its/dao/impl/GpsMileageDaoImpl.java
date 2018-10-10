package com.njusoft.its.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.njusoft.its.dao.BaseDao;
import com.njusoft.its.dao.GpsMileageDao;
import com.njusoft.its.domain.GpsMileage;
import com.njusoft.its.utils.DBConnectionUtils;
import com.njusoft.its.utils.ModelUtils;
import com.njusoft.its.utils.Utils;

@Repository
public class GpsMileageDaoImpl extends BaseDao implements GpsMileageDao{
	private final static Logger logger = LoggerFactory.getLogger(GpsMileageDaoImpl.class);

	@Override
	public List<GpsMileage> loadGpsMileage(int start, int limit, String startWorkDate,String endWorkDate, String lineCode, String busCode)
			throws Exception {
		StringBuilder sqlBuilder=new StringBuilder();
		sqlBuilder.append("select g.* from t_gpsmileage g where 1=1 ");
		if (Utils.validateStringNull(startWorkDate)) {
			sqlBuilder.append("and g.workDate>=to_date('").append(startWorkDate).append("','yyyy-mm-dd') ");
		}
		if (Utils.validateStringNull(endWorkDate)) {
			sqlBuilder.append("and g.workDate<=to_date('").append(endWorkDate).append("','yyyy-mm-dd') ");
		}
		if (Utils.validateStringNull(lineCode)) {
			sqlBuilder.append("and g.lineCode='").append(lineCode).append("' ");
		}
		if (Utils.validateStringNull(busCode)) {
			sqlBuilder.append("and g.buscode='").append(busCode).append("' ");
		}
		sqlBuilder.append("order by g.workDate,g.lineCode,g.buscode");
		Connection connection = null;
    	PreparedStatement preparedStatement = null;
    	ResultSet resultSet = null;
    	List<GpsMileage> gpsMileages=new ArrayList<>();
    	try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(sqlBuilder.toString());
			resultSet=preparedStatement.executeQuery();
			gpsMileages = ModelUtils.buildListFromResultSet(GpsMileage.class, resultSet);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				DBConnectionUtils.closeConnection(connection, preparedStatement, resultSet);
			} catch (Exception e2) {
				throw new SQLException("release connection error");
			}
		}
		return gpsMileages;
	}

	@Override
	public List<GpsMileage> saveOrUpdate(List<GpsMileage> list) throws Exception {
		try {
			for (GpsMileage gpsMileage : list) {
				if (gpsMileage.getGpsMileageId()==null) {
	        		getEntityManager().persist(gpsMileage);
				} else {
	        		getEntityManager().merge(gpsMileage);
				}   
			}
        }catch (Exception e){
        	logger.error("保存GPS里程分析数据异常",e);
        	throw new Exception("保存GPS里程分析数据异常 "+"参数:["+list.toString()+"]");
        }
		return list;
	}

	@Override
	public boolean delete(String startWorkDate,String endWorkDate, String lineCode, String[] busCodes) throws Exception {
		StringBuilder sqlBuilder=new StringBuilder();
		sqlBuilder.append("delete from GpsMileage g where 1=1 ");
		if (Utils.validateStringNull(startWorkDate)) {
			sqlBuilder.append("and g.workDate>=to_date('").append(startWorkDate).append("','yyyy-mm-dd') ");
		}
		if (Utils.validateStringNull(endWorkDate)) {
			sqlBuilder.append("and g.workDate<=to_date('").append(endWorkDate).append("','yyyy-mm-dd') ");
		}
		if (Utils.validateStringNull(lineCode)) {
			sqlBuilder.append("and g.lineCode='").append(lineCode).append("' ");
		}
		if (busCodes!=null&&busCodes.length>0) {
			sqlBuilder.append("and g.busCode in ("); 
			for(int i=0;i<busCodes.length;i++){
				sqlBuilder.append("'").append(busCodes[i]).append("',");
	        }
			sqlBuilder.setCharAt(sqlBuilder.lastIndexOf(","),')');
		}
    	try {
			EntityManager entityManager = getEntityManager();
			Query query = entityManager.createQuery(sqlBuilder.toString());
			query.executeUpdate();
		} catch (Exception e) {
			logger.error("删除gps里程分析数据异常", e);
			throw new SQLException(e.getMessage());
		}
		return true;
	}
}
