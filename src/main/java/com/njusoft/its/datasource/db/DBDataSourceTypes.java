package com.njusoft.its.datasource.db;

import com.njusoft.its.datasource.db.decoder.BusDBDataDecoderImpl;
import com.njusoft.its.datasource.db.decoder.LineDBDataDecoderImpl;
import com.njusoft.its.datasource.db.decoder.LineStationDBDataDecoderImpl;
import com.njusoft.its.domain.Bus;
import com.njusoft.its.domain.Line;

/** 
* 数据源类型
* 每种类型 对应的model对象实体 及相应的解析器
* @author 作者 E-mail:857332533@qq.com 
* @date 创建时间：2017年10月24日 上午11:39:50 
* @version 1.0 
* @since JDK 1.7
*/
public enum DBDataSourceTypes {
	//oracle db相关
	DB_LINE("DB_LINE",Line.class,new LineDBDataDecoderImpl()),
	//DB_LINESTATION("DB_LINESTATION",LineStationItem.class,new LineStationDBDataDecoderImpl()),
	DB_BUS("DB_BUS",Bus.class,new BusDBDataDecoderImpl());


	
	
	private String name;
	private Class<?> modelClass;
	private DBDataDecoderAdapter dataDecoder;
	public String getName(){
		return this.name;
	}
	
	public Class<?> getModelClass(){
		return this.modelClass;
	}
	
	public DBDataDecoderAdapter getDataDecoder(){
		return this.dataDecoder;
	}
	
	private DBDataSourceTypes(String name,Class<?> modelClass,DBDataDecoderAdapter dataDecoder) {
		this.name = name;
		this.modelClass = modelClass;
		this.dataDecoder = dataDecoder;
	}
}
