package cn.sims.services.impl;

import java.util.List;

import cn.sims.dao.PostDao;
import cn.sims.domain.Post;
import cn.sims.services.PostService;
import cn.sims.tool.PageModel;

public class PostServiceImpl implements PostService {

	@Override
	public boolean add(Post post) {
		return postDao.insert(post);
	}

	@Override
	public boolean del(int id) {
		return postDao.delete(id);
	}

	@Override
	public boolean modify(Post post) {
		return postDao.update(post);
	}

	@Override
	public Post find(int id) {
		return postDao.query(id);
	}

	@Override
	public List<Post> findAll() {
		return postDao.findAll();
	}

	@Override
	public PageModel findAll(int pageNo, int pageSize, String queryStr) {
		return postDao.findAll(pageNo, pageSize, queryStr);
	}

////////////////////////////////////////////////////////////////////////////////
	
	public PostDao getPostDao() {
		return postDao;
	}

	public void setPostDao(PostDao postDao) {
		this.postDao = postDao;
	}



	/**
	 * 通知Dao的引用
	 */
	private PostDao postDao;

}
