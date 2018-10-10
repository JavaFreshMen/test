package com.njusoft.its.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
@JsonAutoDetect
@Entity
@Table(name = "T_GPSMILEAGE")
public class GpsMileage implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
    @Column(name = "GPSMILEAGEID", unique = true, nullable = false)
    @GeneratedValue(generator = "gpsMileage_id_Generator")
    @GenericGenerator(name = "gpsMileage_id_Generator", strategy = "guid")
    private String gpsMileageId;
	@Column(name = "LINECODE")
    private String lineCode;
    @Column(name = "BUSCODE")
    private String busCode;
    @Column(name = "BUSBRANDNO")
    private String busBrandNo;
    @Column(name = "WORKDATE")
    private Date workDate;
    @Column(name = "TOTALGPSMILEAGE")
    private Integer totalGpsMileage;
    @Column(name = "OPERATIONMILEAGE")
    private Integer operationMileage;
    @Column(name = "EMPTYMILEAGE")
    private Integer emptyMileage;
    @Column(name = "CREATETIME")
    private Date createTime;
    @Column(name = "CREATOR")
    private String creator;
	public String getGpsMileageId() {
		return gpsMileageId;
	}
	public void setGpsMileageId(String gpsMileageId) {
		this.gpsMileageId = gpsMileageId;
	}
	public String getLineCode() {
		return lineCode;
	}
	public void setLineCode(String lineCode) {
		this.lineCode = lineCode;
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
	public Date getWorkDate() {
		return workDate;
	}
	public void setWorkDate(Date workDate) {
		this.workDate = workDate;
	}
	public Integer getTotalGpsMileage() {
		return totalGpsMileage;
	}
	public void setTotalGpsMileage(Integer totalGpsMileage) {
		this.totalGpsMileage = totalGpsMileage;
	}
	public Integer getOperationMileage() {
		return operationMileage;
	}
	public void setOperationMileage(Integer operationMileage) {
		this.operationMileage = operationMileage;
	}
	public Integer getEmptyMileage() {
		return emptyMileage;
	}
	public void setEmptyMileage(Integer emptyMileage) {
		this.emptyMileage = emptyMileage;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
}
