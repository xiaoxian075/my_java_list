package com.at.pojo.admin;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

/**
 * Created by Administrator on 2017/6/12.
 */
public class GroupAuthBO {
    @ApiModelProperty("权限组Id")
    private int groupId;
    @ApiModelProperty("即将分配的控制器Id列表")
    private int[] ctrlIds;
    @ApiModelProperty("即将分配的方法Id列表")
    private int[] methodIds;
    @ApiModelProperty("即将分配的方法Id对应的控制Id列表")
    private int[] methodCtrlIds;

    public void setMethodCtrlIds(int[] methodCtrlIds) {
        this.methodCtrlIds = methodCtrlIds;
    }

    public int[] getMethodCtrlIds() {
        return methodCtrlIds;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int[] getCtrlIds() {
        return ctrlIds;
    }

    public void setCtrlIds(int[] ctrlIds) {
        this.ctrlIds = ctrlIds;
    }

    public int[] getMethodIds() {
        return methodIds;
    }

    public void setMethodIds(int[] methodIds) {
        this.methodIds = methodIds;
    }
}
