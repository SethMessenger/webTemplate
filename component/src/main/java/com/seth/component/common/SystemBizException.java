package com.seth.component.common;

/**
 * @author  xunbo.xu
 * @desc    系统内部业务流转异常
 * @date 18/10/11
 */
public class SystemBizException extends RuntimeException{

    private final String userErrMsg;
    private final SystemErrorEnum errorCode;

    public SystemBizException(SystemErrorEnum errorCode, String sysErrMsg, String userErrMsg) {
        super(sysErrMsg);
        this.userErrMsg = userErrMsg;
        this.errorCode = errorCode;
    }

    public SystemBizException(SystemErrorEnum errorCode, String sysErrMsg, String userErrMsg, Throwable cause) {
        super(sysErrMsg, cause);
        this.userErrMsg = userErrMsg;
        this.errorCode = errorCode;
    }

    public SystemBizException(SystemErrorEnum errorCode, String sysErrMsg) {
        super(sysErrMsg);
        this.userErrMsg = null;
        this.errorCode = errorCode;
    }

    public SystemErrorEnum getErrorCode() {
        return errorCode;
    }

    public String getUserErrMsg() {
        return userErrMsg;
    }

    public String getSysErrMsg() {
        return getMessage();
    }

}
