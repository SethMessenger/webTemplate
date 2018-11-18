package com.seth.api.controller;

import com.seth.bean.base.BaseView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author  xunbo.xu
 * @desc    用户金币管理controller
 * @date 18/11/18
 */
@Controller
@RequestMapping("coins")
public class ApiUserCoinController {

    @RequestMapping(value = "/{openId}/log", method = RequestMethod.POST)
    @ResponseBody
    public BaseView queryUserList(@PathVariable String openId){
        BaseView view = BaseView.FAIL;

        return view;
    }

}
