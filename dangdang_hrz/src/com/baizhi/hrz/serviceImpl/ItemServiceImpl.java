package com.baizhi.hrz.serviceImpl;

import com.baizhi.hrz.dao.ItemDAO;
import com.baizhi.hrz.entity.Item;
import com.baizhi.hrz.service.ItemService;
import com.baizhi.hrz.util.MyBatisUtil;

public class ItemServiceImpl implements ItemService{

	//添加一个购物项业务
	@Override
	public void add(Item item) {
		ItemDAO id = (ItemDAO) MyBatisUtil.getMapper(ItemDAO.class);
		try {
			//调用dao层方法
			id.add(item);
			//提交
			MyBatisUtil.commit();
		} catch (Exception e) {
			e.printStackTrace();
			MyBatisUtil.rollback();
		}
		
		
		
	}

}
