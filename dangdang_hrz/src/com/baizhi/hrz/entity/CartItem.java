package com.baizhi.hrz.entity;

/**
 * 购物项
 * @author lenovo
 *
 */
public class CartItem {
	private Book book; //图书对象(商品)
	private Integer count; //购买数量 
	private Double littelPrice; //小计
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Double getLittelPrice() {
		return littelPrice;
	}
	public void setLittelPrice(Double littelPrice) {
		this.littelPrice = littelPrice;
	}
	public CartItem(Book book, Integer count, Double littelPrice) {
		super();
		this.book = book;
		this.count = count;
		this.littelPrice = littelPrice;
	}
	@Override
	public String toString() {
		return "CartItem [book=" + book + ", count=" + count + ", littelPrice="
				+ littelPrice + "]";
	}
	public CartItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
