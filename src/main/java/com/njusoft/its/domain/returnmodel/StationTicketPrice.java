package com.njusoft.its.domain.returnmodel;

import java.io.Serializable;

/**
 * 站点票价
 * @author yxx 
 * @date 2018年7月18日
 */
public class StationTicketPrice implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer startStation;
	private Double price;
	public Integer getStartStation() {
		return startStation;
	}
	public void setStartStation(Integer startStation) {
		this.startStation = startStation;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "StationTicketPrice [startStation=" + startStation + ", price=" + price + "]";
	}
}
