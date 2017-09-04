package com.at.systemconfig.filter;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/4/24.
 */
@Component
public class RequestConfigFilter implements com.at.frame.requestassem.RequestConfigFilter {

    @Override
    public String accept(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("这里是自定义请求信息拦截器.....com.at.systemconfig.filter.RequestConfigFilter");
        System.out.println("本次请求req.html参数值为：g=" + req.getParameter("g"));
        System.out.println("用来处理当用户请求Url地址参数时的其他操作或拦截");
        return SUCCESS;
    }

    @Override
    public Map<String, String> addReq() {
//        Map<String,String> reqs = new HashMap<>();
//        reqs.put("adminTree","admin/common/tree");
        return null;
    }
}
