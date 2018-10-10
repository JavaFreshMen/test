package com.njusoft.its.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * Created by jia ji on 2017/4/28.
 */
public class SystemDateUtils {

    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    private static SimpleDateFormat time_format = new SimpleDateFormat("HH:mm");
    private static SimpleDateFormat date_time_format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    private static SimpleDateFormat date_time_second_format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static SimpleDateFormat timeSecond_format = new SimpleDateFormat("HH:mm:ss");
    private static SimpleDateFormat date_time_second_format_withoutsymbol = new SimpleDateFormat("yyyyMMddHHmmss");

    /**
     * 计算日期的周数 即当前日期距离2000-01-03的周数
     * @param dateStr 待测的日期 yyyy-MM-dd格式
     * @return
     * @throws Exception
     */
    public static Integer getWeek(String dateStr) throws Exception{
        Long diffWeek = (format.parse(dateStr).getTime() - format.parse("2000-01-03").getTime())/(24*60*60*1000*7);
        return diffWeek.intValue();
    }

    /**
     * 将时间转为日期
     * @param time time字符串 如:08:00
     * @return
     * @throws Exception
     */
    public static Date parseDate(String time) throws Exception{
        return time_format.parse(time);
    }

    /**
     * 将日期时间转为date对象
     * @param dateTime
     * @return
     * @throws Exception
     */
    public static Date parseDateTime(String dateTime) throws Exception{
        return date_time_format.parse(dateTime);
    }

    /**
     * 格式化日期为yyyy-MM-dd的格式
     * @param date
     * @return
     * @throws Exception
     */
    public static String formatDate(Date date) throws Exception{
        return format.format(date);
    }
    
    public static String formatDateTimeSecond(Date date) throws Exception{
    	return date_time_second_format.format(date);
    }
    
    public static String formatDateTimeSecondWithoutSymbol(Date date) throws Exception{
    	return date_time_second_format_withoutsymbol.format(date);
    }

    /**
     * 将日期字符串转为日期类型 yyyy-MM-dd
     * @param date
     * @return
     * @throws Exception
     */
    public static Date parseDate2(String date) throws Exception{
        return format.parse(date);
    }

    public static Date parseDateFromTimeSecond(String date) throws Exception{
        return timeSecond_format.parse(date);
    }

    public static Date parseDateFromTimeSecond(Date date) throws Exception{
        return timeSecond_format.parse(timeSecond_format.format(date));
    }
    
    /**
     * yyyy-MM-dd HH:mm:ss
     * @param date
     * @return
     * @throws Exception
     */
    public static Date parseDate3(String date) throws Exception{
    	return date_time_second_format.parse(date);
    }

    /**
     * 获取日期中的小时时间  HH:mm格式
     * @param date 日期
     * @return
     * @throws Exception
     */
    public static String timeFormat(Date date) throws Exception{
        if(null == date)
            return "";
        return time_format.format(date);
    }

    /**
     * 指定时间上加上分钟
     * @param date 日期
     * @param minutes 增加分钟数
     * @return
     * @throws Exception
     */
    public static Date addTime(Date date,Integer minutes) throws Exception{
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE,minutes);
        return calendar.getTime();
    }

    /**
     * 将时间转为日期
     * @param time time字符串 如:08:00
     * @return
     * @throws Exception
     */
    public static Calendar parseCalendar(String time) throws Exception{
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time_format.parse(time));
        return calendar;
    }

    /**
     * 获取指定日期所在月有多少天
     * @param workDate yyyy-MM-dd格式
     * @return
     * @throws Exception
     */
    public static Integer getDaysOfMonth(String workDate) throws Exception{
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(format.parse(workDate));
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取上月1号的日期 格式 yyyy-MM-dd
     * @param workDate 当前查询的日期
     * @return
     * @throws Exception
     */
    public static String lastMonthFirstDay(String workDate) throws Exception{
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(format.parse(workDate));
        calendar.add(Calendar.MONTH,-1);
        calendar.set(Calendar.DAY_OF_MONTH,1);
        return format.format(calendar.getTime());
    }

    /**
     * 获取上月最后一天的日期 格式 yyyy-MM-dd
     * @param workDate 当前查询的日期
     * @return
     * @throws Exception
     */
    public static String lastMonthLastDay(String workDate) throws Exception{
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(format.parse(workDate));
        calendar.add(Calendar.MONTH,-1);
        calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return format.format(calendar.getTime());
    }

    /**
     * 获取今天的日期
     * @return 日期字符串  格式 yyyy-MM-dd
     * @throws Exception
     */
    public static String currentDate() throws Exception{
        return format.format(new Date());
    }

    /**
     * 获取特定的时间
     * @param minutes 相差的分钟数
     * @return 指定分钟之前或者之后的时间
     * @throws Exception
     */
    public static String specificTime(int minutes) throws Exception{
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MINUTE,calendar.get(Calendar.MINUTE)+minutes);
        calendar.set(Calendar.SECOND,0);
        return timeSecond_format.format(calendar.getTime());
    }

    /**
     * 获取指定的日期
     * @param workDate
     * @param weeks
     * @return
     * @throws Exception
     */
    public static Date specificDate(String workDate,int weeks) throws Exception{
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(format.parse(workDate));
        calendar.set(Calendar.DAY_OF_MONTH,calendar.get(Calendar.DAY_OF_MONTH)+ 7 * weeks);
        return calendar.getTime();
    }

    /**
     * 获取指定的日期
     * @param date
     * @param weeks
     * @return
     * @throws Exception
     */
    public static Date specificDate(Date date,int weeks) throws Exception{
        int diffDays = weeks < 0? 1:-1;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH,calendar.get(Calendar.DAY_OF_MONTH)+ 7 * weeks + diffDays);
        return calendar.getTime();
    }

    /**
     * 获取指定开始日期之后的几天的日期天数字符串
     * @param startDate
     * @param days
     * @return
     * @throws Exception
     */
    public static List<String> allWorkDatesByDays(Date startDate,int days) throws Exception{
        List<String> workDates = new LinkedList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        for(int i=0,len=Math.abs(days);i < len;i++){
            workDates.add(format.format(calendar.getTime()));
            calendar.set(Calendar.DAY_OF_MONTH,calendar.get(Calendar.DAY_OF_MONTH)+1);
        }
        return workDates;
    }
    
    /**
     * 
     * @param startDate
     * @param days
     * @return
     * @throws Exception
     */
    public static String nextWorkDateByDay(String startDate,int day) throws Exception{
        List<String> workDates = new LinkedList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(parseDate2(startDate));
        workDates.add(format.format(calendar.getTime()));
        calendar.set(Calendar.DAY_OF_MONTH,calendar.get(Calendar.DAY_OF_MONTH)+day);
        return formatDate(calendar.getTime());
    }
    
    /**
     * 获取明天日期
     * @return
     * @throws Exception
     */
    public static String tomorrowDate() throws Exception{
    	Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH)+1);
        return format.format(calendar.getTime());
    }
    
    /**
     * 获取昨天日期
     * @return
     * @throws Exception
     */
    public static String lastDate() throws Exception{
    	Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH)-1);
        return format.format(calendar.getTime());
    }

    /**
     * 获取指定开始日期之后的几周的日期天数字符串
     * @param startDate
     * @param weeks
     * @return
     * @throws Exception
     */
    public static List<String> allWorkDates(Date startDate,int weeks) throws Exception{
        return allWorkDatesByDays(startDate,7*weeks);
    }

    /**
     * 判断两个时间是否在同一小时内
     * @param date1
     * @param date2
     * @return true or false
     */
    public static boolean isInHour(Date date1,Date date2){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date1);
        int hour1 = calendar.get(Calendar.HOUR_OF_DAY);
        calendar.setTime(date2);
        int hour2 = calendar.get(Calendar.HOUR_OF_DAY);
        return hour1==hour2?true:false;
    }
    /**
     * 判断两个时间是否在同一小时内
     * @param date1
     * @param date2
     * @return hour or null
     */
    public static Integer isInHour2(Date date1,Date date2){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date1);
        int hour1 = calendar.get(Calendar.HOUR_OF_DAY);
        calendar.setTime(date2);
        int hour2 = calendar.get(Calendar.HOUR_OF_DAY);
        return hour1==hour2?hour1:null;
    }
    /**
     * 获取小时
     * @param date
     * @return hour
     */
    public static Integer getHour(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.HOUR_OF_DAY);
    }
    /**
     * 获取分钟
     * @param date
     * @return hour
     */
    public static Integer getMinute(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MINUTE);
    }
    /**
     * 获取分钟差
     * @param date1
     * @param date2
     * @return hour
     */
    public static Integer getMinuteDiffer(Date date1,Date date2){
        int hour1 = getHour(date1);
        int hour2 = getHour(date2);
        int minute1 = getMinute(date1);
        int minute2 = getMinute(date2);
        return (hour1-hour2)*60+(minute1-minute2);
    }
    /**
     * 获取天数差
     * @param dateSmall
     * @param dateBig
     * @return
     */
    public static Integer getDaysDiffer(Date dateSmall,Date dateBig){
        return (int) ((dateBig.getTime()-dateSmall.getTime())/(1000*60*60*24));
    }
    /**
     * 判断日期字符串是否是同一年同一月，日期格式（yyyy-MM）
     * @param dateStr1
     * @param dateStr2
     * @return
     */
    public static boolean isSameYearMonth(String dateStr1, String dateStr2){
    	try {
			if (dateStr1.split("-")[0].equals(dateStr2.split("-")[0])&&dateStr1.split("-")[1].equals(dateStr2.split("-")[1])){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return false;
    }
    
}
