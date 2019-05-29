package com.baizhi.hrz.service;

import java.util.List;

import com.baizhi.hrz.entity.Category;

public interface CategoryService {
	/*//查询所有
	public List<Category> showAll();
	//添加一级类别
	public void addfirst(Category cate);
	//查询所有一级类别
	public List<Category> showFirst();
	//添加二级类别
	public void addSecond(Category cate);
	//删除类别
	public void delete(Category category);*/
	
	public List<Category> queryAll();
	public void add(Category cate);
	public List<Category> selectFirst();
	public void delete(int levels,String id);
	
	
	
	
	/**
	 * 前台显示所有类别
	 */
	public List<Category> selectAllCategory();
	
	/**
	 * 二级页面显示
	 */
	public Category queryfirstCategory(String id);
	
}
