package cn.sims.services;

import java.util.List;

import cn.sims.domain.Post;
import cn.sims.tool.PageModel;

public interface PostService {

	// 增加帖子
	public boolean add(Post post);

	// 删除
	public boolean del(int id);

	// 更新
	public boolean modify(Post post);

	// 根据id查询
	public Post find(int id);

	// 查询所有
	public List<Post> findAll();

	// 分页
	public PageModel findAll(int pageNo, int pageSize, String queryStr);

}
