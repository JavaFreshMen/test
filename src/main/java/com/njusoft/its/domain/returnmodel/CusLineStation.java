package com.njusoft.its.domain.returnmodel;

import java.util.LinkedList;
import java.util.List;
/**
 * 线路站点返回数据
 * @author yxx 
 * @date 2018年6月14日
 */
public class CusLineStation {

	private String lineCode;
	private Double lineKM;
	private Integer direction;
	private Integer runTime;
	private Double starLevel;
	private Integer remarkNum;
	private List<StationNode> stationInfo = new LinkedList<>();
	public String getLineCode() {
		return lineCode;
	}
	public void setLineCode(String lineCode) {
		this.lineCode = lineCode;
	}
	public Double getLineKM() {
		return lineKM;
	}
	public void setLineKM(Double lineKM) {
		this.lineKM = lineKM;
	}
	public Integer getDirection() {
		return direction;
	}
	public void setDirection(Integer direction) {
		this.direction = direction;
	}
	public Integer getRunTime() {
		return runTime;
	}
	public void setRunTime(Integer runTime) {
		this.runTime = runTime;
	}
	public Double getStarLevel() {
		return starLevel;
	}
	public void setStarLevel(Double starLevel) {
		this.starLevel = starLevel;
	}
	public Integer getRemarkNum() {
		return remarkNum;
	}
	public void setRemarkNum(Integer remarkNum) {
		this.remarkNum = remarkNum;
	}
	public List<StationNode> getStationInfo() {
		return stationInfo;
	}
	public void setStationInfo(List<StationNode> stationInfo) {
		this.stationInfo = stationInfo;
	}
	
}
