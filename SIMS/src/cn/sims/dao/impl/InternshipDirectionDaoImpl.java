package cn.sims.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.sims.dao.InternshipDirectionDao;
import cn.sims.domain.Classes;
import cn.sims.domain.InternshipDirection;
import cn.sims.tool.PageModel;

public class InternshipDirectionDaoImpl extends HibernateDaoSupport implements
		InternshipDirectionDao {

	@Override
	public boolean delete(int id) {
		try {
			InternshipDirection i = (InternshipDirection) this
					.getHibernateTemplate().load(InternshipDirection.class, id);
			this.getHibernateTemplate().delete(i);
		} catch (Exception e) {
			System.out.println("InternshipDirectionDao实现层：delete方法："
					+ e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean insert(InternshipDirection internshipDirection) {
		try {
			this.getHibernateTemplate().save(internshipDirection);
		} catch (Exception e) {
			System.out.println("InternshipDirectionDao实现层：insert方法："
					+ e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public InternshipDirection query(int id) {
		return (InternshipDirection) this.getHibernateTemplate().load(
				InternshipDirection.class, id);

	}

	@Override
	public boolean update(InternshipDirection internshipDirection) {
		try {
			this.getHibernateTemplate().update(internshipDirection);
		} catch (Exception e) {
			System.out.println("InternshipDirectionDao实现层：update方法："
					+ e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public PageModel findInternshipDirectionAll(final int pageNo,
			final int pageSize, final String queryStr) {
		PageModel pageModel = null;
		List shixiList = null;

		if (queryStr != null && queryStr.trim().length() != 0) {
			shixiList = this.getHibernateTemplate().executeFind(
					new HibernateCallback() {

						@Override
						public Object doInHibernate(Session session)
								throws HibernateException, SQLException {
							return session
									.createQuery(
											"select s from Student s inner join s.internshipDirection isd where isd.type = ?")
									.setParameter(0, queryStr)
									.setFirstResult((pageNo - 1) * pageSize)
									.setMaxResults(pageSize).list();
						}
					});
		} else {
			shixiList = this.getHibernateTemplate().executeFind(
					new HibernateCallback() {

						@Override
						public Object doInHibernate(Session session)
								throws HibernateException, SQLException {
							return session
									.createQuery(
											"select s from Student s inner join s.internshipDirection isd")
									.setFirstResult((pageNo - 1) * pageSize)
									.setMaxResults(pageSize).list();
						}
					});
		}

		pageModel = new PageModel();
		pageModel.setList(shixiList);
		pageModel.setPageNo(pageNo);
		pageModel.setPageSize(pageSize);
		pageModel.setTotalRecords(getTotalRecords(queryStr));
		return pageModel;
	}

	public int getTotalRecords(String queryStr) {
		Long count = null;
		if (queryStr != null && queryStr.trim().length() != 0) {
			count = (Long) this
					.getHibernateTemplate()
					.find("select s from Student s inner join s.internshipDirection isd where isd.type = ?",
							new String[] { queryStr }).get(0);

		} else {
			count = (Long) this
					.getHibernateTemplate()
					.find("select count(*) from Student s inner join s.internshipDirection isd")
					.get(0);
		}
		return count.intValue();
	}

}
