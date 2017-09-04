package com.at.entity.mapper;

import com.at.entity.TSystemCtrl;
import com.at.entity.TSystemCtrlCriteria;
import com.at.entity.custom.TSystemCtrlMapperCustom;
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

public interface TSystemCtrlMapper extends TSystemCtrlMapperCustom {
    @SelectProvider(type=TSystemCtrlSqlProvider.class, method="countByExample")
    long countByExample(TSystemCtrlCriteria example);

    @DeleteProvider(type=TSystemCtrlSqlProvider.class, method="deleteByExample")
    int deleteByExample(TSystemCtrlCriteria example);

    @Delete({
        "delete from t_system_ctrl",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into t_system_ctrl (id, ctrl_name, ",
        "ctrl_desc, ctrl_version, ",
        "ctrl_url, parent_id, ",
        "last_update_time)",
        "values (#{id,jdbcType=INTEGER}, #{ctrlName,jdbcType=VARCHAR}, ",
        "#{ctrlDesc,jdbcType=VARCHAR}, #{ctrlVersion,jdbcType=INTEGER}, ",
        "#{ctrlUrl,jdbcType=VARCHAR}, #{parentId,jdbcType=INTEGER}, ",
        "#{lastUpdateTime,jdbcType=TIMESTAMP})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(TSystemCtrl record);

    @InsertProvider(type=TSystemCtrlSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertSelective(TSystemCtrl record);

    @SelectProvider(type=TSystemCtrlSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="ctrl_name", property="ctrlName", jdbcType=JdbcType.VARCHAR),
        @Result(column="ctrl_desc", property="ctrlDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="ctrl_version", property="ctrlVersion", jdbcType=JdbcType.INTEGER),
        @Result(column="ctrl_url", property="ctrlUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.INTEGER),
        @Result(column="last_update_time", property="lastUpdateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<TSystemCtrl> selectByExample(TSystemCtrlCriteria example);

    @Select({
        "select",
        "id, ctrl_name, ctrl_desc, ctrl_version, ctrl_url, parent_id, last_update_time",
        "from t_system_ctrl",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="ctrl_name", property="ctrlName", jdbcType=JdbcType.VARCHAR),
        @Result(column="ctrl_desc", property="ctrlDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="ctrl_version", property="ctrlVersion", jdbcType=JdbcType.INTEGER),
        @Result(column="ctrl_url", property="ctrlUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.INTEGER),
        @Result(column="last_update_time", property="lastUpdateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    TSystemCtrl selectByPrimaryKey(Integer id);

    @UpdateProvider(type=TSystemCtrlSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TSystemCtrl record, @Param("example") TSystemCtrlCriteria example);

    @UpdateProvider(type=TSystemCtrlSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TSystemCtrl record, @Param("example") TSystemCtrlCriteria example);

    @UpdateProvider(type=TSystemCtrlSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TSystemCtrl record);

    @Update({
        "update t_system_ctrl",
        "set ctrl_name = #{ctrlName,jdbcType=VARCHAR},",
          "ctrl_desc = #{ctrlDesc,jdbcType=VARCHAR},",
          "ctrl_version = #{ctrlVersion,jdbcType=INTEGER},",
          "ctrl_url = #{ctrlUrl,jdbcType=VARCHAR},",
          "parent_id = #{parentId,jdbcType=INTEGER},",
          "last_update_time = #{lastUpdateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TSystemCtrl record);

    @SelectProvider(type=com.at.entity.mapper.TSystemCtrlSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="ctrl_name", property="ctrlName", jdbcType=JdbcType.VARCHAR),
        @Result(column="ctrl_desc", property="ctrlDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="ctrl_version", property="ctrlVersion", jdbcType=JdbcType.INTEGER),
        @Result(column="ctrl_url", property="ctrlUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.INTEGER),
        @Result(column="last_update_time", property="lastUpdateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    TSystemCtrl getByExample(TSystemCtrlCriteria example);

    @Select({
    "select * from",
    "t_system_ctrl"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="ctrl_name", property="ctrlName", jdbcType=JdbcType.VARCHAR),
        @Result(column="ctrl_desc", property="ctrlDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="ctrl_version", property="ctrlVersion", jdbcType=JdbcType.INTEGER),
        @Result(column="ctrl_url", property="ctrlUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.INTEGER),
        @Result(column="last_update_time", property="lastUpdateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<TSystemCtrl> selectAll();
}