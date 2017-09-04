package com.at.entity.custom;

import com.at.entity.TSystemUser;
import com.at.entity.mapper.TSystemUserMapper;
import com.at.frame.annotation.MapperCustom;
import com.at.status.SystemUserState;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * Created by Administrator on 2017/6/6.
 */
@MapperCustom(TSystemUserMapper.class)
public interface TSystemUserMapperCustom {
    public static byte STATUS_NORMAL = 0;//正常用户
    public static byte STATUS_DEL = 1;//被删除的用户
    public static byte STATUS_UNABLE = 4;//被禁用的


    @SelectProvider(type=TSystemUserSqlProviderCustom.class, method="queryUsers")
    public List<TSystemUser> queryUsers(@Param("loginName") String loginName,
                                        @Param("groupId") Integer groupId);

    @Select({
            "SELECT COUNT(1)",
            "FROM t_system_user",
            "WHERE login_name = #{loginName} AND status <> ",
            SystemUserState.DELETED+""
    })
    public int countByLoginName(String loginName);
}
