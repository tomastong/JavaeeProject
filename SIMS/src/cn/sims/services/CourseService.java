package cn.sims.services;

import java.util.List;

import cn.sims.domain.Course;

public interface CourseService {

	// 增加课程
	public boolean add(Course course);

	// 删除
	public boolean del(int id);

	// 更新
	public boolean modify(Course course);

	// 根据id查询
	public Course find(int id);

	// 查询所有
	public List<Course> findAll();

}
