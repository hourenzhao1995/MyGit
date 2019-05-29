package com.baizhi.hrz.dao;

import java.util.List;

import com.baizhi.hrz.entity.Order;

public interface OrderDAO {
	/**1、
	 * 查询并展示所有订单
	 */
	public List<Order> selectAll();
	
	/**2、
	 * 根据订单编号查询订单的详细信息
	 * @return
	 */
	public Order selectByOreder_no(String order_no);
	
	/**
	 * 前台：添加一个订单
	 */
	public void addOrder(Order order);

}
