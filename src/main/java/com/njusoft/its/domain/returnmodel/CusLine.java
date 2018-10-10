package com.njusoft.its.domain.returnmodel;

public class CusLine {
	private String startStation;
	private String endStation;
	private String lineCode;
	private Integer lineType;
	private String ticketPrice;
	private Integer customerNum;
	
	public String getStartStation() {
		return startStation;
	}
	public void setStartStation(String startStation) {
		this.startStation = startStation;
	}
	public String getEndStation() {
		return endStation;
	}
	public void setEndStation(String endStation) {
		this.endStation = endStation;
	}
	public String getLineCode() {
		return lineCode;
	}
	public void setLineCode(String lineCode) {
		this.lineCode = lineCode;
	}
	public Integer getLineType() {
		return lineType;
	}
	public void setLineType(Integer lineType) {
		this.lineType = lineType;
	}
	public String getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(String ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	public Integer getCustomerNum() {
		return customerNum;
	}
	public void setCustomerNum(Integer customerNum) {
		this.customerNum = customerNum;
	}

}
