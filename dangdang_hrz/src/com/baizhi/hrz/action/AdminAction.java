package com.baizhi.hrz.action;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.hrz.entity.Admin;
import com.baizhi.hrz.service.AdminService;
import com.baizhi.hrz.serviceImpl.AdminServiceImpl;

public class AdminAction {
	//接受页面传入的数据
	private Admin admin;
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	//验证码
	private String vcode;
	private String message;
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public String getVcode() {
		return vcode;
	}
	public void setVcode(String vcode) {
		this.vcode = vcode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	private AdminService as=new AdminServiceImpl();
	//登录Action
	public String login(){
		//获取session对象
		HttpSession session = ServletActionContext.getRequest().getSession();
		//获取作用域中的验证码
		String code = (String) session.getAttribute("validationCode");
		System.out.println("获取的为："+code);
		HttpServletRequest request = ServletActionContext.getRequest();

		try {
			Admin admin2 = as.login(username, password);
			//将用户名存储在session作用于中，用于在主页面显示登录的用户
			session.setAttribute("username", username);
			//判断验证码
			if(!code.equals(vcode)){
				String message="验证码错误";
				request.setAttribute("message", message);
				return "error";
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			String message=e.getMessage();
			request.setAttribute("message", message);
			return "error";
		}
		return "ok";
		
		/*if(code.equals(vcode)){
			//调用service层的登陆方法
			Admin user = as.login(username, password);
			if(user!=null){
				//将登陆的用户名存入session'作用域中
				session.setAttribute("username", username);
				return "ok";
			}else {
				return "error";
			}
		}else {
			return "error";
		}*/
	}
	
	//安全退出Action
	public String Exit(){
		//获取session对象
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.invalidate();
		return "exit";
	}

}



















