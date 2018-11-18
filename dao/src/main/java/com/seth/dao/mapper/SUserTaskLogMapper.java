package com.seth.dao.mapper;

import com.seth.dao.domain.SUserTaskLog;

public interface SUserTaskLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SUserTaskLog record);

    int insertSelective(SUserTaskLog record);

    SUserTaskLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SUserTaskLog record);

    int updateByPrimaryKey(SUserTaskLog record);
}