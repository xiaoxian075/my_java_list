package com.at.entity.custom;

import com.at.entity.TSystemCtrl;
import com.at.entity.mapper.TSystemCtrlMapper;
import com.at.frame.annotation.MapperCustom;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Administrator on 2017/5/15.
 */
@MapperCustom(TSystemCtrlMapper.class)
public interface TSystemCtrlMapperCustom {
    @Select({
        "select a.* from t_system_ctrl a ",
        "right join t_system_group_ctrl g ",
        "on a.id = g.ctrl_id ",
        "where g.group_id = #{groupId}"
    })
    public List<TSystemCtrl> queryByGroupId(@Param("groupId") int groupId);
}
