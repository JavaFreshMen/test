package com.njusoft.its.domain.returnmodel;

import java.util.Date;

/**
 * 足迹返回信息
 * @author hzg
 *
 */
public class History {
	
	private String lineCode;
	
	private String lineName;
	
	private Date orderTime;
	
	private Date remarkTime;
	
	private String remarkContent;
	
	private Double starLevel;

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

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public Date getRemarkTime() {
		return remarkTime;
	}

	public void setRemarkTime(Date remarkTime) {
		this.remarkTime = remarkTime;
	}

	public String getRemarkContent() {
		return remarkContent;
	}

	public void setRemarkContent(String remarkContent) {
		this.remarkContent = remarkContent;
	}

	public Double getStarLevel() {
		return starLevel;
	}

	public void setStarLevel(Double starLevel) {
		this.starLevel = starLevel;
	}

	@Override
	public String toString() {
		return "History [lineCode=" + lineCode + ", lineName=" + lineName + ", orderTime=" + orderTime + ", remarkTime="
				+ remarkTime + ", remarkContent=" + remarkContent + ", starLevel=" + starLevel + "]";
	}
}
