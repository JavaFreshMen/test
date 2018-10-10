package com.njusoft.its.domain.returnmodel;

import java.io.Serializable;
/**
 * 关注线路
 * @author yxx 
 * @date 2018年6月19日
 */
public class CareLineRet implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3829026928981451285L;
	private String lineCode;
	private String lineName;
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
	@Override
	public String toString() {
		return "CareLine [lineCode=" + lineCode + ", lineName=" + lineName + "]";
	}
}
