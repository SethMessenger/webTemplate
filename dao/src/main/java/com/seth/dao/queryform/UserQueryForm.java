package com.seth.dao.queryform;

/**
 * @author  xunbo.xu
 * @desc    用户查询
 * @date 18/10/11
 */
public class UserQueryForm {

    private String userUuid;
    private Integer id;
    private String openId;
    private String unionId;

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }
}
