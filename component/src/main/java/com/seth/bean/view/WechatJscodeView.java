package com.seth.bean.view;

/**
 * @author xunbo.xu
 * @desc
 * @date 18/11/11
 */
public class WechatJscodeView {

    private String openid;
    private String unionid;
    private String sessionKey;

    public WechatJscodeView(String openid, String unionid, String sessionKey) {
        this.openid = openid;
        this.unionid = unionid;
        this.sessionKey = sessionKey;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }
}
