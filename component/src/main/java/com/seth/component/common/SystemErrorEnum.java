package com.seth.component.common;

/**
 * @author  xunbo.xu
 * @desc    系统内部可视化异常编码
 * @date 18/10/11
 */
public enum  SystemErrorEnum {

    SUCCESS(0, "系统异常");

    private int error;
    private String errorMsg;

    private SystemErrorEnum(){}
    private SystemErrorEnum(int error, String errorMsg){
        this.error = error;
        this.errorMsg = errorMsg;
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

}
