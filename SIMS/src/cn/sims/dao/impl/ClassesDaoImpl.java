package cn.sims.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.sims.dao.ClassesDao;
import cn.sims.domain.Classes;

public class ClassesDaoImpl extends HibernateDaoSupport implements ClassesDao {

	@Override
	public boolean delete(int id) {
		try {
			Classes c = (Classes) this.getHibernateTemplate().load(
					Classes.class, id);
			this.getHibernateTemplate().delete(c);
		} catch (Exception e) {
			System.out.println("ClassesDao实现层：delete方法：" + e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public List<Classes> findAll() {
		List<Classes> list;
		try {
			list = this.getHibernateTemplate().find("select c from Classes c");
		} catch (Exception e) {
			System.out.println("ClassesDao实现层：findAll方法：" + e.getMessage());
			return null;
		}
		return list;
	}

	@Override
	public boolean insert(Classes classes) {
		try {
			this.getHibernateTemplate().save(classes);
		} catch (Exception e) {
			System.out.println("ClassesDao实现层：insert方法：" + e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public Classes query(int id) {
		return (Classes) this.getHibernateTemplate().load(Classes.class, id);

	}

	@Override
	public boolean update(Classes classes) {
		try {
			this.getHibernateTemplate().update(classes);
		} catch (Exception e) {
			System.out.println("ClassesDao实现层：update方法：" + e.getMessage());
			return false;
		}
		return true;
	}

}
