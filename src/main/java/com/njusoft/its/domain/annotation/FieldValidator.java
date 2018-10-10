package com.njusoft.its.domain.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** 
*
* @author 作者 E-mail:857332533@qq.com 
* @date 创建时间：2017年10月10日 上午9:51:44 
* @version 1.0 
* @since JDK 1.7
*/
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface FieldValidator {
	
	/**
	 * 字段名称
	 * @return
	 */
	String name();
	/**
	 * 错误提醒信息
	 * @return
	 */
	String errMsg();
}
