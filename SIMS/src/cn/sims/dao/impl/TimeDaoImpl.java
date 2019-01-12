package cn.sims.dao.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.sims.dao.TimeDao;
import cn.sims.domain.Grade;
import cn.sims.domain.Time;

public class TimeDaoImpl extends HibernateDaoSupport implements TimeDao {

	@Override
	public boolean checkShiXiValidate(Grade grade, Date date) {
		Set<Time> set = grade.getTimes();
		Iterator it = set.iterator();
		while (it.hasNext()) {
			Time time = (Time) it.next();
			if ("shixi".equals(time.getType())) {
				if (date.getTime() > time.getStartTime().getTime()
						&& date.getTime() < time.getEndTime().getTime()) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean checkShiXunValidate(Grade grade, Date date) {
		Set<Time> set = grade.getTimes();
		Iterator it = set.iterator();
		while (it.hasNext()) {
			Time time = (Time) it.next();
			if ("shixun".equals(time.getType())) {
				if (date.getTime() > time.getStartTime().getTime()
						&& date.getTime() < time.getEndTime().getTime()) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean delete(int id) {
		try {
			Time time = (Time) this.getHibernateTemplate().load(Time.class, id);
			this.getHibernateTemplate().delete(time);
		} catch (Exception e) {
			System.out.println("TimeDao实现层：delete方法：" + e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public List<Time> findAll() {
		return this.getHibernateTemplate().find("");
	}

	@Override
	public boolean insert(Time time) {
		try {
			this.getHibernateTemplate().save(time);
		} catch (Exception e) {
			System.out.println("TimeDao实现层：insert方法：" + e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public Time query(int id) {
		return (Time) this.getHibernateTemplate().load(Time.class, id);
	}

	@Override
	public boolean update(Time time) {
		try {
			this.getHibernateTemplate().update(time);
		} catch (Exception e) {
			System.out.println("TimeDao实现层：update方法：" + e.getMessage());
			return false;
		}
		return true;
	}

}
