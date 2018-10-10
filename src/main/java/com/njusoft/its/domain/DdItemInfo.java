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
 *CREATE TABLE T_DDITEMINFO(
 DDCODE VARCHAR2(50) NOT NULL,
 ITEMCODE VARCHAR2(50) NOT NULL,
 ITEMNAME VARCHAR2(50),
 LISTGROUP VARCHAR2(20),
 REMARK VARCHAR2(50),
 CREATOR VARCHAR2(20),
 CREATETIME DATE,
 CONSTRAINT PK_DDITEMINFO PRIMARY KEY(ITEMCODE),
 CONSTRAINT FK_T_DDITEM_DD_DDITEM_T_DDINFO FOREIGN KEY(DDCODE) REFERENCES T_DDINFO(DDCODE)
 );
 */
@JsonAutoDetect
@Entity
@Table(name="T_DDITEMINFO")
public class DdItemInfo implements Serializable {
    private static final long serialVersionUID = 98956378L;
    //SEQ_DDITEMINFO_ID
    //@GeneratedValue
    @Id
    @Column(name="DDITEMINFO_ID")
    @GeneratedValue(generator = "DDiteminfo_Generator")
    @GenericGenerator(name = "DDiteminfo_Generator", strategy = "guid")
    private String id;

    @Column(name="DDCODE",nullable = false)
    private String ddCode;

    @Column(name="ITEMCODE",unique = true,nullable = false)
    private String itemCode;

    @Column(name="ITEMNAME")
    private String itemName;

    @Column(name="LISTGROUP")
    private String listGroup;

    @Column(name="REMARK")
    private String remark;

    @Column(name="CREATOR")
    private String creator;

    @Column(name="CREATETIME")
    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDdCode() {
        return ddCode;
    }

    public void setDdCode(String ddCode) {
        this.ddCode = ddCode;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getListGroup() {
        return listGroup;
    }

    public void setListGroup(String listGroup) {
        this.listGroup = listGroup;
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

    @Override
    public String toString() {
        return "数据字典项{" +
                "主键=" + id +
                ", 数据字典编号='" + ddCode + '\'' +
                ", 字典项编号='" + itemCode + '\'' +
                ", 字典项名称='" + itemName + '\'' +
                ", 数据字典分组='" + listGroup + '\'' +
                ", 备注='" + remark + '\'' +
                ", 创建者='" + creator + '\'' +
                ", 创建时间=" + createTime +
                '}';
    }
}
