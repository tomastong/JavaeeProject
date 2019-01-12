package cn.sims.dao.impl;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.sims.dao.TeacherDao;
import cn.sims.domain.Teacher;
import cn.sims.tool.PageModel;

public class TeacherDaoImpl extends HibernateDaoSupport implements TeacherDao {

	@Override
	public boolean delete(int id) {
		try {
			Teacher t = (Teacher) this.getHibernateTemplate().load(
					Teacher.class, id);
			this.getHibernateTemplate().delete(t);
		} catch (Exception e) {
			System.out.println("TeacherDaoʵ�ֲ㣺delete������" + e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public List<Teacher> findAll() {
		List<Teacher> list;
		try {
			list = this.getHibernateTemplate().find("select t from Teacher t");
		} catch (Exception e) {
			System.out.println("TeacherDaoʵ�ֲ㣺findAll������" + e.getMessage());
			return null;
		}
		return list;
	}

	@Override
	public boolean insert(Teacher teacher) {
		try {
			this.getHibernateTemplate().save(teacher);
		} catch (Exception e) {
			System.out.println("TeacherDaoʵ�ֲ㣺insert������" + e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public Teacher login(String username, String password) {
		Teacher teacher = null; 
		try {
			teacher = (Teacher) this
					.getHibernateTemplate()
					.find(
							"select t from Teacher t where t.jobNum=? and t.password=?",
							new String[] { username, password }).get(0);
		} catch (Exception e) {
			return null;
		}
		return teacher;
	}

	@Override
	public Teacher query(int id) {
		return (Teacher) this.getHibernateTemplate().load(Teacher.class, id);

	}

	@Override
	public boolean update(Teacher teacher) {
		try {
			this.getHibernateTemplate().update(teacher);
		} catch (Exception e) {
			System.out.println("TeacherDaoʵ�ֲ㣺update������" + e.getMessage());
			return false;
		}
		return true;
	}

}
