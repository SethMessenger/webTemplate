package com.seth.api.controller;

import com.seth.api.service.ApiTaskService;
import com.seth.bean.base.BaseView;
import com.seth.bean.base.MessageView;
import com.seth.bean.base.ObjectView;
import com.seth.bean.view.UserTaskView;
import com.seth.component.common.ErrorCodeEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author  xunbo.xu
 * @desc    任务系统controller
 * @date 18/10/29
 */
@RequestMapping("task")
@Controller
public class TaskController {

    @Autowired
    private ApiTaskService apiTaskService;

    /**
     * 查询当前用户所需展示的任务列表
     * @param userUuid
     * @param openId
     * @return
     */
    @RequestMapping("list")
    public BaseView queryTasks(@RequestParam(required = false) String userUuid,
                               @RequestParam(required = false) String openId){
        if(StringUtils.isEmpty(userUuid) && StringUtils.isEmpty(openId)){
            return new MessageView(ErrorCodeEnum.PARAM_ERROR, "参数不全");
        }
        UserTaskView taskView = new UserTaskView();
        if(StringUtils.isNotEmpty(openId)){
            taskView = this.apiTaskService.queryUserTaskListByOpenUuid(openId);
        }else if(StringUtils.isNotEmpty(userUuid)){
            taskView = this.apiTaskService.queryUserTaskListByUserUuid(userUuid);
        }
        return new ObjectView<UserTaskView>(taskView);
    }

    /**
     * 用户完成任务统计
     * @param openId
     * @param appId
     * @return
     */
    @RequestMapping("complete")
    public BaseView completeTask(@RequestParam(required = true) String openId,
                               @RequestParam(required = true) String appId){
        BaseView resultView = BaseView.FAIL;
        try {
            boolean flag = this.apiTaskService.completeTask(openId, appId);
            if(flag){
                resultView = BaseView.SUCCESS;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return resultView;
    }

}
