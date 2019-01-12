package cn.sims.services.impl;

import java.util.List;

import cn.sims.dao.GradeDao;
import cn.sims.domain.Grade;
import cn.sims.services.GradeService;

public class GradeServiceImpl implements GradeService {

	@Override
	public boolean add(Grade grade) {
		return gradeDao.insert(grade);
	}

	@Override
	public boolean del(int id) {
		return gradeDao.delete(id);
	}

	@Override
	public boolean modify(Grade grade) {
		return gradeDao.update(grade);
	}

	@Override
	public Grade find(int id) {
		return gradeDao.query(id);
	}

	@Override
	public List<Grade> findAll() {
		return gradeDao.findAll();
	}
	
////////////////////////////////////////////////////////////////////////////////
	
	
	public GradeDao getGradeDao() {
		return gradeDao;
	}
	
	public void setGradeDao(GradeDao gradeDao) {
		this.gradeDao = gradeDao;
	}
	
	/**
	 * 年级Dao的引用
	 */
	private GradeDao gradeDao;

}
