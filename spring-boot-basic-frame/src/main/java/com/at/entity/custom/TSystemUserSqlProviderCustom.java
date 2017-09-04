package com.at.entity.custom;

import com.at.entity.TSystemGroupMethodCriteria;
import com.at.entity.mapper.TSystemUserSqlProvider;
import com.at.frame.annotation.MapperCustom;
import com.at.status.SystemUserState;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;
import java.util.Objects;

/**
 * Created by Administrator on 2017/6/6.
 */
public class TSystemUserSqlProviderCustom {

    public String queryUsers(Map<String,Object> params) {
        SQL sql = new SQL();
        sql.SELECT("u.id,u.login_name,u.password,u.status,u.group_id,u.bind_ip,u.create_time,u.create_ip,u.creator,g.group_name");
        sql.FROM("t_system_user u");
        sql.LEFT_OUTER_JOIN("t_system_group g ON u.group_id = g.id");
        StringBuilder where = new StringBuilder();
        where.append("u.status <> ").append(TSystemUserMapperCustom.STATUS_DEL);
        String loginName = (String)params.get("loginName");
        if(loginName != null && loginName.length() > 0){
            where.append(" AND u.login_name like \"%\"#{loginName}\"%\"");
        }
        Integer groupId = (Integer)params.get("groupId");
        if(groupId != null && groupId.intValue() != 0){
            where.append(" AND u.group_id = #{groupId}");
        }else{
            where.append(" AND u.group_id > 0");
        }
        where.append(" AND u.status <> ").append(SystemUserState.DELETED);
        sql.WHERE(where.toString());
        return sql.toString();
    }
}
