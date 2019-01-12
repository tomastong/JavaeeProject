package cn.sims.services.impl;

import java.util.List;

import cn.sims.dao.AdminDao;
import cn.sims.dao.AssistantDao;
import cn.sims.dao.StudentDao;
import cn.sims.dao.TeacherDao;
import cn.sims.dao.TimeDao;
import cn.sims.domain.Admin;
import cn.sims.domain.Assistant;
import cn.sims.domain.Grade;
import cn.sims.domain.Student;
import cn.sims.domain.Teacher;
import cn.sims.domain.Time;
import cn.sims.services.AdminService;
import cn.sims.tool.PageModel;

public class AdminServiceImpl implements AdminService {

	@Override
	public Admin login(String username, String password) {
		return adminDao.login(username, password);
	}

	@Override
	public Admin findAdmin(int id) {
		return adminDao.findAdmin(id);
	}

	@Override
	public boolean modify(Admin admin) {
		return adminDao.update(admin);
	}

	@Override
	public boolean openShiXunPlatform(Time time) {
		return timeDao.insert(time);
	}

	@Override
	public boolean openShiXiPlatform(Time time) {
		return timeDao.insert(time);
	}

	@Override
	public boolean addStudent(Student student) {
		return studentDao.insert(student);
	}

	@Override
	public boolean delStudent(int id) {
		return studentDao.delete(id);
	}

	@Override
	public boolean modStudent(Student student) {
		return studentDao.update(student);
	}

	@Override
	public Student findStudent(int id) {
		return studentDao.query(id);
	}

	@Override
	public PageModel findAllStudent(int pageNo, int pageSize, String queryStr, Grade grade) {
		return studentDao.findAll(pageNo, pageSize, queryStr, null);
	}

	@Override
	public boolean addAssistant(Assistant assistant) {
		return assistantDao.insert(assistant);
	}

	@Override
	public boolean delAssistant(int id) {
		return assistantDao.delete(id);
	}

	@Override
	public boolean modAssistant(Assistant assistant) {
		return assistantDao.update(assistant);
	}

	@Override
	public Assistant findAssistant(int id) {
		return assistantDao.query(id);
	}

	@Override
	public List<Assistant> findAllAssistant() {
		return assistantDao.findAll();
	}

	@Override
	public boolean addTeacher(Teacher teacher) {
		return teacherDao.insert(teacher);
	}

	@Override
	public boolean delTeacher(int id) {
		return teacherDao.delete(id);
	}

	@Override
	public boolean modTeacher(Teacher teacher) {
		return teacherDao.update(teacher);
	}

	@Override
	public Teacher findTeacher(int id) {
		return teacherDao.query(id);
	}

	@Override
	public List<Teacher> findAllTeacher() {
		return teacherDao.findAll();
	}
	
	
	////////////////////////////////////////////////////////////////////////////////
	
	
	 



	public TimeDao getTimeDao() {
		return timeDao;
	}

	public void setTimeDao(TimeDao timeDao) {
		this.timeDao = timeDao;
	}

	public AdminDao getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public AssistantDao getAssistantDao() {
		return assistantDao;
	}

	public void setAssistantDao(AssistantDao assistantDao) {
		this.assistantDao = assistantDao;
	}

	public TeacherDao getTeacherDao() {
		return teacherDao;
	}

	public void setTeacherDao(TeacherDao teacherDao) {
		this.teacherDao = teacherDao;
	}


	/**
	 * 时间dao的引用
	 */
	private TimeDao timeDao;
	/**
	 * 管理员dao的引用
	 */
	private AdminDao adminDao;
	/**
	 *  学生dao的引用
	 */
	private StudentDao studentDao;
	/**
	 *  辅导员dao的引用
	 */
	private AssistantDao assistantDao;
	/**
	 * 教师dao的引用
	 */
	private TeacherDao teacherDao;
}
