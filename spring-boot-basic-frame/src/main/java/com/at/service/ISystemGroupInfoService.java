package com.at.service;

import com.at.entity.TSystemGroup;
import com.at.frame.utils.Result;

import java.util.List;

/**
 * Created by Administrator on 2017/6/7.
 */
public interface ISystemGroupInfoService {
    /**
     * 权限组列表
     */
    Result<List<TSystemGroup>> listGroups();
}
