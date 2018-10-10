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
@Table(name = "T_DISPATCHPLAN")
public class DispatchPlan implements Serializable,Cloneable{
    private static final long serialVersionUID = -1059272024355594958L;
    @Id
    @Column(name = "DISPATCHPLANID", unique = true, nullable = false)
    @GeneratedValue(generator = "dispatchplan_id_Generator")
    @GenericGenerator(name = "dispatchplan_id_Generator", strategy = "guid")
    private String dispatchPlanId;

    @Column(name = "WORKDATE")
    private Date workDate;

    @Column(name = "DAYTYPE")
    private String dayType;

    @Column(name = "CLASSGROUPCODE")
    private String classGroupCode;

    @Column(name = "LINECODE")
    private String lineCode;

    @Column(name = "LINENAME")
    private String lineName;

    @Column(name = "MAINLINECODE")
    private String mainLineCode;

    @Column(name = "DIRECTION")
    private Integer direction;

    @Column(name = "BUSCODE")
    private String busCode;

    @Column(name = "BUSBRANDNO")
    private String busBrandNo;

    @Column(name = "OLDBUSCODE")
    private String oldBusCode;

    @Column(name = "OLDBUSBRANDNO")
    private String oldBusBrandNo;

    @Column(name = "DRIVERCODE")
    private String driverCode;

    @Column(name = "DRIVERNAME")
    private String driverName;

    @Column(name = "OLDDRIVERCODE")
    private String oldDriverCode;

    @Column(name = "OLDDRIVERNAME")
    private String oldDriverName;

    @Column(name = "PLANTYPE")
    private Integer planType;

    @Column(name = "PLANRUNTIME")
    private Date planRunTime;

    @Column(name = "PLANARRIVETIME")
    private Date planArriveTime;

    @Column(name = "REALRUNTIME")
    private Date realRunTime;

    @Column(name = "REALARRIVETIME")
    private Date realArriveTime;

    @Column(name = "OLDPLANRUNTIME")
    private Date oldPlanRunTime;

    @Column(name = "OLDPLANARRIVETIME")
    private Date oldPlanArriveTime;

    @Column(name = "EVENTSTARTTIME")
    private Date eventStartTime;

    @Column(name = "EVENTENDTIME")
    private Date eventEndTime;

    @Column(name = "EVENTKM")
    private Double eventKm;

    @Column(name = "PLANCOUNT")
    private Double planCount;

    @Column(name = "REALCOUNT")
    private Double realCount;

    @Column(name = "DISPATCHTIME")
    private Date dispatchTime;

    @Column(name = "PLANKM")
    private Double planKm;

    @Column(name = "REALKM")
    private Double realKm;

    @Column(name = "GPSKM")
    private Double gpsKm;

    @Column(name = "EMPTYKM")
    private Double emptyKm;

    @Column(name = "PLANSTATE")
    private Integer planState;

    @Column(name = "DATASTATE")
    private Integer dataState;

    @Column(name = "CANCELTYPE")
    private String cancelType;

    @Column(name = "CANCELREASON")
    private String cancelReason;

    @Column(name = "RECORDREASON")
    private String recordReason;

    @Column(name = "FIRSTFIELDNO")
    private String firstFieldNo;

    @Column(name = "FIRSTFIELDNAME")
    private String firstFieldName;

    @Column(name = "LASTFIELDNO")
    private String lastFieldNo;

    @Column(name = "LASTFIELDNAME")
    private String lastFieldName;

    @Column(name = "STARTSTATIONNO")
    private String startStationNo;

    @Column(name = "STARTSTATIONNAME")
    private String startStationName;

    @Column(name = "ENDSTATIONNO")
    private String endStationNo;

    @Column(name = "ENDSTATIONNAME")
    private String endStationName;

    @Column(name = "PLANSEND01")
    private Integer planSend01;

    @Column(name = "PLANSEND02")
    private Integer planSend02;

    @Column(name = "PLANSEND03")
    private Integer planSend03;

    @Column(name = "ISADDTIONAL")
    private Integer isAddtional;

    @Column(name = "ISNIGHT")
    private Integer isNight;

    @Column(name = "ISSENDPLAN")
    private Integer isSendPlan;

    @Column(name = "SENDTIMES")
    private Integer sendTimes;

    @Column(name = "ISUPDATEPLANKM")
    private Integer isUpdatePlanKm;

    @Column(name = "ISAUTOFINISH")
    private Integer isAutoFinish;

    @Column(name = "CHECKPOINTCODE")
    private String checkPointCode;

    @Column(name = "ISADJUST")
    private Integer isAdjust;

    @Column(name = "REMARK")
    private String remark;

    @Column(name = "CREATOR")
    private String creator;

    @Column(name = "CREATETIME")
    private Date createTime;

    @Column(name = "EDITOR")
    private String editor;

    @Column(name = "EDITTIME")
    private Date editTime;

    @Column(name = "TIMEPLANID")
    private String timePlanId;

    @Column(name = "DUTYNO")
    private String dutyNo;

    @Column(name = "PLANFLAG")
    private Integer planFlag;

    @Column(name = "AUDITSTATE")
    private Integer auditState;
    
    @Column(name = "PLANCIRCLE")
    private Double planCircle;

    @Column(name = "REALCIRCLE")
    private Double realCircle;

    @Column(name = "ISSTAYNIGHT")
    private Integer isStayNight;
    
    @Column(name = "BUSCUSCODE")
    private String busCusCode;
    
    @Column(name = "DISPATCHMODE")
    private Integer dispatchMode;
    
    @Column(name = "SERIALNO")
    private String serialNo;
    
    @Transient
    private Double planDifferTime;
    
    @Transient
    private Double realDifferTime;
    
    @Transient
    private Double differTime;
    
	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public Integer getDispatchMode() {
		return dispatchMode;
	}

	public void setDispatchMode(Integer dispatchMode) {
		this.dispatchMode = dispatchMode;
	}

	public Double getPlanCircle() {
		return planCircle;
	}

	public void setPlanCircle(Double planCircle) {
		this.planCircle = planCircle;
	}

	public Double getRealCircle() {
		return realCircle;
	}

	public void setRealCircle(Double realCircle) {
		this.realCircle = realCircle;
	}

	public Integer getIsStayNight() {
		return isStayNight;
	}

	public void setIsStayNight(Integer isStayNight) {
		this.isStayNight = isStayNight;
	}

	public String getBusCusCode() {
		return busCusCode;
	}

	public void setBusCusCode(String busCusCode) {
		this.busCusCode = busCusCode;
	}

	public Integer getAuditState() {
		return auditState;
	}

	public void setAuditState(Integer auditState) {
		this.auditState = auditState;
	}

	public Double getPlanDifferTime() {
		return planDifferTime;
	}

	public void setPlanDifferTime(Double planDifferTime) {
		this.planDifferTime = planDifferTime;
	}

	public Double getRealDifferTime() {
		return realDifferTime;
	}

	public void setRealDifferTime(Double realDifferTime) {
		this.realDifferTime = realDifferTime;
	}

	public Double getDifferTime() {
		return differTime;
	}

	public void setDifferTime(Double differTime) {
		this.differTime = differTime;
	}

	public Integer getPlanFlag() {
        return planFlag;
    }

    public void setPlanFlag(Integer planFlag) {
        this.planFlag = planFlag;
    }

    public String getDayType() {
        return dayType;
    }

    public void setDayType(String dayType) {
        this.dayType = dayType;
    }

    public String getDispatchPlanId() {
		return dispatchPlanId;
	}

	public void setDispatchPlanId(String dispatchPlanId) {
		this.dispatchPlanId = dispatchPlanId;
	}

	public Date getWorkDate() {
        return workDate;
    }

    public void setWorkDate(Date workDate) {
        this.workDate = workDate;
    }

    public String getClassGroupCode() {
        return classGroupCode;
    }

    public void setClassGroupCode(String classGroupCode) {
        this.classGroupCode = classGroupCode;
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

    public String getMainLineCode() {
        return mainLineCode;
    }

    public void setMainLineCode(String mainLineCode) {
        this.mainLineCode = mainLineCode;
    }

    public Integer getDirection() {
        return direction;
    }

    public void setDirection(Integer direction) {
        this.direction = direction;
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

    public String getOldBusCode() {
        return oldBusCode;
    }

    public void setOldBusCode(String oldBusCode) {
        this.oldBusCode = oldBusCode;
    }

    public String getOldBusBrandNo() {
        return oldBusBrandNo;
    }

    public void setOldBusBrandNo(String oldBusBrandNo) {
        this.oldBusBrandNo = oldBusBrandNo;
    }

    public String getDriverCode() {
        return driverCode;
    }

    public void setDriverCode(String driverCode) {
        this.driverCode = driverCode;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getOldDriverCode() {
        return oldDriverCode;
    }

    public void setOldDriverCode(String oldDriverCode) {
        this.oldDriverCode = oldDriverCode;
    }

    public String getOldDriverName() {
        return oldDriverName;
    }

    public void setOldDriverName(String oldDriverName) {
        this.oldDriverName = oldDriverName;
    }

    public Integer getPlanType() {
        return planType;
    }

    public void setPlanType(Integer planType) {
        this.planType = planType;
    }

    public Date getPlanRunTime() {
        return planRunTime;
    }

    public void setPlanRunTime(Date planRunTime) {
        this.planRunTime = planRunTime;
    }

    public Date getPlanArriveTime() {
        return planArriveTime;
    }

    public void setPlanArriveTime(Date planArriveTime) {
        this.planArriveTime = planArriveTime;
    }

    public Date getRealRunTime() {
        return realRunTime;
    }

    public void setRealRunTime(Date realRunTime) {
        this.realRunTime = realRunTime;
    }

    public Date getRealArriveTime() {
        return realArriveTime;
    }

    public void setRealArriveTime(Date realArriveTime) {
        this.realArriveTime = realArriveTime;
    }

    public Date getOldPlanRunTime() {
        return oldPlanRunTime;
    }

    public void setOldPlanRunTime(Date oldPlanRunTime) {
        this.oldPlanRunTime = oldPlanRunTime;
    }

    public Date getOldPlanArriveTime() {
        return oldPlanArriveTime;
    }

    public void setOldPlanArriveTime(Date oldPlanArriveTime) {
        this.oldPlanArriveTime = oldPlanArriveTime;
    }

    public Date getEventStartTime() {
        return eventStartTime;
    }

    public void setEventStartTime(Date eventStartTime) {
        this.eventStartTime = eventStartTime;
    }

    public Date getEventEndTime() {
        return eventEndTime;
    }

    public void setEventEndTime(Date eventEndTime) {
        this.eventEndTime = eventEndTime;
    }

    public Double getEventKm() {
        return eventKm;
    }

    public void setEventKm(Double eventKm) {
        this.eventKm = eventKm;
    }

    public Double getPlanCount() {
        return planCount;
    }

    public void setPlanCount(Double planCount) {
        this.planCount = planCount;
    }

    public Double getRealCount() {
        return realCount;
    }

    public void setRealCount(Double realCount) {
        this.realCount = realCount;
    }

    public Date getDispatchTime() {
        return dispatchTime;
    }

    public void setDispatchTime(Date dispatchTime) {
        this.dispatchTime = dispatchTime;
    }

    public Double getPlanKm() {
        return planKm;
    }

    public void setPlanKm(Double planKm) {
        this.planKm = planKm;
    }

    public Double getRealKm() {
        return realKm;
    }

    public void setRealKm(Double realKm) {
        this.realKm = realKm;
    }

    public Double getGpsKm() {
        return gpsKm;
    }

    public void setGpsKm(Double gpsKm) {
        this.gpsKm = gpsKm;
    }

    public Double getEmptyKm() {
        return emptyKm;
    }

    public void setEmptyKm(Double emptyKm) {
        this.emptyKm = emptyKm;
    }

    public Integer getPlanState() {
        return planState;
    }

    public void setPlanState(Integer planState) {
        this.planState = planState;
    }

    public Integer getDataState() {
        return dataState;
    }

    public void setDataState(Integer dataState) {
        this.dataState = dataState;
    }

    public String getCancelType() {
        return cancelType;
    }

    public void setCancelType(String cancelType) {
        this.cancelType = cancelType;
    }

    public String getCancelReason() {
        return cancelReason;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }

    public String getRecordReason() {
        return recordReason;
    }

    public void setRecordReason(String recordReason) {
        this.recordReason = recordReason;
    }

    public String getFirstFieldNo() {
        return firstFieldNo;
    }

    public void setFirstFieldNo(String firstFieldNo) {
        this.firstFieldNo = firstFieldNo;
    }

    public String getFirstFieldName() {
        return firstFieldName;
    }

    public void setFirstFieldName(String firstFieldName) {
        this.firstFieldName = firstFieldName;
    }

    public String getLastFieldNo() {
        return lastFieldNo;
    }

    public void setLastFieldNo(String lastFieldNo) {
        this.lastFieldNo = lastFieldNo;
    }

    public String getLastFieldName() {
        return lastFieldName;
    }

    public void setLastFieldName(String lastFieldName) {
        this.lastFieldName = lastFieldName;
    }

    public String getStartStationNo() {
        return startStationNo;
    }

    public void setStartStationNo(String startStationNo) {
        this.startStationNo = startStationNo;
    }

    public String getStartStationName() {
        return startStationName;
    }

    public void setStartStationName(String startStationName) {
        this.startStationName = startStationName;
    }

    public String getEndStationNo() {
        return endStationNo;
    }

    public void setEndStationNo(String endStationNo) {
        this.endStationNo = endStationNo;
    }

    public String getEndStationName() {
        return endStationName;
    }

    public void setEndStationName(String endStationName) {
        this.endStationName = endStationName;
    }

    public Integer getPlanSend01() {
        return planSend01;
    }

    public void setPlanSend01(Integer planSend01) {
        this.planSend01 = planSend01;
    }

    public Integer getPlanSend02() {
        return planSend02;
    }

    public void setPlanSend02(Integer planSend02) {
        this.planSend02 = planSend02;
    }

    public Integer getPlanSend03() {
        return planSend03;
    }

    public void setPlanSend03(Integer planSend03) {
        this.planSend03 = planSend03;
    }

    public Integer getIsAddtional() {
        return isAddtional;
    }

    public void setIsAddtional(Integer isAddtional) {
        this.isAddtional = isAddtional;
    }

    public Integer getIsNight() {
        return isNight;
    }

    public void setIsNight(Integer isNight) {
        this.isNight = isNight;
    }

    public Integer getIsSendPlan() {
        return isSendPlan;
    }

    public void setIsSendPlan(Integer isSendPlan) {
        this.isSendPlan = isSendPlan;
    }

    public Integer getSendTimes() {
        return sendTimes;
    }

    public void setSendTimes(Integer sendTimes) {
        this.sendTimes = sendTimes;
    }

    public Integer getIsUpdatePlanKm() {
        return isUpdatePlanKm;
    }

    public void setIsUpdatePlanKm(Integer isUpdatePlanKm) {
        this.isUpdatePlanKm = isUpdatePlanKm;
    }

    public Integer getIsAutoFinish() {
        return isAutoFinish;
    }

    public void setIsAutoFinish(Integer isAutoFinish) {
        this.isAutoFinish = isAutoFinish;
    }

    public String getCheckPointCode() {
        return checkPointCode;
    }

    public void setCheckPointCode(String checkPointCode) {
        this.checkPointCode = checkPointCode;
    }

    public Integer getIsAdjust() {
        return isAdjust;
    }

    public void setIsAdjust(Integer isAdjust) {
        this.isAdjust = isAdjust;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public String getTimePlanId() {
        return timePlanId;
    }

    public void setTimePlanId(String timePlanId) {
        this.timePlanId = timePlanId;
    }

    public String getDutyNo() {
        return dutyNo;
    }

    public void setDutyNo(String dutyNo) {
        this.dutyNo = dutyNo;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "DispatchPlan{" +
                "dispatchPlanId='" + dispatchPlanId + '\'' +
                ", workDate=" + workDate +
                ", dayType='" + dayType + '\'' +
                ", classGroupCode='" + classGroupCode + '\'' +
                ", lineCode='" + lineCode + '\'' +
                ", lineName='" + lineName + '\'' +
                ", mainLineCode='" + mainLineCode + '\'' +
                ", direction=" + direction +
                ", busCode='" + busCode + '\'' +
                ", busBrandNo='" + busBrandNo + '\'' +
                ", oldBusCode='" + oldBusCode + '\'' +
                ", oldBusBrandNo='" + oldBusBrandNo + '\'' +
                ", driverCode='" + driverCode + '\'' +
                ", driverName='" + driverName + '\'' +
                ", oldDriverCode='" + oldDriverCode + '\'' +
                ", oldDriverName='" + oldDriverName + '\'' +
                ", planType=" + planType +
                ", planRunTime=" + planRunTime +
                ", planArriveTime=" + planArriveTime +
                ", realRunTime=" + realRunTime +
                ", realArriveTime=" + realArriveTime +
                ", oldPlanRunTime=" + oldPlanRunTime +
                ", oldPlanArriveTime=" + oldPlanArriveTime +
                ", eventStartTime=" + eventStartTime +
                ", eventEndTime=" + eventEndTime +
                ", eventKm=" + eventKm +
                ", planCount=" + planCount +
                ", realCount=" + realCount +
                ", dispatchTime=" + dispatchTime +
                ", planKm=" + planKm +
                ", realKm=" + realKm +
                ", gpsKm=" + gpsKm +
                ", emptyKm=" + emptyKm +
                ", planState=" + planState +
                ", dataState=" + dataState +
                ", cancelType='" + cancelType + '\'' +
                ", cancelReason='" + cancelReason + '\'' +
                ", recordReason='" + recordReason + '\'' +
                ", firstFieldNo='" + firstFieldNo + '\'' +
                ", firstFieldName='" + firstFieldName + '\'' +
                ", lastFieldNo='" + lastFieldNo + '\'' +
                ", lastFieldName='" + lastFieldName + '\'' +
                ", startStationNo='" + startStationNo + '\'' +
                ", startStationName='" + startStationName + '\'' +
                ", endStationNo='" + endStationNo + '\'' +
                ", endStationName='" + endStationName + '\'' +
                ", planSend01=" + planSend01 +
                ", planSend02=" + planSend02 +
                ", planSend03=" + planSend03 +
                ", isAddtional=" + isAddtional +
                ", isNight=" + isNight +
                ", isStayNight=" + isStayNight +
                ", dispatchMode=" + dispatchMode +
                ", isSendPlan=" + isSendPlan +
                ", sendTimes=" + sendTimes +
                ", isUpdatePlanKm=" + isUpdatePlanKm +
                ", isAutoFinish=" + isAutoFinish +
                ", checkPointCode='" + checkPointCode + '\'' +
                ", isAdjust=" + isAdjust +
                ", remark='" + remark + '\'' +
                ", creator='" + creator + '\'' +
                ", createTime=" + createTime +
                ", editor='" + editor + '\'' +
                ", editTime=" + editTime +
                ", timePlanId='" + timePlanId + '\'' +
                ", dutyNo='" + dutyNo + '\'' +
                '}';
    }
}
