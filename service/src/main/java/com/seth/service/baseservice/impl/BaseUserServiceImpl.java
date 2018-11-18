package com.seth.service.baseservice.impl;

import com.seth.dao.domain.SUser;
import com.seth.dao.mapper.STaskMapper;
import com.seth.dao.mapper.SUserMapper;
import com.seth.dao.queryform.UserQueryForm;
import com.seth.service.baseservice.BaseUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xunbo.xu
 * @desc
 * @date 18/10/11
 */
@Service
public class BaseUserServiceImpl implements BaseUserService {

    @Autowired
    private SUserMapper userMapper;
    @Autowired
    private STaskMapper taskMapper;


    /**
     * 用户基础信息添加
     *
     * @param user
     * @return
     */
    @Override
    public SUser addUser(SUser user) {
        int count = this.userMapper.insert(user);
        if(count > 0){
            return user;
        }
        return null;
    }

    /**
     * 用户列表查询
     * @param form
     * @return
     */
    @Override
    public List<SUser> queryUserList(UserQueryForm form) {
        return this.userMapper.selectByQueryForm(form);
    }
}
