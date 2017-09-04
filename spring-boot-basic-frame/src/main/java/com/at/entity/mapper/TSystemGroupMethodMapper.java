package com.at.entity.mapper;

import com.at.entity.TSystemGroupMethod;
import com.at.entity.TSystemGroupMethodCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface TSystemGroupMethodMapper {
    @SelectProvider(type=TSystemGroupMethodSqlProvider.class, method="countByExample")
    long countByExample(TSystemGroupMethodCriteria example);

    @DeleteProvider(type=TSystemGroupMethodSqlProvider.class, method="deleteByExample")
    int deleteByExample(TSystemGroupMethodCriteria example);

    @Delete({
        "delete from t_system_group_method",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into t_system_group_method (id, group_id, ",
        "ctrl_id, method_id)",
        "values (#{id,jdbcType=INTEGER}, #{groupId,jdbcType=INTEGER}, ",
        "#{ctrlId,jdbcType=INTEGER}, #{methodId,jdbcType=INTEGER})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(TSystemGroupMethod record);

    @InsertProvider(type=TSystemGroupMethodSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertSelective(TSystemGroupMethod record);

    @SelectProvider(type=TSystemGroupMethodSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="group_id", property="groupId", jdbcType=JdbcType.INTEGER),
        @Result(column="ctrl_id", property="ctrlId", jdbcType=JdbcType.INTEGER),
        @Result(column="method_id", property="methodId", jdbcType=JdbcType.INTEGER)
    })
    List<TSystemGroupMethod> selectByExample(TSystemGroupMethodCriteria example);

    @Select({
        "select",
        "id, group_id, ctrl_id, method_id",
        "from t_system_group_method",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="group_id", property="groupId", jdbcType=JdbcType.INTEGER),
        @Result(column="ctrl_id", property="ctrlId", jdbcType=JdbcType.INTEGER),
        @Result(column="method_id", property="methodId", jdbcType=JdbcType.INTEGER)
    })
    TSystemGroupMethod selectByPrimaryKey(Integer id);

    @UpdateProvider(type=TSystemGroupMethodSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TSystemGroupMethod record, @Param("example") TSystemGroupMethodCriteria example);

    @UpdateProvider(type=TSystemGroupMethodSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TSystemGroupMethod record, @Param("example") TSystemGroupMethodCriteria example);

    @UpdateProvider(type=TSystemGroupMethodSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TSystemGroupMethod record);

    @Update({
        "update t_system_group_method",
        "set group_id = #{groupId,jdbcType=INTEGER},",
          "ctrl_id = #{ctrlId,jdbcType=INTEGER},",
          "method_id = #{methodId,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TSystemGroupMethod record);

    @SelectProvider(type=com.at.entity.mapper.TSystemGroupMethodSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="group_id", property="groupId", jdbcType=JdbcType.INTEGER),
        @Result(column="ctrl_id", property="ctrlId", jdbcType=JdbcType.INTEGER),
        @Result(column="method_id", property="methodId", jdbcType=JdbcType.INTEGER)
    })
    TSystemGroupMethod getByExample(TSystemGroupMethodCriteria example);

    @Select({
    "select * from",
    "t_system_group_method"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="group_id", property="groupId", jdbcType=JdbcType.INTEGER),
        @Result(column="ctrl_id", property="ctrlId", jdbcType=JdbcType.INTEGER),
        @Result(column="method_id", property="methodId", jdbcType=JdbcType.INTEGER)
    })
    List<TSystemGroupMethod> selectAll();
}