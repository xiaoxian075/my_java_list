package com.at.entity;

import io.swagger.annotations.ApiModelProperty;

public class TSystemUserFieldFilter {
    /*
    * 自增Id
    */
    @ApiModelProperty(value="自增Id")
    private Integer id;

    /*
    * t_system_user.id
    */
    @ApiModelProperty(value="t_system_user.id")
    private Integer userId;

    /*
    * t_system_ctrl.id
    */
    @ApiModelProperty(value="t_system_ctrl.id")
    private Integer ctrlId;

    /*
    * t_system_method.id
    */
    @ApiModelProperty(value="t_system_method.id")
    private Integer methodId;

    /*
    * 过滤的字段，多字段以,隔开
    */
    @ApiModelProperty(value="过滤的字段，多字段以,隔开")
    private String filterFields;

    public static final String ID_ASC = "id ASC";

    public static final String ID_DESC = "id DESC";

    public static final String USER_ID_ASC = "user_id ASC";

    public static final String USER_ID_DESC = "user_id DESC";

    public static final String CTRL_ID_ASC = "ctrl_id ASC";

    public static final String CTRL_ID_DESC = "ctrl_id DESC";

    public static final String METHOD_ID_ASC = "method_id ASC";

    public static final String METHOD_ID_DESC = "method_id DESC";

    public static final String FILTER_FIELDS_ASC = "filter_fields ASC";

    public static final String FILTER_FIELDS_DESC = "filter_fields DESC";

    public Integer getId() {
        return id;
    }

    /**
     * @param id 自增Id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId t_system_user.id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public Integer getMethodId() {
        return methodId;
    }

    /**
     * @param methodId t_system_method.id
     */
    public void setMethodId(Integer methodId) {
        this.methodId = methodId;
    }

    public String getFilterFields() {
        return filterFields;
    }

    /**
     * @param filterFields 过滤的字段，多字段以,隔开
     */
    public void setFilterFields(String filterFields) {
        this.filterFields = filterFields == null ? null : filterFields.trim();
    }
}