package admin.service;

import java.util.List;

import admin.entity.UserInfo;


/**
 * 用户service接口
 * @author liuyazhuang
 *
 */
public interface UserService {

	public void saveUser(UserInfo user);

	public List<UserInfo> getAllUser();

	public UserInfo getById(Integer id);

	public void rename(UserInfo user);

	public void deleteById(Integer id);
}
