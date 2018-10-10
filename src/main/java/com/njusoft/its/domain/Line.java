package com.njusoft.its.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
@Entity
@Table(name = "T_LINE")
public class Line implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @Column(name = "LINECODE", unique = true, nullable = false)
    private String lineCode;
    @Column(name = "ID")
    private Integer id;
    @Column(name = "LINENAME")
    private String lineName;
    @Column(name = "DEPTCODE")
    private String deptCode;
    @Column(name = "LINETYPE")
    private String lineType;
    @Column(name = "ISMAINLINE")
    private Integer isMainLine;
    @Column(name = "MAINLINECODE")
    private String mainLineCode;
    @Column(name = "RUNTYPE")
    private String runType;
    @Column(name = "STARTDATE")
    private Date startDate;
    @Column(name = "TICKETPRICE")
    private String ticketPrice;
    @Column(name = "LINELENGTH")
    private Double lineLength;
    @Column(name = "LINELENGTH_LS")
    private Double lineLength_Ls;
    @Column(name = "BUSNUM")
    private Integer busNum;
    @Column(name = "FIRSTTIME")
    private Date firstTime;
    @Column(name = "LASTTIME")
    private Date lastTime;
    @Column(name = "FIRSTTIME_LS")
    private Date firstTime_Ls;
    @Column(name = "LASTTIME_LS")
    private Date lastTime_Ls;
    @Column(name = "FIRSTFIELDNO")
    private String firstFieldNo;
    @Column(name = "LASTFIELDNO")
    private String lastFieldNo;
    @Column(name = "FIRSTFIELDNO_LS")
    private String firstFieldNo_Ls;
    @Column(name = "LASTFIELDNO_LS")
    private String lastFieldNo_Ls;
    @Column(name = "PLANCLASSTIMES")
    private Integer planClassTimes;
    @Column(name = "ISSTOP")
    private Integer isStop;
    @Column(name = "STOPDAY")
    private Date stopDay;
    @Column(name = "ORDERNO")
    private Integer orderNo;
    @Column(name = "CREATOR")
    private String creator;
    @Column(name = "CREATETIME")
    private Date createTime;
    @Column(name = "EDITOR")
    private String editor;
    @Column(name = "EDITTIME")
    private Date editTime;
    @Column(name = "EMPTYKM")
    private Float emptyKm;
    @Column(name = "STANDARDKMRATE")
    private Double standardKmRate;
    @Column(name = "UPPLANCOUNT")
    private Double upPlanCount;
    @Column(name = "DOWNPLANCOUNT")
    private Double downPlanCount;
    @Column(name = "UPPLANCIRCLE")
    private Double upPlanCircle;
    @Column(name = "DOWNPLANCIRCLE")
    private Double downPlanCircle;
    @Column(name = "SAFEKM")
    private Double safeKm;
    @Column(name = "OPENSTATE")
    private Integer openState;
    @Column(name = "FIRSTTOTALMINUTES")
    private Integer firstTotalMinutes;
    @Column(name = "FIRSTTOTALMINUTES_LS")
    private Integer firstTotalMinutes_Ls;
    
    @Transient
    private String deptName;
    
    public Integer getOpenState() {
		return openState;
	}

	public void setOpenState(Integer openState) {
		this.openState = openState;
	}

	public Integer getFirstTotalMinutes() {
		return firstTotalMinutes;
	}

	public void setFirstTotalMinutes(Integer firstTotalMinutes) {
		this.firstTotalMinutes = firstTotalMinutes;
	}

	public Integer getFirstTotalMinutes_Ls() {
		return firstTotalMinutes_Ls;
	}

	public void setFirstTotalMinutes_Ls(Integer firstTotalMinutes_Ls) {
		this.firstTotalMinutes_Ls = firstTotalMinutes_Ls;
	}

	public Double getSafeKm() {
		return safeKm;
	}

	public void setSafeKm(Double safeKm) {
		this.safeKm = safeKm;
	}

	public Double getUpPlanCount() {
		return upPlanCount;
	}

	public void setUpPlanCount(Double upPlanCount) {
		this.upPlanCount = upPlanCount;
	}

	public Double getDownPlanCount() {
		return downPlanCount;
	}

	public void setDownPlanCount(Double downPlanCount) {
		this.downPlanCount = downPlanCount;
	}

	public Double getUpPlanCircle() {
		return upPlanCircle;
	}

	public void setUpPlanCircle(Double upPlanCircle) {
		this.upPlanCircle = upPlanCircle;
	}

	public Double getDownPlanCircle() {
		return downPlanCircle;
	}

	public void setDownPlanCircle(Double downPlanCircle) {
		this.downPlanCircle = downPlanCircle;
	}

	public Double getStandardKmRate() {
		return standardKmRate;
	}

	public void setStandardKmRate(Double standardKmRate) {
		this.standardKmRate = standardKmRate;
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

	public Float getEmptyKm() {
        return emptyKm;
    }

    public void setEmptyKm(Float emptyKm) {
        this.emptyKm = emptyKm;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getLineCode() {
        return lineCode;
    }

    public void setLineCode(String lineCode) {
        this.lineCode = lineCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getLineType() {
        return lineType;
    }

    public void setLineType(String lineType) {
        this.lineType = lineType;
    }

    public Integer getIsMainLine() {
        return isMainLine;
    }

    public void setIsMainLine(Integer isMainLine) {
        this.isMainLine = isMainLine;
    }

    public String getMainLineCode() {
        return mainLineCode;
    }

    public void setMainLineCode(String mainLineCode) {
        this.mainLineCode = mainLineCode;
    }

    public String getRunType() {
        return runType;
    }

    public void setRunType(String runType) {
        this.runType = runType;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(String ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public Double getLineLength() {
        return lineLength;
    }

    public void setLineLength(Double lineLength) {
        this.lineLength = lineLength;
    }

    public Double getLineLength_Ls() {
        return lineLength_Ls;
    }

    public void setLineLength_Ls(Double lineLength_Ls) {
        this.lineLength_Ls = lineLength_Ls;
    }

    public Integer getBusNum() {
        return busNum;
    }

    public void setBusNum(Integer busNum) {
        this.busNum = busNum;
    }

    public Date getFirstTime() {
        return firstTime;
    }

    public void setFirstTime(Date firstTime) {
        this.firstTime = firstTime;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    public Date getFirstTime_Ls() {
        return firstTime_Ls;
    }

    public void setFirstTime_Ls(Date firstTime_Ls) {
        this.firstTime_Ls = firstTime_Ls;
    }

    public Date getLastTime_Ls() {
        return lastTime_Ls;
    }

    public void setLastTime_Ls(Date lastTime_Ls) {
        this.lastTime_Ls = lastTime_Ls;
    }

    public String getFirstFieldNo() {
        return firstFieldNo;
    }

    public void setFirstFieldNo(String firstFieldNo) {
        this.firstFieldNo = firstFieldNo;
    }

    public String getLastFieldNo() {
        return lastFieldNo;
    }

    public void setLastFieldNo(String lastFieldNo) {
        this.lastFieldNo = lastFieldNo;
    }

    public String getFirstFieldNo_Ls() {
        return firstFieldNo_Ls;
    }

    public void setFirstFieldNo_Ls(String firstFieldNo_Ls) {
        this.firstFieldNo_Ls = firstFieldNo_Ls;
    }

    public String getLastFieldNo_Ls() {
        return lastFieldNo_Ls;
    }

    public void setLastFieldNo_Ls(String lastFieldNo_Ls) {
        this.lastFieldNo_Ls = lastFieldNo_Ls;
    }

    public Integer getPlanClassTimes() {
        return planClassTimes;
    }

    public void setPlanClassTimes(Integer planClassTimes) {
        this.planClassTimes = planClassTimes;
    }

    public Integer getIsStop() {
        return isStop;
    }

    public void setIsStop(Integer isStop) {
        this.isStop = isStop;
    }

    public Date getStopDay() {
        return stopDay;
    }

    public void setStopDay(Date stopDay) {
        this.stopDay = stopDay;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
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
        return "线路{" +
                "线路编号='" + lineCode + '\'' +
                ", 主键=" + id +
                ", 线路名称='" + lineName + '\'' +
                ", 部门编号='" + deptCode + '\'' +
                ", 线路类型='" + lineType + '\'' +
                ", 是否主线=" + isMainLine +
                ", 主线编号='" + mainLineCode + '\'' +
                ", 运行类型='" + runType + '\'' +
                ", 开通日期=" + startDate +
                ", 票价='" + ticketPrice + '\'' +
                ", 上行线路长度=" + lineLength +
                ", 下行线路长度=" + lineLength_Ls +
                ", 车辆数=" + busNum +
                ", 标准公里转换率=" + standardKmRate +
                ", 上行首班时间=" + firstTime +
                ", 上行末班时间=" + lastTime +
                ", 下行首班时间=" + firstTime_Ls +
                ", 下行末班时间=" + lastTime_Ls +
                ", 上行发车场站='" + firstFieldNo + '\'' +
                ", 上行终点场站='" + lastFieldNo + '\'' +
                ", 下行发车场站='" + firstFieldNo_Ls + '\'' +
                ", 下行终点场站='" + lastFieldNo_Ls + '\'' +
                ", 核定班次=" + planClassTimes +
                ", 是否停运=" + isStop +
                ", 停运日期=" + stopDay +
                ", 序号=" + orderNo +
                ", 开通状态='" + openState + '\'' +
                ", 上行全程时间='" + firstTotalMinutes + '\'' +
                ", 下行全程时间=" + firstTotalMinutes_Ls +
                ", 创建者='" + creator + '\'' +
                ", 创建时间=" + createTime +
                ", 部门名称='" + deptName + '\'' +
                '}';
    }
}
