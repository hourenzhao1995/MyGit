package com.baizhi.hrz.action;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.hrz.entity.Address;
import com.baizhi.hrz.entity.User;
import com.baizhi.hrz.service.AddressService;
import com.baizhi.hrz.serviceImpl.AddressServiceImpl;

public class AddressAction {
	private AddressService as=new AddressServiceImpl();
	//接收页面传入的数据
	private Address address;
	//接受用户选中的地址id
	private String addressId;
	
	public String getAddressId() {
		return addressId;
	}
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	public AddressService getAs() {
		return as;
	}
	public void setAs(AddressService as) {
		this.as = as;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	//通过用户id查询地址
	public String queryAddressByUserId(){
		User loginUser = (User) ServletActionContext.getRequest().getSession().getAttribute("loginUser");
		String id = loginUser.getId();
		//返回一个地址集合
		List<Address> addresses = as.queryAddressByUserId(loginUser.getId());
		for (Address address : addresses) {
			System.out.println(address);
		}
		//存入request作用域
		ServletActionContext.getRequest().setAttribute("list",addresses);
		return "ok";
	}
	
	//通过Address的id查询地址
	public String queryAddressById(){
		Address address = as.queryAddressById(addressId);
		//将结果存入request作用域
		ServletActionContext.getRequest().setAttribute("address", address);
		return "ok";
	}
	
	//添加一个新地址
	public String addAddress(){
		User loginUser = (User) ServletActionContext.getRequest().getSession().getAttribute("loginUser");
		String id = loginUser.getId();
		address.setUser_id(id);
		address.setId(UUID.randomUUID().toString());
		System.out.println(address);
		as.addAddress(address);
		return "ok";
	}
	

}



























