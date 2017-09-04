package com.at.config;

/**
 * ID规则：
 *      非写入数据库的控制器的Id为100以下
 *      父级Id为100-299之内 例：100
 *      子级Id为父级Id+xxx 例： 100001
 *      APP父级Id为300-999之内 例：300
 *      APP子级Id为APP父级ID+xxx 例：300001
 * Created by Administrator on 2017/4/20.
 */
public interface CtrId {

    /**
     * 登录控制器
     */
    public static final int ADMIN_LOGIN = 1;
    /**
     * 父节点：系统管理
     */
    public static final int PARENT_SYSTEM_MAMAGER = 100;
    //系统用户权限
    public static final int SYSTEM_USER_AUTH = 100100;


    public static final int DICT_TABLE_CONTROLLER  = 1111111;
}
