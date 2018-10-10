package com.njusoft.its.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.njusoft.its.domain.Bus;
import com.njusoft.its.service.BusService;
import com.njusoft.its.utils.ExtJSReturn;
/**
 * 
 * @author Louise
 *
 */
@RestController
@RequestMapping("bus")
public class BusController {

	private final static Logger logger = LoggerFactory.getLogger(BusController.class);
	
	@Autowired
	private BusService service;
	@RequestMapping(value="loadAllBusInfo.action",method={RequestMethod.GET,RequestMethod.POST})
	public Map<String, ? extends Object> checkFileExits() throws Exception{
		List<Bus> buses=service.loadAllBuses();
		return  ExtJSReturn.mapOK(buses);
	}
	
	 @RequestMapping(value="viewGlobal.action",method={RequestMethod.GET,RequestMethod.POST})
	 public @ResponseBody  Map<String, ? extends Object> queryGlobalList(HttpServletRequest request) throws Exception {
	        try {
	            List<Bus> list = service.queryGlobalList();
	            return ExtJSReturn.mapOK(list);
	        } catch (Exception e) {
	        	e.printStackTrace();
	        	logger.error(e.getMessage());
	            return ExtJSReturn.mapError(e.getMessage());
	        }
	    }
	
	

	
}
