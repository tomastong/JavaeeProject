package cn.sims.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.sims.dao.ResourcesDao;
import cn.sims.domain.Classes;
import cn.sims.domain.Resources;

public class ResourcesDaoImpl extends HibernateDaoSupport implements ResourcesDao {

	@Override
	public boolean delete(int id) {
		try {
			Resources c = (Resources) this.getHibernateTemplate().load(
					Resources.class, id);
			this.getHibernateTemplate().delete(c);
		} catch (Exception e) {
			System.out.println("ResourcesDao实现层：delete方法：" + e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public List<Resources> findAll() {
		List<Resources> list;
		try {
			list = this.getHibernateTemplate().find("select r from Resources r");
		} catch (Exception e) {
			System.out.println("ResourcesDao实现层：findAll方法：" + e.getMessage());
			return null;
		}
		return list;
	}

	@Override
	public boolean insert(Resources resources) {
		try {
			this.getHibernateTemplate().save(resources);
		} catch (Exception e) {
			System.out.println("ResourcesDao实现层：insert方法：" + e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public Resources query(int id) {
		return (Resources) this.getHibernateTemplate().load(Resources.class, id);

		}

	@Override
	public boolean update(Resources resources) {
		try {
			this.getHibernateTemplate().update(resources);
		} catch (Exception e) {
			System.out.println("ResourcesDao实现层：update方法：" + e.getMessage());
			return false;
		}
		return true;
	}

}
