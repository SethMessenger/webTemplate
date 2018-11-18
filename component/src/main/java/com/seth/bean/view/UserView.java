package com.seth.bean.view;

/**
 * @author  xunbo.xu
 * @desc    用户展示视图
 * @date 18/10/11
 */
public class UserView {

    private String userUuid;
    private String openId;
    private String unionId;
    private String headImg;
    private Integer gender;

    private Integer coins;
    private Integer cash;
    private Integer completeTaskNum;
    private Integer recommendNum;
    private Integer randomPack;
    private Integer lastCoins;

    public UserView() {
        super();
    }

    public UserView(String userUuid, String openId, String unionId, String headImg, Integer gender,
                    Integer coins, Integer cash, Integer completeTaskNum, Integer recommendNum, Integer randomPack, Integer lastCoins) {
        this.userUuid = userUuid;
        this.openId = openId;
        this.unionId = unionId;
        this.headImg = headImg;
        this.gender = gender;
        this.coins = coins;
        this.cash = cash;
        this.completeTaskNum = completeTaskNum;
        this.recommendNum = recommendNum;
        this.randomPack = randomPack;
        this.lastCoins = lastCoins;
    }

    public Integer getCoins() {
        return coins;
    }

    public void setCoins(Integer coins) {
        this.coins = coins;
    }

    public Integer getCash() {
        return cash;
    }

    public void setCash(Integer cash) {
        this.cash = cash;
    }

    public Integer getCompleteTaskNum() {
        return completeTaskNum;
    }

    public void setCompleteTaskNum(Integer completeTaskNum) {
        this.completeTaskNum = completeTaskNum;
    }

    public Integer getRecommendNum() {
        return recommendNum;
    }

    public void setRecommendNum(Integer recommendNum) {
        this.recommendNum = recommendNum;
    }

    public Integer getRandomPack() {
        return randomPack;
    }

    public void setRandomPack(Integer randomPack) {
        this.randomPack = randomPack;
    }

    public Integer getLastCoins() {
        return lastCoins;
    }

    public void setLastCoins(Integer lastCoins) {
        this.lastCoins = lastCoins;
    }

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }
}
