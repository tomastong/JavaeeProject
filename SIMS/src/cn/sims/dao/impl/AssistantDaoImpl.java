package cn.sims.dao.impl;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.sims.dao.AssistantDao;
import cn.sims.dao.DirectionDao;
import cn.sims.dao.InformDao;
import cn.sims.dao.InternshipDirectionDao;
import cn.sims.dao.ZhouJiDao;
import cn.sims.domain.Assistant;
import cn.sims.domain.Direction;
import cn.sims.domain.Inform;
import cn.sims.domain.InternshipDirection;
import cn.sims.domain.ZhouJi;
import cn.sims.tool.PageModel;

public class AssistantDaoImpl extends HibernateDaoSupport implements
		AssistantDao {

	@Override
	public boolean delete(int id) {
		try {
			Assistant assistant = (Assistant) this.getHibernateTemplate().load(
					Assistant.class, id);
			this.getHibernateTemplate().delete(assistant);
		} catch (Exception e) {
			System.out.println("AssistantDao实现层：delete方法：" + e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public List<Assistant> findAll() {
		List<Assistant> list;
		try {
			list = this.getHibernateTemplate().find("select a from Assistant a");
		} catch (Exception e) {
			System.out.println("AssistantDao实现层：findAll方法：" + e.getMessage());
			return null;
		}
		return list;
	}

	@Override
	public boolean insert(Assistant assistant) {
		try {
			this.getHibernateTemplate().save(assistant);
		} catch (Exception e) {
			System.out.println("AssistantDao实现层：insert方法：" + e.getMessage());
			return false;
		}
		return true;
	}


	@Override
	public Assistant login(String username, String password) {
		Assistant assistant = null;
		try {
			assistant = (Assistant) this
					.getHibernateTemplate()
					.find(
							"select a from Assistant a where a.jobNum=? and a.password=?",
							new String[] { username, password }).get(0);
		} catch (Exception e) {
			return null;
		}
		return assistant;
	}

	@Override
	public Assistant query(int id) {
		return (Assistant) this.getHibernateTemplate()
				.load(Assistant.class, id);

	}

	@Override
	public boolean update(Assistant assistant) {
		try {
			this.getHibernateTemplate().update(assistant);
		} catch (Exception e) {
			System.out.println("AssistantDao实现层：update方法：" + e.getMessage());
			return false;
		}
		return true;
	}
	
}
