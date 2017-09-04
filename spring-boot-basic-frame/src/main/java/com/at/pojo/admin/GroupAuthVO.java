package com.at.pojo.admin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2017/6/12.
 * 权限组权限数据对象
 */
public class GroupAuthVO {

    List<Integer> ctrlIds;
    List<Integer> methodIds;

    public GroupAuthVO(){

    }

    public void setCtrlIds(List<Integer> ctrlIds) {
        this.ctrlIds = ctrlIds;
    }

    public void setMethodIds(List<Integer> methodIds) {
        this.methodIds = methodIds;
    }

    public List<Integer> getCtrlIds() {
        return ctrlIds;
    }

    public List<Integer> getMethodIds() {
        return methodIds;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
