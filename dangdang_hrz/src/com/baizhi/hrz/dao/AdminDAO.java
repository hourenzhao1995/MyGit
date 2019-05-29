package com.baizhi.hrz.dao;

import org.apache.ibatis.annotations.Param;

import com.baizhi.hrz.entity.Admin;

public interface AdminDAO {
	//管理员登录
	public Admin selectByUserNameAndPassword(@Param("username")String username);

}
