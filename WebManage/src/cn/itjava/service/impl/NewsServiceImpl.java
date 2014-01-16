package cn.itjava.service.impl;

import java.util.List;

import cn.itjava.dao.NewsDao;
import cn.itjava.dao.impl.NewsDaoImpl;
import cn.itjava.domain.News;
import cn.itjava.service.NewsService;
import cn.itjava.util.PageModel;

public class NewsServiceImpl implements NewsService {

	@Override
	public boolean addNews(News news) {
		boolean flag = newsDao.addNews(news);
		return flag;
	}

	@Override
	public boolean delNews(int id) {
		boolean flag = newsDao.deleteNews(id);
		return flag;
	}

	@Override
	public boolean delNews(int[] ids) {
		boolean flag = newsDao.deleteNews(ids);
		return flag;
	}

	@Override
	public boolean updNews(News news, int id) {
		boolean flag = newsDao.updateNews(news, id);
		return flag;
	}

	@Override
	public News queNews(int id) {
		return newsDao.queryNews(id);
	}

	@Override
	public PageModel pageNews(String name, String str, int pageNo) {
		return newsDao.pageQueryNews(name, str, pageNo);
	}

	@Override
	public List<News> getNewsList() {
		return newsDao.getNewsList();
	}
	
	private NewsDao newsDao = new NewsDaoImpl();
}
