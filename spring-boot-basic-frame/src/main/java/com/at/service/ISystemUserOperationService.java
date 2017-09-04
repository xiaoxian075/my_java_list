package com.at.service;

import com.at.entity.TSystemUser;
import com.at.frame.utils.Result;
import com.at.pojo.admin.SystemUserBO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 2017/6/6.
 */
public interface ISystemUserOperationService {
    /**
     * 系统用户登录
     * @param loginName
     * @param password
     * @return
     */
    Result<String> login(HttpServletRequest request, String loginName, String password);

    /**
     * 添加系统用户
     * @param request
     * @param systemUserBO
     * @return
     */
    Result<String> add(HttpServletRequest request, SystemUserBO systemUserBO);
}
