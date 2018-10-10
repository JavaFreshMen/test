package com.njusoft.its.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 实体工具类
 * Created by Administrator on 2016/12/10 0010.
 */
public class ModelUtils {

    /**
     * 将对象LinkedHashMap封装成对象
     * @param data Map data.get("data")
     * @param clazz 要转换的类对象
     * @return list对象数组
     */
    public static List decodeValueToModelList(Object data,Class clazz){
        List<LinkedHashMap> datas = new ArrayList<>();
        try {
            datas = (List<LinkedHashMap>) data;
        }catch (Exception e){
            datas.add((LinkedHashMap) data);
        }
        List models = new ArrayList();
        try {
            for(LinkedHashMap item:datas){
                Object model = clazz.newInstance();
                Field[] fields = clazz.getDeclaredFields();
                for(Field field:fields){
                    if(field.getName().trim().toLowerCase().equals("serialversionuid"))
                        continue;
                    Annotation[] annotations = field.getAnnotations();
                    if(annotations.length > 0) {
                        Class fieldType = field.getType();
                        String fieldName = field.getName();
                        String methodName = "set" + Utils.getMethodName(fieldName);
                        Method method = null;
                        try {
                            method = clazz.getMethod(methodName, fieldType);
                        }catch (Exception e){
                            //用于处理类似rTblName这样的字段 对应的set方法为setrTblName
                            method = clazz.getMethod("set"+fieldName,fieldType);
                        }
                        Object value = item.get(fieldName);
                        if (value != null) {
                            method.invoke(model, ModelUtils.getTypeValue(fieldType,value));
                        }
                    }
                }
                models.add(model);
            }
            return models;
        }catch (Exception e){
            e.printStackTrace();
            return new ArrayList();
        }
    }

    /**
     * 从结果集中封装成对象
     * @param clazz 对象类
     * @param resultSet 结果集
     * @return 对象集合
     * @throws Exception
     */
    public static List buildListFromResultSet(Class clazz, ResultSet resultSet) throws Exception{
        List resultDatas = new LinkedList();
        List<String> unIncludeFields = Arrays.asList(new String[]{"serialversionuid"});
        Field[] fields = clazz.getDeclaredFields();
        while (resultSet.next()){
            Object obj = clazz.newInstance();
            for(Field field:fields){
                String fieldName = field.getName();
                String typeName = field.getType().getSimpleName().toLowerCase();
                if(unIncludeFields.contains(fieldName.trim().toLowerCase())){
                    continue;
                }
                Method setMethod = null;
                try {
                    setMethod = clazz.getMethod("set" + Utils.getMethodName(fieldName),getTypeClass(typeName));
                }catch (Exception e){
                    setMethod = clazz.getMethod("set" + fieldName,getTypeClass(typeName));
                }
                Object value = null;
                try {
                    value = getTypeValue(getTypeClass(typeName),resultSet.getObject(fieldName));
                }catch (Exception e){
                }
                if(typeName.equals("string") && "null".equals(value)){
                    value = "";
                }
                setMethod.invoke(obj,value);
            }
            resultDatas.add(obj);
        }
        return resultDatas;
    }

    /**
     * 获取当前的字段类型
     *
     * @param type
     * @return
     */
    private static Class getTypeClass(String type) {
        switch (type.trim().toLowerCase()) {
            case "string":
                return String.class;
            case "integer":
                return Integer.class;
            case "boolean":
                return Boolean.class;
            case "date":
                return Date.class;
            case "double":
                return Double.class;
            case "float":
                return Float.class;
            default:
                return null;
        }
    }

    /**
     * 对值根据类型进行重新封装
     * @param clazz 数据格式
     * @param value 数据
     * @return
     */
    private static Object getTypeValue(Class clazz,Object value){
        String simpleName = clazz.getSimpleName();
        Object cellValue = value;
        if(simpleName.equalsIgnoreCase("Integer")){
            String t_cellValue = String.valueOf(value);
            if(!t_cellValue.trim().equals("") && !t_cellValue.trim().equals("null"))
                cellValue = Integer.valueOf(t_cellValue);
            else
                cellValue = null;
        }else if(simpleName.equalsIgnoreCase("Double")){
            String t_cellValue = String.valueOf(value);
            if(!t_cellValue.trim().equals("") && !t_cellValue.trim().equals("null"))
                cellValue = Double.valueOf(t_cellValue);
            else
                cellValue = null;
        }else if(simpleName.equalsIgnoreCase("Float")){
            String t_cellValue = String.valueOf(value);
            if(!t_cellValue.trim().equals("") && !t_cellValue.trim().equals("null"))
                cellValue = Float.valueOf(t_cellValue);
            else
                cellValue = null;
        }else if(simpleName.equalsIgnoreCase("Boolean")){
            String t_cellValue = String.valueOf(value);
            if(!t_cellValue.trim().equals("") && !t_cellValue.trim().equals("null"))
                cellValue = Boolean.valueOf(t_cellValue);
            else
                cellValue = null;
        }else if(simpleName.equalsIgnoreCase("String")){
            cellValue = String.valueOf(value);
        }else if(simpleName.equalsIgnoreCase("Date")){
            String t_cellValue = String.valueOf(value);
            if(!t_cellValue.trim().equals("")&&!t_cellValue.equals("null"))
                try {
                    cellValue = (Date)value;
                }catch (Exception e){
                    cellValue = new Date(Long.valueOf(t_cellValue));
                }
            else
                cellValue = null;
        }
        return cellValue;
    }
}
