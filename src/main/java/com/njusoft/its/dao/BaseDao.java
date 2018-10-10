package com.njusoft.its.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.njusoft.its.web.exception.BaseNullPointerException;

/**
 * 基础DAO
 * Created by Administrator on 2016/11/28 0028.
 */
public class BaseDao<T>{
	@PersistenceContext
	protected EntityManager entityManager;
	@Autowired
    protected JdbcTemplate jdbcTemplate;
	@Autowired
    protected NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public EntityManager getEntityManager() {
		return entityManager;
	}
    
    public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
    
    public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return namedParameterJdbcTemplate;
	}

	/**
     * 获取connection对象
     * @return
     * @throws SQLException
     */
    protected Connection getConnection() throws SQLException{
        return jdbcTemplate.getDataSource().getConnection();
    }

    /**
     * 保存pojo对象
     * @param model
     * @return
     * @throws Exception
     */
    protected T save(T model) throws BaseNullPointerException, Exception{
        if(model == null)
            throw new BaseNullPointerException();
        entityManager.persist(model);
        return model;
    }



    /**
     * 批量删除数据
     * @param ids
     * @param pojoName
     * @throws Exception
     */
    protected void delete(String[] ids,String pojoName) throws HibernateException {
        StringBuilder hqlBuilder = new StringBuilder("delete from "+pojoName+" s where s.id in ( ");
        for(int i=0;i<ids.length;i++){
            hqlBuilder.append("'").append(ids[i]).append("',");
        }
        hqlBuilder.setCharAt(hqlBuilder.lastIndexOf(","),')');
        getEntityManager().createQuery(hqlBuilder.toString()).executeUpdate();
    }

    /**
     * 根据ids获取对应的实体数据集合 默认对象的主键字段名为id
     * @param ids 对象的主键数据集合
     * @param pojoName 实体对象名称
     * @return
     * @throws HibernateException
     */
    protected List<T> list(String[] ids,String pojoName) throws HibernateException {
       return this.list(ids,pojoName,"id");
    }

    /**
     * 根据ids获取对应的实体数据集合
     * @param ids 对象的主键数据集合
     * @param pojoName 实体对象名称
     * @param idField 主键字段名
     * @return
     * @throws HibernateException
     */
    protected List<T> list(String[] ids,String pojoName,String idField) throws HibernateException {
        StringBuilder hqlBuilder = new StringBuilder("from "+pojoName+" s where s."+idField+" in ( ");
        for(int i=0;i<ids.length;i++){
            hqlBuilder.append("'").append(ids[i]).append("',");
        }
        hqlBuilder.setCharAt(hqlBuilder.lastIndexOf(","),')');
        System.out.println(hqlBuilder.toString());
        return getEntityManager().createQuery(hqlBuilder.toString()).getResultList();
    }

    protected List<T> list(Class clazz,String idField,String[] ids) throws HibernateException {
    	return list(ids, clazz.getSimpleName(),idField);
    }

    /**
     * 批量删除数据
     * @param ids
     * @param pojoName
     * @param idField
     * @throws Exception
     */
    protected void delete(String[] ids,String pojoName,String idField) throws HibernateException {
        StringBuilder hqlBuilder = new StringBuilder("delete from "+pojoName+" s where s."+idField+" in ( ");
        for(int i=0;i<ids.length;i++){
            hqlBuilder.append("'").append(ids[i]).append("',");
        }
        hqlBuilder.setCharAt(hqlBuilder.lastIndexOf(","),')');
        getEntityManager().createQuery(hqlBuilder.toString()).executeUpdate();
    }

    protected void delete(Class clazz,String idField,String[] ids) throws HibernateException {
        delete(ids, clazz.getSimpleName(),idField);
    }

    /**
     * 自定义限制条件批量删除数据
     * @param pojoName 实体对象名
     * @param fieldName 实体对象属性字段名
     * @param values fieldName对应值的集合
     * @throws HibernateException
     */
    protected void deleteByCustomRestriction(String pojoName,String fieldName,String[] values) throws HibernateException {
        StringBuilder hqlBuilder = new StringBuilder("delete from "+pojoName+" s where s."+fieldName+" in ( ");
        for(int i=0;i<values.length;i++){
            hqlBuilder.append("'").append(values[i]).append("',");
        }
        hqlBuilder.setCharAt(hqlBuilder.lastIndexOf(","),')');
        getEntityManager().createQuery(hqlBuilder.toString()).executeUpdate();
    }

    ////以下是为了溧阳移植过来的功能正常运行而添加的功能

    /**
     * 格式化为double数据
     * @param data 数据
     * @return double类型的数据
     */
    protected Double parseDouble(String data){
        try {
            return Double.valueOf(data);
        } catch (Exception e){
            return Double.valueOf("0");
        }
    }

    /**
     * 格式化为string
     * @param obj 数据
     * @return 对应的string类型 null则为空
     */
    protected String parseString(Object obj){
        if(obj == null)
            return "";
        else
            return String.valueOf(obj);
    }
}
