package com.njusoft.its.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.njusoft.its.domain.GpsMileage;
import com.njusoft.its.gps.analyse.GPSMileageAnalyseMgr;
import com.njusoft.its.service.GpsMileageService;
import com.njusoft.its.service.LastLocationService;
import com.njusoft.its.utils.DateUtil;
import com.njusoft.its.utils.ExtJSReturn;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
@RestController
@RequestMapping("gpsMileage")
public class GpsMileageController {

	private final static Logger logger = LoggerFactory.getLogger(GpsMileageController.class);
	
	@Autowired
	private GpsMileageService gpsMileageService;
	@Autowired
	LastLocationService lastLocationService;
	
	@ApiOperation(notes="手动生成指定日期、指定车辆的gps里程分析数据",value="手动生成指定日期、指定车辆的gps里程分析数据")
	@ApiImplicitParams(value={
	@ApiImplicitParam(name="startWorkDate",value="运营日期-开始日期：yyyy-mm-dd",dataType="String",required=true,paramType="query"),
	@ApiImplicitParam(name="endWorkDate",value="运营日期-结束日期：yyyy-mm-dd",dataType="String",required=true,paramType="query"),
	@ApiImplicitParam(name="busCode",value="车辆编号",dataType="String",required=true,paramType="query")
	})
	@RequestMapping(value="analysisGpsMileage/analyseSingleBus.action",method={RequestMethod.GET,RequestMethod.POST})
	public Map<String, ? extends Object> analyseSingleBus(String startWorkDate, String endWorkDate,String busCode) throws Exception{
		String[] busCodeArr = {busCode};
		gpsMileageService.delete(startWorkDate, endWorkDate, null,busCodeArr);
		List<String> workDates=DateUtil.getBetweenDate(startWorkDate, endWorkDate);
		for (String workDate : workDates) {
			GPSMileageAnalyseMgr.getInstance().analyseBusCodes(workDate,Arrays.asList(new String[]{busCode}));
		}
		return  ExtJSReturn.mapOK();
	}
	@ApiOperation(notes="手动生成指定日期所有上线车辆的gps里程分析数据",value="手动生成指定日期所有上线车辆的gps里程分析数据")
	@ApiImplicitParams(value={
	@ApiImplicitParam(name="startWorkDate",value="运营日期-开始日期：yyyy-mm-dd",dataType="String",required=true,paramType="query"),
	@ApiImplicitParam(name="endWorkDate",value="运营日期-结束日期：yyyy-mm-dd",dataType="String",required=true,paramType="query")
	})
	@RequestMapping(value="analysisGpsMileage/analyseBusesDuringDays.action",method={RequestMethod.GET,RequestMethod.POST})
	public Map<String, ? extends Object> analyseBusesDuringDays(String startWorkDate, String endWorkDate) throws Exception{
		gpsMileageService.delete(startWorkDate, endWorkDate, null,null);
		
		List<String> workDates=DateUtil.getBetweenDate(startWorkDate, endWorkDate);
		for (String workDate : workDates) {
			//加载所有上线车辆
			List<String> busCodes=lastLocationService.loadLastLocationBusCodes(startWorkDate, endWorkDate, null, null);
			GPSMileageAnalyseMgr.getInstance().analyseBusCodes(workDate,busCodes);
		}
		return  ExtJSReturn.mapOK();
	}
	
	@ApiOperation(notes="查询gps里程分析数据",value="查询gps里程分析数据")
	@ApiImplicitParams(value={
	@ApiImplicitParam(name="startWorkDate",value="运营日期-开始日期：yyyy-mm-dd",dataType="String",required=true,paramType="query"),
	@ApiImplicitParam(name="endWorkDate",value="运营日期-结束日期：yyyy-mm-dd",dataType="String",required=true,paramType="query"),
	@ApiImplicitParam(name="lineCode",value="线路编号",dataType="String",paramType="query"),
	@ApiImplicitParam(name="busCode",value="车辆编号",dataType="String",required=true,paramType="query")
	})
	@RequestMapping(value="analysisGpsMileage/getGpsMileageList.action",method={RequestMethod.GET,RequestMethod.POST})
	public Map<String, ? extends Object> getGpsMileageList(int start,int limit,String startWorkDate, String endWorkDate, String lineCode,String busCode) throws Exception{
		
		List<GpsMileage> list=gpsMileageService.loadGpsMileage(0, 10000, startWorkDate, endWorkDate, lineCode, busCode);
		return  ExtJSReturn.mapOK(list);
	}
	
	
}
