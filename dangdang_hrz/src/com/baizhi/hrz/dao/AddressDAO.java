package com.baizhi.hrz.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.hrz.entity.Address;

public interface AddressDAO {
	//1、通过用户id查询用户的地址
	public List<Address> queryAddressByUserId(String id);
	
	//2、通过Address的id，查询地址
	public Address queryAddressById(String id);
	
	//3、添加一个新地址
	public void addAddress(Address address);
	
	//4、修改地址
	public void update(Address address);
	
	
	
	

}
