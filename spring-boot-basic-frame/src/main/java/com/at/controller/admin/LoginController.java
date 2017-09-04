package com.at.controller.admin;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.at.config.AtConfig;
import com.at.config.CtrId;
import com.at.config.Text;
import com.at.frame.annotation.*;
import com.at.frame.utils.Result;
import com.at.frame.utils.VerifyUtil;
import com.at.service.ISystemUserOperationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/4/19.
 */
@AutoCtrl(
        id = CtrId.ADMIN_LOGIN,//控制器Id
        name = "admin",//该配置只暴露给admin组查看
        prefix = "adminLogin",//控制器的方法生成时的方法名称前缀
        desc = "后台管理系统登录",//控制器描述
        api2Db = false,//该控制器的信息不保存到数据库
        version = 3//控制器的版本号信息
)
public class LoginController {

    @Autowired
    private ISystemUserOperationService systemUserOperationService;

    @AutoMethod(
        id = 1, name = "login", desc = "系统登录",
        implicitParams = {
                @ApiImplicitParam(name = "loginName",value = "登录名 长度：4-32位"),
                @ApiImplicitParam(name = "password", value = "密码 长度：4-32位")
        }
    )
    Result<String> login(HttpServletRequest request,String loginName, String password){
        return systemUserOperationService.login(request,loginName,password);
    }

    @AutoMethod(id = 2, name = "logout", desc = "退出系统登录")
    Result logout(HttpServletRequest request){
        request.getSession().removeAttribute(AtConfig.ADMIN_SESSION);
        return Result.suc(Text.EMPTY);
    }

    @AutoMethod(id=3,name="test",desc="联动测试")
    JSONArray test(Integer id){
        JSONArray array = new JSONArray();
        StringBuilder builder = new StringBuilder();
        for(int i=0;i<100;){
            JSONObject obj = new JSONObject();
            obj.put("id",++i);
            builder.append(i).append("_").append(id == null ? "0" : id);
            obj.put("text",builder.toString());
            builder.setLength(0);
            array.add(obj);
        }
        return array;
    }
}
