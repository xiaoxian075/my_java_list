package com.at.controller.admin;

import com.at.config.AtConfig;
import com.at.config.CtrId;
import com.at.config.Text;
import com.at.entity.TSystemGroup;
import com.at.entity.TSystemUser;
import com.at.frame.annotation.ApiImplicitParam;
import com.at.frame.annotation.AutoCtrl;
import com.at.frame.annotation.AutoMethod;
import com.at.frame.utils.Result;
import com.at.pojo.admin.*;
import com.at.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 系统用户权限控制器
 * Created by Administrator on 2017/5/26.
 */
@AutoCtrl(
        id = CtrId.SYSTEM_USER_AUTH,
        name = "admin",
        prefix = "adminSystemUserAuth",
        desc = "系统用户权限管理",
        parentId = CtrId.PARENT_SYSTEM_MAMAGER,
        url = "system/systemUserAuth.html",//配置前台跳转的地址
        version = 2
)
public class SystemUserAuthController {

    @Autowired
    private ISystemUserInfoService systemUserInfoService;
    @Autowired
    private ISystemUserOperationService systemUserOperationService;
    @Autowired
    private ISystemGroupInfoService systemGroupInfoService;
    @Autowired
    private ISystemCtrlInfoService systemCtrlInfoService;
    @Autowired
    private ISystemGroupOperationService systemGroupOperationService;


    @AutoMethod(
            id = 1,
            name = "users",
            desc = "系统用户列表",
            method = RequestMethod.POST,
            implicitParams = {
                    @ApiImplicitParam(name = "loginName", value = "系统用户名称,最大长度32", required = false),
                    @ApiImplicitParam(name = "groupId", value = "系统权限组Id", required = false)
            }
    )
    Result<List<TSystemUser>> listUsers(String loginName, Integer groupId) {
        return systemUserInfoService.listUsers(loginName, groupId);
    }

    @AutoMethod(
            id = 2,
            name = "groups",
            desc = "系统权限组列表",
            method = RequestMethod.POST
    )
    Result<List<TSystemGroup>> listGroups() {
        return systemGroupInfoService.listGroups();
    }

    @AutoMethod(
            id = 3,
            name = "tree",
            desc = "系统权限树数据",
            method = RequestMethod.GET
    )
    Result<List<TreeLeafVO>> listAuth() {
        return systemCtrlInfoService.authTree();
    }

    @AutoMethod(
            id = 4,
            name = "groupAuth",
            desc = "权限组权限数据",
            method = RequestMethod.POST
    )
    Result<GroupAuthVO> listGroupAuth(Integer groupId) {
        return systemCtrlInfoService.groupAuth(groupId);
    }

    @AutoMethod(
            id = 5,
            name = "userAuthTree",
            desc = "当前系统的系统用户权限树",
            method = RequestMethod.GET
    )
    Result<List<UserAuthVO>> getUserAuthTree(HttpServletRequest request) {
        LoginedSystemUserBO userAuth = (LoginedSystemUserBO) request.getSession().getAttribute(AtConfig.ADMIN_SESSION);
        return Result.suc(userAuth.getUserAuthVO(), Text.SUCCESS);
    }

    @AutoMethod(
            id = 6,
            name = "deleteGroup",
            desc = "删除权限组",
            method = RequestMethod.POST,
            implicitParams = {
                    @ApiImplicitParam(name = "groupIds", value = "系统权限组Id数组"),
            }
    )
    Result<String> deleteGroup(int[] groupIds) {
        return systemGroupOperationService.deleteGroup(groupIds);
    }

    @AutoMethod(
            id = 7,
            name = "disableGroup",
            desc = "禁用权限组",
            method = RequestMethod.POST,
            implicitParams = {
                    @ApiImplicitParam(name = "groupIds", value = "系统权限组Id数组"),
            }
    )
    Result<String> disableGroup(int[] groupIds) {
        return systemGroupOperationService.disableGroup(groupIds);
    }

    @AutoMethod(
            id = 8,
            name = "enableGroup",
            desc = "启用权限组",
            method = RequestMethod.POST,
            implicitParams = {
                    @ApiImplicitParam(name = "groupIds", value = "系统权限组Id数组"),
            }
    )
    Result<String> enableGroup(int[] groupIds) {
        return systemGroupOperationService.enableGroup(groupIds);
    }

    @AutoMethod(
            id = 9,
            name = "addGroup",
            method = RequestMethod.POST,
            desc = "新增权限组",
            implicitParams = {
                    @ApiImplicitParam(name = "groupName", value = "系统权限组名称，长度1-32"),
            }
    )
    Result<String> addGroup(HttpServletRequest request, String groupName) {
        return systemGroupOperationService.add(request, groupName);
    }

    @AutoMethod(
            id = 10,
            name = "updateGroup",
            method = RequestMethod.POST,
            desc = "修改权限组",
            implicitParams = {
                    @ApiImplicitParam(name = "id", value = "系统权限组ID"),
                    @ApiImplicitParam(name = "groupName", value = "系统权限组名称，长度1-32"),
            }
    )
    Result<String> updateGroup(HttpServletRequest request, int id, String groupName) {
        return systemGroupOperationService.update(id, groupName);
    }

    @AutoMethod(
            id = 11,
            name = "addUser",
            method = RequestMethod.POST,
            desc = "添加权限组用户"
    )
    Result<String> addUser(HttpServletRequest request,SystemUserBO systemUserBO){
        return systemUserOperationService.add(request,systemUserBO);
    }

    @AutoMethod(
            id = 20,
            name = "updateGroupAuth",
            method = RequestMethod.POST,
            desc = "修改权限组权限"
    )
    Result<String> updateGroupAuth(GroupAuthBO groupAuth) {
        return systemGroupOperationService.updateGroupAuth(groupAuth);
    }
}
