package com.at.controller.app;

import com.at.config.CtrId;
import com.at.frame.annotation.AutoCtrl;
import com.at.frame.annotation.AutoMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/6/2.
 */
@AutoCtrl(
        id = CtrId.DICT_TABLE_CONTROLLER ,//控制器Id
        name = "app",//该配置只暴露给app组查看
        prefix = "dictTable",//控制器的方法生成时的方法名称前缀
        desc = "字典管理",//控制器描述
        version = 1//控制器的版本号信息
)
public class DictTableController {
    private static final Logger LOGGER = LoggerFactory.getLogger(DictTableController.class);

    @AutoMethod(id = 1, name = "initData", desc = "初始化字典")
    public void initDict(HttpServletRequest request, HttpServletResponse response) {
        try{
            System.out.println("111");
        }catch (Exception e){
            LOGGER.error("initDict",e);
        }
    }
}
