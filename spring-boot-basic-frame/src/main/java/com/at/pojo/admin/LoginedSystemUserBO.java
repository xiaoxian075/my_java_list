package com.at.pojo.admin;

import com.at.entity.TSystemUser;

import java.util.List;

/**
 * Created by Administrator on 2017/6/14.
 * 登录用户的信息
 */
public class LoginedSystemUserBO {


    private int userId;

    private TSystemUser user;

    private List<UserAuthVO> userAuthVO;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public TSystemUser getUser() {
        return user;
    }

    public void setUser(TSystemUser user) {
        this.user = user;
    }

    public List<UserAuthVO> getUserAuthVO() {
        return userAuthVO;
    }

    public void setUserAuthVO(List<UserAuthVO> userAuthVO) {
        this.userAuthVO = userAuthVO;
    }
}
