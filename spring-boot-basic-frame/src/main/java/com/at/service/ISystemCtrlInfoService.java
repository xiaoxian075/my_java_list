package com.at.service;

import com.at.frame.utils.Result;
import com.at.pojo.admin.GroupAuthVO;
import com.at.pojo.admin.TreeLeafVO;

import java.util.List;

/**
 * Created by Administrator on 2017/6/8.
 */
public interface ISystemCtrlInfoService {
    /**
     * 取得权限树数据
     */
    Result<List<TreeLeafVO>> authTree();

    /**
     * 取得权限组对应的权限数据
     * @param groupId
     */
    Result<GroupAuthVO> groupAuth(Integer groupId);
}
