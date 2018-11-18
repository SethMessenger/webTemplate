package com.seth.dao.mapper;

import com.seth.dao.domain.SUser;
import com.seth.dao.queryform.UserQueryForm;

import java.util.List;

public interface SUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SUser record);

    int insertSelective(SUser record);

    SUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SUser record);

    int updateByPrimaryKey(SUser record);

    /**
     * 列表查询
     * @param form
     * @return
     */
    List<SUser> selectByQueryForm(UserQueryForm form);
}