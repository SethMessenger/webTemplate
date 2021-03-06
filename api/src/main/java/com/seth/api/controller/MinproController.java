package com.seth.api.controller;

import com.seth.api.service.ApiMiniproService;
import com.seth.bean.base.BaseView;
import com.seth.bean.base.ObjectView;
import com.seth.bean.view.BannerView;
import com.seth.bean.view.MiniProView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author xunbo.xu
 * @desc
 * @date 18/11/10
 */
@Controller
@RequestMapping("mini")
public class MinproController {

    @Autowired
    private ApiMiniproService miniproService;

    /**
     * banner列表
     * @return
     */
    @RequestMapping("banners")
    public BaseView querybanners(@RequestParam(required = false) String openId){
        List<BannerView> views =  this.miniproService.queryBanners(openId);
        return new ObjectView<List<BannerView>>(views);
    }

    /**
     * 最新小程序列表
     * @return
     */
    @RequestMapping("newlist")
    public BaseView queryNewMinis(@RequestParam(required = false) String openId){
        List<MiniProView> views =  this.miniproService.queryNewMinis(openId);
        return new ObjectView<List<MiniProView>>(views);
    }

    /**
     * 最热小程序列表
     * @return
     */
    @RequestMapping("hotlist")
    public BaseView queryHotMinis(@RequestParam(required = false) String openId){
        List<MiniProView> views =  this.miniproService.queryHotMinis(openId);
        return new ObjectView<List<MiniProView>>(views);
    }

    /**
     * 全部小程序
     * @return
     */
    @RequestMapping("list")
    public BaseView queryAllMinis(@RequestParam(required = false) String openId){
        List<MiniProView> views =  this.miniproService.queryAllMinis(openId);
        return new ObjectView<List<MiniProView>>(views);
    }

}
