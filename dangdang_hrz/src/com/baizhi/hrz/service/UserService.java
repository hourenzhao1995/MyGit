package com.baizhi.hrz.service;

import java.util.List;

import com.baizhi.hrz.entity.User;

public interface UserService {
	//查询所有用户
	public List<User> selectAll();

	//修改用户状态
	public void updateUser(String email);

	/**前台：
	 * 注册用户
	 */
	public void adduser(User user,String code);
	
	//修改(激活)
	public void active(String inputCode);
	
	//登录
	public void login(String email,String password);
	
	
}
