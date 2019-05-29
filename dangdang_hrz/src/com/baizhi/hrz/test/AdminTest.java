package com.baizhi.hrz.test;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Test;

import com.baizhi.hrz.dao.AdminDAO;
import com.baizhi.hrz.dao.BookDao;
import com.baizhi.hrz.dao.CategoryDao;
import com.baizhi.hrz.entity.Admin;
import com.baizhi.hrz.entity.Book;
import com.baizhi.hrz.entity.Category;
import com.baizhi.hrz.service.CategoryService;
import com.baizhi.hrz.serviceImpl.CategoryServiceImpl;
import com.baizhi.hrz.util.MyBatisUtil;

public class AdminTest {
	/*@Test
	public void login(){
		AdminDAO ad= (AdminDAO) MyBatisUtil.getMapper(AdminDAO.class);
		Admin admin = ad.selectByUserNameAndPassword("admin");
		System.out.println(admin.getUsername()+"---"+admin.getPassword());
		
	}
	
	@Test
	public void All(){
		CategoryDao cd = (CategoryDao) MyBatisUtil.getMapper(CategoryDao.class);
		List<Category> list = cd.queryAll();
		for (Category category : list) {
			System.out.println(category);
		}
		MyBatisUtil.close();
		
		
	}
	
	//添加数据
	@Test
	public void add(){
		CategoryDao cd = (CategoryDao) MyBatisUtil.getMapper(CategoryDao.class);
		String id = UUID.randomUUID().toString();
		Category cate=new Category();
		cate.setId(id);
		cate.setName("ttt");
		cate.setLevels(1);
		cd.add(cate);
		MyBatisUtil.commit();
	}
	
	@Test
	public void selectSecond(){
		CategoryDao cd = (CategoryDao) MyBatisUtil.getMapper(CategoryDao.class);
		List<Category> list = cd.selectSecondAll();
		for (Category category : list) {
			System.out.println(category);
			MyBatisUtil.close();
		}
	}
	
	
	//测试Service
	@Test
	public void selSS(){
		CategoryService cs=new CategoryServiceImpl();
		List<Category> list = cs.selectSecondAll();
		for (Category category : list) {
			System.out.println(category);
		}
	}
	
	@Test
	public void addBook(){
		BookDao bd = (BookDao) MyBatisUtil.getMapper(BookDao.class);
		Book book=new Book();
id=6070b8e9-88fe-4586-ad4d-caee204303f9, name=十里桃林, author=地方, 
 * cover=24157752-1_l_2.jpg, press=昆仑,
press_date=Thu Mar 07 00:00:00 CST 2019, edition=第一版,
 print_date=Thu Mar 14 00:00:00 CST 2019, impression=第一次, 
 isbn=300, word_num=232, page_num=3456, sizes=精装, paper=hhh, 
 pack=所属, price=234.0, dprice=44.0, create_date=Wed Mar 27 21:04:09 CST 2019, 
 editor_recommend=而且按我说的as, content_abstract=萨达, author_abstract=as啊,
  director=啊是山水大厦, media_commentary=阿斯如打发深Vva, 
  category_id=f0dbdcb6-1857-4063-8759-090265c217c4, sale=0, stock=546]	
		
		book.setId("132213");
		book.setName("ewqrwe");
		book.setAuthor("暗色调");
		book.setCover("24157752-1_l_2.jpg"); 
		book.setPress("坤");					
		book.setPress_date(new Date()); 
		book.setEdition("1");				
		book.setPrint_date(new Date());  
		book.setImpression("1ci");
		book.setIsbn("300");
		book.setWord_num(200);
		book.setPage_num(47347);
		book.setSizes("精装");
		book.setPaper("ddd");
		book.setPack("ssss");
		book.setPrice(34.0);
		book.setDprice(33.0);
		book.setCreate_date(new Date());
		book.setEditor_recommend("idhnfhj");
		book.setContent_abstract("dfas所属");
		book.setAuthor_abstract("sdsa");
		book.setDirector("ssss");
		book.setMedia_commentary("wwww");
		book.setCategory_id(UUID.randomUUID().toString());
		book.setSale(0);
		book.setStock(444);
		
		bd.addBook(book);
		MyBatisUtil.commit();
		
	}
	
	@Test
	public void UPDATE(){
		BookDao bd = (BookDao) MyBatisUtil.getMapper(BookDao.class);
		Book book=new Book();
		book.setId("132213");
		book.setName("ewqrwe");
		book.setAuthor("暗色调");
		book.setCover("24157752-1_l_2.jpg"); 
		book.setPress("坤");					
		book.setPress_date(new Date()); 
		book.setEdition("1");				
		book.setPrint_date(new Date());  
		book.setImpression("1ci");
		book.setIsbn("300");
		book.setWord_num(200);
		book.setPage_num(47347);
		book.setSizes("精装");
		book.setPaper("ddd");
		book.setPack("ssss");
		book.setPrice(34.0);
		book.setDprice(33.0);
		book.setCreate_date(new Date());
		book.setEditor_recommend("idhnfhj");
		book.setContent_abstract("dfas所属");
		book.setAuthor_abstract("sdsa");
		book.setDirector("ssss");
		book.setMedia_commentary("wwww");
		book.setCategory_id(UUID.randomUUID().toString());
		book.setSale(0);
		book.setStock(444);
		bd.updateBook(book);
		
		MyBatisUtil.commit();
	}
*/
}
