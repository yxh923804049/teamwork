package com.hg.teamwork.controller.vo;

import java.util.Date;

public class MaterialsVo {
    /**
     * 资料id
     */
    private Integer id;
    /**
     * 资料名
     */
    private String profileName;
    /**
     * 资料路径
     */
    private String path;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 分享名
     */
    private String userName;
    /**
     * 创建时间
     */
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
