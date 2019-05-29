package com.baizhi.hrz.service;

import com.baizhi.hrz.entity.Cart;

//购物车业务
public interface CartService {
	//添加商品进入购物车
	public Cart addCart(String id,Cart cart);
	
	public Cart update(String id,int count,Cart cart);
	
	public Cart delete(String id,Cart cart);
	
	
	
}
