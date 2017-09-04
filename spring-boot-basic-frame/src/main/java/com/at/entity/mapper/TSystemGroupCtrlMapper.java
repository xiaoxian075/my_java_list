package com.at.entity.mapper;

import com.at.entity.TSystemGroupCtrl;
import com.at.entity.TSystemGroupCtrlCriteria;
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

public interface TSystemGroupCtrlMapper {
    @SelectProvider(type=TSystemGroupCtrlSqlProvider.class, method="countByExample")
    long countByExample(TSystemGroupCtrlCriteria example);

    @DeleteProvider(type=TSystemGroupCtrlSqlProvider.class, method="deleteByExample")
    int deleteByExample(TSystemGroupCtrlCriteria example);

    @Delete({
        "delete from t_system_group_ctrl",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into t_system_group_ctrl (id, group_id, ",
        "ctrl_id)",
        "values (#{id,jdbcType=INTEGER}, #{groupId,jdbcType=INTEGER}, ",
        "#{ctrlId,jdbcType=INTEGER})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(TSystemGroupCtrl record);

    @InsertProvider(type=TSystemGroupCtrlSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertSelective(TSystemGroupCtrl record);

    @SelectProvider(type=TSystemGroupCtrlSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="group_id", property="groupId", jdbcType=JdbcType.INTEGER),
        @Result(column="ctrl_id", property="ctrlId", jdbcType=JdbcType.INTEGER)
    })
    List<TSystemGroupCtrl> selectByExample(TSystemGroupCtrlCriteria example);

    @Select({
        "select",
        "id, group_id, ctrl_id",
        "from t_system_group_ctrl",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="group_id", property="groupId", jdbcType=JdbcType.INTEGER),
        @Result(column="ctrl_id", property="ctrlId", jdbcType=JdbcType.INTEGER)
    })
    TSystemGroupCtrl selectByPrimaryKey(Integer id);

    @UpdateProvider(type=TSystemGroupCtrlSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TSystemGroupCtrl record, @Param("example") TSystemGroupCtrlCriteria example);

    @UpdateProvider(type=TSystemGroupCtrlSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TSystemGroupCtrl record, @Param("example") TSystemGroupCtrlCriteria example);

    @UpdateProvider(type=TSystemGroupCtrlSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TSystemGroupCtrl record);

    @Update({
        "update t_system_group_ctrl",
        "set group_id = #{groupId,jdbcType=INTEGER},",
          "ctrl_id = #{ctrlId,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TSystemGroupCtrl record);

    @SelectProvider(type=com.at.entity.mapper.TSystemGroupCtrlSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="group_id", property="groupId", jdbcType=JdbcType.INTEGER),
        @Result(column="ctrl_id", property="ctrlId", jdbcType=JdbcType.INTEGER)
    })
    TSystemGroupCtrl getByExample(TSystemGroupCtrlCriteria example);

    @Select({
    "select * from",
    "t_system_group_ctrl"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="group_id", property="groupId", jdbcType=JdbcType.INTEGER),
        @Result(column="ctrl_id", property="ctrlId", jdbcType=JdbcType.INTEGER)
    })
    List<TSystemGroupCtrl> selectAll();
}