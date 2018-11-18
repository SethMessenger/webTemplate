package com.seth.dao.mapper;

import com.seth.dao.domain.SUser;

public interface SUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SUser record);

    int insertSelective(SUser record);

    SUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SUser record);

    int updateByPrimaryKey(SUser record);
}