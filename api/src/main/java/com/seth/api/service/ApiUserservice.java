package com.seth.api.service;

import com.seth.bean.form.UserRegisterForm;
import com.seth.bean.view.UserView;
import com.seth.dao.domain.SUser;

/**
 * @author xunbo.xu
 * @desc
 * @date 18/10/11
 */
public interface ApiUserservice {

    /**
     * 用户信息注册
     * @param userForm
     * @return
     */
    SUser userAdd(UserRegisterForm userForm);

    /**
     * 条件查询用户信息
     * @param userUuid
     * @param id
     * @return
     */
    UserView queryUser(String userUuid, Integer id);

    /**
     * 用户列表查询
     */
    void queryUserList();

    /**
     *
     * @param openId
     * @return
     */
    SUser queryUserByOpenId(String openId);
}
