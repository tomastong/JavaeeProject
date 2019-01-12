package cn.sims.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.sims.dao.DirectionDao;
import cn.sims.domain.Direction;
import cn.sims.domain.Grade;
import cn.sims.tool.PageModel;

public class DirectionDaoImpl extends HibernateDaoSupport implements
		DirectionDao {

	@Override
	public boolean delete(int id) {
		try {
			Direction d = (Direction) this.getHibernateTemplate().load(
					Direction.class, id);
			this.getHibernateTemplate().delete(d);
		} catch (Exception e) {
			System.out.println("DirectionDao实现层：delete方法：" + e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean insert(Direction direction) {
		try {
			this.getHibernateTemplate().save(direction);
		} catch (Exception e) {
			System.out.println("DirectionDao实现层：insert方法：" + e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public Direction query(int id) {
		return (Direction) this.getHibernateTemplate()
				.load(Direction.class, id);

	}

	@Override
	public boolean update(Direction direction) {
		try {
			this.getHibernateTemplate().update(direction);
		} catch (Exception e) {
			System.out.println("DirectionDao实现层：update方法：" + e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public List<Direction> findAll(Grade grade) {
		return this
				.getHibernateTemplate()
				.find("select d from Direction d inner join d.grade g where g.id=?",
						new Integer[] { grade.getId() });
	}
	
	@Override
	public List<Direction> findAll() {
		return this
				.getHibernateTemplate()
				.find("select d from Direction d ");
	}
}
