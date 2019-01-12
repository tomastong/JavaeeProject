package cn.sims.services.impl;

import java.util.Date;
import java.util.List;

import cn.sims.dao.DirectionDao;
import cn.sims.dao.InternshipDirectionDao;
import cn.sims.dao.StudentDao;
import cn.sims.dao.TimeDao;
import cn.sims.dao.ZhouJiDao;
import cn.sims.domain.Direction;
import cn.sims.domain.Grade;
import cn.sims.domain.InternshipDirection;
import cn.sims.domain.Student;
import cn.sims.domain.ZhouJi;
import cn.sims.services.StudentService;
import cn.sims.tool.PageModel;

public class StudentServiceImpl implements StudentService {

	@Override
	public Student login(String username, String password) {
		return studentDao.login(username, password);
	}

	@Override
	public boolean add(Student student) {
		return studentDao.insert(student);
	}

	@Override
	public boolean del(int id) {
		return studentDao.delete(id);
	}

	@Override
	public boolean modify(Student student) {
		return studentDao.update(student);
	}

	@Override
	public Student find(int id) {
		return studentDao.query(id);
	}

	@Override
	public List<Student> findAll() {
		return studentDao.findAll();
	}

	@Override
	public PageModel findAll(int pageNo, int pageSize, String queryStr, Grade grade) {
		return studentDao.findAll(pageNo, pageSize, queryStr, grade);
	}

	@Override
	public Direction findShiXunResult(Student s) {
		return shixunDao.query(s.getId());
	}

	@Override
	public InternshipDirection findShiXiResult(Student s) {
		return shixiDao.query(s.getId());
	}

	@Override
	public boolean shixunPlatform(Student s, Date date) {
		return timeDao.checkShiXiValidate(s.getGrade(), date);
	}

	@Override
	public boolean shixiPlatform(Student s, Date date) {
		return timeDao.checkShiXunValidate(s.getGrade(), date);
	}

	@Override
	public List<ZhouJi> findAllZj(Student student) {
		return zjDao.findOwnAll(student);
	}

	// //////////////////////////////////////////////////////////////////////////////

	public DirectionDao getShixunDao() {
		return shixunDao;
	}

	public void setShixunDao(DirectionDao shixunDao) {
		this.shixunDao = shixunDao;
	}

	public TimeDao getTimeDao() {
		return timeDao;
	}

	public void setTimeDao(TimeDao timeDao) {
		this.timeDao = timeDao;
	}

	public InternshipDirectionDao getShixiDao() {
		return shixiDao;
	}

	public void setShixiDao(InternshipDirectionDao shixiDao) {
		this.shixiDao = shixiDao;
	}

	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public ZhouJiDao getZjDao() {
		return zjDao;
	}

	public void setZjDao(ZhouJiDao zjDao) {
		this.zjDao = zjDao;
	}

	/**
	 * 引用一下，实训申请方向
	 */
	private DirectionDao shixunDao;
	/**
	 * 引用一下， 时间管理
	 */
	private TimeDao timeDao;
	/**
	 * 引用一下，实习申请方向
	 */
	private InternshipDirectionDao shixiDao;
	/**
	 * 引用一下，学生Dao
	 */
	private StudentDao studentDao;
	/**
	 * 引用一下，周记Dao
	 */
	private ZhouJiDao zjDao;

}
