package com.njusoft.its.domain;

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
@Table(name = "T_STATION")
public class Station {
    @Id
    @Column(name = "STATIONID", unique = true, nullable = false)
    @GeneratedValue(generator = "Station_id_Generator")
    @GenericGenerator(name = "Station_id_Generator", strategy = "guid")
    private String id;
    @Column(name = "LINECODE")
    private String lineCode;
    @Column(name = "DIRECTION")
    private Integer direction;
    @Column(name = "ORDERNO")
    private Integer orderNo;
    @Column(name = "NAME")
    private String name;
    @Column(name = "SHORTNAME")
    private String shortName;
    @Column(name = "FLAG")
    private Integer flag;
    @Column(name = "STOPAREACODE")
    private String stopAreaCode;
    @Column(name = "BYSTARTDISTANCE")
    private Double byStartDistance;
    @Column(name = "LAT")
    private Double lat;
    @Column(name = "LNG")
    private Double lng;
    @Column(name = "ANGLE")
    private Integer angle;
    @Column(name = "KM")
    private Double km;
    @Column(name = "LNGOUT")
    private Double lngOut;
    @Column(name = "LATOUT")
    private Double latOut;
    @Column(name = "ANGLEOUT")
    private Integer angleOut;
    @Column(name = "KMOUT")
    private Double kmOut;
    @Column(name = "LAMPNO")
    private Integer lampNo;
    @Column(name = "ISDISABLE")
    private Integer isDisable;
    @Column(name = "CREATOR")
    private String creator;
    @Column(name = "CREATETIME")
    private Date createTime;
    @Column(name = "SEQ")
    private Integer seq;
    @Column(name = "POSITION")
    private String position;

    @Transient
    private String lineName;
    @Transient
    private String deptCode;
    @Transient
    private String deptName;

    public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public Double getKm() {
		return km;
	}

	public void setKm(Double km) {
		this.km = km;
	}

	public Double getKmOut() {
		return kmOut;
	}

	public void setKmOut(Double kmOut) {
		this.kmOut = kmOut;
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

    public Integer getDirection() {
        return direction;
    }

    public void setDirection(Integer direction) {
        this.direction = direction;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getStopAreaCode() {
        return stopAreaCode;
    }

    public void setStopAreaCode(String stopAreaCode) {
        this.stopAreaCode = stopAreaCode;
    }

    public Double getByStartDistance() {
        return byStartDistance;
    }

    public void setByStartDistance(Double byStartDistance) {
        this.byStartDistance = byStartDistance;
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

    public Integer getAngle() {
        return angle;
    }

    public void setAngle(Integer angle) {
        this.angle = angle;
    }

    public Double getLngOut() {
        return lngOut;
    }

    public void setLngOut(Double lngOut) {
        this.lngOut = lngOut;
    }

    public Double getLatOut() {
        return latOut;
    }

    public void setLatOut(Double latOut) {
        this.latOut = latOut;
    }

    public Integer getAngleOut() {
        return angleOut;
    }

    public void setAngleOut(Integer angleOut) {
        this.angleOut = angleOut;
    }

    public Integer getLampNo() {
        return lampNo;
    }

    public void setLampNo(Integer lampNo) {
        this.lampNo = lampNo;
    }

    public Integer getIsDisable() {
        return isDisable;
    }

    public void setIsDisable(Integer isDisable) {
        this.isDisable = isDisable;
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

    @Override
    public String toString() {
        return "站点{" +
                "主键=" + id +
                ", 线路编号='" + lineCode + '\'' +
                ", 方向=" + direction +
                ", 序号=" + orderNo +
                ", 站点名称='" + name + '\'' +
                ", 站点简称='" + shortName + '\'' +
                ", 站点类型=" + flag +
                ", 站台编号='" + stopAreaCode + '\'' +
                ", 距离起始站=" + byStartDistance +
                ", 进站纬度=" + lat +
                ", 进站经度=" + lng +
                ", 进站方向角=" + angle +
                ", 出站经度=" + lngOut +
                ", 出站纬度=" + latOut +
                ", 出站方向角=" + angleOut +
                ", 灯序=" + lampNo +
                ", 是否禁用=" + isDisable +
                ", 创建人='" + creator + '\'' +
                ", 创建时间=" + createTime +
                ", 线路名称='" + lineName + '\'' +
                ", 部门编号='" + deptCode + '\'' +
                ", 部门名称='" + deptName + '\'' +
                '}';
    }
}
