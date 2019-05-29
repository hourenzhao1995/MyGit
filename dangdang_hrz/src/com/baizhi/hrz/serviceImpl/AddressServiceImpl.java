package com.baizhi.hrz.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.hrz.dao.AddressDAO;
import com.baizhi.hrz.dao.BookDao;
import com.baizhi.hrz.dao.ItemDAO;
import com.baizhi.hrz.dao.OrderDAO;
import com.baizhi.hrz.entity.Address;
import com.baizhi.hrz.entity.Cart;
import com.baizhi.hrz.entity.CartItem;
import com.baizhi.hrz.entity.Item;
import com.baizhi.hrz.entity.Order;
import com.baizhi.hrz.entity.User;
import com.baizhi.hrz.service.AddressService;
import com.baizhi.hrz.util.MyBatisUtil;

public class AddressServiceImpl implements AddressService{

	//通过用户id查询地址
	@Override
	public List<Address> queryAddressByUserId(String id) {
		AddressDAO ad = (AddressDAO) MyBatisUtil.getMapper(AddressDAO.class);
		List<Address> list = ad.queryAddressByUserId(id);
		MyBatisUtil.close();
		return list;
	}

	//通过address的id，查询地址
	@Override
	public Address queryAddressById(String id) {
		AddressDAO ad = (AddressDAO) MyBatisUtil.getMapper(AddressDAO.class);
		Address address = ad.queryAddressById(id);
		MyBatisUtil.close();
		return address;
	}

	//添加新地址
	@Override
	public void addAddress(Address address) {
		System.out.println("传入的address："+address);
		// TODO Auto-generated method stub
				User user = (User) ServletActionContext.getRequest().getSession().getAttribute("loginUser");
				Cart cart = (Cart) ServletActionContext.getRequest().getSession().getAttribute("cart");
				AddressDAO ad = (AddressDAO) MyBatisUtil.getMapper(AddressDAO.class);
				OrderDAO od = (OrderDAO) MyBatisUtil.getMapper(OrderDAO.class);
				ItemDAO itd = (ItemDAO) MyBatisUtil.getMapper(ItemDAO.class);
				BookDao bd = (BookDao) MyBatisUtil.getMapper(BookDao.class);
				Address address2 = ad.queryAddressById(address.getId());
				if(address2==null){
					address.setId(UUID.randomUUID().toString());
					address.setUser_id(user.getId());
					ad.addAddress(address);
				}else{
					
					/*System.out.println("通过地址ID查询"+address2);
					if(!address.toString().equals(address2.toString())){*/
						ad.update(address);
					
				}
				
				Order order=new Order();
				order.setId(UUID.randomUUID().toString());
				order.setAddress_id(address.getId());
				order.setCreate_date(new Date());
				order.setOrder_no(new Date().getTime()+"");
				ServletActionContext.getRequest().setAttribute("orderNo", order.getOrder_no());
				Double price = cart.getTotalPrice();
				double pri=price;
				int total=(int)pri;
				order.setTotal(total);
				ServletActionContext.getRequest().setAttribute("total",order.getTotal());
				order.setUser_id(user.getId());
				od.addOrder(order);
				
				Map<String, CartItem> map = cart.getCartItems();
				for (Entry<String, CartItem> entry : map.entrySet()) {
					CartItem cartItem = entry.getValue();
					Item item=new Item();
					item.setId(UUID.randomUUID().toString());
					item.setBook_id(cartItem.getBook().getId());
					item.setCount(cartItem.getCount());
					item.setCreate_date(new Date());
					item.setOrder_id(order.getId());
					itd.add(item);
					bd.updateBookSaleAndStock(cartItem.getBook().getId(),cartItem.getCount());
				}
				
				MyBatisUtil.commit();
				ServletActionContext.getRequest().getSession().removeAttribute("cart");
				
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	

}
