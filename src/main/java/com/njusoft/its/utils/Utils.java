package com.njusoft.its.utils;

import jxl.CellView;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.UnderlineStyle;
import jxl.write.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.Number;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import com.njusoft.its.model.Operatelog;

public class Utils {

	public static String getGroupValue(String content, String pattern,
	    int groupIndex) {
		String retVal = "";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(content);
		if (m.find()) {
			retVal = m.group(groupIndex);
		}
		return retVal;
	}

	public static double Distance(double lat1, double lng1, double lat2,
	    double lng2) {
		double jl_jd = 102834.74258026089786013677476285;
		double jl_wd = 111712.69150641055729984301412873;
		double b = Math.abs((lng1 - lng2) *
		    jl_jd);
		double a = Math.abs((lat1 - lat2) *
		    jl_wd);
		return Math.sqrt((a *
		    a + b *
		    b));
	}

	/**
	 * 非空返回true
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		return str != null &&
		    !"".equals(str.trim());
	}

	/**
	 * 获取明天的日期
	 * 
	 * @return
	 */
	public static Date getTomorrowDate() {
		Date rDate = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, 1);
			String tomor = sdf.format(cal.getTime());
			rDate = sdf.parse(tomor);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rDate;
	}

	/**
	 * List排重
	 * 
	 * @param list
	 * @return
	 */
	public List<String> clearEqualData(List<String> list) {
		if (list.size() > 0) {
			Set set = new HashSet<String>(list);
			list.clear();
			list.addAll(set);
		}
		return list;
	}

	/**
	 * 字符串首字母大写
	 * 
	 * @param fieldName
	 * @return
	 * @throws Exception
	 */
	public static String getMethodName(String fieldName) throws Exception {
		byte[] items = fieldName.getBytes();
		items[0] = (byte) ((char) items[0] - 'a' + 'A');
		return new String(items);
	}

	public static String loadConfig(String param) {
		String res = "";
		try {
			InputStream in = Utils.class.getClassLoader().getResourceAsStream(
			    "config.properties");
			Properties prop = new Properties();
			prop.load(in);
			res = prop.getProperty(param).toString();
			if (in != null) {
				in.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	/**
	 * 
	 * <p>
	 * 判断字符串是否是数字
	 * </p>
	 * 
	 * @param str
	 * @return
	 * @author: lyz - linyuzhu@nandasoft.com
	 * @date: Created on Sep 14, 2013 10:15:14 PM
	 */
	public static boolean isNum(String str) {
		return str.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
	}

	// 去除重复数据 如{2,2,2,2}→{2}
	public static List<Integer> getOnlyData(List<Integer> dataList) {
		if (dataList.size() <= 1)
			return dataList;
		boolean flag = false;

		List<Integer> list = new ArrayList<Integer>();
		// 排重算法改进
		for (int i = 0; i < dataList.size(); i++) {
			list.clear();
			list.addAll(dataList.subList(0, i + 1));
			if (list.size() > 0) {
				flag = true;
				int count = 0;
				for (int j = i + 1; j < dataList.size(); j++) {
					int index = j %
					    list.size();
					if (!dataList.get(j).equals(list.get(index))) {
						flag = false;
						break;
					}
					count++;
				}
				if (flag &&
				    count %
				        list.size() != 0)
					flag = false;
				if (flag)
					break;
			}
		}
		return list;

		/*
		 * //奇数时 判断是否重复 if(dataList.size()%2!=0) { Integer workday =
		 * dataList.get(0);
		 * 
		 * for(Integer iday: dataList) { if(workday!=iday) { flag = false; break; }
		 * } if(flag) { dataList.clear(); dataList.add(workday); } return dataList;
		 * }
		 * 
		 * List<Integer> list = new ArrayList<Integer>(); List<Integer> list1 = new
		 * ArrayList<Integer>(); List<Integer> list2 = new ArrayList<Integer>();
		 * flag = true; //分割list到两个子集合中 for(int i=0;i<dataList.size();i++) {
		 * if(i<dataList.size()/2) { list1.add(dataList.get(i)); } else {
		 * list2.add(dataList.get(i)); } } //排重 for(int i=0;i<list1.size();i++) {
		 * if(list1.get(i)!=list2.get(i)) { flag = false; break; } } if(flag) { list
		 * = getOnlyData(list1); } else { list = dataList; }
		 * 
		 * return list;
		 */
	}

	/**
	 * 添加到用户操作日志
	 * 
	 * @return
	 */
//	public static Operatelog addOperateLog(HttpServletRequest request,
//	    String content) {
//		// 添加到用户操作日志中
//		String username = "";
//		Cookie cookies[] = request.getCookies();
//		if (cookies != null) {
//			for (int i = 0; i < cookies.length; i++) {
//				if ("username".equals(cookies[i].getName())) {
//					username = cookies[i].getValue();
//					break;
//				}
//			}
//		}
//		Operatelog bean = new Operatelog();
//		bean.setIp(request.getRemoteAddr());
//		bean.setOperator(username);
//		bean.setContent(content);
//		return bean;
//	}

	public static String getUsername(HttpServletRequest request) {
			// 添加到用户操作日志中
			String username = "";
			Cookie cookies[] = request.getCookies();
			if (cookies != null) {
				for (int i = 0; i < cookies.length; i++) {
					if ("username".equals(cookies[i].getName())) {
						username = cookies[i].getValue();
						break;
					}
				}
			}			
			return username;
		}
	
	public static String getCookiesProperty(HttpServletRequest request,
	    String property) {
		String temp = null;
		Cookie cookies[] = request.getCookies();
		if (cookies != null &&
		    property != null) {
			for (int i = 0; i < cookies.length; i++) {
				if (property.equals(cookies[i].getName())) {
					temp = unescape(cookies[i].getValue());
					break;
				}
			}
		}
		return temp;
	}

	public static String unescape(String src) {
		StringBuffer tmp = new StringBuffer();
		tmp.ensureCapacity(src.length());
		int lastPos = 0, pos = 0;
		char ch;
		while (lastPos < src.length()) {
			pos = src.indexOf("%", lastPos);
			if (pos == lastPos) {
				if (src.charAt(pos + 1) == 'u') {
					ch = (char) Integer.parseInt(src.substring(pos + 2, pos + 6), 16);
					tmp.append(ch);
					lastPos = pos + 6;
				} else {
					ch = (char) Integer.parseInt(src.substring(pos + 1, pos + 3), 16);
					tmp.append(ch);
					lastPos = pos + 3;
				}
			} else {
				if (pos == -1) {
					tmp.append(src.substring(lastPos));
					lastPos = src.length();
				} else {
					tmp.append(src.substring(lastPos, pos));
					lastPos = pos;
				}
			}
		}
		return tmp.toString();
	}

	/**
	 * 非空(空格,null ,'null','undefined') 返回true
	 * 
	 * @param str
	 * @return
	 */
	public static boolean validateStringNull(String str) {
		if (str == null ||
		    str.trim().length() <= 0 || "null".equalsIgnoreCase(str) ||
		    "undefined".equalsIgnoreCase(str))
			return false;
		else
			return true;
	}

	/**
	 * 非空(空格,null ,'null','undefined') 返回去除左右空格值 否则 返回 NULL
	 * 
	 * @param arg
	 * @return
	 */
	public static String returnNullIfEmpty(String arg) {
		if (arg == null ||
		    arg.trim().length() <= 0 || "null".equalsIgnoreCase(arg) ||
		    "undefined".equalsIgnoreCase(arg))
			return null;
		else
			return arg.trim();
	}

	/**
	 * 非空(空格,null ,'null','undefined') 返回去除左右空格值
	 * 
	 * @param arg
	 * @return
	 */
	public static String returnEmptyIfEmpty(String arg) {
		if (arg == null ||
		    arg.trim().length() <= 0 || "null".equalsIgnoreCase(arg) ||
		    "undefined".equalsIgnoreCase(arg))
			return "";
		else
			return arg.trim();
	}
	/**
	 *'null','undefined' 返回‘’
	 * 
	 * @param arg
	 * @return
	 */
	public static String returnEmptyIfNull(String arg) {
		if (arg == null ||
			    arg.trim().length() <= 0 || "null".equalsIgnoreCase(arg) ||
			    "undefined".equalsIgnoreCase(arg))
				return "";
			else
				return arg.trim();
		}
	
	public static Number returnEmptyIfEmpty(Number arg) {
		if (arg == null)
			return 0;
		else
			return arg;
	}

	public static String returnEmptyIfEmpty(Date arg, SimpleDateFormat sdf) {
		if (arg == null ||
		    !isDate(arg, sdf))
			return "";
		else
			return sdf.format(arg);
	}

	public static String returnEmptyIfEmpty(Date arg, String format) {
		if (arg == null ||
		    !isDate(arg, format))
			return "";
		else
			return new SimpleDateFormat(format).format(arg);
	}

	public static Date returnEmptyIfEmpty(String arg, String format)
	    throws ParseException {
		if (!validateStringNull(arg) ||
		    !isDate(arg, format))
			return null;
		else
			return new SimpleDateFormat(format).parse(arg);
	}

	/**
	 * * 判断日期格式
	 * 
	 * @param str
	 * @param format
	 * @return
	 */
	public static boolean isDate(String str, String format) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			Date date = (Date) sdf.parse(str);
			return str.equals(sdf.format(date));
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 判断日期格式
	 * 
	 * @param str
	 * @param sdf
	 * @return
	 */
	public static boolean isDate(String str, SimpleDateFormat sdf) {
		try {
			Date date = (Date) sdf.parse(str);
			return str.equals(sdf.format(date));
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 判断日期格式
	 * 
	 * @param date
	 * @param sdf
	 * @return
	 */
	public static boolean isDate(Date date, SimpleDateFormat sdf) {
		try {
			String str = (String) sdf.format(date);
			return date.equals(sdf.parse(str));
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 ** 判断日期格式
	 * @param date
	 * @param format
	 * @return
	 */
	public static boolean isDate(Date date, String format) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			String str = (String) sdf.format(date);
			return date.equals(sdf.parse(str));
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 判断字符串是否是整数
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isInteger(String value) {
		try {
			Integer.parseInt(value);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 * 判断字符串是否是浮点数
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isDouble(String value) {
		try {
			Double.parseDouble(value);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 * 判断是否为数字(integer,double)
	 * @param arg
	 * @return
	 */
	public static boolean isNumber(String arg) {
		try {
			return isInteger(arg) ||
			    isDouble(arg);
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 判断是否为整数0 或 1
	 * @param arg
	 * @return
	 */
	public static boolean is0or1(String arg) {
		try {
			int a = Integer.parseInt(arg);
			return a == 0 ||
			    a == 1;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	 public static int getMinutes(java.util.Date date)
	   {
		   int retVal = 0;
		   try{
			   int hours = Integer.parseInt(new SimpleDateFormat("HH", Locale.CHINA).format(date));
			   int minutes = Integer.parseInt(new SimpleDateFormat("mm", Locale.CHINA).format(date));
			   retVal = hours*60 + minutes;
			   
		   }catch(Exception e){
			   
		   }
		   return retVal; //new SimpleDateFormat("HH:mm", Locale.CHINA).format(date);
	   }
	 public static Date minTodate(double time,Date date)
	   {

		  try{
			  int hourtime = (int) (time/60);
		  	double mintime = (time%60);
		  	date.setHours(hourtime);
		  	date.setMinutes((int) mintime);
		  
		  	}catch(Exception e){
			   
		 }
		   
		   return date; //new SimpleDateFormat("HH:mm", Locale.CHINA).format(date);
	   }
	 
	 public static String getEncoding(String str) {      
	       String encode = "GB2312";      
	      try {      
	          if (str.equals(new String(str.getBytes(encode), encode))) {      
	               String s = encode;      
	              return s;      
	           }      
	       } catch (Exception exception) {      
	       }      
	       encode = "ISO-8859-1";      
	      try {      
	          if (str.equals(new String(str.getBytes(encode), encode))) {      
	               String s1 = encode;      
	              return s1;      
	           }      
	       } catch (Exception exception1) {      
	       }      
	       encode = "UTF-8";      
	      try {      
	          if (str.equals(new String(str.getBytes(encode), encode))) {      
	               String s2 = encode;      
	              return s2;      
	           }      
	       } catch (Exception exception2) {      
	       }      
	       encode = "GBK";      
	      try {      
	          if (str.equals(new String(str.getBytes(encode), encode))) {      
	               String s3 = encode;      
	              return s3;      
	           }      
	       } catch (Exception exception3) {      
	       }      
	      return "";      
	 }

	 /**
	 * 导出
	 */
	public static void exportExcel(HttpServletResponse response,List list,List<String> listHead,String fileName,String sheetName) throws Exception {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			/**
			 * 自定义样式
			 */
			WritableFont wf_head = new WritableFont(WritableFont.createFont("黑体"), 12, WritableFont.BOLD, false,
					UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.GREEN);
			WritableFont wf_table = new WritableFont(WritableFont.createFont("宋体"), 10, WritableFont.BOLD, false,
					UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);
			WritableCellFormat wcf_head = new WritableCellFormat(wf_head);
			wcf_head.setAlignment(jxl.format.Alignment.CENTRE);
			wcf_head.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
			wcf_head.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
			WritableCellFormat wcf_table = new WritableCellFormat(wf_table);
			wcf_table.setAlignment(jxl.format.Alignment.CENTRE);
			wcf_table.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
			// 取得输出流
			OutputStream out = response.getOutputStream();
			response.reset();
			response.setHeader("Content-Disposition", "attachment;filename="
					+ new String((fileName).getBytes("gb2312"), "ISO8859-1") + sdf.format(new Date()) + ".xls");
			response.setContentType("application/msexcel");
			WritableWorkbook workbook = Workbook.createWorkbook(out);
			WritableSheet sheet = workbook.createSheet(sheetName, 0);
			CellView cellView = new CellView();
			// cellView.setAutosize(true); // 设置自动大小
			// col
			for (int col = 0; col < listHead.size(); col++) {
				sheet.setColumnView(col, 20);// 根据内容自动设置列宽
			}
			// 组装单元格
			sheet.addCell(new Label(0, 0, sheetName, wcf_head));
			sheet.mergeCells(0, 0, listHead.size()-1, 0);


			int index=0;
			for(String entry: listHead){
				String[] ary = entry.split("\\.",2);
				sheet.addCell(new Label(index, 1, ary[1], wcf_head));
				Method method = list.get(0).getClass().getMethod("get"+ary[0]);
				for (int i = 0; i < list.size(); i++) {
					sheet.addCell(new Label(index, 2 + i, String.valueOf(method.invoke(list.get(i))), wcf_table));
				}
				index++;
			}

			workbook.write();
			workbook.close();
			out.flush();
			out.close();
		} catch (Exception e) {

		}
	}
	/**
	 * 导入
	 * @return
	 */
	public static List importExcel(HttpServletRequest request, HttpServletResponse response, List list, List<String> listColumn, Object obj) throws Exception {
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		try {
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			MultipartFile multipartFile = multipartRequest.getFile("file");
			Workbook wb = Workbook.getWorkbook(multipartFile.getInputStream());
			// 获取工作表
			Sheet sheet = wb.getSheet(0);
			// 按行读取
			for (int i = 2; i < sheet.getRows(); i++) {
				int index=0;
				for(String entry: listColumn){
					Method[] methods=obj.getClass().getMethods();
					for(Method methodary:methods){
						if(methodary.getName().equals("set"+entry)){
							methodary.invoke(obj, sheet.getCell(index, i).getContents());
						}
					}
					index++;
				}
				list.add(obj);
			}
			wb.close();
			// logService.save(Utils.addOperateLog(request, "【导入】车辆信息导入"));
			out.print("{success:true}");

		} catch (Exception e) {

			out.print("{success:false,msg:'数据处理异常！'}");
		}
		return list;
	}

	public static void safeClose(Object... arg) {
		if (arg != null)
			for (int i = 0; i < arg.length; i++) {
				if (arg[i] instanceof ResultSet)
					Utils.safeClose((ResultSet) arg[i]);
				else if (arg[i] instanceof Statement)
					Utils.safeClose((Statement) arg[i]);
				else if (arg[i] instanceof Connection)
					Utils.safeClose((Connection) arg[i]);
				else if (arg[i] instanceof InputStream)
					Utils.safeClose((InputStream) arg[i]);
				else if (arg[i] instanceof OutputStream)
					Utils.safeClose((OutputStream) arg[i]);
				else if (arg[i] instanceof WritableWorkbook)
					Utils.safeClose((WritableWorkbook) arg[i]);
				else if (arg[i] instanceof Workbook)
					Utils.safeClose((Workbook) arg[i]);
			}
	}

	/**
	 * 生成guid
	 */
	public static String createGuid(){
		return UUID.randomUUID().toString().replace("-", "").toUpperCase();
	}
	
	/**
	 * 将String型的.5转为0.5
	 */
	public static String prepend0BeforeStr(String str){
		if (".".equals(str.substring(0, 1))){
			return "0"+str;
		}
		return str;
	}
	
	/**
	 * 保留小数点后几位
	 * @param value
	 * @param num
	 * @return
	 */
	public static Double transValue(Double value, Integer num) {
		try {
			return Double.valueOf(String.format("%."+num+"f",value));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0d;
	}
	/**
	 * 防止出现 "a,b,c,,44,,,"字符串调用split之后数组长为5(期望为8)的现象
	 * @param str
	 * @param seprator 分隔符 必须是单个字符
	 * @return
	 */
	public static String[] fillStrSplitArrLength(String str,String seprator){
		String[] src=str.split(seprator);
		if (str.endsWith(seprator)) {
			int count=0;
			char[] chars=new char[str.length()];
			str.getChars(0, str.length(),chars,0);
			for(int i=chars.length-1;i>=0;i--){
				if (String.valueOf(chars[i]).equals(seprator)) {
					count++;
				}else {
					break;
				}
			}
			String[] result=new String[src.length+count];
			System.arraycopy(str.split(seprator),0,result,0,src.length);
			return result;
		}else{
			return src;
		}
		
		
	}
}
