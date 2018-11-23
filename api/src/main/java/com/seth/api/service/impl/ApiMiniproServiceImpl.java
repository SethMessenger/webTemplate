package com.seth.api.service.impl;

import com.seth.api.service.ApiMiniproService;
import com.seth.bean.view.BannerView;
import com.seth.bean.view.MiniProView;
import com.seth.component.common.MiniProTypeEnum;
import com.seth.dao.domain.SUser;
import com.seth.dao.domain.SUserTaskLog;
import com.seth.dao.mapper.SUserMapper;
import com.seth.dao.mapper.SUserTaskLogMapper;
import com.seth.dao.queryform.UserQueryForm;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private SUserTaskLogMapper taskLogMapper;
    @Autowired
    private SUserMapper userMapper;

    @Override
    public List<MiniProView> queryNewMinis(String openId) {
        List<MiniProView> views = this.queryAllMinis(openId);
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
    public List<MiniProView> queryHotMinis(String openId) {
        List<MiniProView> views = this.queryAllMinis(openId);
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
    public List<MiniProView> queryAllMinis(String openId) {
        List<MiniProTypeEnum> enums = MiniProTypeEnum.getAll();
        List<MiniProView> views = new ArrayList<MiniProView>();
        List<SUserTaskLog> logs = new ArrayList<>();
        if(StringUtils.isNotEmpty(openId)){
            UserQueryForm form = new UserQueryForm();
            form.setOpenId(openId);
            List<SUser> users = this.userMapper.selectByQueryForm(form);
            if(CollectionUtils.isNotEmpty(users)){
                logs = this.taskLogMapper.selectByParams(null, users.get(0).getUserUuid());
            }
        }
        for (MiniProTypeEnum e : enums){
            boolean isComplete = false;
            for (SUserTaskLog log : logs){
                if(log.getTaskUuid().equals(e.getAppId())){
                    isComplete = true;
                }
            }
            MiniProView view = new MiniProView(e, isComplete);
            views.add(view);
        }
        return views;
    }

    @Override
    public List<BannerView> queryBanners(String openId) {
        List<MiniProTypeEnum> enums = MiniProTypeEnum.getAll();
        List<BannerView> banners = new ArrayList<BannerView>();
        for (MiniProTypeEnum e : enums){
            BannerView banner = new BannerView(e);
            banners.add(banner);
        }
        return banners;
    }


}
