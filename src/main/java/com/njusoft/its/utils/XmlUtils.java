package com.njusoft.its.utils;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;

/**
 * xml解析工具
* @author 作者 David Ji E-mail:857332533@qq.com 
* @date 创建时间：2017年10月24日 上午10:21:49 
* @version 1.0 
* @since 2017年10月24日 上午10:21:49
 */

public class XmlUtils {
	
	private final static Logger logger = Logger.getLogger(XmlUtils.class);
	
	/**
	 * xml字符串转为对象形式
	 * @param xmlStr
	 * @param beanClass
	 * @return
	 */
	public static Object xmlStr2Bean(String xmlStr,Class<?> beanClass){
		try {
			JAXBContext context = JAXBContext.newInstance(beanClass);  
			Unmarshaller unmarshaller = context.createUnmarshaller(); 
			Object object = unmarshaller.unmarshal(new StringReader(xmlStr));
			return object;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		return null;
	}

}
