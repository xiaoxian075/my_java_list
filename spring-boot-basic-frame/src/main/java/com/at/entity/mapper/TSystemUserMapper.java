package com.at.entity.mapper;

import com.at.entity.TSystemUser;
import com.at.entity.TSystemUserCriteria;
import com.at.entity.custom.TSystemUserMapperCustom;
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

public interface TSystemUserMapper extends TSystemUserMapperCustom {
    @SelectProvider(type=TSystemUserSqlProvider.class, method="countByExample")
    long countByExample(TSystemUserCriteria example);

    @DeleteProvider(type=TSystemUserSqlProvider.class, method="deleteByExample")
    int deleteByExample(TSystemUserCriteria example);

    @Delete({
        "delete from t_system_user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into t_system_user (id, login_name, ",
        "password, status, group_id, ",
        "bind_ip, create_time, ",
        "create_ip, creator)",
        "values (#{id,jdbcType=INTEGER}, #{loginName,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=CHAR}, #{status,jdbcType=TINYINT}, #{groupId,jdbcType=INTEGER}, ",
        "#{bindIp,jdbcType=BIGINT}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{createIp,jdbcType=BIGINT}, #{creator,jdbcType=INTEGER})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(TSystemUser record);

    @InsertProvider(type=TSystemUserSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertSelective(TSystemUser record);

    @SelectProvider(type=TSystemUserSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="login_name", property="loginName", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.CHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="group_id", property="groupId", jdbcType=JdbcType.INTEGER),
        @Result(column="bind_ip", property="bindIp", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_ip", property="createIp", jdbcType=JdbcType.BIGINT),
        @Result(column="creator", property="creator", jdbcType=JdbcType.INTEGER)
    })
    List<TSystemUser> selectByExample(TSystemUserCriteria example);

    @Select({
        "select",
        "id, login_name, password, status, group_id, bind_ip, create_time, create_ip, ",
        "creator",
        "from t_system_user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="login_name", property="loginName", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.CHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="group_id", property="groupId", jdbcType=JdbcType.INTEGER),
        @Result(column="bind_ip", property="bindIp", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_ip", property="createIp", jdbcType=JdbcType.BIGINT),
        @Result(column="creator", property="creator", jdbcType=JdbcType.INTEGER)
    })
    TSystemUser selectByPrimaryKey(Integer id);

    @UpdateProvider(type=TSystemUserSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TSystemUser record, @Param("example") TSystemUserCriteria example);

    @UpdateProvider(type=TSystemUserSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TSystemUser record, @Param("example") TSystemUserCriteria example);

    @UpdateProvider(type=TSystemUserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TSystemUser record);

    @Update({
        "update t_system_user",
        "set login_name = #{loginName,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=CHAR},",
          "status = #{status,jdbcType=TINYINT},",
          "group_id = #{groupId,jdbcType=INTEGER},",
          "bind_ip = #{bindIp,jdbcType=BIGINT},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "create_ip = #{createIp,jdbcType=BIGINT},",
          "creator = #{creator,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TSystemUser record);

    @SelectProvider(type=com.at.entity.mapper.TSystemUserSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="login_name", property="loginName", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.CHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="group_id", property="groupId", jdbcType=JdbcType.INTEGER),
        @Result(column="bind_ip", property="bindIp", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_ip", property="createIp", jdbcType=JdbcType.BIGINT),
        @Result(column="creator", property="creator", jdbcType=JdbcType.INTEGER)
    })
    TSystemUser getByExample(TSystemUserCriteria example);

    @Select({
    "select * from",
    "t_system_user"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="login_name", property="loginName", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.CHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="group_id", property="groupId", jdbcType=JdbcType.INTEGER),
        @Result(column="bind_ip", property="bindIp", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_ip", property="createIp", jdbcType=JdbcType.BIGINT),
        @Result(column="creator", property="creator", jdbcType=JdbcType.INTEGER)
    })
    List<TSystemUser> selectAll();
}