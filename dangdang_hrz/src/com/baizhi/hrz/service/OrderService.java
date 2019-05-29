package com.baizhi.hrz.service;

import java.util.List;

import com.baizhi.hrz.entity.Order;

public interface OrderService {
	
	/*
	 * 查询所有订单
	 */
	public List<Order> selectAll();
	
	//通过order的id查询详细订单信息
	public Order selectByOrder_no(String order_no);

	
}
