package com.seth.dao.mapper;

import com.seth.dao.domain.SUserCoinLog;

public interface SUserCoinLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SUserCoinLog record);

    int insertSelective(SUserCoinLog record);

    SUserCoinLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SUserCoinLog record);

    int updateByPrimaryKey(SUserCoinLog record);
}