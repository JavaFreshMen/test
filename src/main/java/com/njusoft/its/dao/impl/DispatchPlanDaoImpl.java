package com.njusoft.its.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.njusoft.its.dao.BaseDao;
import com.njusoft.its.dao.DispatchPlanDao;
import com.njusoft.its.domain.DispatchPlan;
import com.njusoft.its.utils.Const;
import com.njusoft.its.utils.DBConnectionUtils;
import com.njusoft.its.utils.ModelUtils;
import com.njusoft.its.utils.Utils;
import com.njusoft.its.web.exception.SystemInnerException;

@Repository
public class DispatchPlanDaoImpl extends BaseDao implements DispatchPlanDao{
	private final static Logger logger = Logger.getLogger(DispatchPlanDaoImpl.class);
	@Override
	public List<String> loadBusCodes(String workDate) throws Exception {
		   try {
	            StringBuffer sqlBuffer = new StringBuffer();
	            sqlBuffer.append("select distinct d.busCode from t_dispatchplan d where 1=1 ");
	           
	            if (Utils.validateStringNull(workDate)){
	                sqlBuffer.append("and d.workdate =to_date('").append(workDate).append("','yyyy-mm-dd') ");
	            }
	            sqlBuffer.append("order by d.buscode ");
	            
	            Connection connection = null;
	        	PreparedStatement preparedStatement = null;
	        	ResultSet resultSet = null;
	        	List<String> list=new ArrayList<>();
	        	try {
	                connection = getConnection();
	                preparedStatement = connection.prepareStatement(sqlBuffer.toString());
	                resultSet = preparedStatement.executeQuery();
	                while (resultSet.next()) {
	                	list.add(resultSet.getString("buscode"));
					}
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
				logger.error("获取车辆自编号list异常",e);
	            throw new SystemInnerException("获取车辆自编号list异常！"+Const.EXCEPTION_SPLIT_FLAG+"参数:[workDate:"+workDate+"]");
	        }
	}
	@Override
	public List<DispatchPlan> loadPlansOfCertainBusSomeDay(String workDate,String busCode) throws Exception {
		try {
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("select d.workdate,d.buscode,nvl(d.realruntime,d.planruntime) as realruntime,nvl(d.realarrivetime,d.planarrivetime) as realarrivetime from t_dispatchplan d where 1=1 ");
            sqlBuffer.append("and d.planstate!=3 ");
            if (Utils.validateStringNull(workDate)){
                sqlBuffer.append("and d.workdate =to_date('").append(workDate).append("','yyyy-mm-dd') ");
            }
            if (Utils.validateStringNull(busCode)){
                sqlBuffer.append("and d.busCode ='").append(busCode).append("' ");
            }
            sqlBuffer.append("order by d.buscode,d.planruntime,d.realruntime");
            System.out.println(sqlBuffer.toString());
            Connection connection = null;
        	PreparedStatement preparedStatement = null;
        	ResultSet resultSet = null;
        	List<DispatchPlan> list=new ArrayList<>();
        	try {
                connection = getConnection();
                preparedStatement = connection.prepareStatement(sqlBuffer.toString());
                resultSet = preparedStatement.executeQuery();
                list=ModelUtils.buildListFromResultSet(DispatchPlan.class, resultSet);
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
			logger.error("获取车辆自编号list异常",e);
            throw new SystemInnerException("获取车辆自编号list异常！"+Const.EXCEPTION_SPLIT_FLAG+"参数:[workDate:"+workDate+"]");
        }
	}
}
