package com.seth.cms.service.impl;

import com.seth.cms.service.CmsUserService;
import com.seth.dao.mapper.SUserMapper;
import com.seth.dao.domain.SUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author  xunbo.xu
 * @desc
 * @date 18/10/10
 */
@Service
public class UserServiceImpl implements CmsUserService {

    @Autowired
    private SUserMapper userMapper;

    /**
     * 用户注册
     *
     * @param user
     */
    @Override
    public void register(SUser user) {
        this.userMapper.insert(user);
    }
}
