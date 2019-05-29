package com.baizhi.hrz.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.baizhi.hrz.entity.Book;
import com.baizhi.hrz.entity.Category;
import com.baizhi.hrz.service.BookService;
import com.baizhi.hrz.service.CategoryService;
import com.baizhi.hrz.serviceImpl.BookServiceImpl;
import com.baizhi.hrz.serviceImpl.CategoryServiceImpl;

public class MainAction {
	
	private BookService bs=new BookServiceImpl();
	private CategoryService cs=new CategoryServiceImpl();
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String mainJSP(){
		//编辑推荐
		List<Book> relist = bs.recommendBook();
		ServletActionContext.getRequest().setAttribute("recommends",relist);
		//热卖书籍
		List<Book> hotBook = bs.hotBook();
		ServletActionContext.getRequest().setAttribute("sales",hotBook);
		//新书
		List<Book> newBook = bs.newBook();
		ServletActionContext.getRequest().setAttribute("news",newBook);
		//新书热卖
		List<Book> newAndHotBook = bs.newAndHotBook();
		ServletActionContext.getRequest().setAttribute("newAndHotBook",newAndHotBook);
		
		//左栏类别显示
		List<Category> selectAllCategory = cs.selectAllCategory();
		ServletActionContext.getRequest().setAttribute("firsts", selectAllCategory);
		
		
		//通过id查询图书信息
		
		return "main";
		
	}

}
