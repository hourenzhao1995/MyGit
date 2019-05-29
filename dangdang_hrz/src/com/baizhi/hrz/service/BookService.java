package com.baizhi.hrz.service;

import java.util.List;

import com.baizhi.hrz.entity.Book;
import com.baizhi.hrz.entity.Category;

public interface BookService {
	//展示所有
		public List<Book> queryAllBook();
		//添加书籍
		public void addBook(Book book);
		
		//模糊查询
		public List<Book> queryBookBykey(String key,String content);
		//删除图书
		public void deleteBookBy(String id);
		//修改图书
		public void updateBook(Book book);
		//通过id查询书籍
		public Book queryBookById(String id);
		
		/**
		 * 前台:查询图书，并显示
		 */
		//1、编辑推荐图书
		public List<Book> recommendBook();
		
		//2、热卖图书
		public List<Book> hotBook();
		
		//3、新书上架
		public List<Book> newBook();
		
		//4、新书热卖
		public List<Book> newAndHotBook();
		
		//5、
		public List<Book> querySecondBook(String fid,String sid,int currentPage);
	
}








































