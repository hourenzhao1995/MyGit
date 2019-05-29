package com.baizhi.hrz.entity;

import java.util.List;

public class Address {
	private String id; //编号
	private String name; //名字
	private String local; //详细地址
	private String zip_code;//邮编
	private String phone; //手机号码
	private String user_id; //用户编号的
	private User user; //用户 
	private List<Order> orders;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getZip_code() {
		return zip_code;
	}
	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", name=" + name + ", local=" + local
				+ ", zip_code=" + zip_code + ", phone=" + phone + ", user_id="
				+ user_id + ", user=" + user + ", orders=" + orders + "]";
	}
	public Address(String id, String name, String local, String zip_code,
			String phone, String user_id, User user, List<Order> orders) {
		super();
		this.id = id;
		this.name = name;
		this.local = local;
		this.zip_code = zip_code;
		this.phone = phone;
		this.user_id = user_id;
		this.user = user;
		this.orders = orders;
	}
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

}
