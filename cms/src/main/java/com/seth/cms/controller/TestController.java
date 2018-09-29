package com.seth.cms.controller;

import com.seth.component.bean.DeployView;
import com.seth.component.bean.base.BaseView;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * @author  xunbo.xu
 * @desc    项目测试目录,用于项目的启动测试 & 各项测试
 * @date 18/9/18
 */
@Controller
@RequestMapping("test")
public class TestController {

    /** 部署版本 TODO 使用MySQL或者其他线上服务进行管理 */
    private static String version = "0.0.1";
    /** 最近部署时间 */
    private static Date lastDate = new Date();


    /**
     * 项目启动测试
     */
    @RequestMapping(value = "ping", method = { RequestMethod.GET, RequestMethod.POST })
    public BaseView ping(){
        BaseView result = BaseView.FAIL;
        try {
            if(null != lastDate && StringUtils.isNotEmpty(version)){
                result = new DeployView(version, lastDate);
            }
        } catch (Exception e){
            result = BaseView.FAIL;
        }
        return result;
    }

    /**
     * 测试加载页面
     * @param path
     * @return
     */
    @RequestMapping(value = "loading/{path}", method = { RequestMethod.GET })
    public ModelAndView loadingPage(@PathVariable String path){
        if(StringUtils.isEmpty(path)){
            path = "test";
        }
        ModelAndView mv = new ModelAndView(path);
        mv.addObject("param", "Seth");
        return mv;
    }

}
