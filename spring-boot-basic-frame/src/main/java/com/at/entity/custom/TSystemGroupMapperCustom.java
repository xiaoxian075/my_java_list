package com.at.entity.custom;

import com.at.entity.TSystemGroup;
import com.at.entity.mapper.TSystemGroupMapper;
import com.at.frame.annotation.MapperCustom;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Administrator on 2017/6/12.
 */
@MapperCustom(TSystemGroupMapper.class)
public interface TSystemGroupMapperCustom {

    @Select("SELECT COUNT(1) FROM t_system_group WHERE id = #{id}")
    int countById(int id);

    @Select("SELECT * FROM t_system_group WHERE status <> #{state} AND id > 0")
    List<TSystemGroup> selectFilterState(byte state);
}
