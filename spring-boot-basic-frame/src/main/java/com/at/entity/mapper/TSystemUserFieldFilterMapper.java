package com.at.entity.mapper;

import com.at.entity.TSystemUserFieldFilter;
import com.at.entity.TSystemUserFieldFilterCriteria;
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

public interface TSystemUserFieldFilterMapper {
    @SelectProvider(type=TSystemUserFieldFilterSqlProvider.class, method="countByExample")
    long countByExample(TSystemUserFieldFilterCriteria example);

    @DeleteProvider(type=TSystemUserFieldFilterSqlProvider.class, method="deleteByExample")
    int deleteByExample(TSystemUserFieldFilterCriteria example);

    @Delete({
        "delete from t_system_user_field_filter",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into t_system_user_field_filter (id, user_id, ",
        "ctrl_id, method_id, ",
        "filter_fields)",
        "values (#{id,jdbcType=INTEGER}, #{userId,jdbcType=INTEGER}, ",
        "#{ctrlId,jdbcType=INTEGER}, #{methodId,jdbcType=INTEGER}, ",
        "#{filterFields,jdbcType=VARCHAR})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(TSystemUserFieldFilter record);

    @InsertProvider(type=TSystemUserFieldFilterSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertSelective(TSystemUserFieldFilter record);

    @SelectProvider(type=TSystemUserFieldFilterSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="ctrl_id", property="ctrlId", jdbcType=JdbcType.INTEGER),
        @Result(column="method_id", property="methodId", jdbcType=JdbcType.INTEGER),
        @Result(column="filter_fields", property="filterFields", jdbcType=JdbcType.VARCHAR)
    })
    List<TSystemUserFieldFilter> selectByExample(TSystemUserFieldFilterCriteria example);

    @Select({
        "select",
        "id, user_id, ctrl_id, method_id, filter_fields",
        "from t_system_user_field_filter",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="ctrl_id", property="ctrlId", jdbcType=JdbcType.INTEGER),
        @Result(column="method_id", property="methodId", jdbcType=JdbcType.INTEGER),
        @Result(column="filter_fields", property="filterFields", jdbcType=JdbcType.VARCHAR)
    })
    TSystemUserFieldFilter selectByPrimaryKey(Integer id);

    @UpdateProvider(type=TSystemUserFieldFilterSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TSystemUserFieldFilter record, @Param("example") TSystemUserFieldFilterCriteria example);

    @UpdateProvider(type=TSystemUserFieldFilterSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TSystemUserFieldFilter record, @Param("example") TSystemUserFieldFilterCriteria example);

    @UpdateProvider(type=TSystemUserFieldFilterSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TSystemUserFieldFilter record);

    @Update({
        "update t_system_user_field_filter",
        "set user_id = #{userId,jdbcType=INTEGER},",
          "ctrl_id = #{ctrlId,jdbcType=INTEGER},",
          "method_id = #{methodId,jdbcType=INTEGER},",
          "filter_fields = #{filterFields,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TSystemUserFieldFilter record);

    @SelectProvider(type=com.at.entity.mapper.TSystemUserFieldFilterSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="ctrl_id", property="ctrlId", jdbcType=JdbcType.INTEGER),
        @Result(column="method_id", property="methodId", jdbcType=JdbcType.INTEGER),
        @Result(column="filter_fields", property="filterFields", jdbcType=JdbcType.VARCHAR)
    })
    TSystemUserFieldFilter getByExample(TSystemUserFieldFilterCriteria example);

    @Select({
    "select * from",
    "t_system_user_field_filter"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="ctrl_id", property="ctrlId", jdbcType=JdbcType.INTEGER),
        @Result(column="method_id", property="methodId", jdbcType=JdbcType.INTEGER),
        @Result(column="filter_fields", property="filterFields", jdbcType=JdbcType.VARCHAR)
    })
    List<TSystemUserFieldFilter> selectAll();
}