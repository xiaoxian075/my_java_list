package com.at.service;

import com.at.entity.TSystemGroup;
import com.at.frame.utils.Result;
import com.at.pojo.admin.GroupAuthBO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 2017/6/7.
 */
public interface ISystemGroupOperationService {
    /**
     * 更新权限组权限
     * @param groupAuth
     * @return
     */
    Result<String> updateGroupAuth(GroupAuthBO groupAuth);
    /**
     * 禁用权限组
     */
    Result<String> disableGroup(int[] groupIds);
    /**
     * 启用权限组
     */
    Result<String> enableGroup(int[] groupIds);
    /**
     * 删除权限组
     */
    Result<String> deleteGroup(int[] groupIds);

    /**
     * 添加权限组
     */
    Result<String> add(HttpServletRequest request, String groupName);

    /**
     * 修改权限组
     */
    Result<String> update(int groupId, String groupName);
}
