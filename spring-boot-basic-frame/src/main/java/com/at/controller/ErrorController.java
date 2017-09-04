package com.at.controller;

import org.apache.ibatis.executor.Executor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ErrorController{
    private static final Logger LOGGER = LoggerFactory.getLogger(ErrorController.class);
    public ErrorController(){
        System.out.println("------ErrorController");
    }

    /**
     * 注：如果设置开启了
     * at.frame.controller-handler
     * 则，设置的包下的所有异常将由特定的拦截器处理，则不会由该类处理
     * 即如果设置了，则该配置失效！！！！
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String exception(Exception e){
        System.out.println("---advice--exception--------");
        LOGGER.error("error",e);
        return e.getMessage();
    }

}
