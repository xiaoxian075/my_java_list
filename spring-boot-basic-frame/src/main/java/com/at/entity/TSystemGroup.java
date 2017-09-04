package com.at.entity;

import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

public class TSystemGroup {
    private Integer id;

    /*
    * 权限组名称
    */
    @ApiModelProperty(value="权限组名称")
    private String groupName;

    /*
    * 状态0正常1被删除4禁用
    */
    @ApiModelProperty(value="状态0正常1被删除4禁用")
    private Byte status;

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

    public static final String GROUP_NAME_ASC = "group_name ASC";

    public static final String GROUP_NAME_DESC = "group_name DESC";

    public static final String STATUS_ASC = "status ASC";

    public static final String STATUS_DESC = "status DESC";

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
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    /**
     * @param groupName 权限组名称
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
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