package cn.sims.tool;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

// 这里文件时进行提供单元测试使用
public final class HibernateTool {
	
	static{
		Configuration cfg = new Configuration().configure();
		factory = cfg.buildSessionFactory();
	}
	
	public static SessionFactory getSessionFactory(){
		return factory;
	}
	
	public static Session getSession(){
		return factory.openSession();
	}
	
	public static void closeSession(Session session){
		if(session!=null && session.isOpen()){
			session.close();
		}
	}
	
	private static SessionFactory factory;
}
