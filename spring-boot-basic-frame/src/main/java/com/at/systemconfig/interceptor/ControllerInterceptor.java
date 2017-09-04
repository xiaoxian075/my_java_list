package com.at.systemconfig.interceptor;

import com.at.config.AtConfig;
import com.at.config.Text;
import com.at.frame.ControllerHandler;
import com.at.frame.entity.ReqInfo;
import com.at.frame.utils.Result;
import com.at.pojo.admin.LoginedSystemUserBO;
import com.at.pojo.admin.UserAuthVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.helpers.BasicMarker;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Administrator on 2017/5/12.
 * 控制器请求拦截
 */
@Component
public class ControllerInterceptor extends ControllerHandler{

    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerInterceptor.class);

    @Override
    protected boolean before(ReqInfo reqInfo) {
        int ctrId = reqInfo.getCtrlId();
        int methodId = reqInfo.getMethodId();
        HttpServletRequest request = reqInfo.getRequest();
        HttpServletResponse response = reqInfo.getResponse();
        System.out.println("before请求：" + ctrId + "," + methodId);
        if(ctrId > 0 && ctrId < 100){
            return true;
        }
        System.out.println("url : " + request.getRequestURI());
        LoginedSystemUserBO loginedUser = (LoginedSystemUserBO) request.getSession().getAttribute(AtConfig.ADMIN_SESSION);
        if(loginedUser == null){
            Result.write(response,"noLogin");
            return false;
        }
        return true;
    }

    @Override
    protected boolean after(ReqInfo reqInfo) {
        return true;
    }

    @Override
    protected Object exception(Throwable e,ReqInfo reqInfo) {
        LOGGER.error(reqInfo.toString(),e);
        return Result.fail(Text.EXCEPTION,Result.EXCEPTION);
    }
}
