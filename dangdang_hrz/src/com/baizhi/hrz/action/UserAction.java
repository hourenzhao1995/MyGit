package com.baizhi.hrz.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.hrz.entity.User;
import com.baizhi.hrz.service.UserService;
import com.baizhi.hrz.serviceImpl.UserServiceImpl;
import com.baizhi.hrz.util.Md5Utils;

public class UserAction {
	private String email;//要修改的用户邮箱
	private String status;//要修改的用户状态
	//前台页面
	private User user;
	private String code; //用户注册时，获取的值
	private String inputCode;//用户输入的邮箱验证码
	private UserService us=new UserServiceImpl(); //得到service层的对象
	private String registMessage;//用户注册失败信息
	private String activeMessage;//激活失败的信息
	
	
	public String getInputCode() {
		return inputCode;
	}

	public void setInputCode(String inputCode) {
		this.inputCode = inputCode;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String showAll(){
		UserService us=new UserServiceImpl();
		List<User> list = us.selectAll();
		ServletActionContext.getRequest().setAttribute("list", list);
		
		return "success";
	}

	
	
	//修改用户状态
	public String userStatus(){
		UserService us=new UserServiceImpl();
		us.updateUser(email);
		return "success";
	}
	
	

	//前台：
	/*
	 * 登录 login
	 */
	
	//注册用户
	public String regist(){
		try {
			us.adduser(user, code);
			return "ok";
		} catch (Exception e) {
			e.printStackTrace();
			registMessage=e.getMessage();
			return "error";
		}
		
	}
	
	/**
	 * 想用户邮箱发发送验证码
	 * @return
	 */
	public String sendEmail(){
		//首先获取验证码
		String salt = Md5Utils.getSalt(6);
		HttpSession session = ServletActionContext.getRequest().getSession();
		//获取登录的用户对象
		User loginUser = (User) session.getAttribute("loginUser");
		session.setAttribute("emailCode",salt);
		return "ok";
	}
	
	/**
	 * 点击完成激活用户
	 * @return
	 */
	public String active(){
		try {
			us.active(inputCode);
			return "ok";
		} catch (Exception e) {
			e.printStackTrace();
			activeMessage=e.getMessage();
			return "error";
		}
	}
	
	/**
	 * 前台：用户登录
	 * @return
	 */
	public String login(){
		try {
			System.out.println(user.getEmail()+"----"+user.getPassword());
			us.login(user.getEmail(),user.getPassword());
			return "ok";
		} catch (Exception e) {
			String loginMessage=e.getMessage();
			ServletActionContext.getRequest().getSession().setAttribute("Message",loginMessage);
			return "error";
		}
	}
	
	
	/*
	 * 用户的安全退出
	 */
	public String exit(){
		//得到session对象
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.invalidate();
		
		return "exit";
	}
	
	
	

}




























