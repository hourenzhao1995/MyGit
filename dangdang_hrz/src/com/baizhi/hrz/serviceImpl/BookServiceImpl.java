package com.baizhi.hrz.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.struts2.ServletActionContext;

import com.baizhi.hrz.dao.BookDao;
import com.baizhi.hrz.entity.Book;
import com.baizhi.hrz.entity.Category;
import com.baizhi.hrz.service.BookService;
import com.baizhi.hrz.util.MyBatisUtil;

public class BookServiceImpl implements BookService{

	//根据条件模糊查询书籍信息
	/*@Override
	public List<Book> selectByKey(String key, String content) {
		BookDao bd = (BookDao) MyBatisUtil.getMapper(BookDao.class);
		List<Book> byKey = bd.selectByKey(key, content);
		//关闭资源
		MyBatisUtil.close();
		return byKey;
	}*/

	//private	BookDao bd = (BookDao) MyBatisUtil.getMapper(BookDao.class);
	@Override
	public List<Book> queryAllBook() {
		BookDao bd = (BookDao) MyBatisUtil.getMapper(BookDao.class);
		return bd.selectAllBook();
	}
	@Override
	public void addBook(Book book) {
		BookDao bd = (BookDao) MyBatisUtil.getMapper(BookDao.class);
		//使用UUID充当id
		String id = UUID.randomUUID().toString();
		book.setId(id);
		book.setCreateDate(new Date());
		try {
			bd.addBook(book);
			MyBatisUtil.commit();
		} catch (Exception e) {
			e.printStackTrace();
			MyBatisUtil.rollback();
		}finally{
			MyBatisUtil.close();
		}
	}
	@Override
	public List<Book> queryBookBykey(String key,String content) {
		BookDao bd = (BookDao) MyBatisUtil.getMapper(BookDao.class);
		return bd.selectBookByKey(key,content);
	}
	@Override
	public void deleteBookBy(String id) {
		BookDao bd = (BookDao) MyBatisUtil.getMapper(BookDao.class);
		try {
			bd.deleteBook(id);
			MyBatisUtil.commit();
		} catch (Exception e) {
			e.printStackTrace();
			MyBatisUtil.rollback();
		}finally{
			MyBatisUtil.close();
		}
	}
	@Override
	public void updateBook(Book book) {
		BookDao bd = (BookDao) MyBatisUtil.getMapper(BookDao.class);
		try {
			bd.updateBook(book);
			MyBatisUtil.commit();
		} catch (Exception e) {
			e.printStackTrace();
			MyBatisUtil.rollback();
		}finally{
			MyBatisUtil.close();
		}
	}
	@Override
	public Book queryBookById(String id) {
		BookDao bd = (BookDao) MyBatisUtil.getMapper(BookDao.class);
		
		return bd.selectBookById(id);
		
	}
	

	/**
	 * 前台:展示
	 */
	//1、编辑推荐的图书
	@Override
	public List<Book> recommendBook() {
		BookDao bd = (BookDao) MyBatisUtil.getMapper(BookDao.class);
		//查询所有书籍
		List<Book> list = bd.selectAllBook();
		List<Book> recommendAllBook=new ArrayList<Book>();
		List<Book> recommendBook =new ArrayList<Book>();
		//遍历当前书籍的集合
		for (Book book : list) {
			if(!book.getEditorRecommend().equals("编辑没有推荐")){
				recommendAllBook.add(book);
			}
		}
		int a=(int)(Math.random()*recommendAllBook.size());
		int b=(int)(Math.random()*recommendAllBook.size());
		while(a==b){
			b=(int)(Math.random()*recommendAllBook.size());
		}
		recommendBook.add(recommendAllBook.get(a));
		recommendBook.add(recommendAllBook.get(b));
		return recommendBook;
		
	}
	
	//热卖书籍
	@Override
	public List<Book> hotBook() {
		BookDao bd = (BookDao) MyBatisUtil.getMapper(BookDao.class);
		List<Book> list = bd.hotBook();
		return list;
	}
	
	//新书
	@Override
	public List<Book> newBook() {
		BookDao bd = (BookDao) MyBatisUtil.getMapper(BookDao.class);
		List<Book> list = bd.newBook();
		return list;
	}
	
	//新书热卖
	@Override
	public List<Book> newAndHotBook() {
		BookDao bd = (BookDao) MyBatisUtil.getMapper(BookDao.class);
		List<Book> list = bd.newAndHotBook();
		
		return list;
	}
	
	/**
	 * 前台：二级页面战展示图书信息
	 */
	
	@Override
	public List<Book> querySecondBook(String fid, String sid, int currentPage) {
		BookDao bd = (BookDao) MyBatisUtil.getMapper(BookDao.class);
		//图书总量
		Integer count = bd.totalCount(fid, sid);
		//总页数
		int totalPage=(count%3==0)?count/3:count/3+1;
		//当前页数
		//每页条数
		int a=3;
		//从哪儿查询
		int begin=(currentPage-1)*3+1;
		//到哪里结束
		int end=3*currentPage;
		ServletActionContext.getRequest().setAttribute("totalPage",totalPage);
		List<Book> list = bd.querySecondBook(fid, sid, begin, end);
		//关闭资源
		MyBatisUtil.close();
		return list;
	}
	
	


	


	

	
	
	
	
	

}




















