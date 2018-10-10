package com.njusoft.its.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 数据库连接相关的工具类
 * @author David Ji
 *
 */
public class DBConnectionUtils {
	
	/**
	 * 统一关闭connection、preparedStatement、resultSet
	 * @param connection
	 * @param preparedStatement
	 * @param resultSet
	 * @throws Exception
	 */
	public static void closeConnection(Connection connection,PreparedStatement preparedStatement,ResultSet resultSet) throws Exception{
		if(null != resultSet){
			try {
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			resultSet = null;
		}
		if(null != preparedStatement){
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			preparedStatement = null;
		}
		if(null != connection){
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			connection = null;
		}
	}
	
	/**
	 * 统一关闭connection、preparedStatement
	 * @param connection
	 * @param preparedStatement
	 * @throws Exception
	 */
	public static void closeConnection(Connection connection,PreparedStatement preparedStatement) throws Exception{
		if(null != preparedStatement){
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			preparedStatement = null;
		}
		if(null != connection){
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			connection = null;
		}
	}
}
