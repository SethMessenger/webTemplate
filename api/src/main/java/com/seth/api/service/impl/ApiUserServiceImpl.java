package com.seth.api.service.impl;

import com.seth.api.service.ApiUserservice;
import com.seth.bean.form.UserRegisterForm;
import com.seth.bean.view.UserView;
import com.seth.dao.domain.SUser;
import com.seth.dao.queryform.UserQueryForm;
import com.seth.service.baseservice.BaseUserService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xunbo.xu
 * @desc
 * @date 18/10/11
 */
@Service
public class ApiUserServiceImpl implements ApiUserservice{

    @Autowired
    private BaseUserService baseUserService;
    /**
     * 用户信息注册
     *
     * @param userForm
     * @return
     */
    @Override
    public SUser userAdd(UserRegisterForm userForm) {
        UserQueryForm form = new UserQueryForm();
        form.setOpenId(userForm.getOpenId());
        List<SUser> users = this.baseUserService.queryUserList(form);
        if(CollectionUtils.isNotEmpty(users)){
            return null;
        }else {
            SUser user = new SUser(userForm);
            return this.baseUserService.addUser(user);
        }
    }

    /**
     * 条件查询用户信息
     *  @param userUuid
     * @param id
     */
    @Override
    public UserView queryUser(String userUuid, Integer id) {
        if(StringUtils.isNotEmpty(userUuid) || (null != id && id > 0)){
            UserQueryForm form = new UserQueryForm();
            form.setUserUuid(userUuid);
            form.setId(id);
            List<SUser> users = this.baseUserService.queryUserList(form);
            if(CollectionUtils.isNotEmpty(users)){
                SUser item = users.get(0);
                return new UserView(item.getUserUuid(), item.getOpenId(), item.getUnionId(), item.getHeadImg(), item.getGender(),
                        item.getTotal(), 0, 0, 0, 0, 0);
            }
        }
        return null;
    }

    /**
     * 用户列表查询
     */
    @Override
    public void queryUserList() {

    }

    /**
     * 根据openid查询用户信息
     * @param openId
     * @return
     */
    @Override
    public SUser queryUserByOpenId(String openId) {
        UserQueryForm form = new UserQueryForm();
        form.setOpenId(openId);
        List<SUser> users = this.baseUserService.queryUserList(form);
        if(CollectionUtils.isNotEmpty(users)){
            return users.get(0);
        }
        return null;
    }
}
