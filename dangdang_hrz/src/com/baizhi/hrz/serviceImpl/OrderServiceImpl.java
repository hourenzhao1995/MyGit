package com.baizhi.hrz.serviceImpl;

import java.util.List;

import com.baizhi.hrz.dao.OrderDAO;
import com.baizhi.hrz.entity.Order;
import com.baizhi.hrz.service.OrderService;
import com.baizhi.hrz.util.MyBatisUtil;

public class OrderServiceImpl implements OrderService{

	//查询显示所有的订单
	@Override
	public List<Order> selectAll() {
		OrderDAO od = (OrderDAO) MyBatisUtil.getMapper(OrderDAO.class);
		List<Order> list = od.selectAll();
		
		MyBatisUtil.close();
		
		return list;
	}

	//通过Order的id查询详细订单
	@Override
	public Order selectByOrder_no(String order_no) {
		OrderDAO od = (OrderDAO) MyBatisUtil.getMapper(OrderDAO.class);
		Order byorder_no = od.selectByOreder_no(order_no);
		MyBatisUtil.close();
		
		return byorder_no;
	}

}
