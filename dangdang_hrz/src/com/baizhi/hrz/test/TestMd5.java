package com.baizhi.hrz.test;

import org.junit.Test;

import com.baizhi.hrz.entity.User;
import com.baizhi.hrz.util.Md5Utils;

public class TestMd5 {
	@Test
	public void loginTest(){
		User user=new User();
		String newPwd = Md5Utils.getMd5Code(user.getPassword()+user.getSalt());
		System.out.println("加密后的密码："+newPwd);
	}
	
	@Test
	public void tt(){
		//得到6位数的盐值
		String salt = Md5Utils.getSalt(6);
		String password="222222";
		String code = Md5Utils.getMd5Code(password+salt);
		System.out.println("盐值:"+salt);
		System.out.println("加密后的密码："+code);
		
	}
}
