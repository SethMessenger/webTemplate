package com.seth.api.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.seth.api.service.ApiWechatService;
import com.seth.bean.base.BaseView;
import com.seth.bean.base.MessageView;
import com.seth.bean.base.ObjectView;
import com.seth.bean.view.WechatJscodeView;
import com.seth.component.common.ErrorCodeEnum;
import com.seth.service.connection.base.HttpClient;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @author xunbo.xu
 * @desc
 * @date 18/11/11
 */
@Service
public class ApiWechatServiceImpl implements ApiWechatService{

    private static final String URL_WECHAT_JSCODE_FORMAT = "https://api.weixin.qq.com/sns/jscode2session?appid=%s&secret=%s&js_code=%s&grant_type=authorization_code";

    @Override
    public BaseView queryJsCode(String jsCode) {
        String url = String.format(URL_WECHAT_JSCODE_FORMAT, "wx0ddc0ffb1e8551ef", "4f6938d3bd657e9fe7f2c764a0731372", jsCode);
        String jsonStr = HttpClient.doGet(url, null, true);
        if(StringUtils.isNotEmpty(jsonStr)) {
            JSONObject jsonObject = JSON.parseObject(jsonStr);
            if(jsonObject.getInteger("errcode") == null || jsonObject.getInteger("errcode") == 0){
                String openid = jsonObject.getString("openid");
                String unionid = jsonObject.getString("unionid");
                String session_key = jsonObject.getString("session_key");
                return new ObjectView<WechatJscodeView>(new WechatJscodeView(openid, unionid, session_key));
            }else if(jsonObject.getInteger("errcode") == 40029){
                return new MessageView(ErrorCodeEnum.FAIL, "code 无效");
            }else if(jsonObject.getInteger("errcode") == 45011){
                return new MessageView(ErrorCodeEnum.FAIL, "频率限制，每个用户每分钟100次");
            }else if(jsonObject.getInteger("errcode") == 40163){
                return new MessageView(ErrorCodeEnum.FAIL, "jscode已经失效");
            }else if(jsonObject.getInteger("errcode") == -1){
                return new MessageView(ErrorCodeEnum.FAIL, "微信系统繁忙，此时请开发者稍候再试");
            }else {
                return new MessageView(ErrorCodeEnum.FAIL, "未知错误码");
            }
        }
        return new MessageView(ErrorCodeEnum.FAIL, "微信响应空");
    }
}
