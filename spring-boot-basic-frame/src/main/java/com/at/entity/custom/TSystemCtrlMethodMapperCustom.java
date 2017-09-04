package com.at.entity.custom;

import com.at.entity.TSystemCtrlMethod;
import com.at.entity.mapper.TSystemCtrlMethodMapper;
import com.at.frame.annotation.MapperCustom;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Administrator on 2017/5/15.
 */
@MapperCustom(TSystemCtrlMethodMapper.class)
public interface TSystemCtrlMethodMapperCustom {
    @Select({
        "select a.* from t_system_ctrl_method a ",
        "right join t_system_group_method gm ",
        "on a.id = gm.method_id ",
        "where gm.group_id = #{groupId}"
    })
    public List<TSystemCtrlMethod> queryByGroupId(@Param("groupId") int groupId);
}
