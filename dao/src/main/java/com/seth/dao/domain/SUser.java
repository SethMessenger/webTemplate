package com.seth.dao.domain;

import com.seth.bean.form.UserRegisterForm;
import com.seth.utils.UuidGenerator;

import java.util.Date;

public class SUser {
    private Integer id;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte isDel;

    private String operator;

    private String userUuid;

    private Integer total;

    private Integer gender;

    private String nickName;

    private String openId;

    private String unionId;

    private String userMobile;

    private String userWechat;

    private String password;

    private String headImg;

    private String remark;

    public SUser() {
        super();
    }

    public SUser(UserRegisterForm userForm) {
        super();
        this.gmtCreate = new Date();
        this.gmtModified = gmtCreate;
        this.isDel = (byte) 0;
        this.operator = "SYSTEM_ROOT";
        this.userUuid = UuidGenerator.getUUID32();
        this.gender = userForm.getGender();
        this.nickName = userForm.getNickName();
        this.openId = userForm.getOpenId();
        this.unionId = userForm.getUnionId();
        this.userMobile = userForm.getMobile();
        this.userWechat = userForm.getWechat();
        this.password = "DEFAULT_PWD";
        this.headImg = userForm.getHeadImg();
        this.total = 0;
        this.remark = null;
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

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId == null ? null : unionId.trim();
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile == null ? null : userMobile.trim();
    }

    public String getUserWechat() {
        return userWechat;
    }

    public void setUserWechat(String userWechat) {
        this.userWechat = userWechat == null ? null : userWechat.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg == null ? null : headImg.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}