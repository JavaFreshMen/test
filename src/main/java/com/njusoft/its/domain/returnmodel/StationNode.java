package com.njusoft.its.domain.returnmodel;

import java.io.Serializable;
/**
 * 站点
 * @author yxx 
 * @date 2018年6月14日
 */
public class StationNode implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8669622860043629926L;
	
	private Integer orderNo;
	private Integer flag;
	private String name;
	private Double lat;
	private Double lng;
	private String arriveTime;
	private String position;
	private Double stepPrice;
	
	public Double getStepPrice() {
		return stepPrice;
	}
	public void setStepPrice(Double stepPrice) {
		this.stepPrice = stepPrice;
	}
	public Integer getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getArriveTime() {
		return arriveTime;
	}
	public void setArriveTime(String arriveTime) {
		this.arriveTime = arriveTime;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	@Override
	public String toString() {
		return "StationNode [orderNo=" + orderNo + ", flag=" + flag + ", name=" + name + ", lat=" + lat + ", lng=" + lng
				+ ", arriveTime=" + arriveTime + ", position=" + position + ", stepPrice=" + stepPrice + "]";
	}
}
