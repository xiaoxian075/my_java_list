package com.at.entity.mapper;

import com.at.entity.TSystemGroup;
import com.at.entity.TSystemGroupCriteria;
import com.at.entity.custom.TSystemGroupMapperCustom;
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

public interface TSystemGroupMapper extends TSystemGroupMapperCustom {
    @SelectProvider(type=TSystemGroupSqlProvider.class, method="countByExample")
    long countByExample(TSystemGroupCriteria example);

    @DeleteProvider(type=TSystemGroupSqlProvider.class, method="deleteByExample")
    int deleteByExample(TSystemGroupCriteria example);

    @Delete({
        "delete from t_system_group",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into t_system_group (id, group_name, ",
        "status, create_time, ",
        "create_ip, creator)",
        "values (#{id,jdbcType=INTEGER}, #{groupName,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=TINYINT}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{createIp,jdbcType=BIGINT}, #{creator,jdbcType=INTEGER})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(TSystemGroup record);

    @InsertProvider(type=TSystemGroupSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertSelective(TSystemGroup record);

    @SelectProvider(type=TSystemGroupSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="group_name", property="groupName", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_ip", property="createIp", jdbcType=JdbcType.BIGINT),
        @Result(column="creator", property="creator", jdbcType=JdbcType.INTEGER)
    })
    List<TSystemGroup> selectByExample(TSystemGroupCriteria example);

    @Select({
        "select",
        "id, group_name, status, create_time, create_ip, creator",
        "from t_system_group",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="group_name", property="groupName", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_ip", property="createIp", jdbcType=JdbcType.BIGINT),
        @Result(column="creator", property="creator", jdbcType=JdbcType.INTEGER)
    })
    TSystemGroup selectByPrimaryKey(Integer id);

    @UpdateProvider(type=TSystemGroupSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TSystemGroup record, @Param("example") TSystemGroupCriteria example);

    @UpdateProvider(type=TSystemGroupSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TSystemGroup record, @Param("example") TSystemGroupCriteria example);

    @UpdateProvider(type=TSystemGroupSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TSystemGroup record);

    @Update({
        "update t_system_group",
        "set group_name = #{groupName,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=TINYINT},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "create_ip = #{createIp,jdbcType=BIGINT},",
          "creator = #{creator,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TSystemGroup record);

    @SelectProvider(type=com.at.entity.mapper.TSystemGroupSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="group_name", property="groupName", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_ip", property="createIp", jdbcType=JdbcType.BIGINT),
        @Result(column="creator", property="creator", jdbcType=JdbcType.INTEGER)
    })
    TSystemGroup getByExample(TSystemGroupCriteria example);

    @Select({
    "select * from",
    "t_system_group"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="group_name", property="groupName", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_ip", property="createIp", jdbcType=JdbcType.BIGINT),
        @Result(column="creator", property="creator", jdbcType=JdbcType.INTEGER)
    })
    List<TSystemGroup> selectAll();
}