package com.seth.api.service.impl;

import com.seth.api.service.ApiMiniproService;
import com.seth.bean.view.BannerView;
import com.seth.bean.view.MiniProView;
import com.seth.component.common.MiniProTypeEnum;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author xunbo.xu
 * @desc
 * @date 18/11/10
 */
@Service
public class ApiMiniproServiceImpl implements ApiMiniproService{

    @Override
    public List<MiniProView> queryNewMinis() {
        List<MiniProView> views = this.queryAllMinis();
        Comparator<MiniProView> miniProComparator = new Comparator<MiniProView>() {
            @Override
            public int compare(MiniProView o1, MiniProView o2) {
                return o1.getTimeSort() - o2.getTimeSort();
            }
        };
        Collections.sort(views, miniProComparator);
        return views;
    }

    @Override
    public List<MiniProView> queryHotMinis() {
        List<MiniProView> views = this.queryAllMinis();
        Comparator<MiniProView> miniProComparator = new Comparator<MiniProView>() {
            @Override
            public int compare(MiniProView o1, MiniProView o2) {
                return new BigDecimal(o1.getHotSort()).subtract(new BigDecimal(o2.getHotSort())).
                        multiply(new BigDecimal(100)).intValue();
            }
        };
        Collections.sort(views, miniProComparator);
        return views;
    }

    @Override
    public List<MiniProView> queryAllMinis() {
        List<MiniProTypeEnum> enums = MiniProTypeEnum.getAll();
        List<MiniProView> views = new ArrayList<MiniProView>();
        for (MiniProTypeEnum e : enums){
            MiniProView view = new MiniProView(e);
            views.add(view);
        }
        return views;
    }

    @Override
    public List<BannerView> queryBanners() {
        List<MiniProTypeEnum> enums = MiniProTypeEnum.getAll();
        List<BannerView> banners = new ArrayList<BannerView>();
        for (MiniProTypeEnum e : enums){
            BannerView banner = new BannerView(e);
            banners.add(banner);
        }
        return banners;
    }


}
