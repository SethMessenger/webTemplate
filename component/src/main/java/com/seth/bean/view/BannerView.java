package com.seth.bean.view;

import com.seth.component.common.MiniProTypeEnum;

import java.math.BigDecimal;

/**
 * @author xunbo.xu
 * @desc
 * @date 18/11/11
 */
public class BannerView {

    private String appId;
    private String appName;
    private String appSecret;
    private String bannerPath;
    private String description;
    private String miniProPath;
    private String params;
    private int sort;

    public BannerView(MiniProTypeEnum typeEnum) {
        this.appId = typeEnum.getAppId();
        this.appName = typeEnum.getAppName();
        this.appSecret = typeEnum.getAppSecret();
        this.bannerPath = typeEnum.getBannerPath();
        this.description = typeEnum.getDescription();
        this.miniProPath = typeEnum.getMiniProPath();
        this.params = typeEnum.getParams();
        this.sort = typeEnum.getSort();
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

    public String getBannerPath() {
        return bannerPath;
    }

    public void setBannerPath(String bannerPath) {
        this.bannerPath = bannerPath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
}
