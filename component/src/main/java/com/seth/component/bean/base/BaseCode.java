package com.seth.component.bean.base;

import com.seth.component.common.ErrorCodeEnum;

/**
 * @author xunbo.xu
 * @desc    用于包装前端错误码
 * @date 18/7/8
 */
public class BaseCode {

    private int error;
    private String errorMsg;
    private long timeStamp;

    public BaseCode(ErrorCodeEnum code) {
        this.error = code.getError();
        this.errorMsg = code.getErrorMsg();
        this.timeStamp = System.currentTimeMillis();
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
