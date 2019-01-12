package cn.sims.dao.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.sims.dao.DirectionDao;
import cn.sims.dao.InternshipDirectionDao;
import cn.sims.dao.StudentDao;
import cn.sims.dao.TimeDao;
import cn.sims.domain.Direction;
import cn.sims.domain.Grade;
import cn.sims.domain.InternshipDirection;
import cn.sims.domain.Student;
import cn.sims.tool.PageModel;

public class StudentDaoImpl extends HibernateDaoSupport implements StudentDao {

	@Override
	public boolean delete(int id) {
		try {
			Student s = (Student) this.getHibernateTemplate().load(
					Student.class, id);
			this.getHibernateTemplate().delete(s);
		} catch (Exception e) {
			System.out.println("StudentDao实现层：delete方法：" + e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public List<Student> findAll() {
		List<Student> list;
		try {
			list = this.getHibernateTemplate().find("select s from Student s order by s.id");
		} catch (Exception e) {
			System.out.println("StudentDao实现层：findAll方法：" + e.getMessage());
			return null;
		}
		return list;
	}

	@Override
	public boolean insert(Student student) {
		try {
			this.getHibernateTemplate().save(student);
		} catch (Exception e) {
			System.out.println("StudentDao实现层：insert方法：" + e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public Student login(String username, String password) {
		Student student = null;
		try {
			student = (Student) this
					.getHibernateTemplate()
					.find("select s from Student s where s.sno=? and s.password=?",
							new String[] { username, password }).get(0);
		} catch (Exception e) {
			return null;
		}
		return student;
	}

	@Override
	public Student query(int id) {
		return (Student) this.getHibernateTemplate().load(Student.class, id);
	}

	@Override
	public boolean update(Student student) {
		try {
			this.getHibernateTemplate().update(student);
		} catch (Exception e) {
			System.out.println("StudentDao实现层：update方法：" + e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public PageModel findAll(final int pageNo, final int pageSize,
			final String queryStr, final Grade grade) {
		PageModel pageModel = null;
		List studentList = null;
		if ("shixi".equals(queryStr)) {
			studentList = this.getHibernateTemplate().executeFind(
					new HibernateCallback() {
						
						@Override
						public Object doInHibernate(Session session)
								throws HibernateException, SQLException {
							return session
									.createQuery(
											" select s from Student s inner join s.internshipDirection i inner join s.grade g where g.id=? and i.status=0 order by s.id ")
											.setParameter(0, grade.getId())
											.setFirstResult((pageNo - 1) * pageSize)
											.setMaxResults(pageSize).list();
						}
					});
		} else if ("shixihistory".equals(queryStr)) {
			studentList = this.getHibernateTemplate().executeFind(
					new HibernateCallback() {
						
						@Override
						public Object doInHibernate(Session session)
								throws HibernateException, SQLException {
							return session
									.createQuery(
											" select s from Student s inner join s.internshipDirection i inner join s.grade g where g.id=? and i.status!=0 order by s.id ")
											.setParameter(0, grade.getId())
											.setFirstResult((pageNo - 1) * pageSize)
											.setMaxResults(pageSize).list();
						}
					});
		} else if ("shixun".equals(queryStr)) {
			studentList = this.getHibernateTemplate().executeFind(
					new HibernateCallback() {
						
						@Override
						public Object doInHibernate(Session session)
								throws HibernateException, SQLException {
							return session
									.createQuery(
											" select s from Student s inner join s.direction d inner join s.grade g where g.id=? and d.id!=null order by s.id ")
											.setParameter(0, grade.getId())
											.setFirstResult((pageNo - 1) * pageSize)
											.setMaxResults(pageSize).list();
						}
					});
		} else if(queryStr != null && queryStr.trim().length() != 0){
			studentList = this.getHibernateTemplate().executeFind(
					new HibernateCallback() {
						
						@Override
						public Object doInHibernate(Session session)
								throws HibernateException, SQLException {
							return session
									.createQuery(
											" select s from Student s where s.sno=? order by s.id ")
											.setParameter(0, queryStr)
											.setFirstResult((pageNo - 1) * pageSize)
											.setMaxResults(pageSize).list();
						}
					});
		} else{
			studentList = this.getHibernateTemplate().executeFind(
					new HibernateCallback() {

						@Override
						public Object doInHibernate(Session session)
								throws HibernateException, SQLException {
							return session
									.createQuery(
											" select s from Student s order by s.id ")
									.setFirstResult((pageNo - 1) * pageSize)
									.setMaxResults(pageSize).list();
						}
					});
		}
		pageModel = new PageModel();
		pageModel.setList(studentList);
		pageModel.setPageNo(pageNo);
		pageModel.setPageSize(pageSize);
		pageModel.setTotalRecords(getTotalRecords(queryStr, grade));
		return pageModel;
	}

	public int getTotalRecords(String queryStr, Grade grade) {
		Long count;
		if("shixi".equals(queryStr)){
			count = (Long) this.getHibernateTemplate()
					.find(" select count(*) from Student s inner join s.internshipDirection i inner join s.grade g where g.id=? and i.status=0 order by s.id ", new Integer[] { grade.getId() })
					.get(0);
		} else if("shixihistory".equals(queryStr)){
			count = (Long) this.getHibernateTemplate()
					.find(" select count(*) from Student s inner join s.internshipDirection i inner join s.grade g where g.id=? and i.status!=0 order by s.id ", new Integer[] { grade.getId() })
					.get(0);
		} else if("shixun".equals(queryStr)){
			count = (Long) this.getHibernateTemplate()
					.find(" select count(*) from Student s inner join s.direction d inner join s.grade g where g.id=? and d.id!=null order by s.id ", new Integer[] { grade.getId() })
					.get(0);
		} else if (queryStr != null && queryStr.trim().length() != 0) {
			count = (Long) this
					.getHibernateTemplate()
					.find(" select count(*) from Student s where s.sno=? order by s.id ",
							new String[] { queryStr }).get(0);
		} else{
			count = (Long) this.getHibernateTemplate()
					.find(" select count(*) from Student s order by s.id ")
					.get(0);
		}
		return count.intValue();
	}

}
