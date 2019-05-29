package com.baizhi.hrz.serviceImpl;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.hrz.dao.UserDAO;
import com.baizhi.hrz.entity.User;
import com.baizhi.hrz.service.UserService;
import com.baizhi.hrz.util.Md5Utils;
import com.baizhi.hrz.util.MyBatisUtil;

public class UserServiceImpl implements UserService{

	//查询所有用户
	@Override
	public List<User> selectAll() {
		UserDAO ud = (UserDAO) MyBatisUtil.getMapper(UserDAO.class);
		List<User> allUser = ud.selectAllUser();
		MyBatisUtil.close();
		
		return allUser;
	}

	//修改用户状态 通过
	@Override
	public void updateUser(String email) {
		UserDAO ud = (UserDAO) MyBatisUtil.getMapper(UserDAO.class);
		User user = ud.selectUser(email);
		if(user.getStatus().equals("正常")){
			ud.updateUserStatus("冻结",email);
		}else if (user.getStatus().equals("冻结")) {
			ud.updateUserStatus("正常", email);
		}
		MyBatisUtil.commit();
	}

	@Override
	public void adduser(User user, String code) {
		HttpSession session = ServletActionContext.getRequest().getSession();
		String ycode = (String) session.getAttribute("validationCode");
		//判断验证码
		if(ycode.equals(code)){
			UserDAO ud = (UserDAO) MyBatisUtil.getMapper(UserDAO.class);
			//通过email查询用户
			User checkUser = ud.selectUser(user.getEmail());
			//正确，判断email是否重复
			if(checkUser==null){
				//如果用户不存在，进行添加
				user.setId(UUID.randomUUID().toString());
				user.setStatus("正常");
				String salt = Md5Utils.getSalt(6);
				user.setSalt(salt);
				//加密方式   密码+盐
				String password = Md5Utils.getMd5Code(user.getPassword()+salt);
				user.setPassword(password);
				try {
					System.out.println("user对象数据:"+user);
					ud.addUser(user);
					session.setAttribute("loginUser",user);
					MyBatisUtil.commit();
				} catch (Exception e) {
					MyBatisUtil.rollback();
					throw new RuntimeException("注册失败");
				}
				
			}else {
				//用户名存在
				throw new RuntimeException("改邮箱已经被注册");
			}
			
		}else {
			throw new RuntimeException("验证码有误");
		}
		
	}

	//激活
	@Override
	public void active(String inputCode) {
		HttpSession session = ServletActionContext.getRequest().getSession();
		//获取session中的emailCode
		String emailCode = (String) session.getAttribute("emailCode");
		//判断用户输入的验证码是否正确
		System.out.println("输入的："+inputCode);
		//判断邮箱
		if(inputCode.equals(emailCode)){
			//正确，设置用户的code属性
			User loginUser = (User) session.getAttribute("loginUser");
			loginUser.setCode(emailCode);
			UserDAO ud = (UserDAO) MyBatisUtil.getMapper(UserDAO.class);
			try {
				ud.active(loginUser.getId(),inputCode);
				MyBatisUtil.commit();
			} catch (Exception e) {
				MyBatisUtil.rollback();
				throw new RuntimeException("激活失败");
			}
		}else {
			throw new RuntimeException("邮箱验证码错误");
		}
		
	}

	//登录
	@Override
	public void login(String email, String password) {
		//获取session对象
		HttpSession session = ServletActionContext.getRequest().getSession();
		
		UserDAO ud = (UserDAO) MyBatisUtil.getMapper(UserDAO.class);
		//调用dao层对象，得到user对象
		User checkUser = ud.selectUser(email);
		//判断用户
		if(checkUser==null){
			throw new RuntimeException("邮箱不存在");
		}else {
			//判断密码
			if(checkUser.getPassword().equals(Md5Utils.getMd5Code(password+checkUser.getSalt()))){
				//密码正确
				if(checkUser.getStatus().equals("正常")){
					//登录成功，存入session作用域中
					session.setAttribute("loginUser",checkUser);
				}else {
					throw new RuntimeException("账号已经被冻结。");
				}
			}else {
				throw new RuntimeException("密码错误");
			}
		}
	}

	/**
	 * 前台：用户注册
	 */
	
	
	
	
	
	
	
	
	

	

}
