package com.at.systemconfig.filter;

import com.at.frame.entity.ReqInfo;
import com.at.frame.mybatis.QueryExecutorFilter;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;

/**
 * Created by Administrator on 2017/5/9.
 */
@Component
public class QueryFilter extends QueryExecutorFilter {
    @Override
    public HashSet<String> filterFields(ReqInfo reqInfo) {
        /**
         * 这里处理用户的字段权限逻辑
         * 当用户登录的将用户的权限写入到Session中
         * 然后，查询的时候，根据权限来判断用户请求
         * 或者根据request的参数，比如token来获取用户的权限信息
         * 然后根据权限返回要过滤的查询字段
         * 示例代码：
         *
         *   HttpSession session = request.getSession();
         *   T user = (T) session.getAttribute("admin_user");
         *   if(user != null){
         *   return user.getFilters(ctrId,methodId);
         *   }
         *   return null;
         */
        HashSet<String> filters = new HashSet<>();
        filters.add("paaaaaa");
        System.out.println("filters--------");
        return filters;
    }
}
