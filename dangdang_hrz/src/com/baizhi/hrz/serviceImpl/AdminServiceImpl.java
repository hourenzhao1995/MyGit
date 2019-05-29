package com.baizhi.hrz.serviceImpl;

import com.baizhi.hrz.dao.AdminDAO;
import com.baizhi.hrz.entity.Admin;
import com.baizhi.hrz.service.AdminService;
import com.baizhi.hrz.util.MyBatisUtil;

public class AdminServiceImpl implements AdminService{

	//登录业务
	@Override
	public Admin login(String username,String password) {
		AdminDAO ad = (AdminDAO) MyBatisUtil.getMapper(AdminDAO.class);
		Admin admin = ad.selectByUserNameAndPassword(username);
		if(admin==null){
			throw new RuntimeException("用户名不存在！！！");
		}else {
			if(!admin.getPassword().equals(password)){
				throw new RuntimeException("密码错误！！！");
			}
		}
		MyBatisUtil.commit();
		return admin;
	}

}
