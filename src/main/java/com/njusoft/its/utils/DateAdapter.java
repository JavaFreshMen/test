package com.njusoft.its.utils;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

/** 
*
* @author 作者：jijia  E-mail:857332533@qq.com 
* @date 创建时间：2017年12月20日 下午10:30:30 
* @version 1.0 
* @since JDK 1.7
*/
public class DateAdapter implements JsonSerializer<Date>, JsonDeserializer<Date> {
	
	private final static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	private final static SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Override
	public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		if(null == json){
			return null;
		}
		try {
			return new Date(json.getAsLong()); 
		} catch (Exception e) {
			try {
				return dateTimeFormat.parse(json.getAsString());
			} catch (ParseException e1) {
				try {
					return dateFormat.parse(json.getAsString());
				} catch (ParseException e2) {
					e2.printStackTrace();
				}
			}
		}
		return null;
	}

	@Override
	public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
		if(null == src){
			return null;
		}
		return new JsonPrimitive(src.getTime());
	}

}
