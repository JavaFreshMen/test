 package com.njusoft.its.utils;
 
 import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import org.springframework.util.StringUtils;
 
 public class DateUtil
 {
   public static String toString(Calendar cal)
   {
     return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ms", Locale.CHINA).format(cal.getTime());
   }
   
   public static String dateToString(Date date)
   {
	   String retVal="";
	   try{
		   if(date!=null)
			   retVal = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(date);
	   }catch(Exception e){
		 
	   }
	   return retVal;
   }
   
   public static String dateToString(java.util.Date date)
   {
     return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(date);
   }
   
   public static String dateToDateString(java.util.Date date)
   {
	   String retVal="";
	   try{
		   if(date!=null)
			   retVal = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).format(date);
	   }catch(Exception e){
		 
	   }
	   return retVal;
   }
   
   public static String dateToTimeString(java.util.Date date)
   {
	   String retVal="";
	   try{
		   if(date!=null)
			   retVal = new SimpleDateFormat("HH:mm", Locale.CHINA).format(date);
	   }catch(Exception e){
		 
	   }
	   return retVal;
   }
   
   public static String getCurDate()
   {
	   Date date = new Date(System.currentTimeMillis());
	   return new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).format(date);
   }
   
   public static String getCurDatetime()
   {
	   Date date = new Date(System.currentTimeMillis());
	   return dateToString(date);
   }
   
   public static String filterDate(String date)
   {
	   return StringUtils.hasLength(date) ? date.replace("T00:00:00", "") : null;
   }
   
   public static java.util.Date getDate(Object obj){
 	   java.util.Date date = null;
 	   try {
 			SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
 			if(Utils.validateStringNull( obj.toString()))
 				date =  sdf.parse(obj.toString());
 				
 		} catch (Exception e) {
 			e.printStackTrace();
 			// TODO: handle exception
 		}
 		return date;
    }

    public static java.util.Date getDate(java.util.Date dateTime)throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String s = sdf.format(dateTime);
        return sdf.parse(s);
    }

     public static java.util.Date stringToDate(String date) throws Exception
     {
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
         return sdf.parse(date);
     }
     /**
      *  
      * @param  Date date yyyy-MM-dd HH:mm:ss
      * @return String HH:mm:ss
      * @throws Exception
      */
     public static String getClockTime(java.util.Date date) throws Exception
     {
         SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
         return sdf.format(date);
     }
     public static java.util.Date getDateToMin(java.util.Date dateTime)throws Exception{
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
         String s = sdf.format(dateTime);
         return sdf.parse(s);
     }
     
     
     /**
      * 获取指定起止日期(含边界)直接所有日期
      * @param startDate
      * @param endDate
      * @return List<String>
      */
     public static List<String> getBetweenDate(String startDate, String endDate){
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
         // 声明保存日期集合
         List<String> list = new ArrayList<String>();
         try {
             // 转化成日期类型
        	 java.util.Date sdate = sdf.parse(startDate);
        	 java.util.Date edate = sdf.parse(endDate);
  
             //用Calendar 进行日期比较判断
             Calendar calendar = Calendar.getInstance();
             while (sdate.getTime()<=edate.getTime()){
                 // 把日期添加到集合
                 list.add(sdf.format(sdate));
                 // 设置日期
                 calendar.setTime(sdate);
                 //把日期增加一天
                 calendar.add(Calendar.DATE, 1);
                 // 获取增加后的日期
                 sdate=calendar.getTime();
             }
         } catch (ParseException e) {
             e.printStackTrace();
         }
         return list;
     }
 }
