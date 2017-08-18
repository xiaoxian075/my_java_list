package admin.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import admin.dao.UserDao;
import admin.entity.UserInfo;
import admin.mapper.UserMapper;

@Service("userDao")
public class UserDaoImpl implements UserDao{

	@Autowired
	private UserMapper mapper;
	
	@Override
	public void saveUser(UserInfo user) {
		mapper.saveUser(user);
	}

	@Override
	public List<UserInfo> getAllUser() {
		return mapper.getAllUser();
	}

	@Override
	public UserInfo getUserById(Integer id) {
		return mapper.getUserById(id);
	}

	@Override
	public void renameUser(UserInfo user) {
		mapper.renameUser(user);
	}

	@Override
	public void deleteUserById(Integer id) {
		mapper.deleteUserById(id);
	}

}
