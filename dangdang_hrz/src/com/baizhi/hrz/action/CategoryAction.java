package com.baizhi.hrz.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.baizhi.hrz.entity.Category;
import com.baizhi.hrz.service.CategoryService;
import com.baizhi.hrz.serviceImpl.CategoryServiceImpl;

public class CategoryAction {
	private CategoryService cs = new CategoryServiceImpl();

	private Category category;
	

	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}

	//查询所有
	public String showAll(){
		/*List<Category> categorys = cs.showAll();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("categorys", categorys);*/
		List<Category> list = cs.queryAll();
		ServletActionContext.getRequest().getSession().setAttribute("categorys",list);
		return "showAllYes";
		
	}
	
	//添加一级类别
	public String addfirst(){
		/*cs.addfirst(category);*/
		cs.add(category);
		return "success";
	}
	
	//查询一级类别
	public String queryAllFirst(){
		/*List<Category> list = cs.showFirst();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("list", list);*/
		List<Category> list = cs.selectFirst();
		ServletActionContext.getRequest().setAttribute("list", list);
		
		return "success";
	}
	/*public String addSecond(){
		System.out.println(category);
		cs.addSecond(category);
		
		return "success";
	}*/
	
	//删除类别
	public String delete(){
		System.out.println(category);
		/*cs.delete(category);*/
		cs.delete(category.getLevels(), category.getId());
		return "success";
	}
	
	
}
