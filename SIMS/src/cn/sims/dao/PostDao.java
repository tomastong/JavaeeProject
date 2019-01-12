package cn.sims.dao;

import java.util.List;

import cn.sims.domain.Post;
import cn.sims.tool.PageModel;

public interface PostDao {

	
	// 帖子的增删改查 //////////////////////////////////////////

	/**
	 * 增加帖子
	 * @param  post 帖子对象
	 * @return
	 */
	public boolean insert(Post post);

	/**
	 * 删除
	 * @param id 帖子id
	 * @return
	 */
	public boolean delete(int id);

	/**
	 * 更新
	 * @param post 帖子对象
	 * @return
	 */
	public boolean update(Post post);

	/**
	 * 根据id查询
	 * @param id 帖子id
	 * @return
	 */
	public Post query(int id);

	/**
	 * 查询所有
	 * @return
	 */
	public List<Post> findAll();

	/**
	 * 分页
	 */
	public PageModel findAll(int pageNo, int pageSize, String queryStr);

}
