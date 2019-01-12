package cn.sims.dao.impl;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.sims.dao.AdminDao;
import cn.sims.dao.AssistantDao;
import cn.sims.dao.StudentDao;
import cn.sims.dao.TeacherDao;
import cn.sims.dao.TimeDao;
import cn.sims.domain.Admin;
import cn.sims.domain.Assistant;
import cn.sims.domain.Student;
import cn.sims.domain.Teacher;
import cn.sims.domain.Time;
import cn.sims.tool.PageModel;

public class AdminDaoImpl extends HibernateDaoSupport implements AdminDao {

	@Override
	public Admin login(String username, String password) {
		Admin admin = null; 
		try {
			admin = (Admin) this
					.getHibernateTemplate()
					.find(
							"select a from Admin a where a.username=? and a.password=?",
							new String[] { username, password }).get(0);
		} catch (Exception e) {
			return null;
		}
		return admin;
	}
	
	@Override
	public Admin findAdmin(int id) {
		return (Admin)this.getHibernateTemplate().load(Admin.class, id);
	}


	@Override
	public boolean update(Admin admin) {
		try {
			this.getHibernateTemplate().update(admin);
		} catch (Exception e) {
			System.out.println("AdminDao实现层：update方法：" + e.getMessage());
			return false;
		}
		return true;
	}


}
