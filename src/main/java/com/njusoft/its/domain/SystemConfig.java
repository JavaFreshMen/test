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

/**
 * 系统配置
 * 
 * @author Louise
 *
 */
@JsonAutoDetect
@Entity
@Table(name = "SYS_SYSTEMCONFIG")
public class SystemConfig implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "SYSTEMCONFIG_ID")
	@GeneratedValue(generator = "SYSTEMCONFIG_Generator")
	@GenericGenerator(name = "SYSTEMCONFIG_Generator", strategy = "guid")
	private String id;

	@Column(name = "FUNCNUMBER", unique = true, nullable = false)
	private String funcNumber;

	@Column(name = "FUNCCOMMENT")
	private String funcComment;

	@Column(name = "ARGUMENT", unique = true, nullable = false)
	private String argument;

	@Column(name = "ARGUCOMMENT")
	private String arguComment;

	@Column(name = "ARGUTYPE")
	private String arguType;

	@Column(name = "ARGUVALUE")
	private String arguValue;

	@Column(name = "ARGUNUMBER", unique = true, nullable = false)
	private String arguNumber;
	
	@Column(name = "ISOPEN")
	private Integer isOpen;

	@Column(name = "CREATOR")
	private String creator;

	@Column(name = "CREATETIME")
	private Date createTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFuncNumber() {
		return funcNumber;
	}

	public void setFuncNumber(String funcNumber) {
		this.funcNumber = funcNumber;
	}

	public String getFuncComment() {
		return funcComment;
	}

	public void setFuncComment(String funcComment) {
		this.funcComment = funcComment;
	}

	public Integer getIsOpen() {
		return isOpen;
	}

	public void setIsOpen(Integer isOpen) {
		this.isOpen = isOpen;
	}

	public String getArgument() {
		return argument;
	}

	public void setArgument(String argument) {
		this.argument = argument;
	}

	public String getArguComment() {
		return arguComment;
	}

	public void setArguComment(String arguComment) {
		this.arguComment = arguComment;
	}

	public String getArguType() {
		return arguType;
	}

	public void setArguType(String arguType) {
		this.arguType = arguType;
	}

	public String getArguValue() {
		return arguValue;
	}

	public void setArguValue(String arguValue) {
		this.arguValue = arguValue;
	}

	public String getArguNumber() {
		return arguNumber;
	}

	public void setArguNumber(String arguNumber) {
		this.arguNumber = arguNumber;
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
		return "SystemConfig [id=" + id + ", funcNumber=" + funcNumber + ", funcComment=" + funcComment + ", argument="
				+ argument + ", arguComment=" + arguComment + ", arguType=" + arguType + ", arguValue=" + arguValue
				+ ", arguNumber=" + arguNumber + ", isOpen=" + isOpen + ", creator=" + creator + ", createTime="
				+ createTime + "]";
	}
}
