package cn.itjava.dao;

import java.util.List;

import cn.itjava.domain.News;
import cn.itjava.util.PageModel;

public interface NewsDao {
	// 添加新闻
	public boolean addNews(News news);

	// 删除单个新闻
	public boolean deleteNews(int id);

	// 批量删除新闻
	public boolean deleteNews(int[] ids);

	// 更新新闻
	public boolean updateNews(News news, int id);

	// 查询新闻
	public News queryNews(int id);

	// 返回分页模型
	public PageModel pageQueryNews(String name, String str, int pageNo);
	
	public List<News> getNewsList();
}
