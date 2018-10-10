package com.njusoft.its.domain.returnmodel;

import java.io.Serializable;

/**
 * 模糊搜索线路返回值
 * @author yxx 
 * @date 2018年7月17日
 */
public class LineLike implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3094784768244618198L;
	private String lineCode;
	private String lineName;
    private Integer openState;
    private Integer type;
    
    public LineLike(){}
    
	public LineLike(String lineCode, String lineName, Integer openState, Integer type) {
		super();
		this.lineCode = lineCode;
		this.lineName = lineName;
		this.openState = openState;
		this.type = type;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
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
	public Integer getOpenState() {
		return openState;
	}
	public void setOpenState(Integer openState) {
		this.openState = openState;
	}

	@Override
	public String toString() {
		return "LineLike [lineCode=" + lineCode + ", lineName=" + lineName + ", openState=" + openState + ", type="
				+ type + "]";
	}
}
