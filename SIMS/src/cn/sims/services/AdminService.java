package cn.sims.services;

import java.util.List;

import cn.sims.domain.Admin;
import cn.sims.domain.Assistant;
import cn.sims.domain.Grade;
import cn.sims.domain.Student;
import cn.sims.domain.Teacher;
import cn.sims.domain.Time;
import cn.sims.tool.PageModel;

public interface AdminService {

	// 登录
	public Admin login(String username, String password);
	
	// 查找
	public Admin findAdmin(int id);

	// 修改
	public boolean modify(Admin admin);

	// 开放实训平台
	public boolean openShiXunPlatform(Time time);

	// 开放实习平台
	public boolean openShiXiPlatform(Time time);

	// 引用各个对象Dao进行操作
	// //////////////////////////////////////////////////////////////

	// 学生Dao
	public boolean addStudent(Student student);

	public boolean delStudent(int id);

	public boolean modStudent(Student student);

	public Student findStudent(int id);

	public PageModel findAllStudent(int pageNo, int pageSize, String queryStr, Grade grade);

	// 辅导员Dao
	public boolean addAssistant(Assistant assistant);

	public boolean delAssistant(int id);

	public boolean modAssistant(Assistant assistant);

	public Assistant findAssistant(int id);

	public List<Assistant> findAllAssistant();

	// 教师Dao
	public boolean addTeacher(Teacher teacher);

	public boolean delTeacher(int id);

	public boolean modTeacher(Teacher teacher);

	public Teacher findTeacher(int id);

	public List<Teacher> findAllTeacher();
	// /////////////////////////////////////////////////////////////////////////////////
}
