package cn.itjava.service;

import java.util.List;

import cn.itjava.domain.News;
import cn.itjava.util.PageModel;

public interface NewsService {

	// 添加新闻
	public boolean addNews(News news);

	// 删除单个新闻
	public boolean delNews(int id);

	// 批量删除新闻
	public boolean delNews(int[] ids);

	// 更新新闻
	public boolean updNews(News news, int id);

	// 查询新闻
	public News queNews(int id);

	public List<News> getNewsList();

	// 返回分页模型
	public PageModel pageNews(String name, String str, int pageNo);
}
