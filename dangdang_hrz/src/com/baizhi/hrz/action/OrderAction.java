package com.baizhi.hrz.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.baizhi.hrz.entity.Order;
import com.baizhi.hrz.service.OrderService;
import com.baizhi.hrz.serviceImpl.OrderServiceImpl;

public class OrderAction {
	
	private Order order;
	private String order_no;
	public String getOrder_no() {
		return order_no;
	}
	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public OrderService getOs() {
		return os;
	}
	public void setOs(OrderService os) {
		this.os = os;
	}
	private OrderService os=new OrderServiceImpl();
	public String show(){
		//调用service层的方法
		List<Order> list = os.selectAll();
		ServletActionContext.getRequest().setAttribute("list", list);
		for (Order order : list) {
			System.out.println(order);
		}
		
		return "success";
	}
	
	//通过Order的id查询详细订单
	public String selectItem(){
		Order oer = os.selectByOrder_no(order_no);
		ServletActionContext.getRequest().setAttribute("order", oer);
		return "success";
	}

}
