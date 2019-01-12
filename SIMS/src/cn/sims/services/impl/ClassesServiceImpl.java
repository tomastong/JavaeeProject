package cn.sims.services.impl;

import java.util.List;

import cn.sims.dao.ClassesDao;
import cn.sims.domain.Classes;
import cn.sims.services.ClassesService;

public class ClassesServiceImpl implements ClassesService {

	@Override
	public boolean add(Classes classes) {
		return classesDao.insert(classes);
	}

	@Override
	public boolean del(int id) {
		return classesDao.delete(id);
	}

	@Override
	public boolean modify(Classes classes) {
		return classesDao.update(classes);
	}

	@Override
	public Classes find(int id) {
		return classesDao.query(id);
	}

	@Override
	public List<Classes> findAll() {
		return classesDao.findAll();
	}
	
////////////////////////////////////////////////////////////////////////////////
	

	public ClassesDao getClassesDao() {
		return classesDao;
	}

	public void setClassesDao(ClassesDao classesDao) {
		this.classesDao = classesDao;
	}
	
	/**
	 * 班级dao的引用
	 */
	private ClassesDao classesDao;
}
