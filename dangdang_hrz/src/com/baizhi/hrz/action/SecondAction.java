package com.baizhi.hrz.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.baizhi.hrz.entity.Book;
import com.baizhi.hrz.entity.Category;
import com.baizhi.hrz.service.BookService;
import com.baizhi.hrz.service.CategoryService;
import com.baizhi.hrz.serviceImpl.BookServiceImpl;
import com.baizhi.hrz.serviceImpl.CategoryServiceImpl;

public class SecondAction {
	private CategoryService cs=new CategoryServiceImpl();
	private BookService bs=new BookServiceImpl();
	//一级类别或是二级类别。展示书籍信息时，传入的数据
	private String fid;
	private String sid;
	private int currentPage;
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	public String secondJsp(){
		Category category = cs.queryfirstCategory(fid);
		ServletActionContext.getRequest().setAttribute("category",category);
		//查询图书
		List<Book> list = bs.querySecondBook(fid, sid, currentPage);
		ServletActionContext.getRequest().setAttribute("list",list);
		
		return "second";
	}

}
