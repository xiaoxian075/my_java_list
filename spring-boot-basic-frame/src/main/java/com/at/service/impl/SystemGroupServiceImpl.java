package com.at.service.impl;

import com.alibaba.druid.support.http.util.IPAddress;
import com.at.config.AtConfig;
import com.at.config.Text;
import com.at.entity.*;
import com.at.entity.mapper.TSystemGroupCtrlMapper;
import com.at.entity.mapper.TSystemGroupMapper;
import com.at.entity.mapper.TSystemGroupMethodMapper;
import com.at.frame.utils.IPUtil;
import com.at.frame.utils.Result;
import com.at.frame.utils.StringUtils;
import com.at.frame.utils.VerifyUtil;
import com.at.pojo.admin.GroupAuthBO;
import com.at.pojo.admin.LoginedSystemUserBO;
import com.at.service.ISystemGroupInfoService;
import com.at.service.ISystemGroupOperationService;
import com.at.status.SystemGroupState;
import org.omg.SendingContext.RunTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.net.util.IPAddressUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/6/7.
 */
@Service
public class SystemGroupServiceImpl implements ISystemGroupInfoService,ISystemGroupOperationService{
    private static final Logger LOGGER = LoggerFactory.getLogger(SystemGroupServiceImpl.class);

    @Autowired
    private TSystemGroupMapper systemGroupMapper;
    @Autowired
    private TSystemGroupCtrlMapper systemGroupCtrlMapper;
    @Autowired
    private TSystemGroupMethodMapper systemGroupMethodMapper;

    @Override
    public Result<List<TSystemGroup>> listGroups() {
        List<TSystemGroup> groups = systemGroupMapper.selectFilterState(SystemGroupState.DELETED);
        return Result.suc(groups,Text.SUCCESS);
    }


    @Override
    @Transactional
    public Result<String> updateGroupAuth(GroupAuthBO groupAuth) {
        if(groupAuth == null){
            LOGGER.error("参数:groupAuth is null");
            return Result.fail(Text.PARAM_ERROR);
        }
        Integer groupId = groupAuth.getGroupId();
        int[] ctrlIds = groupAuth.getCtrlIds();
        int[] methodIds = groupAuth.getMethodIds();
        int[] methodCtrlIds = groupAuth.getMethodCtrlIds();
        if((methodIds == null && methodCtrlIds == null)
                || (methodIds.length != methodCtrlIds.length)){
            LOGGER.error("methodIds:{},methodCtrIds:{}",methodIds,methodCtrlIds);
            return Result.fail(Text.PARAM_ERROR);
        }
        if(groupId == null || groupId < 0){
            LOGGER.error("权限组不存在，id:{}",groupId);
            return Result.fail(Text.SYSTEM_GROUP_LOSE);
        }
        if(systemGroupMapper.countById(groupId) < 1){
            LOGGER.error("权限组不存在，id:{}",groupId);
            return Result.fail(Text.SYSTEM_GROUP_LOSE);
        }
        TSystemGroupCtrlCriteria tgcc = new TSystemGroupCtrlCriteria();
        TSystemGroupCtrlCriteria.Criteria criteria = tgcc.createCriteria();
        criteria.andGroupIdEqualTo(groupId);
        systemGroupCtrlMapper.deleteByExample(tgcc);

        TSystemGroupMethodCriteria tgmc = new TSystemGroupMethodCriteria();
        TSystemGroupMethodCriteria.Criteria methodCriteria = tgmc.createCriteria();
        methodCriteria.andGroupIdEqualTo(groupId);
        systemGroupMethodMapper.deleteByExample(tgmc);

        if(ctrlIds != null){
            for(int ctrlId : ctrlIds){
                TSystemGroupCtrl systemGroupCtrl = new TSystemGroupCtrl();
                systemGroupCtrl.setCtrlId(ctrlId);
                systemGroupCtrl.setGroupId(groupId);
                systemGroupCtrlMapper.insert(systemGroupCtrl);
            }
        }
        if(methodIds != null){
            for(int i = 0,l = methodIds.length; i < l; i++){
                int methodId = methodIds[i];
                int methodCtrlId = methodCtrlIds[i];
                TSystemGroupMethod systemGroupMethod = new TSystemGroupMethod();
                systemGroupMethod.setCtrlId(methodCtrlId);
                systemGroupMethod.setMethodId(methodId);
                systemGroupMethod.setGroupId(groupId);
                systemGroupMethodMapper.insert(systemGroupMethod);
            }
        }
        return Result.suc(Text.SUCCESS);
    }

    @Override
    public Result<String> disableGroup(int[] groupIds) {
        return this.updateGroupState(groupIds,SystemGroupState.DISABLE);
    }

    @Override
    public Result<String> enableGroup(int[] groupIds) {
        return this.updateGroupState(groupIds,SystemGroupState.NORMAL);
    }

    @Override
    public Result<String> deleteGroup(int[] groupIds) {
        return this.updateGroupState(groupIds,SystemGroupState.DELETED);
    }

    private Result<String> updateGroupState(int[] groupIds, byte state) {
        if(groupIds == null || state < 0){
            LOGGER.error("groupId:{},state:{}",groupIds,state);
            return Result.fail(Text.PARAM_ERROR);
        }
        for(int groupId : groupIds){
            if(groupId == -1){
                //-1的权限是不可变更的
                continue;
            }
            TSystemGroup group = systemGroupMapper.selectByPrimaryKey(groupId);
            if(group == null){
                LOGGER.error("权限组不存在，id:{}",groupId);
                continue;
            }
            if(group.getStatus() == SystemGroupState.DELETED){
                LOGGER.error("权限组已被删除，id:{}",groupId);
                continue;
            }
            group.setStatus(state);
            systemGroupMapper.updateByPrimaryKeySelective(group);
        }
        return Result.suc(Text.SUCCESS);
    }

    @Override
    public Result<String> add(HttpServletRequest request,String groupName) {
        if(VerifyUtil.isAnyEmpty(groupName) || VerifyUtil.isAnyLengthGreat(32,groupName)){
            LOGGER.error("参数错误groupName:{}",groupName);
            return Result.fail(Text.PARAM_ERROR);
        }
        LoginedSystemUserBO loginedUser = (LoginedSystemUserBO) request.getSession().getAttribute(AtConfig.ADMIN_SESSION);
        TSystemGroup group = new TSystemGroup();
        group.setGroupName(groupName);
        group.setStatus(SystemGroupState.NORMAL);
        group.setCreateIp(IPUtil.getLongIP(request));
        group.setCreator(loginedUser.getUserId());
        group.setCreateTime(new Date());
        systemGroupMapper.insert(group);
        return Result.suc(Text.SUCCESS);
    }

    @Override
    public Result<String> update(int groupId, String groupName) {
        if(groupId < 1){
            LOGGER.error("参数错误groupId:{}",groupId);
            return Result.fail(Text.PARAM_ERROR);
        }
        if(VerifyUtil.isAnyEmpty(groupName) || VerifyUtil.isAnyLengthGreat(32,groupName)){
            LOGGER.error("参数错误groupName:{}",groupName);
            return Result.fail(Text.PARAM_ERROR);
        }
        TSystemGroup group = systemGroupMapper.selectByPrimaryKey(groupId);
        if(group == null){
            LOGGER.error("权限组{}不存在",groupId);
            return Result.fail(Text.SYSTEM_GROUP_LOSE);
        }
        group.setGroupName(groupName);
        systemGroupMapper.updateByPrimaryKeySelective(group);
        return Result.suc(Text.SUCCESS);
    }
}
