package cn.sims.services;

import java.util.List;

import cn.sims.domain.Teacher;
import cn.sims.tool.PageModel;

public interface TeacherService {

	// ��¼
	public Teacher login(String username, String password);

	// ������ʦ
	public boolean add(Teacher teacher);

	// ɾ��
	public boolean del(int id);

	// ����
	public boolean modify(Teacher teacher);

	// ����id��ѯ
	public Teacher find(int id);

	// ��ѯ����
	public List<Teacher> findAll();

}
