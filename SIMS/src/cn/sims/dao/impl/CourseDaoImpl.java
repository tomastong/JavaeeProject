package cn.sims.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.sims.dao.CourseDao;
import cn.sims.domain.Classes;
import cn.sims.domain.Course;

public class CourseDaoImpl extends HibernateDaoSupport implements CourseDao {

	@Override
	public boolean delete(int id) {
		try {
			Course c = (Course) this.getHibernateTemplate().load(
					Course.class, id);
			this.getHibernateTemplate().delete(c);
		} catch (Exception e) {
			System.out.println("CourseDaoʵ�ֲ㣺delete������" + e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public List<Course> findAll() {
		List<Course> list;
		try {
			list = this.getHibernateTemplate().find("");
		} catch (Exception e) {
			System.out.println("CourseDaoʵ�ֲ㣺findAll������" + e.getMessage());
			return null;
		}
		return list;
	}

	@Override
	public boolean insert(Course course) {
		try {
			this.getHibernateTemplate().save(course);
		} catch (Exception e) {
			System.out.println("CourseDaoʵ�ֲ㣺insert������" + e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public Course query(int id) {
		return (Course) this.getHibernateTemplate().load(Course.class, id);

		}

	@Override
	public boolean update(Course course) {
		try {
			this.getHibernateTemplate().update(course);
		} catch (Exception e) {
			System.out.println("CourseDaoʵ�ֲ㣺update������" + e.getMessage());
			return false;
		}
		return true;
	}

}
