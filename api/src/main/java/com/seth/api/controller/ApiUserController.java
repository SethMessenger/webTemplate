package com.seth.api.controller;

import com.seth.api.service.impl.ApiUserServiceImpl;
import com.seth.bean.base.BaseView;
import com.seth.bean.base.MessageView;
import com.seth.bean.base.ObjectView;
import com.seth.bean.form.UserRegisterForm;
import com.seth.bean.view.UserView;
import com.seth.component.common.ErrorCodeEnum;
import com.seth.dao.domain.SUser;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author  xunbo.xu
 * @desc    用户API操作
 * @date 18/10/10
 */
@Controller
@RequestMapping("user")
public class ApiUserController {

    @Autowired
    private ApiUserServiceImpl userService;

    /**
     * 用户微信登录注册
     * @param form
     * @return
     */
    @RequestMapping(value = "register", method = RequestMethod.POST)
    @ResponseBody
    public BaseView queryUserList(@RequestBody UserRegisterForm form){
        BaseView view = BaseView.FAIL;
        UserView resultView = null;
        try {
            if(checkForm(form)){
                SUser user = this.userService.userAdd(form);
                if(null != user){
                    resultView = new UserView(user.getUserUuid(), user.getOpenId(), user.getUnionId(), user.getHeadImg(), user.getGender(),
                            user.getTotal(), 0, 0, 0, 0, 0);
                    view = new ObjectView<UserView>(resultView);
                }else {
                    view = new MessageView(ErrorCodeEnum.FAIL, "用户已经注册");
                }
            }else{
                view = new MessageView(ErrorCodeEnum.PARAM_ERROR, "参数不全");
            }
        }catch (Exception e){
            e.printStackTrace();
            view = new MessageView(ErrorCodeEnum.FAIL, "系统异常");
        }
        return view;
    }

    /**
     * 查询用户信息
     * @param openId
     * @return
     */
    @RequestMapping(value = "info", method = RequestMethod.GET)
    @ResponseBody
    public BaseView queryUserInfo(@RequestParam String openId){
        BaseView view = BaseView.FAIL;
        UserView resultView = null;
        try {
            if(StringUtils.isNotEmpty(openId)){
                SUser user = this.userService.queryUserByOpenId(openId);
                if(null != user){
                    //TODO  新增用户账户和任务系统查询
                    resultView = new UserView(user.getUserUuid(), user.getOpenId(), user.getUnionId(), user.getHeadImg(), user.getGender(),
                            user.getTotal(), 0, 0, 0, 0, 0);
                    view = new ObjectView<UserView>(resultView);
                }else {
                    view = new MessageView(ErrorCodeEnum.PARAM_ERROR, "用户不存在");
                }
            }else {
                view = new MessageView(ErrorCodeEnum.PARAM_ERROR, "参数错误");
            }
        }catch (Exception e){
            e.printStackTrace();
            view = new MessageView(ErrorCodeEnum.FAIL, "系统异常");
        }
        return view;
    }

    /**
     * 用户注册参数校验
     * @param form
     * @return
     */
    private boolean checkForm(UserRegisterForm form) {
        if(StringUtils.isNotEmpty(form.getHeadImg()) && StringUtils.isNotEmpty(form.getOpenId()) && null != form.getGender() &&
                StringUtils.isNotEmpty(form.getNickName())){
            return true;
        }
        return false;
    }

}
