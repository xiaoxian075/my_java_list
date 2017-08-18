package admin.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import admin.dao.UserDao;
import admin.entity.UserInfo;
import admin.service.UserService;
//DROP TABLE IF EXISTS `account`;
//create TABLE `account` (
//	`id` BIGINT NOT NULL auto_increment,
//	`loginName` CHAR(64) NOT NULL COMMENT '登入名',
//	`password` CHAR(128) NOT NULL COMMENT '密码',
//	`userName` CHAR(64) NOT NULL COMMENT '用户名',
//	`nickName` CHAR(64) NOT NULL COMMENT '昵称',
//	`identityID` CHAR(18) NOT NULL COMMENT '身份证号',
//	`identityName` CHAR(64) NOT NULL COMMENT '身份证上的姓名',
//	`birth` DATE NOT NULL COMMENT '出生年月日',
//	`createTime` TIMESTAMP NOT NULL COMMENT '创建日期',
//	PRIMARY KEY (`id`)
//);
@Repository
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
    private RedisTemplate<Serializable, UserInfo> template;
	
	@Override
	public void saveUser(UserInfo user) {
		userDao.saveUser(user);
		template.opsForValue().set(user.getId(),user);
	}

	@Override
	public List<UserInfo> getAllUser() {
		UserInfo user = template.opsForValue().get(6);
		System.out.println(user);
		return userDao.getAllUser();
	}

	@Override
	public UserInfo getById(Integer id) {
		return userDao.getUserById(id);
	}

	@Override
	public void rename(UserInfo user) {
		userDao.renameUser(user);
	}

	@Override
	public void deleteById(Integer id) {
		userDao.deleteUserById(id);
	}


}
