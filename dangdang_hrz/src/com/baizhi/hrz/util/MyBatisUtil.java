package com.baizhi.hrz.util;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * MyBatis的工具类
 * @author lenovo
 * 作用：减少冗余代码，简便开发，提高效率。
 *
 */
public class MyBatisUtil {
	private static SqlSessionFactory ssf=null;
	//线程绑定对象
	private static ThreadLocal<SqlSession> tl=new ThreadLocal<SqlSession>();
	static{
		try {
			//1、读取Mybatis运行参数Resources
			InputStream is=Resources.getResourceAsStream("mybatis-config.xml");
			//2、构建SqlSession工厂对象
			ssf = new SqlSessionFactoryBuilder().build(is);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//获取连接对象SqlSession
		public static SqlSession  openSession(){
			//3、创建SqlSession对象
			//获取线程中的SqlSession对象
			SqlSession ss = tl.get();
			//如果没有
			if(ss==null){
				//新建一个 并且绑定到当前的线程中
				ss = ssf.openSession();
				tl.set(ss);
			}
			return ss;
		}
		
		//获取接口对应的实现类
		public static Object getMapper(Class clazz){
			return openSession().getMapper(clazz);
		}
		
		//获取SqlSession对象的方法 仅供测试缓存使用
		public static SqlSession getSqlSession(){
			return ssf.openSession();
		}
		
		//关闭资源 关闭sqlSesion对象资源 从当前线程中移除
		public static void close(){
			openSession().close();
			tl.remove();
		}
		//提交控制
		public static void commit(){
			 openSession().commit();
			 close();
		}
		//回滚事务
		public static void rollback(){
			 openSession().rollback();
			 close();
		}
	

}
