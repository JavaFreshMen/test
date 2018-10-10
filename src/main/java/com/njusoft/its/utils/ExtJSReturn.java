package com.njusoft.its.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Util class, returns a Map in the format Ext JS expects
 * 
 * Sample project presented at BrazilJS
 * Brazilian JavaScript Conference
 * Fortaleza - Cear� - 13-14 May 2011
 * http://braziljs.com.br/2011
 * 
 * @author Loiane Groner
 * http://loianegroner.com (English)
 * http://loiane.com (Portuguese)
 */
public class ExtJSReturn {

	/**
	 * Generates modelMap to return in the modelAndView
	 * @param datas
	 * @return
	 */
	public static Map<String,Object> mapOK(List<? extends Object> datas){
		
		Map<String,Object> modelMap = new HashMap<String,Object>(3);
		modelMap.put("total", datas.size());
		modelMap.put("data", datas);
		modelMap.put("success", true);
		
		return modelMap;
	}
	
	public static Map<String,Object> mapOK(Object data){
		
		Map<String,Object> modelMap = new HashMap<String,Object>(2);
		modelMap.put("data", data);
		modelMap.put("success", true);
		
		return modelMap;
	}
	
	/**
	 * Generates modelMap to return in the modelAndView
	 * @param datas
	 * @return
	 */
	public static Map<String,Object> mapOK(List<? extends Object> datas, int total){
		Map<String,Object> modelMap = new HashMap<String,Object>(3);
		modelMap.put("total", total);
		modelMap.put("data", datas);
		modelMap.put("success", true);
		return modelMap;
	}

	/**
	 * 操作成功
	 * @param msg
	 * @return
	 */
	public static Map<String,Object> mapOK(String msg){
		Map<String,Object> modelMap = new HashMap<String,Object>(2);
		modelMap.put("message", msg);
		modelMap.put("success", true);
		return modelMap;
	}

	/**
	 * 登录成功
	 * @param msg 返回信息
	 * @param csrfToken csrfToken
	 * @return
	 */
	public static Map<String,Object> mapOK(String msg,String csrfToken,String xAuthToken,String token,String realName
			,String deptCodesStr,String lineCodesStr){
		Map<String,Object> modelMap = new HashMap<String,Object>(2);
		modelMap.put("message", msg);
		modelMap.put("csrfToken",csrfToken);
		modelMap.put("x-auth-token",xAuthToken);
		modelMap.put("token",token);
		modelMap.put("realName", realName);
		modelMap.put("success", true);
		modelMap.put("deptCodesStr", deptCodesStr);
		modelMap.put("lineCodesStr", lineCodesStr);
		return modelMap;
	}

	/**
	 * 操作成功
	 * @return
	 */
	public static Map<String,Object> mapOK(){
		Map<String,Object> modelMap = new HashMap<String,Object>(2);
		modelMap.put("success", true);
		modelMap.put("message", "操作成功");
		return modelMap;
	}

	/**
	 * Generates modelMap to return in the modelAndView in case
	 * of exception
	 * @param msg message
	 * @return
	 */
	public static Map<String,Object> mapError(String msg){
		Map<String,Object> modelMap = new HashMap<String,Object>(2);
		modelMap.put("message", msg);
		modelMap.put("data", new ArrayList<>());
		modelMap.put("total", 0);
		modelMap.put("success", false);
		return modelMap;
	}
	
	public static Map<String,Object> mapErrorWithMsg(String msg){
		Map<String,Object> modelMap = new HashMap<String,Object>(2);
		modelMap.put("msg", msg);
		modelMap.put("data", new ArrayList<>());
		modelMap.put("total", 0);
		modelMap.put("success", false);
		return modelMap;
	}

	public static Map<String,Object> mapError(){
		Map<String,Object> modelMap = new HashMap<String,Object>(2);
		modelMap.put("success", false);
		modelMap.put("message", "");
		modelMap.put("data", new ArrayList<>());
		modelMap.put("total", 0);
		return modelMap;
	}
}
