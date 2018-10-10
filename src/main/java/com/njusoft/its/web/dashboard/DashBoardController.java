package com.njusoft.its.web.dashboard;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashBoardController {

	// 调度系统主页
	@RequestMapping(value = "device-gps")
	public String deviceGps(HttpServletRequest request) {
		return "device-gps/device-gps";
	}
	@RequestMapping(value = "device-gps-detail")
	public String deviceGpsDetail(HttpServletRequest request) {
		return "device-gps/device-gps-detail";
	}
	@RequestMapping(value = "home")
	public String home(HttpServletRequest request) {
		return "home/index";
	}
}
