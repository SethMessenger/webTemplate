package com.seth.component.common;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author  xunbo.xu
 * @desc    接入的小程序枚举
 * @date 18/10/11
 */
public enum MiniProTypeEnum {

    MINI_PROGRAME_QUWAN("wxe6590ca8db40de", "趣玩小盒子", "secret", "http://i2.bvimg.com/654120/cc1c63b362b2302e.png",
            "http://i2.bvimg.com/654120/90d6ef32a377a099.png","http://i1.bvimg.com/654120/91f88425b30b593cs.jpg",
                 1L,"玩趣玩小盒子赢奖品",10,"pages/index/index", "id=1006",1, 2, 1.9),
    MINI_PROGRAME_CAICAICAI("wxd83d18d1977dfb7c","名字猜猜猜","secret","http://i2.bvimg.com/654120/04870c1046915ae4.gif",
            "http://i1.bvimg.com/654120/b0a0608bb3dcfa2fs.png","http://i1.bvimg.com/654120/91f88425b30b593cs.jpg",
            2L,"猜明星，赢现金", 10, "pages/index/index","id=1007",2, 1, 1.2),
    MINI_PROGRAME_HUANHUAN("wx239bfcba6aeb0084","有练换换","secret", "",
            "http://i2.bvimg.com/654120/96b5845841a37a9fs.jpg","http://i1.bvimg.com/654120/91f88425b30b593cs.jpg",
            3L,"0元撸好物，天天领现金", 10, "pages/index", "scene=TG00004rc0jua000000", 3, 3, 1.1);

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


    private MiniProTypeEnum(){}

    MiniProTypeEnum(String appId, String appName, String appSecret, String iconPath, String bannerPath, String sunCodePath,
                    long playNum, String description, int val, String miniProPath, String params, int sort, int timeSort, double hotSort) {
        this.appId = appId;
        this.appName = appName;
        this.appSecret = appSecret;
        this.iconPath = iconPath;
        this.bannerPath = bannerPath;
        this.sunCodePath = sunCodePath;
        this.playNum = playNum;
        this.description = description;
        this.val = val;
        this.miniProPath = miniProPath;
        this.params = params;
        this.sort = sort;
        this.timeSort = timeSort;
        this.hotSort = hotSort;
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

    public static List<MiniProTypeEnum> getAll(){
        return CollectionUtils.arrayToList(MiniProTypeEnum.values());
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

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public int getSort() {
        return sort;
    }

    public String getMiniProPath() {
        return miniProPath;
    }

    public void setMiniProPath(String miniProPath) {
        this.miniProPath = miniProPath;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }
}