package com.at.pojo.admin;

import com.at.entity.TSystemCtrl;
import com.at.entity.TSystemCtrlMethod;

import java.util.*;

/**
 * Created by Administrator on 2017/5/22.
 *
 * 系统登录用户的权限树数据
 */
public class UserAuthVO {

    private static final Map<Integer,UserAuthVO> AUTH = new HashMap<>();

    private String title;
    private int ctrlId;
    private int parentId;
    private String url;
    private TSystemCtrl ctrl;
    private List<TSystemCtrlMethod> methods = new ArrayList<>();
    private List<Integer> methodIds = new ArrayList<>();

    private UserAuthVO(){

    }

    public static UserAuthVO addCtrl(TSystemCtrl ctrl){
        UserAuthVO auth = new UserAuthVO();
        auth.ctrlId = ctrl.getId();
        auth.title = ctrl.getCtrlDesc();
        auth.parentId = ctrl.getParentId();
        auth.url = ctrl.getCtrlUrl();
        auth.ctrl = ctrl;
        AUTH.put(auth.ctrlId,auth);
        return auth;
    }

    public void addMethod(TSystemCtrlMethod method){
        methods.add(method);
        methodIds.add(method.getId());
    }

    public int getCtrlId() {
        return ctrlId;
    }

    public String getTitle() {
        return title;
    }

    public int getParentId() {
        return parentId;
    }

    public String getUrl() {
        return url;
    }

    public List<TSystemCtrlMethod> getMethods() {
        return methods;
    }

    public List<Integer> getMethodIds() {
        return methodIds;
    }

}
