package com.at.pojo.admin;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Administrator on 2017/6/15.
 */
public class SystemUserBO {
    @ApiModelProperty("用户Id")
    private int id;
    @ApiModelProperty("登录名称，长度4-32")
    private String loginName;
    @ApiModelProperty("登录密码,长度4-32")
    private String password;
    @ApiModelProperty("所属权限组Id")
    private int groupId;
    @ApiModelProperty("绑定IP登录")
    private String bindIp;

    public void setBindIp(String bindIp) {
        this.bindIp = bindIp;
    }

    public String getBindIp() {
        return bindIp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
}
