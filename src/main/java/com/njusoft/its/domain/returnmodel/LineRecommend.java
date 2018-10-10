package com.njusoft.its.domain.returnmodel;

import java.util.Date;

import com.njusoft.its.utils.SystemDateUtils;

public class LineRecommend implements Comparable<LineRecommend>{

	private String userId;
	
	private String lineCode;
	
	private String lineName;
	
	private Integer startStation;
	
	private Integer endStation;
	
	private String startStationName;
	
	private String endStationName;
	
	private Integer lineType;
	
	private Double ticketPrice;
	
	private Integer customerNum;
	
	private Double star;
	
	private Date useDate;
	
	private String runtime;
	
	private String planruntimestr;
	
	private Integer seatNum; 
	
	private Integer moreTicket;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

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

	public Integer getStartStation() {
		return startStation;
	}

	public void setStartStation(Integer startStation) {
		this.startStation = startStation;
	}

	public Integer getEndStation() {
		return endStation;
	}

	public void setEndStation(Integer endStation) {
		this.endStation = endStation;
	}

	public String getStartStationName() {
		return startStationName;
	}

	public void setStartStationName(String startStationName) {
		this.startStationName = startStationName;
	}

	public String getEndStationName() {
		return endStationName;
	}

	public void setEndStationName(String endStationName) {
		this.endStationName = endStationName;
	}

	public Integer getLineType() {
		return lineType;
	}

	public void setLineType(Integer lineType) {
		this.lineType = lineType;
	}

	public Double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(Double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public Integer getCustomerNum() {
		return customerNum;
	}

	public void setCustomerNum(Integer customerNum) {
		this.customerNum = customerNum;
	}

	public Double getStar() {
		return star;
	}

	public void setStar(Double star) {
		this.star = star;
	}

	public Date getUseDate() {
		return useDate;
	}

	public void setUseDate(Date useDate) {
		this.useDate = useDate;
	}

	public String getRuntime() {
		return runtime;
	}

	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}

	public String getPlanruntimestr() {
		return planruntimestr;
	}

	public void setPlanruntimestr(String planruntimestr) {
		this.planruntimestr = planruntimestr;
	}

	
	public Integer getSeatNum() {
		return seatNum;
	}

	public void setSeatNum(Integer seatNum) {
		this.seatNum = seatNum;
	}

	public Integer getMoreTicket() {
		return moreTicket;
	}

	public void setMoreTicket(Integer moreTicket) {
		this.moreTicket = moreTicket;
	}

	@Override
	public String toString() {
		return "LineRecommend [userId=" + userId + ", lineCode=" + lineCode + ", lineName=" + lineName
				+ ", startStation=" + startStation + ", endStation=" + endStation + ", startStationName="
				+ startStationName + ", endStationName=" + endStationName + ", lineType=" + lineType + ", ticketPrice="
				+ ticketPrice + ", customerNum=" + customerNum + ", star=" + star + ", useDate=" + useDate
				+ ", runtime=" + runtime + ", planruntimestr=" + planruntimestr + ", seatNum=" + seatNum
				+ ", moreTicket=" + moreTicket + "]";
	}

	@Override
	public int compareTo(LineRecommend o) {
		int i = 0;
		try {
			i = (int) (SystemDateUtils.parseDate(this.getRuntime()).getTime()-SystemDateUtils.parseDate(o.getRuntime()).getTime());
		} catch (Exception e) {
			e.printStackTrace();
		} 
        return i; 
	}
	
	
}
