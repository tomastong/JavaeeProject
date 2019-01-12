package cn.sims.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.sims.dao.GradeDao;
import cn.sims.domain.Grade;

public class GradeDaoImpl extends HibernateDaoSupport implements GradeDao {

	@Override
	public boolean delete(int id) {
		try {
			Grade g = (Grade) this.getHibernateTemplate().load(Grade.class, id);
			this.getHibernateTemplate().delete(g);
		} catch (Exception e) {
			System.out.println("GradeDaoʵ�ֲ㣺delete������" + e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public List<Grade> findAll() {
		List<Grade> list;
		try {
			list = this.getHibernateTemplate().find("select g from Grade g");
		} catch (Exception e) {
			System.out.println("GradeDaoʵ�ֲ㣺findAll������" + e.getMessage());
			return null;
		}
		return list;
	}

	@Override
	public boolean insert(Grade grade) {
		try {
			this.getHibernateTemplate().save(grade);
		} catch (Exception e) {
			System.out.println("GradeDaoʵ�ֲ㣺insert������" + e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public Grade query(int id) {
		return (Grade) this.getHibernateTemplate().load(Grade.class, id);

	}

	@Override
	public boolean update(Grade grade) {
		try {
			this.getHibernateTemplate().update(grade);
		} catch (Exception e) {
			System.out.println("GradeDaoʵ�ֲ㣺update������" + e.getMessage());
			return false;
		}
		return true;
	}
}
