package com.baizhi.hrz.test;

import java.util.UUID;

import org.junit.Test;

import com.baizhi.hrz.dao.UserDAO;
import com.baizhi.hrz.entity.User;
import com.baizhi.hrz.util.Md5Utils;
import com.baizhi.hrz.util.MyBatisUtil;

public class UserTest {
	/**
	 * 登录测试
	 */
	@Test
	public void loginUser(){
		UserDAO ud = (UserDAO) MyBatisUtil.getMapper(UserDAO.class);
		User user=new User();
		user.setId(UUID.randomUUID().toString());
		user.setEmail("www@qq.com");
		user.setPassword("111222");
		user.setNickname("asd");
		String salt = Md5Utils.getSalt(6);
		user.setSalt(salt);
		user.setStatus("正常");
		user.setCode("we3e");
		ud.addUser(user);
		MyBatisUtil.commit();
	}

}
