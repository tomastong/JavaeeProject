package cn.sims.services.impl;

import java.util.List;

import cn.sims.dao.ZhouJiDao;
import cn.sims.domain.Grade;
import cn.sims.domain.Student;
import cn.sims.domain.ZhouJi;
import cn.sims.services.ZhouJiService;
import cn.sims.tool.PageModel;

public class ZhouJiServiceImpl implements ZhouJiService {

	@Override
	public boolean add(ZhouJi zhouji) {
		return zjDao.insert(zhouji);
	}

	@Override
	public boolean del(int id) {
		return zjDao.delete(id);
	}

	@Override
	public boolean modify(ZhouJi zhouji) {
		return zjDao.update(zhouji);
	}

	@Override
	public ZhouJi find(int id) {
		return zjDao.query(id);
	}

	@Override
	public List<ZhouJi> findOwnAll(Student student) {
		return zjDao.findOwnAll(student);
	}

	@Override
	public PageModel findAll(int pageNo, int pageSize, String queryStr, Grade grade) {
		return zjDao.findAll(pageNo, pageSize, queryStr, grade);
	}
	
////////////////////////////////////////////////////////////////////////////////
	
	
	public ZhouJiDao getZjDao() {
		return zjDao;
	}

	public void setZjDao(ZhouJiDao zjDao) {
		this.zjDao = zjDao;
	}




	/**
	 * 周记Dao的引用
	 */
	private ZhouJiDao zjDao;
}
