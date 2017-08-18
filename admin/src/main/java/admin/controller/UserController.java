package admin.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import admin.entity.UserInfo;
import admin.service.UserService;


@Controller
@RequestMapping("/user")
public class UserController {
	private final Log logger = LogFactory.getLog(this.getClass());
	
	@Autowired
	private UserService mUserService;
	
	/**
	 * 保存用户
	 * @param name
	 * @param sex
	 * @param age
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	public Integer save(@RequestParam(value="name", defaultValue="") String name,
			@RequestParam(value="sex", defaultValue="") String sex,
			@RequestParam(value="age", defaultValue="0") String age){
		logger.debug(name);
		UserInfo user = new UserInfo(name, sex, Integer.parseInt(age));
		mUserService.saveUser(user);
		return 1;
	}
	
	/**
	 * 获取所有用户列表
	 * @return
	 */
	@RequestMapping("/getall")
	@ResponseBody
	public Object getAllUser(){
		List<UserInfo> users = mUserService.getAllUser();
		for(UserInfo u : users){
			logger.debug(u.toString());
		}
		return users;
	}
	/**
	 * 根据用户id获取用户信息
	 * @return
	 */
	@RequestMapping("/getUserById")
	@ResponseBody
	public Object getUserById(@RequestParam(value="id", defaultValue="0") String id){
		UserInfo user = mUserService.getById(Integer.parseInt(id));
		logger.debug(user.toString());
		return user;
	}
	
	/**
	 * 根据用户id获取用户信息
	 * @return
	 */
	@RequestMapping("/renameUser")
	@ResponseBody
	public Integer renameUser(@RequestParam(value="id", defaultValue="0") String id, 
							 @RequestParam(value="name", defaultValue="") String name){
		logger.debug(id + "=========" + name);
		mUserService.rename(new UserInfo(Integer.parseInt(id), name));
		return 1;
	}
	/**
	 * 根据用户id获取用户信息
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public Integer delete(@RequestParam(value="id", defaultValue="0") String id){
		logger.debug(id);
		mUserService.deleteById(Integer.parseInt(id));
		return 1;
	}
}
