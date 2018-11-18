package com.seth.dao.mapper;

import com.seth.dao.domain.STask;

public interface STaskMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(STask record);

    int insertSelective(STask record);

    STask selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(STask record);

    int updateByPrimaryKey(STask record);
}