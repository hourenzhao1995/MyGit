package com.baizhi.hrz.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * 购物车
 * @author lenovo
 *该类中放：购物车项集合、节省的金钱、商品总额
 */
public class Cart {
	//购物项集合
	private Map<String, CartItem> cartItems=new HashMap<String, CartItem>();
	//商品总金额
	private Double totalPrice;
	//节省的钱
	private  Double savePrice;
	
	
	public Map<String, CartItem> getCartItems() {
		return cartItems;
	}
	public void setCartItems(Map<String, CartItem> cartItems) {
		this.cartItems = cartItems;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Double getSavePrice() {
		return savePrice;
	}
	public void setSavePrice(Double savePrice) {
		this.savePrice = savePrice;
	}
	@Override
	public String toString() {
		return "Cart [cartItems=" + cartItems + ", totalPrice=" + totalPrice
				+ ", savePrice=" + savePrice + "]";
	}
	public Cart(Map<String, CartItem> cartItems, Double totalPrice,
			Double savePrice) {
		super();
		this.cartItems = cartItems;
		this.totalPrice = totalPrice;
		this.savePrice = savePrice;
	}
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
