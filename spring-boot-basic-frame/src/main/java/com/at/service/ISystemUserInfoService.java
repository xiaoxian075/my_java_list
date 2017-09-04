package com.at.service;

import com.at.entity.TSystemGroup;
import com.at.entity.TSystemUser;
import com.at.frame.utils.Result;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 2017/6/6.
 */
public interface ISystemUserInfoService {
    /**
     * 查找用户列表
     * @param loginName
     * @return
     */
    Result<List<TSystemUser>> listUsers(String loginName,Integer groupId);
}
