package com.baizhi.hrz.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.hrz.entity.Book;
import com.baizhi.hrz.entity.Category;

public interface BookDao {
	//通过id查询一本书籍
	public int queryBookByCateId(String id);
	////////////////////////////////////////////////
	//根据类别id查询  1.在删除类别时会用到
		public List<Book> selectBookByCategory_id(String id);
		//查询所有
		public List<Book> selectAllBook();
		//添加书籍
		public void addBook(Book book);
		//根据id查询书籍
		public Book selectBookById(String id);
		//修改图书
		public void updateBook(Book book);
		//删除图书
		public void deleteBook(String id);
		//根据关键字搜索图书
		public List<Book> selectBookByKey(@Param("key")String key,@Param("content")String content);
		
		/*前台:
		 */
		//1、编辑推荐
		public List<Book> remomendBook();
		
		//2、热销图书
		public List<Book> hotBook();
		
		//3、最新上架图书
		public List<Book> newBook();
		
		//4、新书热卖
		public List<Book> newAndHotBook();
		
		//5、二级页面集合
		public List<Book> querySecondBook(@Param("fid")String fid,@Param("sid")String sid,@Param("begin")int begin,@Param("end")int end);
		
		//6、查询某个类别写的图书总条数
		public Integer totalCount(@Param("fid")String fid,@Param("sid")String sid);
	
	
		public void updateBookSaleAndStock(@Param(value="id")String id,@Param(value="count")int count);
	
	
	
}




























