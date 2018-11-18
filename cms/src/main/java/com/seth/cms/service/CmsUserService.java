package com.seth.cms.service;

import com.seth.dao.domain.SUser;

/**
 * @author  xunbo.xu
 * @desc    用户账户操作service
 * @date 18/10/8
 */
public interface CmsUserService {

    /**
     * 用户注册
     * @param user
     */
    void register(SUser user);


}
