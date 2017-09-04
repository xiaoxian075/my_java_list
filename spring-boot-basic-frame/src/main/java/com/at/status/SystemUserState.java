package com.at.status;

/**
 * Created by Administrator on 2017/6/13.
 */
public interface SystemUserState {
    //普通正常
    public static final byte NORMAL = 0;
    //已删除的
    public static final byte DELETED = 1;
    //被禁用的
    public static final byte DISABLE = 4;
}
