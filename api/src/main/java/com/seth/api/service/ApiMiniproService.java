package com.seth.api.service;

import com.seth.bean.view.BannerView;
import com.seth.bean.view.MiniProView;

import java.util.List;

/**
 * @author  xunbo.xu
 * @desc    接入小程序service
 * @date 18/11/10
 */
public interface ApiMiniproService {

    List<MiniProView> queryNewMinis();

    List<MiniProView> queryHotMinis();

    List<MiniProView> queryAllMinis();

    List<BannerView> queryBanners();
}
