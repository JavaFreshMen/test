package com.njusoft.its.utils;

import java.lang.reflect.Type;
import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/** 
*
* @author 作者 E-mail:857332533@qq.com 
* @date 创建时间：2017年10月23日 上午11:12:36 
* @version 1.0 
* @since JDK 1.7
*/
public class GsonUtils {
	
	private static final Gson gson = new GsonBuilder()
									.registerTypeAdapter(Date.class, new DateAdapter())
									.create();
	private static final JsonParser jsonParser = new JsonParser();
	
	/**
	 * 对象转为json string
	 * @param object
	 * @return
	 * @throws Exception
	 */
	public static String toJson(Object object) throws Exception{
		return gson.toJson(object);
	}
	
	/**
	 * json string 转为json object
	 * @param message
	 * @return
	 * @throws Exception
	 */
	public static JsonObject parseJson(String message) throws Exception{
		return (JsonObject) jsonParser.parse(message);
	}
	
	/**
	 * 将json转为对象
	 * @param message
	 * @param classOfT
	 * @return 
	 * @return
	 */
	public static <T> T fromJson(String message,Class<T> classOfT){
		return gson.fromJson(message, classOfT);
	}
	
	/**
	 * 将json转为对象
	 * @param message
	 * @param classOfT
	 * @return 
	 * @return
	 */
	public static <T> T fromJson(String message, Type typeOfT){
		return gson.fromJson(message, typeOfT);
	}
}
