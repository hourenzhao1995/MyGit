package com.baizhi.hrz.test;

import java.util.List;

import org.junit.Test;

import com.baizhi.hrz.dao.OrderDAO;
import com.baizhi.hrz.entity.Order;
import com.baizhi.hrz.util.MyBatisUtil;

public class OrderTest {
	@Test
	public void selectAllOrder(){
		OrderDAO od = (OrderDAO) MyBatisUtil.getMapper(OrderDAO.class);
		List<Order> list = od.selectAll();
		for (Order order : list) {
			System.out.println(order);
		}
	}
	
	
	@Test
	public void AllIt(){
		OrderDAO od = (OrderDAO) MyBatisUtil.getMapper(OrderDAO.class);
		Order oo = od.selectByOreder_no("01");
		System.out.println(oo);
	}

}
