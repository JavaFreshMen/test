package com.njusoft.its.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
@Entity
@Table(name = "T_BUS")
public class Bus implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name = "BUSID", unique = true, nullable = false)
    @GeneratedValue(generator = "BasicInfo_Bus_Generator")
    @GenericGenerator(name = "BasicInfo_Bus_Generator", strategy = "guid")
    private String busId;
    @Column(name = "BUSCODE")
    private String busCode;
    @Column(name = "BUSBRANDNO")
    private String busBrandNo;
    @Column(name = "BUSSCOPE")
    private String busScope;
    @Column(name = "LINECODE")
    private String lineCode;
    @Column(name = "FEATURE")
    private String feature;
    @Column(name = "STATE")
    private String state;
    @Column(name = "BUSTYPE")
    private String busType;
    @Column(name = "SEATNUM")
    private String seatNum;
    @Column(name = "LIMITEDNUM")
    private String limitedNum;
    @Column(name = "USEDATE")
    private Date useDate;
    @Column(name = "ISDISABLE")
    private Integer isDisable;
    @Column(name = "ISINSTALL")
    private Integer isInstall;
    @Column(name = "DEVICEBRAND")
    private String deviceBrand;
    @Column(name = "DEVICETYPE")
    private Integer deviceType;
    @Column(name = "DEVICECODE")
    private String deviceCode;
    @Column(name = "DEVICESIMCARDNO")
    private String deviceSimCardNo;
    @Column(name = "VIDEOBRAND")
    private String videoBrand;
    @Column(name = "VIDEOTYPE")
    private String videoType;
    @Column(name = "VIDEOCODE")
    private String videoCode;
    @Column(name = "VIDEOSIMCARDNO")
    private String videoSimCardNo;
    @Column(name = "EDITOR")
    private String editor;
    @Column(name = "EDITTIME")
    private Date editTime;
    @Column(name = "CREATOR")
    private String creator;
    @Column(name = "CREATETIME")
    private Date createTime;
    @Column(name = "BUSCUSCODE")
    private String busCusCode;
    @Column(name = "FLOWCODE")
    private String flowCode;
    
    @Transient
    private String lineName;
    @Transient
    private String deptCode;
    @Transient
    private String deptName;   

	public String getBusCusCode() {
		return busCusCode;
	}

	public void setBusCusCode(String busCusCode) {
		this.busCusCode = busCusCode;
	}
	

	public String getFlowCode() {
		return flowCode;
	}

	public void setFlowCode(String flowCode) {
		this.flowCode = flowCode;
	}

	public String getBusId() {
		return busId;
	}

	public void setBusId(String busId) {
		this.busId = busId;
	}

	public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getBusScope() {
        return busScope;
    }

    public void setBusScope(String busScope) {
        this.busScope = busScope;
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

    public String getLineCode() {
        return lineCode;
    }

    public void setLineCode(String lineCode) {
        this.lineCode = lineCode;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getBusType() {
        return busType;
    }

    public void setBusType(String busType) {
        this.busType = busType;
    }

    public String getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(String seatNum) {
        this.seatNum = seatNum;
    }

    public String getLimitedNum() {
        return limitedNum;
    }

    public void setLimitedNum(String limitedNum) {
        this.limitedNum = limitedNum;
    }

    public Date getUseDate() {
        return useDate;
    }

    public void setUseDate(Date useDate) {
        this.useDate = useDate;
    }

    public Integer getIsDisable() {
        return isDisable;
    }

    public void setIsDisable(Integer isDisable) {
        this.isDisable = isDisable;
    }

    public Integer getIsInstall() {
        return isInstall;
    }

    public void setIsInstall(Integer isInstall) {
        this.isInstall = isInstall;
    }

    public String getDeviceBrand() {
        return deviceBrand;
    }

    public void setDeviceBrand(String deviceBrand) {
        this.deviceBrand = deviceBrand;
    }

    public Integer getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(Integer deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public String getDeviceSimCardNo() {
        return deviceSimCardNo;
    }

    public void setDeviceSimCardNo(String deviceSimCardNo) {
        this.deviceSimCardNo = deviceSimCardNo;
    }

    public String getVideoBrand() {
        return videoBrand;
    }

    public void setVideoBrand(String videoBrand) {
        this.videoBrand = videoBrand;
    }

    public String getVideoType() {
        return videoType;
    }

    public void setVideoType(String videoType) {
        this.videoType = videoType;
    }

    public String getVideoCode() {
        return videoCode;
    }

    public void setVideoCode(String videoCode) {
        this.videoCode = videoCode;
    }

    public String getVideoSimCardNo() {
        return videoSimCardNo;
    }

    public void setVideoSimCardNo(String videoSimCardNo) {
        this.videoSimCardNo = videoSimCardNo;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public Date getEditTime() {
        return editTime;
    }

    public void setEditTime(Date editTime) {
        this.editTime = editTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "车辆信息{" +
                "车辆编号='" + busCode + '\'' +
                ", 车牌号码='" + busBrandNo + '\'' +
                ", 车辆规模='" + busScope + '\'' +
                ", 线路编号='" + lineCode + '\'' +
                ", 车辆性质='" + feature + '\'' +
                ", 车辆状态='" + state + '\'' +
                ", 车辆类型='" + busType + '\'' +
                ", 座位数='" + seatNum + '\'' +
                ", 限载人数='" + limitedNum + '\'' +
                ", 车辆投产日期=" + useDate +
                ", 是否禁用=" + isDisable +
                ", 是否安装设备=" + isInstall +
                ", 调度终端品牌='" + deviceBrand + '\'' +
                ", 调度终端型号=" + deviceType +
                ", 调度终端编码='" + deviceCode + '\'' +
                ", 调度终端SIM卡号='" + deviceSimCardNo + '\'' +
                ", 视频终端品牌='" + videoBrand + '\'' +
                ", 视频终端型号='" + videoType + '\'' +
                ", 视频终端编码='" + videoCode + '\'' +
                ", 视频终端SIM卡号='" + videoSimCardNo + '\'' +
                ", 修改者='" + editor + '\'' +
                ", 修改时间=" + editTime +
                ", 创建者='" + creator + '\'' +
                ", 创建时间=" + createTime +
                ", 线路名称='" + lineName + '\'' +
                ", 部门编号='" + deptCode + '\'' +
                ", 部门名称='" + deptName + '\'' +
                '}';
    }
}
