package com.njusoft.its.utils;
/**
 * 节假日工具类
* @author 作者 :jijia E-mail:857332533@qq.com 
* @date 创建时间：2018年6月29日 上午10:39:00 
* @version 1.0 
* @since 2018年6月29日 上午10:39:00
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.google.gson.JsonObject;

public class HolidayUtils {
	private final static Logger logger = LoggerFactory.getLogger(HolidayUtils.class);
	
	private final static String HOLIDAY_HOST_URL = "http://api.goseek.cn/Tools/holiday?date=";
	
	private final static int HOLIDAY = 2;		//节假日
	private final static int REST_DAY = 1;		//休息日

	/**
	 * 判断指定的日期是否是节假日
	 * @param workDate
	 * @return
	 */
	public static boolean isHoliday(String workDate){
		if(StringUtils.hasLength(workDate)){
			try {
				String retHolidayJsonStr = SystemHttpUtils.sendGet(HOLIDAY_HOST_URL+workDate);
				JsonObject retHolidayJsonObj = GsonUtils.parseJson(retHolidayJsonStr);
				if(retHolidayJsonObj.get("data").getAsInt() == HOLIDAY){
					return true;
				}
			} catch (Exception e) {
				logger.error("校验是否是节假日异常", e);
			}
		}
		return false;
	}
}
