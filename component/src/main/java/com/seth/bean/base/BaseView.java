package com.seth.bean.base;

import com.seth.component.common.ErrorCodeEnum;
import java.io.Serializable;

/**
 * @author xunbo.xu
 * @desc    api节点返回值的根节点
 * @date 18/7/8
 */
public abstract class BaseView implements Serializable{

    private static final long serialVersionUID = 1L;

    public static final BaseView SUCCESS = new BaseView(ErrorCodeEnum.SUCCESS) {
        private static final long serialVersionUID = 1L;

        @Override
        public BaseCode getError(){
            return new BaseCode(ErrorCodeEnum.SUCCESS);
        }
    };

    public static final BaseView FAIL = new BaseView(ErrorCodeEnum.FAIL) {
        private static final long serialVersionUID = 1L;

        @Override
        public BaseCode getError(){
            return new BaseCode(ErrorCodeEnum.FAIL);
        }
    };

    public static final BaseView PARAM_ERROR = new BaseView(ErrorCodeEnum.PARAM_ERROR) {
        private static final long serialVersionUID = 1L;

        @Override
        public BaseCode getError(){
            return new BaseCode(ErrorCodeEnum.PARAM_ERROR);
        }
    };

    protected BaseView(ErrorCodeEnum code){
        this.error = new BaseCode(code);
    }

    protected BaseCode error;

    public BaseCode getError() {
        return error;
    }

    public void setError(BaseCode error) {
        this.error = error;
    }
}
