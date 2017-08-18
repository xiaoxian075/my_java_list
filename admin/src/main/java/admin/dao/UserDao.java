package admin.dao;

import java.util.List;

import admin.entity.UserInfo;

/**
 * 用户dao接口
 * @author chenjx
 *
 */
public interface UserDao {
    /**
     * 保存用户
     * @param user
     */
    void saveUser(UserInfo user);
	
	/**
	 * 获取所有用户列表
	 * @return
	 */
	List<UserInfo> getAllUser();
	
	/**
	 * 根据id查询用户信息
	 * @param id
	 * @return
	 */
	UserInfo getUserById(Integer id);
	
	/**
	 * 更新用户的名称
	 * @param user
	 */
	void renameUser(UserInfo user);
	
	/**
	 * 根据id删除指定的用户
	 * @param id
	 */
	void deleteUserById(Integer id);
}

