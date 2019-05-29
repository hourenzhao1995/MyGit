package com.baizhi.hrz.entity;

import java.util.Date;
import java.util.List;

/**
 * 订单表
 * @author lenovo
 *
 */
public class Order {
	private String id; //订单ID
	private String order_no; //订单编号
	private String user_id; //用户id
	private Integer total; //金额
	private Date create_date; //创建时间
	private String address_id; //地址编号
	private Address address;//地址类
	private List<Item> items; //订单项
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrder_no() {
		return order_no;
	}
	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public String getAddress_id() {
		return address_id;
	}
	public void setAddress_id(String address_id) {
		this.address_id = address_id;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", order_no=" + order_no + ", user_id="
				+ user_id + ", total=" + total + ", create_date=" + create_date
				+ ", address_id=" + address_id + ", address=" + address
				+ ", items=" + items + "]";
	}
	public Order(String id, String order_no, String user_id, Integer total,
			Date create_date, String address_id, Address address,
			List<Item> items) {
		super();
		this.id = id;
		this.order_no = order_no;
		this.user_id = user_id;
		this.total = total;
		this.create_date = create_date;
		this.address_id = address_id;
		this.address = address;
		this.items = items;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}