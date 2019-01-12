package cn.sims.services;

import java.util.List;

import cn.sims.domain.Course;

public interface CourseService {

	// ���ӿγ�
	public boolean add(Course course);

	// ɾ��
	public boolean del(int id);

	// ����
	public boolean modify(Course course);

	// ����id��ѯ
	public Course find(int id);

	// ��ѯ����
	public List<Course> findAll();

}
