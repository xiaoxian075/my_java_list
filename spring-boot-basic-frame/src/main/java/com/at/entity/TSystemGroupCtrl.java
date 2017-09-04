package com.at.entity;

import io.swagger.annotations.ApiModelProperty;

public class TSystemGroupCtrl {
    private Integer id;

    /*
    * t_system_group.id
    */
    @ApiModelProperty(value="t_system_group.id")
    private Integer groupId;

    /*
    * t_system_ctrl.id
    */
    @ApiModelProperty(value="t_system_ctrl.id")
    private Integer ctrlId;

    public static final String ID_ASC = "id ASC";

    public static final String ID_DESC = "id DESC";

    public static final String GROUP_ID_ASC = "group_id ASC";

    public static final String GROUP_ID_DESC = "group_id DESC";

    public static final String CTRL_ID_ASC = "ctrl_id ASC";

    public static final String CTRL_ID_DESC = "ctrl_id DESC";

    public Integer getId() {
        return id;
    }

    /**
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGroupId() {
        return groupId;
    }

    /**
     * @param groupId t_system_group.id
     */
    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
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
}