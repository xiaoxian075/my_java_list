package com.at.entity;

import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

public class TSystemCtrlMethod {
    /*
    * 主键Id
    */
    @ApiModelProperty(value="主键Id")
    private Integer id;

    /*
    * 方法Id
    */
    @ApiModelProperty(value="方法Id")
    private Integer methodId;

    /*
    * t_system_ctrl.id
    */
    @ApiModelProperty(value="t_system_ctrl.id")
    private Integer ctrlId;

    /*
    * 方法名称
    */
    @ApiModelProperty(value="方法名称")
    private String methodName;

    /*
    * 方法描述
    */
    @ApiModelProperty(value="方法描述")
    private String methodDesc;

    /*
    * 方法版本
    */
    @ApiModelProperty(value="方法版本")
    private Integer methodVersion;

    /*
    * 最后更新时间
    */
    @ApiModelProperty(value="最后更新时间")
    private Date lastUpdateTime;

    public static final String ID_ASC = "id ASC";

    public static final String ID_DESC = "id DESC";

    public static final String METHOD_ID_ASC = "method_id ASC";

    public static final String METHOD_ID_DESC = "method_id DESC";

    public static final String CTRL_ID_ASC = "ctrl_id ASC";

    public static final String CTRL_ID_DESC = "ctrl_id DESC";

    public static final String METHOD_NAME_ASC = "method_name ASC";

    public static final String METHOD_NAME_DESC = "method_name DESC";

    public static final String METHOD_DESC_ASC = "method_desc ASC";

    public static final String METHOD_DESC_DESC = "method_desc DESC";

    public static final String METHOD_VERSION_ASC = "method_version ASC";

    public static final String METHOD_VERSION_DESC = "method_version DESC";

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

    public Integer getMethodId() {
        return methodId;
    }

    /**
     * @param methodId 方法Id
     */
    public void setMethodId(Integer methodId) {
        this.methodId = methodId;
    }

    public Integer getCtrlId() {
        return ctrlId;
    }

    /**
     * @param ctrlId t_system_ctrl.id
     */
    public void setCtrlId(Integer ctrlId) {
        this.ctrlId = ctrlId;
    }

    public String getMethodName() {
        return methodName;
    }

    /**
     * @param methodName 方法名称
     */
    public void setMethodName(String methodName) {
        this.methodName = methodName == null ? null : methodName.trim();
    }

    public String getMethodDesc() {
        return methodDesc;
    }

    /**
     * @param methodDesc 方法描述
     */
    public void setMethodDesc(String methodDesc) {
        this.methodDesc = methodDesc == null ? null : methodDesc.trim();
    }

    public Integer getMethodVersion() {
        return methodVersion;
    }

    /**
     * @param methodVersion 方法版本
     */
    public void setMethodVersion(Integer methodVersion) {
        this.methodVersion = methodVersion;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * @param lastUpdateTime 最后更新时间
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }
}