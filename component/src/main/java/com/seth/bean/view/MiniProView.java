package com.seth.bean.view;

import com.seth.component.common.MiniProTypeEnum;

import java.math.BigDecimal;

/**
 * @author  xunbo.xu
 * @desc    小程序展示层
 * @date 18/11/10
 */
public class MiniProView {

    private String appId;
    private String appName;
    private String appSecret;
    private String iconPath;
    private String bannerPath;
    private String sunCodePath;
    private long playNum;
    private String description;
    private int val;
    private String miniProPath;
    private String params;
    private int sort;
    private int timeSort;
    private double hotSort;
    private boolean completeStatus;

    public MiniProView(MiniProTypeEnum typeEnum, boolean completeStatus) {
        this.appId = typeEnum.getAppId();
        this.appName = typeEnum.getAppName();
        this.appSecret = typeEnum.getAppSecret();
        this.iconPath = typeEnum.getIconPath();
        this.bannerPath = typeEnum.getBannerPath();
        this.sunCodePath = typeEnum.getSunCodePath();
        this.playNum = new BigDecimal(typeEnum.getHotSort()).multiply(new BigDecimal(System.currentTimeMillis())).
                divideAndRemainder(new BigDecimal(100000000))[1].longValue();
        this.description = typeEnum.getDescription();
        this.val = typeEnum.getVal();
        this.miniProPath = typeEnum.getMiniProPath();
        this.params = typeEnum.getParams();
        this.sort = typeEnum.getSort();
        this.timeSort = typeEnum.getTimeSort();
        this.hotSort = typeEnum.getHotSort();
        this.completeStatus = completeStatus;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }

    public String getBannerPath() {
        return bannerPath;
    }

    public void setBannerPath(String bannerPath) {
        this.bannerPath = bannerPath;
    }

    public String getSunCodePath() {
        return sunCodePath;
    }

    public void setSunCodePath(String sunCodePath) {
        this.sunCodePath = sunCodePath;
    }

    public long getPlayNum() {
        return playNum;
    }

    public void setPlayNum(long playNum) {
        this.playNum = playNum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public String getMiniProPath() {
        return miniProPath;
    }

    public void setMiniProPath(String miniProPath) {
        this.miniProPath = miniProPath;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public int getTimeSort() {
        return timeSort;
    }

    public void setTimeSort(int timeSort) {
        this.timeSort = timeSort;
    }

    public double getHotSort() {
        return hotSort;
    }

    public void setHotSort(double hotSort) {
        this.hotSort = hotSort;
    }

    public boolean isCompleteStatus() {
        return completeStatus;
    }

    public void setCompleteStatus(boolean completeStatus) {
        this.completeStatus = completeStatus;
    }
}
