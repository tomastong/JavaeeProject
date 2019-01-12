package cn.sims.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.sims.dao.InformDao;
import cn.sims.domain.Assistant;
import cn.sims.domain.Inform;
import cn.sims.tool.PageModel;

public class InformDaoImpl extends HibernateDaoSupport implements InformDao {

	@Override
	public boolean delete(int id) {
		try {
			Inform i = (Inform) this.getHibernateTemplate().load(Inform.class,
					id);
			this.getHibernateTemplate().delete(i);
		} catch (Exception e) {
			System.out.println("InformDao实现层：delete方法：" + e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public List<Inform> findAll(Assistant assistant, int scope) {
		List<Inform> list;
		String hql = "";

		try {
			if (-1 == scope) {
				list = this.getHibernateTemplate().find(
						"select i from Inform i ");
			} else {
				list = this
						.getHibernateTemplate()
						.find("select i from Inform i inner join i.grade g where i.scope in (0, ?) and g.id=?",
								new Integer[] { scope,
										assistant.getGrade().getId() });
			}
		} catch (Exception e) {
			System.out.println("InformDao实现层：findAll方法：" + e.getMessage());
			return null;
		}
		return list;
	}

	@Override
	public PageModel findAll(int pageNo, int pageSize, String queryStr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Inform inform) {
		try {
			this.getHibernateTemplate().save(inform);
		} catch (Exception e) {
			System.out.println("InformDao实现层：insert方法：" + e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public Inform query(int id) {
		return (Inform) this.getHibernateTemplate().load(Inform.class, id);

	}

	@Override
	public boolean update(Inform inform) {
		try {
			this.getHibernateTemplate().update(inform);
		} catch (Exception e) {
			System.out.println("InformDao实现层：update方法：" + e.getMessage());
			return false;
		}
		return true;
	}

}
