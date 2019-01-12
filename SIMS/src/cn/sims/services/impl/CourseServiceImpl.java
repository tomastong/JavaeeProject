package cn.sims.services.impl;

import java.util.List;

import cn.sims.dao.CourseDao;
import cn.sims.domain.Course;
import cn.sims.services.CourseService;

public class CourseServiceImpl implements CourseService {

	@Override
	public boolean add(Course course) {
		return courseDao.insert(course);
	}

	@Override
	public boolean del(int id) {
		return courseDao.delete(id);
	}

	@Override
	public boolean modify(Course course) {
		return courseDao.update(course);
	}

	@Override
	public Course find(int id) {
		return courseDao.query(id);
	}

	@Override
	public List<Course> findAll() {
		return courseDao.findAll();
	}
	
////////////////////////////////////////////////////////////////////////////////
	 

	public CourseDao getCourseDao() {
		return courseDao;
	}

	public void setCourseDao(CourseDao courseDao) {
		this.courseDao = courseDao;
	}
	
	/**
	 * 班级Dao的引用
	 */
	private CourseDao courseDao;
}
