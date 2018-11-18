package com.seth.api.controller;

import com.seth.api.service.ApiWechatService;
import com.seth.bean.base.BaseView;
import com.seth.bean.base.MessageView;
import com.seth.component.common.ErrorCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author  xunbo.xu
 * @desc    转发微信请求
 * @date 18/11/11
 */
@RequestMapping("wechat")
@Controller
public class WechatController {

    @Autowired
    private ApiWechatService wechatService;

    @RequestMapping("jscode2session")
    public BaseView jscode2session(@RequestParam(required = true) String jsCode){
        BaseView view = BaseView.FAIL;
        try {
            view = this.wechatService.queryJsCode(jsCode);
        }catch (Exception e){
            e.printStackTrace();
            view = new MessageView(ErrorCodeEnum.FAIL, "API系统错误");
        }
        return view;
    }

}
