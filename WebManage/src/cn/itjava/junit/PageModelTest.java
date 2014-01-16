package cn.itjava.junit;

import java.util.List;

import org.junit.Test;

import cn.itjava.domain.News;
import cn.itjava.service.NewsService;
import cn.itjava.service.impl.NewsServiceImpl;
import cn.itjava.util.PageModel;

public class PageModelTest {
	
	@Test
	public void pageTest(){
		NewsService newsService = new NewsServiceImpl();
		PageModel model = newsService.pageNews("","",3);
		List<News> list = model.getList();
		for(News news :list){
			System.out.println(news.getTitle()+news.getAuthor());
		}
	}
}
