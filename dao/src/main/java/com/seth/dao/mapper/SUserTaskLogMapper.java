package com.seth.dao.mapper;

import com.seth.dao.domain.SUserTaskLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SUserTaskLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SUserTaskLog record);

    int insertSelective(SUserTaskLog record);

    SUserTaskLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SUserTaskLog record);

    int updateByPrimaryKey(SUserTaskLog record);

    List<SUserTaskLog> selectByParams(@Param("appId") String appId, @Param("userUuid")String userUuid);
}