package com.seth.dao.domain;

import java.util.Date;

public class SUserCoinLog {
    private Integer id;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte isDel;

    private String operator;

    private String userUuid;

    private Integer val;

    private Integer logType;

    private String description;

    private String remark;

    public SUserCoinLog() {
    }

    public SUserCoinLog(String operator, String userUuid, Integer val, Integer logType, String desc, String remark) {
        this.gmtCreate = new Date();
        this.gmtModified = gmtCreate;
        this.isDel = (byte)0;
        this.operator = operator;
        this.userUuid = userUuid;
        this.val = val;
        this.logType = logType;
        this.description = desc;
        this.remark = remark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Byte getIsDel() {
        return isDel;
    }

    public void setIsDel(Byte isDel) {
        this.isDel = isDel;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid == null ? null : userUuid.trim();
    }

    public Integer getVal() {
        return val;
    }

    public void setVal(Integer val) {
        this.val = val;
    }

    public Integer getLogType() {
        return logType;
    }

    public void setLogType(Integer logType) {
        this.logType = logType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}