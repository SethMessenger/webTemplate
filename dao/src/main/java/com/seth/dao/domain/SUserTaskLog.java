package com.seth.dao.domain;

import java.util.Date;

public class SUserTaskLog {
    private Integer id;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte isDel;

    private String operator;

    private String taskUuid;

    private String userUuid;

    private Date commitTime;

    private Integer val;

    private String remark;

    public SUserTaskLog() {
    }

    public SUserTaskLog(String operator, String taskUuid, String userUuid, Date commitTime, Integer val, String remark) {
        this.gmtCreate = new Date();
        this.gmtModified = gmtCreate;
        this.isDel = (byte)0;
        this.operator = operator;
        this.taskUuid = taskUuid;
        this.userUuid = userUuid;
        this.commitTime = commitTime;
        this.val = val;
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

    public String getTaskUuid() {
        return taskUuid;
    }

    public void setTaskUuid(String taskUuid) {
        this.taskUuid = taskUuid == null ? null : taskUuid.trim();
    }

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

    public Date getCommitTime() {
        return commitTime;
    }

    public void setCommitTime(Date commitTime) {
        this.commitTime = commitTime;
    }

    public Integer getVal() {
        return val;
    }

    public void setVal(Integer val) {
        this.val = val;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}