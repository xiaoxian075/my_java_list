package com.mybatis.dao;

import com.mybatis.entity.GoodInfo;

public interface GoodInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GoodInfo record);

    int insertSelective(GoodInfo record);

    GoodInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodInfo record);

    int updateByPrimaryKey(GoodInfo record);
}