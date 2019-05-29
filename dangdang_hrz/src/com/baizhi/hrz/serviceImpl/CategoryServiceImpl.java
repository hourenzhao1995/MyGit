package com.baizhi.hrz.serviceImpl;

import java.util.List;
import java.util.UUID;

import com.baizhi.hrz.dao.BookDao;
import com.baizhi.hrz.dao.CategoryDao;
import com.baizhi.hrz.entity.Book;
import com.baizhi.hrz.entity.Category;
import com.baizhi.hrz.service.CategoryService;
import com.baizhi.hrz.util.MyBatisUtil;

public class CategoryServiceImpl implements CategoryService {

private CategoryDao cd = (CategoryDao) MyBatisUtil.getMapper(CategoryDao.class);
	
	/*//展示所有类别
	@Override
	public List<Category> showAll() {
		return cd.queryAll();
	}
	//添加一级类别
	@Override
	public void addfirst(Category cate) {
		//使用UUID充当category的id
		String id = UUID.randomUUID().toString();
		cate.setId(id);
		System.out.println(cate);
		try {
			cd.addCategory(cate);
			MyBatisUtil.commit();
		} catch (Exception e) {
			e.printStackTrace();
			MyBatisUtil.rollback();
		}finally{
			MyBatisUtil.close();
		}
	}
	//查询一级类别
	@Override
	public List<Category> showFirst() {
		return cd.queryFirst();
	}
	//添加二级类别
	@Override
	public void addSecond(Category cate) {
		//使用UUID充当category的id
		String id = UUID.randomUUID().toString();
		cate.setId(id);
		System.out.println(cate);
		try {
			cd.addSecond(cate);
			MyBatisUtil.commit();
		} catch (Exception e) {
			e.printStackTrace();
			MyBatisUtil.rollback();
		}finally{
			MyBatisUtil.close();
		}
	}
	//删除类别
	@Override
	public void delete(Category category) {
		BookDao bd = (BookDao) MyBatisUtil.getMapper(BookDao.class);
		System.out.println(category);
		if(category.getLevels() == 1){
			List<Category> list = cd.querySocend(category.getId());
			if(list.size() == 0){
				try {
					cd.delete(category.getId());
					MyBatisUtil.commit();
				} catch (Exception e) {
					e.printStackTrace();
					MyBatisUtil.rollback();
				}finally{
					MyBatisUtil.close();
				}
			}
		}else{
			List<Book> list = bd.selectBookByCategory_id(category.getId());
			if(list.size() == 0){
				try {
					cd.delete(category.getId());
					MyBatisUtil.commit();
				} catch (Exception e) {
					e.printStackTrace();
					MyBatisUtil.rollback();
				}finally{
					MyBatisUtil.close();
				}
			}
		}
	}*/
	
	//前台：查询所有类别
	
	@Override
	public List<Category> selectAllCategory() {
		List<Category> list = cd.selectAllCategory();
		MyBatisUtil.close();
		return list;
	}
	
	//二级页面显示
	@Override
	public Category queryfirstCategory(String id) {
		Category category = cd.queryfirstCategory(id);
		MyBatisUtil.close();
		return category;
	}

	/*后台：
	 */
	//查询所有
	@Override
	public List<Category> queryAll() {
		List<Category> list = cd.queryAll();
		MyBatisUtil.close();
		return list;
	}

	//添加一级类别
	@Override
	public void add(Category cate) {
		try {
			String id=UUID.randomUUID().toString();
			cate.setId(id);
			cd.add(cate);
			MyBatisUtil.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			MyBatisUtil.rollback();
		}
		
		
	}

	//查询所有的一级类别
	@Override
	public List<Category> selectFirst() {
		List<Category> list = cd.selectfirst();
		MyBatisUtil.close();
		return list;
	}

	//删除类别
	@Override
	public void delete(int levels, String id) {
		try {
			BookDao bd = (BookDao) MyBatisUtil.getMapper(BookDao.class);
			if(levels==1){
				List<Category> list = cd.selectSecond(id);
				if(list.size()==0){
					cd.delete(id);
				}
			}else{
				int aa=bd.queryBookByCateId(id);
				if(aa==0){
					cd.delete(id);
				}
			}
			MyBatisUtil.commit();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			MyBatisUtil.rollback();
		}
		
	}
	
}
