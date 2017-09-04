package com.at.service.impl;

import com.at.config.AtConfig;
import com.at.config.Text;
import com.at.entity.*;
import com.at.entity.mapper.TSystemCtrlMapper;
import com.at.entity.mapper.TSystemCtrlMethodMapper;
import com.at.entity.mapper.TSystemGroupMapper;
import com.at.entity.mapper.TSystemUserMapper;
import com.at.frame.utils.IPUtil;
import com.at.frame.utils.Result;
import com.at.frame.utils.SafetyUtil;
import com.at.frame.utils.VerifyUtil;
import com.at.pojo.admin.LoginedSystemUserBO;
import com.at.pojo.admin.SystemUserBO;
import com.at.service.ISystemUserInfoService;
import com.at.service.ISystemUserOperationService;
import com.at.status.SystemGroupState;
import com.at.status.SystemUserState;
import com.at.utils.LoginError;
import com.at.pojo.admin.UserAuthVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by Administrator on 2017/4/20.
 */
@Service
public class SystemUserServiceImpl implements ISystemUserInfoService,ISystemUserOperationService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SystemUserServiceImpl.class);

    @Autowired
    private TSystemUserMapper systemUserMapper;
    @Autowired
    private TSystemCtrlMapper systemCtrlMapper;
    @Autowired
    private TSystemCtrlMethodMapper systemCtrlMethodMapper;
    @Autowired
    private TSystemGroupMapper systemGroupMapper;

    @Override
    public Result<List<TSystemUser>> listUsers(String loginName,Integer groupId) {
        List<TSystemUser> systemUsers = systemUserMapper.queryUsers(loginName,groupId);
        return Result.suc(systemUsers,Text.SUCCESS);
    }

    //-------------------operation-----------------
    @Override
    public Result<String> login(HttpServletRequest request, String loginName, String password) {
        if(VerifyUtil.isAnyLengthNotIn(4,32,loginName,password)){
            LOGGER.error("错误的参数：loginName:{},passowd:{}",loginName,password);
            return Result.fail(Text.PARAM_ERROR);
        }
        if(LoginError.denial(loginName)){//被拒绝登录
            LOGGER.error("用户[{}]密码错误过多导致无法登录");
            return Result.fail(Text.USER_DENIAL);
        }
        TSystemUserCriteria query = new TSystemUserCriteria();
        query.createCriteria().andLoginNameEqualTo(loginName);
        TSystemUser su = systemUserMapper.getByExample(query);
        String secuityPwd = SafetyUtil.getAbnormalMd5(password);
        if(su == null || !su.getPassword().equals(secuityPwd)){
            LOGGER.error("用户[{}]尝试登录，但是密码不正确，次数：[{}]",loginName,LoginError.statics(loginName));
            return Result.fail(Text.USER_LOGIN_ERROR);
        }
        int groupId = su.getGroupId();
        List<TSystemCtrl> ctrls;
        List<TSystemCtrlMethod> methods;
        if(groupId < 0){//拥有超特殊权限，即无组，但拥有所有功能权限
            ctrls = systemCtrlMapper.selectByExample(null);
            methods = systemCtrlMethodMapper.selectByExample(null);
        }else{
            //判断权限组状态
            TSystemGroup group = systemGroupMapper.selectByPrimaryKey(groupId);
            if(group == null || group.getStatus() != SystemGroupState.NORMAL){
                LOGGER.error("用户[{}],尝试登录，但是权限组状态[{}]",loginName,group==null?-1:group.getStatus());
                return Result.fail(Text.USER_GROUP_PERMISSION_DENIED);
            }
            ctrls = systemCtrlMapper.queryByGroupId(groupId);
            if(ctrls == null || ctrls.size() < 1){
                return Result.fail(Text.USER_PERMISSION_DENIED);
            }
            methods = systemCtrlMethodMapper.queryByGroupId(groupId);
        }
        LoginedSystemUserBO loginedUser = new LoginedSystemUserBO();
        loginedUser.setUserId(su.getId());
        loginedUser.setUser(su);

        int methodLen;
        List<UserAuthVO> auths;
        if(methods != null && (methodLen = methods.size()) > 0){
            TSystemCtrl ctrl;
            TSystemCtrlMethod method;
            int ctrlId,ctrlLen;
            auths = new ArrayList<>((ctrlLen = ctrls.size()));
            for(int i = 0; i < ctrlLen; i++){
                ctrl = ctrls.get(i);
                ctrlId = ctrl.getId();//对应的控制器的Id,不是表主键Id
                UserAuthVO ua = UserAuthVO.addCtrl(ctrl);
                for(int j = 0; j < methodLen; j++){
                    method = methods.get(j);
                    if(method.getCtrlId() == ctrlId){
                        ua.addMethod(method);
                    }
                }
                auths.add(ua);
                methods.removeAll(ua.getMethods());
                methodLen = methods.size();
            }
            loginedUser.setUserAuthVO(auths);
        }
        request.getSession().setAttribute(AtConfig.ADMIN_SESSION,loginedUser);
        return Result.suc(Text.EMPTY,Text.LOGIN_SUCCESS);
    }

    @Override
    public Result<String> add(HttpServletRequest request, SystemUserBO systemUserBO) {
        String loginName = systemUserBO.getLoginName();
        String password = systemUserBO.getPassword();
        int groupId = systemUserBO.getGroupId();
        String bindIp = systemUserBO.getBindIp();
        if(VerifyUtil.isAnyLengthNotIn(4,32,loginName,password)){
            LOGGER.error("错误的参数：loginName:{},passowd:{}",loginName,password);
            return Result.fail(Text.PARAM_ERROR);
        }
        if(groupId <= 0){
            LOGGER.error("错误的参数，groupId:{}",groupId);
            return Result.fail(Text.PARAM_ERROR);
        }
        //这里不验证权限组是否存在，因为如果不存在，也不会影响到逻辑
        if(systemUserMapper.countByLoginName(loginName) > 0){
            return Result.fail(Text.USER_EXIST);
        }
        LoginedSystemUserBO loginedUser = (LoginedSystemUserBO) request.getSession().getAttribute(AtConfig.ADMIN_SESSION);
        TSystemUser systemUser = new TSystemUser();
        systemUser.setCreateIp(IPUtil.getLongIP(request));
        systemUser.setCreator(loginedUser.getUserId());
        systemUser.setCreateTime(new Date());
        systemUser.setLoginName(loginName);
        systemUser.setGroupId(groupId);
        systemUser.setPassword(SafetyUtil.getAbnormalMd5(password));
        systemUser.setBindIp(IPUtil.parseLong(bindIp));
        systemUser.setStatus(SystemUserState.NORMAL);
        systemUserMapper.insert(systemUser);
        return Result.suc(Text.SUCCESS);
    }
}
