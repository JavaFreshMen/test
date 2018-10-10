package com.njusoft.its.domain.returnmodel;

import java.util.Date;

public class RealBusLocation {

	private String lineCode;
	
	private String lineName;
	
	private String busCode;
	
	private String busBrandNo;
	
	private Double lat;
	
	private Double lng;
	
	private Integer busState;
	
	private Date occurTime;

	public String getLineCode() {
		return lineCode;
	}

	public void setLineCode(String lineCode) {
		this.lineCode = lineCode;
	}

	public String getLineName() {
		return lineName;
	}

	public void setLineName(String lineName) {
		this.lineName = lineName;
	}

	public String getBusCode() {
		return busCode;
	}

	public void setBusCode(String busCode) {
		this.busCode = busCode;
	}

	public String getBusBrandNo() {
		return busBrandNo;
	}

	public void setBusBrandNo(String busBrandNo) {
		this.busBrandNo = busBrandNo;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLng() {
		return lng;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}

	public Integer getBusState() {
		return busState;
	}

	public void setBusState(Integer busState) {
		this.busState = busState;
	}

	public Date getOccurTime() {
		return occurTime;
	}

	public void setOccurTime(Date occurTime) {
		this.occurTime = occurTime;
	}

	@Override
	public String toString() {
		return "RealBusLocation [lineCode=" + lineCode + ", lineName=" + lineName + ", busCode=" + busCode
				+ ", busBrandNo=" + busBrandNo + ", lat=" + lat + ", lng=" + lng + ", busState=" + busState
				+ ", occurTime=" + occurTime + "]";
	}
}
