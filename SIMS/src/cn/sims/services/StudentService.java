package cn.sims.services;

import java.util.Date;
import java.util.List;

import cn.sims.domain.Direction;
import cn.sims.domain.Grade;
import cn.sims.domain.InternshipDirection;
import cn.sims.domain.Student;
import cn.sims.domain.ZhouJi;
import cn.sims.tool.PageModel;

public interface StudentService {

	// ��¼
	public Student login(String username, String password);

	// ����ѧ��
	public boolean add(Student student);

	// ɾ��
	public boolean del(int id);

	// ����
	public boolean modify(Student student);

	// ����id��ѯ
	public Student find(int id);

	// ��ѯ����
	public List<Student> findAll();
	
	// ��ѯѧ���Լ����ܼ�
	public List<ZhouJi> findAllZj(Student student);
	
	// ��ҳ
	public PageModel findAll(int pageNo, int pageSize, String queryStr, Grade grade);

	// �鿴ʵϰ����Ľ��
	public Direction findShiXunResult(Student s);

	// �鿴ʵϰ����Ľ��
	public InternshipDirection findShiXiResult(Student s);

	// �鿴ʵѵƽ̨�ܷ����
	public boolean shixunPlatform(Student s, Date date);

	// �鿴ʵϰƽ̨�ܷ����
	public boolean shixiPlatform(Student s, Date date);

}
