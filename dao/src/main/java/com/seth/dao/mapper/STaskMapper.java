package com.seth.dao.mapper;

import com.seth.dao.domain.STask;

import java.util.List;

public interface STaskMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(STask record);

    int insertSelective(STask record);

    STask selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(STask record);

    int updateByPrimaryKey(STask record);

    /**
     * 查询全部可用的任务列表
     * @return
     */
    List<STask> selectAllTasks();
}