package com.seth.bean.view;

/**
 * @author  xunbo.xu
 * @desc    任务信息展示bean
 * @date 18/10/29
 */
public class TaskView {

    /** 任务uuid */
    private String taskUuid;
    /** 任务名称 */
    private String taskName;
    /** 任务描述 */
    private String desc;
    /** 任务奖励金额 */
    private Integer val;
    /** 任务排序 */
    private Integer sort;

    /** 小程序APPID */
    private String appId;
    /** 小程序跳转路径 */
    private String appPath;
    /** 小程序跳转参数 */
    private String appParam;

    public TaskView(){ super(); }

    public TaskView(String taskUuid, String taskName, String desc, Integer val, Integer sort, String appId, String appPath, String appParam) {
        this.taskUuid = taskUuid;
        this.taskName = taskName;
        this.desc = desc;
        this.val = val;
        this.sort = sort;
        this.appId = appId;
        this.appPath = appPath;
        this.appParam = appParam;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppPath() {
        return appPath;
    }

    public void setAppPath(String appPath) {
        this.appPath = appPath;
    }

    public String getAppParam() {
        return appParam;
    }

    public void setAppParam(String appParam) {
        this.appParam = appParam;
    }

    public String getTaskUuid() {
        return taskUuid;
    }

    public void setTaskUuid(String taskUuid) {
        this.taskUuid = taskUuid;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getVal() {
        return val;
    }

    public void setVal(Integer val) {
        this.val = val;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
