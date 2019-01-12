package cn.sims.services.impl;

import java.util.List;

import cn.sims.dao.TeacherDao;
import cn.sims.domain.Teacher;
import cn.sims.services.TeacherService;
import cn.sims.tool.PageModel;

public class TeacherServiceImpl implements TeacherService {

	@Override
	public Teacher login(String username, String password) {
		return teacherDao.login(username, password);
	}

	@Override
	public boolean add(Teacher teacher) {
		return teacherDao.insert(teacher);
	}

	@Override
	public boolean del(int id) {
		return teacherDao.delete(id);
	}

	@Override
	public boolean modify(Teacher teacher) {
		return teacherDao.update(teacher);
	}

	@Override
	public Teacher find(int id) {
		return teacherDao.query(id);
	}

	@Override
	public List<Teacher> findAll() {
		return teacherDao.findAll();
	}

	// //////////////////////////////////////////////////////////////////////////////
	
	public TeacherDao getTeacherDao() {
		return teacherDao;
	}
	
	public void setTeacherDao(TeacherDao teacherDao) {
		this.teacherDao = teacherDao;
	}
	

	/**
	 * 教师Dao的引用
	 */
	private TeacherDao teacherDao;

}
