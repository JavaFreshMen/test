package com.njusoft.its.utils;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.njusoft.its.datasource.DataSourceCenter;
import com.njusoft.its.domain.SystemConfig;

/**
 * 系统工具类
 * Created by jijia on 2017/4/6.
 */
public class SystemUtils {

    //数组转成string的分隔符
    private static String STRING_SPLIT = ",";
    //转成string的开始标识符
    private static char BEFORE_FLAG = '[';
    //转成string的结束标识符
    private static char AFTER_FLAG = ']';

    /**
     * 将数组转成string对象
     * @param lists 集合数据
     * @return string
     * lists: lisi wangwu
     * return [lisi,wangwu]
     */
    public static String listArray2String(List lists){
        StringBuffer buffer = new StringBuffer(BEFORE_FLAG+"");
        for (Object item : lists) {
            buffer.append(item).append(",");
        }
        if (buffer.lastIndexOf(",") > 0)
            buffer.setCharAt(buffer.lastIndexOf(","), AFTER_FLAG);
        else
            buffer.append(AFTER_FLAG);
        return buffer.toString();
    }

    /**
     * 将字符串数组转为string对象
     * @param strings string数组
     * @return string对象
     */
    public static String listArray2String(String[] strings){
        return listArray2String(Arrays.asList(strings));
    }

    /**
     * 获取日期中的年
     * @param workDate 查询日期  格式为2017-04-01形式
     * @return
     * @throws Exception
     */
    public static String getYear(String workDate) throws Exception{
        return workDate.split("-")[0];
    }

    /**
     * 去年
     * @param workDate
     * @return
     * @throws Exception
     */
    public static String getLastYear(String workDate) throws Exception{
        return String.valueOf(Integer.parseInt(workDate.split("-")[0])-1);
    }

    /**
     * 获取日期中的月
     * @param workDate 查询日期  格式为2017-04-01形式
     * @return
     * @throws Exception
     */
    public static String getMonth(String workDate) throws Exception{
        return workDate.split("-")[1];
    }

    /**
     * 返回该日期所在月份的天数
     * @param workDate 查询日期  格式为2017-04-01形式
     * @return 天数
     * @throws Exception
     */
    public static Integer getDaysOfMonth(String workDate) throws Exception{
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(format.parse(workDate));
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取日期距离当日的时间间隔
     * @param workDate 查询日期  格式为2017-04-01形式
     * @return 天数间隔
     * @throws Exception
     */
    public static Integer getIntervalDays(String workDate,String startDate) throws Exception{
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Long diffDays = (format.parse(workDate).getTime() - format.parse(startDate).getTime())/(24*60*60*1000);
        return diffDays.intValue();
    }
    /**
     * 返回分割后拼接字符串
     * @param str待分隔字符串
     * @param delimiter分隔符
     * @param start开始下标，包含
     * @param end结束下标，不包含
     * @return
     */
    public static String splitStr(String str, String delimiter, int start, int end){
    	String[] strs = str.split(delimiter);
    	if (strs.length<end||start>end){
    		return null;
    	}
    	StringBuffer newStr = new StringBuffer();
    	for (int i = start; i < end; i++) {
    		if (i!=start){
    			newStr.append(delimiter);
    		}
    		newStr.append(strs[i]);
		}
    	return newStr.toString();
    }
    
    /**
     * 保留n位小数
     * @param decimal
     * @param num
     * @return
     */
    public static Double parseNDecimal(Double decimal, int num) {
		return Double.valueOf(String.format("%."+num+"f",decimal));
	}
    
	/**
	 * 根据模块名称和参数名称获取启用的参数值
	 * @param funcName 模块名
	 * @param arguName 参数名
	 * @return
	 */
	public static String loadValidConfig(String funcName,String arguName){
		 Map<String, List<SystemConfig>>  map=DataSourceCenter.sysConfigMap;
		 if (map.containsKey(funcName)&&map.get(funcName).size()>0) {
			 for (SystemConfig systemConfig :  map.get(funcName)) {
				if (systemConfig.getArguNumber().equals(arguName)&&systemConfig.getIsOpen()==1) {
					return systemConfig.getArguValue();
				}
			}
		}
		return null;
	}
}
