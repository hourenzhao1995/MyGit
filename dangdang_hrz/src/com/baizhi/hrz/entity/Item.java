package com.baizhi.hrz.entity;

import java.util.Date;

public class Item {
	private String id; //编号
	private String book_id; //图书编号
	private int count;//数量
	private Date create_date;//创建时间
	private String order_id; //订单编号
	private Book book; //图书对象
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBook_id() {
		return book_id;
	}
	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Item(String id, String book_id, int count, Date create_date,
			String order_id, Book book) {
		super();
		this.id = id;
		this.book_id = book_id;
		this.count = count;
		this.create_date = create_date;
		this.order_id = order_id;
		this.book = book;
	}
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", book_id=" + book_id + ", count=" + count
				+ ", create_date=" + create_date + ", order_id=" + order_id
				+ ", book=" + book + "]";
	}
}
