package cn.sims.services.impl;

import cn.sims.dao.InternshipDirectionDao;
import cn.sims.domain.InternshipDirection;
import cn.sims.services.InternshipDirectionService;
import cn.sims.tool.PageModel;

public class InternshipDirectionServiceImpl implements
		InternshipDirectionService {

	@Override
	public boolean add(InternshipDirection internshipDirection) {
		return shixiDao.insert(internshipDirection);
	}

	@Override
	public boolean del(int id) {
		return shixiDao.delete(id);
	}

	@Override
	public boolean modify(InternshipDirection internshipDirection) {
		return shixiDao.update(internshipDirection);
	}

	@Override
	public InternshipDirection find(int id) {
		return shixiDao.query(id);
	}

	@Override
	public PageModel findInternshipDirectionAll(int pageNo, int pageSize,
			String queryStr) {
		return shixiDao.findInternshipDirectionAll(pageNo,
				pageSize, queryStr);
	}
	
////////////////////////////////////////////////////////////////////////////////
	
	public InternshipDirectionDao getShixiDao() {
		return shixiDao;
	}

	public void setShixiDao(InternshipDirectionDao shixiDao) {
		this.shixiDao = shixiDao;
	}
	
	/**
	 * 实习去向Dao的引用
	 */
	private InternshipDirectionDao shixiDao;
}
