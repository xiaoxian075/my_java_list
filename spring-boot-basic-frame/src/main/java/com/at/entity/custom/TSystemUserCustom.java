package com.at.entity.custom;

import com.at.entity.TSystemUser;
import com.at.frame.annotation.MapperCustom;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by Administrator on 2017/6/6.
 */
@MapperCustom(TSystemUser.class)
public class TSystemUserCustom {

    private String groupName;//扩展的，组别名

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
