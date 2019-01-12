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

	// ��¼
	public Admin login(String username, String password);
	
	// ����
	public Admin findAdmin(int id);

	// �޸�
	public boolean modify(Admin admin);

	// ����ʵѵƽ̨
	public boolean openShiXunPlatform(Time time);

	// ����ʵϰƽ̨
	public boolean openShiXiPlatform(Time time);

	// ���ø�������Dao���в���
	// //////////////////////////////////////////////////////////////

	// ѧ��Dao
	public boolean addStudent(Student student);

	public boolean delStudent(int id);

	public boolean modStudent(Student student);

	public Student findStudent(int id);

	public PageModel findAllStudent(int pageNo, int pageSize, String queryStr, Grade grade);

	// ����ԱDao
	public boolean addAssistant(Assistant assistant);

	public boolean delAssistant(int id);

	public boolean modAssistant(Assistant assistant);

	public Assistant findAssistant(int id);

	public List<Assistant> findAllAssistant();

	// ��ʦDao
	public boolean addTeacher(Teacher teacher);

	public boolean delTeacher(int id);

	public boolean modTeacher(Teacher teacher);

	public Teacher findTeacher(int id);

	public List<Teacher> findAllTeacher();
	// /////////////////////////////////////////////////////////////////////////////////
}
