package cn.itjava.junit;

import org.junit.Test;

import cn.itjava.dao.NewsDao;
import cn.itjava.dao.impl.NewsDaoImpl;
import cn.itjava.domain.News;

public class NewsOperatorTest {
	/*@Test
	public void add(){
		News news = new News();
		news.setTitle("junit test");
		news.setAuthor("zhangsan");
		news.setContent("about today's add news test");
		
		NewsDao newsdao = new NewsDaoImpl();
		boolean flag = newsdao.addNews(news);
		System.out.println(flag);
	}*/

	/*@Test
	public void del(){
		
		NewsDao newsdao = new NewsDaoImpl();
		boolean flag = newsdao.deleteNews(2);
		System.out.println(flag);
	}*/
	/*@Test
	public void del(int[] arr){
		
		NewsDao newsdao = new NewsDaoImpl();
		int[] ids = new int[]{1,2}; 
		boolean flag = newsdao.deleteNews(ids);
		System.out.println(flag);
	}*/
/*	@Test
	public void query(){
		
		NewsDao newsdao = new NewsDaoImpl();
		News news = newsdao.queryNews(2);
		System.out.println(news.getTitle());
		System.out.println(news.getAuthor());
		System.out.println(news.getContent());
		
	}
*//*	@Test
	public void update(){
		News news = new News();
		news.setTitle("junit");
		news.setAuthor("zhangsan");
		news.setContent("today's add news test");
		
		NewsDao newsdao = new NewsDaoImpl();
		boolean flag = newsdao.updateNews(news, 2);
		System.out.println(flag);
		
	}
*/}
