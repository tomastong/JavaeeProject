package cn.sims.dao.impl;

import java.util.List;


import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.sims.dao.PostDao;
import cn.sims.domain.Post;
import cn.sims.tool.PageModel;

public class PostDaoImpl extends HibernateDaoSupport implements PostDao {

	@Override
	public boolean delete(int id) {
		try {
			Post p = (Post) this.getHibernateTemplate().load(
					Post.class, id);
			this.getHibernateTemplate().delete(p);
		} catch (Exception e) {
			System.out.println("PostDao实现层：delete方法：" + e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public List<Post> findAll() {
		List<Post> list;
		try {
			list = this.getHibernateTemplate().find("");
		} catch (Exception e) {
			System.out.println("PostDao实现层：findAll方法：" + e.getMessage());
			return null;
		}
		return list;
	}

	@Override
	public PageModel findAll(int pageNo, int pageSize, String queryStr) {
		return null;
	}

	@Override
	public boolean insert(Post post) {
		try {
			this.getHibernateTemplate().save(post);
		} catch (Exception e) {
			System.out.println("PostDao实现层：insert方法：" + e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public Post query(int id) {
		return (Post) this.getHibernateTemplate().load(Post.class, id);

		}

	@Override
	public boolean update(Post post) {
		try {
			this.getHibernateTemplate().update(post);
		} catch (Exception e) {
			System.out.println("PostDao实现层：update方法：" + e.getMessage());
			return false;
		}
		return true;
	}

}
