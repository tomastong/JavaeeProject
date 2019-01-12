package cn.sims.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.sims.dao.ZhouJiDao;
import cn.sims.domain.Grade;
import cn.sims.domain.Student;
import cn.sims.domain.ZhouJi;
import cn.sims.tool.PageModel;

public class ZhouJiDaoImpl extends HibernateDaoSupport implements ZhouJiDao {

	@Override
	public boolean delete(int id) {
		try {
			ZhouJi zj = (ZhouJi) this.getHibernateTemplate().load(ZhouJi.class,
					id);
			this.getHibernateTemplate().delete(zj);
		} catch (Exception e) {
			System.out.println("ZhouJiDao实现层：delete方法：" + e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public List<ZhouJi> findOwnAll(Student student) {
		List<ZhouJi> list;
		try {
			list = this
					.getHibernateTemplate()
					.find("select zj from ZhouJi zj inner join zj.student s where s.sno = ?",
							new String[] { student.getSno() });
		} catch (Exception e) {
			System.out.println("ZhouJiDao实现层：findOwnAll方法：" + e.getMessage());
			return null;
		}
		return list;

	}

	@Override
	public boolean insert(ZhouJi zhouji) {
		try {
			this.getHibernateTemplate().save(zhouji);
		} catch (Exception e) {
			System.out.println("ZhouJiDao实现层：insert方法：" + e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public ZhouJi query(int id) {
		return (ZhouJi) this.getHibernateTemplate().load(ZhouJi.class, id);

	}

	@Override
	public boolean update(ZhouJi zhouji) {
		try {
			this.getHibernateTemplate().update(zhouji);
		} catch (Exception e) {
			System.out.println("ZhouJiDao实现层：update方法：" + e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public PageModel findAll(final int pageNo, final int pageSize,
			final String queryStr ,final Grade grade) {
		PageModel pageModel = null;
		List<ZhouJi> zjList = null;
		if (queryStr != null && queryStr.trim().length() != 0) {
			zjList = this.getHibernateTemplate().executeFind(
					new HibernateCallback() {

						@Override
						public Object doInHibernate(Session session)
								throws HibernateException, SQLException {
							return session
									.createQuery(
											"select zj from ZhouJi zj inner join zj.student s inner join s.grade g where zj.status = ? and g.id=?")
									.setParameter(0, Integer.parseInt(queryStr))
									.setParameter(1, grade.getId())
									.setFirstResult((pageNo - 1) * pageSize)
									.setMaxResults(pageSize).list();
						}
					});
		} else {
			zjList = this.getHibernateTemplate().executeFind(
					new HibernateCallback() {

						@Override
						public Object doInHibernate(Session session)
								throws HibernateException, SQLException {
							return session
									.createQuery(
											"select zj from ZhouJi zj inner join zj.student s inner join s.grade g where zj.status != 1  and g.id=?")
									.setParameter(0, grade.getId())
									.setFirstResult((pageNo - 1) * pageSize)
									.setMaxResults(pageSize).list();
						}
					});
		}
		
		for(ZhouJi zj: zjList){
			System.out.println("学生：年级"+zj.getStudent().getGrade().getName());
		}
		pageModel = new PageModel();
		pageModel.setList(zjList);
		pageModel.setPageNo(pageNo);
		pageModel.setPageSize(pageSize);
		pageModel.setTotalRecords(getTotalRecords(queryStr, grade));
		return pageModel;
	}

	public int getTotalRecords(String queryStr, Grade grade) {
		Long count = null;
		if (queryStr != null && queryStr.trim().length() != 0) {
			count = (Long) this
					.getHibernateTemplate()
					.find("select count(*) from ZhouJi zj inner join zj.student s inner join s.grade g where zj.status = ? and g.id=?",
							new Integer[] { Integer.parseInt(queryStr), grade.getId() })
					.get(0);
		} else {
			count = (Long) this
					.getHibernateTemplate()
					.find("select count(*) from ZhouJi zj inner join zj.student s inner join s.grade g where zj.status != 1  and g.id=?",
							new Integer[] { grade.getId() })
					.get(0);
		}
		return count.intValue();
	}

}
