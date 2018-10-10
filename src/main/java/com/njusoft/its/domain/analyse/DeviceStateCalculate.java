package com.njusoft.its.domain.analyse;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class DeviceStateCalculate implements Serializable , Comparable<DeviceStateCalculate> {

	private static final long serialVersionUID = 1L;
	// 车辆基础信息
	private String busCode;
	private String busCusCode;
	private String busBrandNo;
	private String lineCode;
	private String deviceBrand;
	private String deviceType;
	private Date useDate;
	private String useDateStr;
	//流水计划信息
	private String startRunTime;//开始运营时间
	private String endRunTime;	//结束运营时间
	private String dispatchPlanRuntimeRange;
	// gps基础信息
	private Date workDate;
	private String workDateStr;
	// 统计指标
	private int offLineCount;
	private int  totalOfflinePackCount;//离线包数
	private long offLineTime;
	private int additionalDataCount;
	private long additinalDataTime;
	// 统计指标追溯明细
	private String offlineTimeRange;
	private String offLinePackPerMinMap;
	private String uploadAdditionalsTimeRange;
	private String 	additionalPackPerMinMap;
	
	public int getTotalOfflinePackCount() {
		return totalOfflinePackCount;
	}

	public void setTotalOfflinePackCount(int totalOfflinePackCount) {
		this.totalOfflinePackCount = totalOfflinePackCount;
	}

	public String getBusCode() {
		return busCode;
	}

	public void setBusCode(String busCode) {
		this.busCode = busCode;
	}

	public String getBusCusCode() {
		return busCusCode;
	}

	public void setBusCusCode(String busCusCode) {
		this.busCusCode = busCusCode;
	}

	public String getBusBrandNo() {
		return busBrandNo;
	}

	public void setBusBrandNo(String busBrandNo) {
		this.busBrandNo = busBrandNo;
	}

	public String getLineCode() {
		return lineCode;
	}

	public void setLineCode(String lineCode) {
		this.lineCode = lineCode;
	}

	public String getDeviceBrand() {
		return deviceBrand;
	}

	public void setDeviceBrand(String deviceBrand) {
		this.deviceBrand = deviceBrand;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public Date getUseDate() {
		return useDate;
	}

	public void setUseDate(Date useDate) {
		this.useDate = useDate;
	}

	public String getUseDateStr() {
		return useDateStr;
	}

	public void setUseDateStr(String useDateStr) {
		this.useDateStr = useDateStr;
	}

	public Date getWorkDate() {
		return workDate;
	}

	public void setWorkDate(Date workDate) {
		this.workDate = workDate;
	}

	public String getWorkDateStr() {
		return workDateStr;
	}

	public void setWorkDateStr(String workDateStr) {
		this.workDateStr = workDateStr;
	}

	public int getOffLineCount() {
		return offLineCount;
	}

	public void setOffLineCount(int offLineCount) {
		this.offLineCount = offLineCount;
	}

	public long getOffLineTime() {
		return offLineTime;
	}

	public void setOffLineTime(long offLineTime) {
		this.offLineTime = offLineTime;
	}

	public int getAdditionalDataCount() {
		return additionalDataCount;
	}

	public void setAdditionalDataCount(int additionalDataCount) {
		this.additionalDataCount = additionalDataCount;
	}

	public long getAdditinalDataTime() {
		return additinalDataTime;
	}

	public void setAdditinalDataTime(long additinalDataTime) {
		this.additinalDataTime = additinalDataTime;
	}

	public String getOfflineTimeRange() {
		return offlineTimeRange;
	}

	public void setOfflineTimeRange(String offlineTimeRange) {
		this.offlineTimeRange = offlineTimeRange;
	}


	public String getUploadAdditionalsTimeRange() {
		return uploadAdditionalsTimeRange;
	}

	public void setUploadAdditionalsTimeRange(String uploadAdditionalsTimeRange) {
		this.uploadAdditionalsTimeRange = uploadAdditionalsTimeRange;
	}

	public String getAdditionalPackPerMinMap() {
		return additionalPackPerMinMap;
	}
	public void setAdditionalPackPerMinMap(String additionalPackPerMinMap) {
		this.additionalPackPerMinMap = additionalPackPerMinMap;
	}
	public String getOffLinePackPerMinMap() {
		return offLinePackPerMinMap;
	}
	public void setOffLinePackPerMinMap(String offLinePackPerMinMap) {
		this.offLinePackPerMinMap = offLinePackPerMinMap;
	}
	public String getStartRunTime() {
		return startRunTime;
	}

	public void setStartRunTime(String startRunTime) {
		this.startRunTime = startRunTime;
	}

	public String getEndRunTime() {
		return endRunTime;
	}

	public void setEndRunTime(String endRunTime) {
		this.endRunTime = endRunTime;
	}

	public String getDispatchPlanRuntimeRange() {
		return dispatchPlanRuntimeRange;
	}

	public void setDispatchPlanRuntimeRange(String dispatchPlanRuntimeRange) {
		this.dispatchPlanRuntimeRange = dispatchPlanRuntimeRange;
	}

/*	@Override
	public String toString() {
		return busCode + "," + busCusCode + "," + busBrandNo + "," + lineCode + "," + deviceBrand + "," + deviceType
				+ "," + useDateStr + "," + workDateStr + "," + offLineCount + "," +	totalOfflinePackCount+","+ offLineTime + ","
				+ additionalDataCount + "," + additinalDataTime + "," + offlineTimeRange 
				+","+offLinePackPerMinMap+ "," + uploadAdditionalsTimeRange+","+additionalPackPerMinMap;
	}*/
	@Override
	public int compareTo(DeviceStateCalculate model) {
	    return Long.valueOf(model.getOffLineTime()).compareTo( Long.valueOf(this.getOffLineTime()));
	}

}
