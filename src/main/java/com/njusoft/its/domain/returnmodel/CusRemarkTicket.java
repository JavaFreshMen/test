package com.njusoft.its.domain.returnmodel;

import java.io.Serializable;
/**
 * 评价
 * @author yxx 
 * @date 2018年6月14日
 */
public class CusRemarkTicket implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4101006447143237528L;
	private Double starLevel;
	private Integer remarkNum;
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
	
}
