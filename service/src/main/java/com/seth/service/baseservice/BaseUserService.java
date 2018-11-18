package com.seth.service.baseservice;

import com.seth.dao.domain.SUser;
import com.seth.dao.queryform.UserQueryForm;

import java.util.List;

/**
 * @author  xunbo.xu
 * @desc    用户基础业务
 * @date 18/10/11
 */
public interface BaseUserService {

    /**
     * 用户基础信息添加
     * @param user
     * @return
     */
    SUser addUser(SUser user);

    /**
     * 用户列表查询
     * @param form
     * @return
     */
    List<SUser> queryUserList(UserQueryForm form);
}
