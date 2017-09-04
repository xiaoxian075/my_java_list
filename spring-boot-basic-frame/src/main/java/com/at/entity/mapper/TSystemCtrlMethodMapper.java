package com.at.entity.mapper;

import com.at.entity.TSystemCtrlMethod;
import com.at.entity.TSystemCtrlMethodCriteria;
import com.at.entity.custom.TSystemCtrlMethodMapperCustom;
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

public interface TSystemCtrlMethodMapper extends TSystemCtrlMethodMapperCustom {
    @SelectProvider(type=TSystemCtrlMethodSqlProvider.class, method="countByExample")
    long countByExample(TSystemCtrlMethodCriteria example);

    @DeleteProvider(type=TSystemCtrlMethodSqlProvider.class, method="deleteByExample")
    int deleteByExample(TSystemCtrlMethodCriteria example);

    @Delete({
        "delete from t_system_ctrl_method",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into t_system_ctrl_method (id, method_id, ",
        "ctrl_id, method_name, ",
        "method_desc, method_version, ",
        "last_update_time)",
        "values (#{id,jdbcType=INTEGER}, #{methodId,jdbcType=INTEGER}, ",
        "#{ctrlId,jdbcType=INTEGER}, #{methodName,jdbcType=VARCHAR}, ",
        "#{methodDesc,jdbcType=VARCHAR}, #{methodVersion,jdbcType=INTEGER}, ",
        "#{lastUpdateTime,jdbcType=TIMESTAMP})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(TSystemCtrlMethod record);

    @InsertProvider(type=TSystemCtrlMethodSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertSelective(TSystemCtrlMethod record);

    @SelectProvider(type=TSystemCtrlMethodSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="method_id", property="methodId", jdbcType=JdbcType.INTEGER),
        @Result(column="ctrl_id", property="ctrlId", jdbcType=JdbcType.INTEGER),
        @Result(column="method_name", property="methodName", jdbcType=JdbcType.VARCHAR),
        @Result(column="method_desc", property="methodDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="method_version", property="methodVersion", jdbcType=JdbcType.INTEGER),
        @Result(column="last_update_time", property="lastUpdateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<TSystemCtrlMethod> selectByExample(TSystemCtrlMethodCriteria example);

    @Select({
        "select",
        "id, method_id, ctrl_id, method_name, method_desc, method_version, last_update_time",
        "from t_system_ctrl_method",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="method_id", property="methodId", jdbcType=JdbcType.INTEGER),
        @Result(column="ctrl_id", property="ctrlId", jdbcType=JdbcType.INTEGER),
        @Result(column="method_name", property="methodName", jdbcType=JdbcType.VARCHAR),
        @Result(column="method_desc", property="methodDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="method_version", property="methodVersion", jdbcType=JdbcType.INTEGER),
        @Result(column="last_update_time", property="lastUpdateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    TSystemCtrlMethod selectByPrimaryKey(Integer id);

    @UpdateProvider(type=TSystemCtrlMethodSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TSystemCtrlMethod record, @Param("example") TSystemCtrlMethodCriteria example);

    @UpdateProvider(type=TSystemCtrlMethodSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TSystemCtrlMethod record, @Param("example") TSystemCtrlMethodCriteria example);

    @UpdateProvider(type=TSystemCtrlMethodSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TSystemCtrlMethod record);

    @Update({
        "update t_system_ctrl_method",
        "set method_id = #{methodId,jdbcType=INTEGER},",
          "ctrl_id = #{ctrlId,jdbcType=INTEGER},",
          "method_name = #{methodName,jdbcType=VARCHAR},",
          "method_desc = #{methodDesc,jdbcType=VARCHAR},",
          "method_version = #{methodVersion,jdbcType=INTEGER},",
          "last_update_time = #{lastUpdateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TSystemCtrlMethod record);

    @SelectProvider(type=com.at.entity.mapper.TSystemCtrlMethodSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="method_id", property="methodId", jdbcType=JdbcType.INTEGER),
        @Result(column="ctrl_id", property="ctrlId", jdbcType=JdbcType.INTEGER),
        @Result(column="method_name", property="methodName", jdbcType=JdbcType.VARCHAR),
        @Result(column="method_desc", property="methodDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="method_version", property="methodVersion", jdbcType=JdbcType.INTEGER),
        @Result(column="last_update_time", property="lastUpdateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    TSystemCtrlMethod getByExample(TSystemCtrlMethodCriteria example);

    @Select({
    "select * from",
    "t_system_ctrl_method"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="method_id", property="methodId", jdbcType=JdbcType.INTEGER),
        @Result(column="ctrl_id", property="ctrlId", jdbcType=JdbcType.INTEGER),
        @Result(column="method_name", property="methodName", jdbcType=JdbcType.VARCHAR),
        @Result(column="method_desc", property="methodDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="method_version", property="methodVersion", jdbcType=JdbcType.INTEGER),
        @Result(column="last_update_time", property="lastUpdateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<TSystemCtrlMethod> selectAll();
}