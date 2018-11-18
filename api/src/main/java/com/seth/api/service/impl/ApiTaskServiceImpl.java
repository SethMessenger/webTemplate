package com.seth.api.service.impl;

import com.seth.api.service.ApiTaskService;
import com.seth.bean.view.TaskView;
import com.seth.bean.view.UserTaskView;
import com.seth.component.common.MiniProTypeEnum;
import com.seth.dao.domain.STask;
import com.seth.dao.domain.SUser;
import com.seth.dao.domain.SUserCoinLog;
import com.seth.dao.domain.SUserTaskLog;
import com.seth.dao.mapper.STaskMapper;
import com.seth.dao.mapper.SUserCoinLogMapper;
import com.seth.dao.mapper.SUserMapper;
import com.seth.dao.mapper.SUserTaskLogMapper;
import com.seth.dao.queryform.UserQueryForm;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
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
    @Autowired
    private SUserMapper userMapper;
    @Autowired
    private SUserTaskLogMapper taskLogMapper;
    @Autowired
    private SUserCoinLogMapper coinLogMapper;

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

    /**
     * 用户完成任务
     *
     * @param openId
     * @param appId
     * @return
     */
    @Override
    public boolean completeTask(String openId, String appId) {
        boolean result = false;
        //查询当前 任务 & 用户 是否存在，用户是否完成
        MiniProTypeEnum task = MiniProTypeEnum.getByAppId(appId);
        if(null != task){
            UserQueryForm form = new UserQueryForm();
            form.setOpenId(openId);
            List<SUser> users = this.userMapper.selectByQueryForm(form);
            SUser currentUser= null;
            if(CollectionUtils.isNotEmpty(users)){
                currentUser = users.get(0);
                List<SUserTaskLog> logs = this.taskLogMapper.selectByParams(task.getAppId(), currentUser.getUserUuid());
                if(CollectionUtils.isEmpty(logs)){
                    Integer total = currentUser.getTotal() + task.getVal();
                    currentUser.setTotal(total);
                    Integer s = this.userMapper.updateByPrimaryKey(currentUser);
                    if(s > 0){
                        SUserTaskLog taskLog = new SUserTaskLog("completeTask",task.getAppId(),
                                currentUser.getUserUuid(), new Date(),task.getVal(),"用户");
                        this.taskLogMapper.insert(taskLog);
                        SUserCoinLog coinLog = new SUserCoinLog("completeTask",currentUser.getUserUuid(),
                                task.getVal(), 1, "完成任务入账", "完成任务入账");
                        this.coinLogMapper.insert(coinLog);
                        result = true;
                    }
                }
            }
        }
        return result;
    }

}
