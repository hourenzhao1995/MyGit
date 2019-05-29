package com.baizhi.hrz.serviceImpl;

import java.util.HashMap;
import java.util.Map;

import com.baizhi.hrz.dao.BookDao;
import com.baizhi.hrz.entity.Book;
import com.baizhi.hrz.entity.Cart;
import com.baizhi.hrz.entity.CartItem;
import com.baizhi.hrz.service.CartService;
import com.baizhi.hrz.util.MyBatisUtil;


public class CartServiceImpl implements CartService {

	@Override
	public Cart addCart(String id, Cart cart) {
		// TODO Auto-generated method stub
		BookDao bd = (BookDao) MyBatisUtil.getMapper(BookDao.class);
		//根据id获取图书对象
		Book book = bd.selectBookById(id);
		//判断这个购物车是否为空,如果为空说明用户第一次购买商品
		if(cart==null){
			//如果用户第一次添加购物车， 新建购物车
			cart=new Cart();
			//新建购物车项集合
			Map<String,CartItem> map=new HashMap<String,CartItem>();
			//新建当前购物车项
			CartItem ci=new CartItem();
			//设置购物车项的属性
			ci.setBook(book);
			ci.setCount(1);
			ci.setLittelPrice(book.getDprice());
			//把购物车项添加到map里
			map.put(id, ci);
			//设置购物车对象里的属性
			cart.setCartItems(map);
			cart.setTotalPrice(book.getDprice());
			cart.setSavePrice(book.getPrice()-book.getDprice());
		}else{
			if(cart.getCartItems().get(id)==null){
				//新建当前购物车项
				CartItem ci=new CartItem();
				//设置购物车项的属性
				ci.setBook(book);
				ci.setCount(1);
				ci.setLittelPrice(book.getDprice());
				//把购物车项设置进map
				cart.getCartItems().put(id, ci);
				//设置购物车的总价
				cart.setTotalPrice(cart.getTotalPrice()+ci.getLittelPrice());
				//设置购物车里的节省金钱
				cart.setSavePrice(cart.getSavePrice()+(book.getPrice()-book.getDprice()));
			}else{
				
				CartItem ci = cart.getCartItems().get(id);
				//如果不是第一次购买此商品，那么商品数量加一
				ci.setCount(ci.getCount()+1);
				//小计
				ci.setLittelPrice(ci.getLittelPrice()+book.getDprice());
				//购物车里的总价
				cart.setTotalPrice(cart.getTotalPrice()+book.getDprice());
				//节省金钱
				cart.setSavePrice(cart.getSavePrice()+(book.getPrice()-book.getDprice()));
				
			}
		}
		
		return cart;
	}

	@Override
	public Cart update(String id, int count, Cart cart) {
		// TODO Auto-generated method stub
		//老购物车项
		CartItem cartItem = cart.getCartItems().get(id);
		//获取当前订单项里的书籍
		Book book = cartItem.getBook();
		
		//获取旧的总价
		Double oldtotalPrice = cart.getTotalPrice();
		//获取旧的小计
		Double oldlittelPrice = cartItem.getLittelPrice();
		//获取旧的节省金钱
		Double oldsavePrice = cart.getSavePrice();
		//获取旧的当前购物车项的节省金钱,用图书里的市场价减当当价  乘以  购买数量
		Double oldcartitemsave=(book.getPrice()-book.getDprice())*cartItem.getCount();
		 
		
		//获取购物车项
		CartItem ci = cart.getCartItems().get(id);
		//设置购物车项的数量
		ci.setCount(count);
		//设置购物车项里的小计
		ci.setLittelPrice(count*ci.getBook().getDprice());
		
		//设置购物车的总价
		cart.setTotalPrice((oldtotalPrice-oldlittelPrice)+ci.getLittelPrice());
		//设置节省金钱,  先用旧的节省金钱-旧购物车项节省的金钱  +新购物车项的节省金钱
		cart.setSavePrice((oldsavePrice-oldcartitemsave)+(book.getPrice()-book.getDprice())*count);
		return cart;
	}

	@Override
	public Cart delete(String id, Cart cart) {
		// TODO Auto-generated method stub
		//计算购物车里的总价
		cart.setTotalPrice(cart.getTotalPrice()-cart.getCartItems().get(id).getLittelPrice());
		
		
		CartItem cartItem = cart.getCartItems().get(id);
		Book book = cartItem.getBook();
		Integer count = cartItem.getCount();
		
		//计算节省金钱
		cart.setSavePrice(cart.getSavePrice()-(book.getPrice()-book.getDprice())*count);
		//移除当前订单项
		cart.getCartItems().remove(id);
		//判断移除之后集合是否还有订单项，如果没有就将cart设置为null
		if(cart.getCartItems().size()==0){
			cart=null;
		}
		return cart;
	}
	
}
