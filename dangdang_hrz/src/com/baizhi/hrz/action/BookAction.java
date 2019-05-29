package com.baizhi.hrz.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.baizhi.hrz.entity.Book;
import com.baizhi.hrz.entity.Category;
import com.baizhi.hrz.service.BookService;
import com.baizhi.hrz.service.CategoryService;
import com.baizhi.hrz.serviceImpl.BookServiceImpl;
import com.baizhi.hrz.serviceImpl.CategoryServiceImpl;

public class BookAction {
	private BookService bs = new BookServiceImpl();
	private Book book;
	private String key;
	private String content;
	private String id;//各种页面传入的id
	private File cover;
	private String coverFileName;
	
	
	public File getCover() {
		return cover;
	}
	public void setCover(File cover) {
		this.cover = cover;
	}
	public String getCoverFileName() {
		return coverFileName;
	}
	public void setCoverFileName(String coverFileName) {
		this.coverFileName = coverFileName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public BookService getBs() {
		return bs;
	} void setBs(BookService bs) {
		this.bs = bs;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
//从一级页面点击类别跳转到二级页面的参数，------一级类别id和 类别id
	private String fid;
	private String sid;
	private Map<String, Integer> bookCount;
	private Integer allCount; //一级分类的图书数量
	private List<Book> byIdAndPage;
	private Integer page;
	
	//查询所有的图书
	public String queryAllBook(){
		List<Book> list = bs.queryAllBook();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("list", list);
		return "success";
	}
	
	//查询二级类别
	public String querySeconds(){
		List<Category> list = seconds();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("seconds", list);
		return "success";
	}
	//添加书籍
	public String addBook() throws IOException{
		System.out.println("cover==="+cover);
		System.out.println("covername==="+coverFileName);
		System.out.println(book);
		
		String realPath = ServletActionContext.getServletContext().getRealPath("/back/img");
		File filePath = new File(realPath,coverFileName);
		if(!filePath.getParentFile().exists()){
			filePath.getParentFile().mkdir();
		}
		FileUtils.copyFile(cover, filePath);
		
		book.setCover(coverFileName);
		bs.addBook(book);
		return "success";
	}
	public String queryBookByKey(){
		List<Book> list = bs.queryBookBykey(key,content);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("list", list);
		return "success";
	}
	
	//通过id删除书籍
	public String removeBookById(){
		bs.deleteBookBy(id);
		return "success";
	}
	//这是点击修改按钮之后 先跳转的地方
	public String queryBookById(){
		List<Category> list = seconds();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("seconds", list);
		book = bs.queryBookById(id);
		return "success";
	}
	public String updateBook(){
		if(cover!=null){
			System.out.println("cover==="+cover);
			System.out.println("covername==="+coverFileName);
			System.out.println(book);
			
			String realPath = ServletActionContext.getServletContext().getRealPath("/back/img");
			File filePath = new File(realPath,coverFileName);
			if(!filePath.getParentFile().exists()){
				filePath.getParentFile().mkdir();
			}
			try {
				FileUtils.copyFile(cover, filePath);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		book.setCover(coverFileName);
		bs.updateBook(book);
		return "success";
	}
	
	//二级类别
	public static List<Category> seconds(){
		CategoryService cs = new CategoryServiceImpl();
		//List<Category> categorys = cs.showAll(); 需要修改
		List<Category> categorys = cs.queryAll();
		List<Category> list = new ArrayList<Category>();
		for (Category category : categorys) {
			if(category.getLevels() == 2){
				list.add(category);
			}
		}
		return list;
	}
	
	/**
	 * 点击图书的名字或者封面，跳转到图书详情页面
	 */
	public String Bookdetail(){
		Book bk = bs.queryBookById(id);
		ServletActionContext.getRequest().setAttribute("book", bk);
		
		return "success";
	}


}











































