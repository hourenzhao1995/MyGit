package com.baizhi.hrz.dao;

import java.util.List;

import com.baizhi.hrz.entity.Category;

public interface CategoryDao {
		//展示所有
	 	public List<Category> queryAll();
	 	//添加一级类别
	 	public void add(Category cate);
	 	//查询所有一级类别
	 	public List<Category> selectfirst();
	 	//删除类别
		public void delete(String id);
		//查询素有二级类别
		public List<Category> selectSecond(String id);
	
	
	
	
	
	
	
		/*//1、展示所有
		public List<Category> queryAll();
		//2、添加类别
		public void addCategory(Category category);
		//3、查询一级类别
		public List<Category> queryFirst();
		//4、添加二级
		public void addSecond(Category category);
		//5、查询二级
		public List<Category> querySocend(String id);
		//6、删除类别
		public void delete(String id);*/
		
		/**
		 * 前台:全部类别显示
		 */
		public List<Category> selectAllCategory();
		
		/**
		 * 二级页面显示
		 */
		public Category queryfirstCategory(String id);
		
}


























