package com.seth.component.bean.base;

import com.seth.component.common.ErrorCodeEnum;

/**
 * @author xunbo.xu
 * @desc
 * @date 18/8/15
 */
public class MessageView extends BaseView{

    private String msg;

    public MessageView(ErrorCodeEnum code, String msg) {
        super(code);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
