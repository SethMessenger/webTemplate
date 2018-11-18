package com.seth.api.service;

import com.seth.bean.base.BaseView;

/**
 * @author xunbo.xu
 * @desc
 * @date 18/11/11
 */
public interface ApiWechatService {

    BaseView queryJsCode(String jsCode);

}
