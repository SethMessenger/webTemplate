package com.seth.bean.view;

import java.util.List;

/**
 * @author  xunbo.xu
 * @desc    用户所需要展示的任务列表
 * @date 18/10/29
 */
public class UserTaskView {
    private String userUuid;
    private String userOpenId;
    private List<TaskView> tasks;

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

    public List<TaskView> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskView> tasks) {
        this.tasks = tasks;
    }

    public String getUserOpenId() {
        return userOpenId;
    }

    public void setUserOpenId(String userOpenId) {
        this.userOpenId = userOpenId;
    }
}
