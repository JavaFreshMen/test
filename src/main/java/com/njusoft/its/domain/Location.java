package com.njusoft.its.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.Transient;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
@Entity
@Table(name = "T_LOCATION")
public class Location implements Serializable{

    private static final long serialVersionUID = 7572040243816531315L;
    @Id
    @Column(name = "LOCATIONID", unique = true, nullable = false)
    @GeneratedValue(generator = "Location_Id_Generator")
    @GenericGenerator(name = "Location_Id_Generator", strategy = "guid")
    private String id;
    @Column(name = "LINECODE")
    private String lineCode;
    @Column(name = "LINENAME")
    private String lineName;
    @Column(name = "BUSCODE")
    private String busCode;
    @Column(name = "BUSBRANDNO")
    private String busBrandNo;
    @Column(name = "WORKDATE")
    private Date workDate;
    @Column(name = "OCCURTIME")
    private Date occurTime;
    @Column(name = "SERVERTIME")
    private Date serverTime;
    @Column(name = "LAT")
    private Double lat;
    @Column(name = "LNG")
    private Double lng;
    @Column(name = "SPEED")
    private Integer speed;
    @Column(name = "ANGLE")
    private Integer angle;
    @Column(name = "HEIGHT")
    private Integer height;
    @Column(name = "SIGNAL")
    private Integer signal;
    @Column(name = "DIRECTION")
    private Integer direction;
    @Column(name = "BUSSTATE")
    private Integer busState;
    @Column(name = "CURSTOPNO")
    private String curStopNo;
    @Column(name = "CURSTOPNAME")
    private String curStopName;
    @Column(name = "RUNMILEAGE")
    private Integer runMileage;
    @Column(name = "SOURCEFLAG")
    private String sourceFlag;
    @Column(name = "CREATOR")
    private String creator;
    @Column(name = "CREATETIME")
    private Date createTime;
    
    @Transient
    private String driverName="";
    @Transient
    private String driverCode="";
    @Transient
    private String dutyNo="";
    @Transient
    private Integer isOnline;//是否在线（丢报数是否超过系统配置） 0否 1是
    @Transient
    private Integer orderNo;

    public Integer getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

	public Integer getIsOnline() {
		return isOnline;
	}

	public void setIsOnline(Integer isOnline) {
		this.isOnline = isOnline;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getDriverCode() {
		return driverCode;
	}

	public void setDriverCode(String driverCode) {
		this.driverCode = driverCode;
	}

	public String getDutyNo() {
		return dutyNo;
	}

	public void setDutyNo(String dutyNo) {
		this.dutyNo = dutyNo;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Date getOccurTime() {
        return occurTime;
    }

    public void setOccurTime(Date occurTime) {
        this.occurTime = occurTime;
    }

    public Date getServerTime() {
        return serverTime;
    }

    public void setServerTime(Date serverTime) {
        this.serverTime = serverTime;
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

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Integer getAngle() {
        return angle;
    }

    public void setAngle(Integer angle) {
        this.angle = angle;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getSignal() {
        return signal;
    }

    public void setSignal(Integer signal) {
        this.signal = signal;
    }

    public Integer getDirection() {
        return direction;
    }

    public void setDirection(Integer direction) {
        this.direction = direction;
    }

    public Integer getBusState() {
        return busState;
    }

    public void setBusState(Integer busState) {
        this.busState = busState;
    }

    public String getCurStopNo() {
        return curStopNo;
    }

    public void setCurStopNo(String curStopNo) {
        this.curStopNo = curStopNo;
    }

    public String getCurStopName() {
        return curStopName;
    }

    public void setCurStopName(String curStopName) {
        this.curStopName = curStopName;
    }

    public Integer getRunMileage() {
        return runMileage;
    }

    public void setRunMileage(Integer runMileage) {
        this.runMileage = runMileage;
    }

    public String getSourceFlag() {
        return sourceFlag;
    }

    public void setSourceFlag(String sourceFlag) {
        this.sourceFlag = sourceFlag;
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
		return "Location [id=" + id + ", lineCode=" + lineCode + ", lineName=" + lineName + ", busCode=" + busCode
				+ ", busBrandNo=" + busBrandNo + ", workDate=" + workDate + ", occurTime=" + occurTime + ", serverTime="
				+ serverTime + ", lat=" + lat + ", lng=" + lng + ", speed=" + speed + ", angle=" + angle + ", height="
				+ height + ", signal=" + signal + ", direction=" + direction + ", busState=" + busState + ", curStopNo="
				+ curStopNo + ", curStopName=" + curStopName + ", runMileage=" + runMileage + ", sourceFlag="
				+ sourceFlag + ", creator=" + creator + ", createTime=" + createTime + ", driverName=" + driverName
				+ ", driverCode=" + driverCode + ", dutyNo=" + dutyNo + ", isOnline=" + isOnline + ", orderNo="
				+ orderNo + "]";
	}
}
