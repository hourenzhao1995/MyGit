package com.baizhi.hrz.service;

import java.util.List;

import com.baizhi.hrz.entity.Address;

public interface AddressService {
	//通过用户id，查询用户的地址
	public List<Address> queryAddressByUserId(String id);
	
	//通过Address的id，查询地址
	public Address queryAddressById(String id);
	
	//添加新地址
	public void addAddress(Address address);
	
	
	
	
	
	
	
	

}
