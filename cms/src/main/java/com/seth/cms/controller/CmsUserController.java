package com.seth.cms.controller;

import com.seth.cms.service.CmsUserService;
import com.seth.dao.domain.SUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * @author xunbo.xu
 * @desc
 * @date 18/10/10
 */
@Controller
@RequestMapping("cms/user")
public class CmsUserController {

    @Autowired
    private CmsUserService userService;

    @RequestMapping("cms/user")
    public void queryUserList(){
        SUser user = new SUser();
        user.setGmtCreate(new Date());
        user.setGmtModified(new Date());
        user.setGender(1);
        user.setNickName("Seth");
        this.userService.register(user);
    }

}
