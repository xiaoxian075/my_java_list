package com.at.entity;

import com.at.entity.custom.TSystemUserCustom;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

public class TSystemUser extends TSystemUserCustom {
    /*
    * 系统用户Id
    */
    @ApiModelProperty(value="系统用户Id")
    private Integer id;

    /*
    * 登录帐号
    */
    @ApiModelProperty(value="登录帐号")
    private String loginName;

    /*
    * 登录密码
    */
    @ApiModelProperty(value="登录密码")
    private String password;

    /*
    * 状态0正常1被删除4禁用
    */
    @ApiModelProperty(value="状态0正常1被删除4禁用")
    private Byte status;

    /*
    * 权限组Id
    */
    @ApiModelProperty(value="权限组Id")
    private Integer groupId;

    /*
    * 绑定Ip地址 0表示所有
    */
    @ApiModelProperty(value="绑定Ip地址 0表示所有")
    private Long bindIp;

    /*
    * 创建时间
    */
    @ApiModelProperty(value="创建时间")
    private Date createTime;

    /*
    * 创建IP
    */
    @ApiModelProperty(value="创建IP")
    private Long createIp;

    /*
    * t_system_user.id 0表示初始化创建
    */
    @ApiModelProperty(value="t_system_user.id 0表示初始化创建")
    private Integer creator;

    public static final String ID_ASC = "id ASC";

    public static final String ID_DESC = "id DESC";

    public static final String LOGIN_NAME_ASC = "login_name ASC";

    public static final String LOGIN_NAME_DESC = "login_name DESC";

    public static final String PASSWORD_ASC = "password ASC";

    public static final String PASSWORD_DESC = "password DESC";

    public static final String STATUS_ASC = "status ASC";

    public static final String STATUS_DESC = "status DESC";

    public static final String GROUP_ID_ASC = "group_id ASC";

    public static final String GROUP_ID_DESC = "group_id DESC";

    public static final String BIND_IP_ASC = "bind_ip ASC";

    public static final String BIND_IP_DESC = "bind_ip DESC";

    public static final String CREATE_TIME_ASC = "create_time ASC";

    public static final String CREATE_TIME_DESC = "create_time DESC";

    public static final String CREATE_IP_ASC = "create_ip ASC";

    public static final String CREATE_IP_DESC = "create_ip DESC";

    public static final String CREATOR_ASC = "creator ASC";

    public static final String CREATOR_DESC = "creator DESC";

    public Integer getId() {
        return id;
    }

    /**
     * @param id 系统用户Id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    /**
     * @param loginName 登录帐号
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getPassword() {
        return password;
    }

    /**
     * @param password 登录密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Byte getStatus() {
        return status;
    }

    /**
     * @param status 状态0正常1被删除4禁用
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    public Integer getGroupId() {
        return groupId;
    }

    /**
     * @param groupId 权限组Id
     */
    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Long getBindIp() {
        return bindIp;
    }

    /**
     * @param bindIp 绑定Ip地址 0表示所有
     */
    public void setBindIp(Long bindIp) {
        this.bindIp = bindIp;
    }

    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCreateIp() {
        return createIp;
    }

    /**
     * @param createIp 创建IP
     */
    public void setCreateIp(Long createIp) {
        this.createIp = createIp;
    }

    public Integer getCreator() {
        return creator;
    }

    /**
     * @param creator t_system_user.id 0表示初始化创建
     */
    public void setCreator(Integer creator) {
        this.creator = creator;
    }
}