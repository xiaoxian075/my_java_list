package com.mybatis.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mybatis.dao.UserMapper;
import com.mybatis.entity.User;

/**
 * TODO 控制层代码
 * @author cjx
 * @date 2017年6月3日
 */
@Controller
public class MyController {
	private static final Logger logger = LoggerFactory.getLogger(MyController.class);  
	
	@Autowired
    private UserMapper userDao;
	
	@RequestMapping("login") //用来处理前台的login请求
	private @ResponseBody String hello(
			@RequestParam(value = "username", required = false)String username,
			@RequestParam(value = "password", required = false)String password
			){
		User user = userDao.selectByPrimaryKey(1);
		logger.info(user.toString());
		//logger.warn("username:"+username+",password:"+password);
		return "你好:"+username+",你的密码是:"+password;
	}

}
