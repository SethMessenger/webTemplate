package com.seth.api.service;

import com.seth.bean.view.UserTaskView;

/**
 * @author  xunbo.xu
 * @desc    API任务业务层
 * @date 18/10/29
 */
public interface ApiTaskService {

    /**
     * 用户uuid查询用户的任务列表
     * @param userUUid
     * @return
     */
    UserTaskView queryUserTaskListByUserUuid(String userUUid);

    /**
     * 用户openId查询用户的任务列表
     * @param openId
     * @return
     */
    UserTaskView queryUserTaskListByOpenUuid(String openId);

    /**
     * 用户完成任务
     * @param openId
     * @param appId
     * @return
     */
    boolean completeTask(String openId, String appId);


}
