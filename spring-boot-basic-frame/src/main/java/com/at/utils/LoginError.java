package com.at.utils;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by Administrator on 2017/5/22.
 */
public class LoginError {
    private static final ConcurrentHashMap<String,LoginError> LOGIN_ERR = new ConcurrentHashMap<>();
    private static final Set<String> DENIAL_LOGIN = new HashSet<>(5);
    private static final AtomicBoolean LOCK = new AtomicBoolean(false);

    private int num;
    private long lastTime;

    private LoginError(){

    }

    public static boolean denial(String loginName){
        return DENIAL_LOGIN.contains(loginName);
    }

    public static int statics(String loginName){
        if(loginName == null || loginName.length() == 0) return 0;
        while(LOCK.compareAndSet(false,true)){
            LoginError error = LOGIN_ERR.get(loginName);
            if(error == null){
                error = new LoginError();
                error.lastTime = System.currentTimeMillis();
                LOGIN_ERR.put(loginName,error);
            }
            error.num = error.num + 1;
            if(error.num == 10){//这边设置==10时放置
                //避免上级使用时，如果逻辑不完善导致的hash碰撞
                DENIAL_LOGIN.add(loginName);
            }
            LOCK.set(false);
            return error.num;
        }
        return 0;
    }

}
