package com.at.entity;

import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

public class TSystemCtrl {
    /*
    * 主键Id
    */
    @ApiModelProperty(value="主键Id")
    private Integer id;

    /*
    * 控制器名称
    */
    @ApiModelProperty(value="控制器名称")
    private String ctrlName;

    /*
    * 控制器描述
    */
    @ApiModelProperty(value="控制器描述")
    private String ctrlDesc;

    /*
    * 版本号
    */
    @ApiModelProperty(value="版本号")
    private Integer ctrlVersion;

    /*
    * 跳转地址
    */
    @ApiModelProperty(value="跳转地址")
    private String ctrlUrl;

    /*
    * 父节点
    */
    @ApiModelProperty(value="父节点")
    private Integer parentId;

    /*
    * 最新更新时间
    */
    @ApiModelProperty(value="最新更新时间")
    private Date lastUpdateTime;

    public static final String ID_ASC = "id ASC";

    public static final String ID_DESC = "id DESC";

    public static final String CTRL_NAME_ASC = "ctrl_name ASC";

    public static final String CTRL_NAME_DESC = "ctrl_name DESC";

    public static final String CTRL_DESC_ASC = "ctrl_desc ASC";

    public static final String CTRL_DESC_DESC = "ctrl_desc DESC";

    public static final String CTRL_VERSION_ASC = "ctrl_version ASC";

    public static final String CTRL_VERSION_DESC = "ctrl_version DESC";

    public static final String CTRL_URL_ASC = "ctrl_url ASC";

    public static final String CTRL_URL_DESC = "ctrl_url DESC";

    public static final String PARENT_ID_ASC = "parent_id ASC";

    public static final String PARENT_ID_DESC = "parent_id DESC";

    public static final String LAST_UPDATE_TIME_ASC = "last_update_time ASC";

    public static final String LAST_UPDATE_TIME_DESC = "last_update_time DESC";

    public Integer getId() {
        return id;
    }

    /**
     * @param id 主键Id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    public String getCtrlName() {
        return ctrlName;
    }

    /**
     * @param ctrlName 控制器名称
     */
    public void setCtrlName(String ctrlName) {
        this.ctrlName = ctrlName == null ? null : ctrlName.trim();
    }

    public String getCtrlDesc() {
        return ctrlDesc;
    }

    /**
     * @param ctrlDesc 控制器描述
     */
    public void setCtrlDesc(String ctrlDesc) {
        this.ctrlDesc = ctrlDesc == null ? null : ctrlDesc.trim();
    }

    public Integer getCtrlVersion() {
        return ctrlVersion;
    }

    /**
     * @param ctrlVersion 版本号
     */
    public void setCtrlVersion(Integer ctrlVersion) {
        this.ctrlVersion = ctrlVersion;
    }

    public String getCtrlUrl() {
        return ctrlUrl;
    }

    /**
     * @param ctrlUrl 跳转地址
     */
    public void setCtrlUrl(String ctrlUrl) {
        this.ctrlUrl = ctrlUrl == null ? null : ctrlUrl.trim();
    }

    public Integer getParentId() {
        return parentId;
    }

    /**
     * @param parentId 父节点
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * @param lastUpdateTime 最新更新时间
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }
}