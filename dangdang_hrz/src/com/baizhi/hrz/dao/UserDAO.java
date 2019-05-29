package com.baizhi.hrz.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.hrz.entity.User;

public interface UserDAO {
	//查询显示所有用户
	public List<User> selectAllUser();
	
	//修改用户状态 通过emial
	public void updateUserStatus(@Param("status")String status,@Param("email")String email);

	//根据email、查询用户信息
	public User selectUser(@Param("email")String email);
	

	/**
	 * 前台：
	 * @param email
	 * @param password
	 * @return
	 */
	//登录
	public User login(@Param("email")String email);
		
	//用户注册
	public void addUser(User user);
	
	//修改用户状态(激活用户)
	public void active(@Param("id")String id,@Param("code")String code);
}
