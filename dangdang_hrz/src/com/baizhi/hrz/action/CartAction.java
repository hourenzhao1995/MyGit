package com.baizhi.hrz.action;

import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.hrz.entity.Cart;
import com.baizhi.hrz.entity.CartItem;
import com.baizhi.hrz.service.BookService;
import com.baizhi.hrz.service.CartService;
import com.baizhi.hrz.serviceImpl.BookServiceImpl;
import com.baizhi.hrz.serviceImpl.CartServiceImpl;

public class CartAction {
	private CartService cs=new CartServiceImpl();
	private String id;
	private int count;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	//1、添加如购物车
	public String addcart(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		Cart oldcart = (Cart) session.getAttribute("cart");
		Cart newCart = cs.addCart(id, oldcart);
		session.setAttribute("cart",newCart);
		
		return "addok";
	}
	
	//修改购物车的数量
	public String update(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		Cart oldcart = (Cart) session.getAttribute("cart");
		Cart cart = cs.update(id, count, oldcart);
		session.setAttribute("cart",cart);
		return "update";
	}
	
	//删除购物车中的商品
	public String delete(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		Cart oldcart = (Cart) session.getAttribute("cart");
		Cart cart = cs.delete(id, oldcart);
		session.setAttribute("cart",cart);
		return "delete";
	}
	
	
	
	
}































