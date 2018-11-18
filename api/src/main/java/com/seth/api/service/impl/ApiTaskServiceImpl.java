package com.seth.api.service.impl;

import com.seth.api.service.ApiTaskService;
import com.seth.bean.view.TaskView;
import com.seth.bean.view.UserTaskView;
import com.seth.dao.domain.STask;
import com.seth.dao.mapper.STaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xunbo.xu
 * @desc
 * @date 18/10/29
 */
@Service
public class ApiTaskServiceImpl implements ApiTaskService{

    @Autowired
    private STaskMapper taskMapper;

    /**
     * 用户uuid查询用户的任务列表
     *
     * @param userUUid
     * @return
     */
    @Override
    public UserTaskView queryUserTaskListByUserUuid(String userUUid) {
        UserTaskView view = new UserTaskView();
        List<STask> tasks = this.taskMapper.selectAllTasks();
        List<TaskView> taskviews = new ArrayList<>();
        for (STask task : tasks){
            TaskView item = new TaskView(task.getTaskUuid(), task.getTaskName(), task.getDescription(), task.getVal(), task.getSort(), task.getAppid(), task.getPath(), task.getParams());
            taskviews.add(item);
        }
        view.setUserUuid(userUUid);
        view.setUserOpenId(null);
        view.setTasks(taskviews);
        return view;
    }

    /**
     * 用户openId查询用户的任务列表
     *
     * @param openId
     * @return
     */
    @Override
    public UserTaskView queryUserTaskListByOpenUuid(String openId) {
        UserTaskView view = new UserTaskView();
        List<STask> tasks = this.taskMapper.selectAllTasks();
        List<TaskView> taskviews = new ArrayList<>();
        for (STask task : tasks){
            TaskView item = new TaskView(task.getTaskUuid(), task.getTaskName(), task.getDescription(), task.getVal(), task.getSort(), task.getAppid(), task.getPath(), task.getParams());
            taskviews.add(item);
        }
        view.setTasks(taskviews);
        view.setUserUuid(null);
        view.setUserOpenId(openId);
        return view;
    }

}
