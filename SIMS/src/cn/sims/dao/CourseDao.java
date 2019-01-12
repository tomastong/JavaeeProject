package cn.sims.dao;

import java.util.List;

import cn.sims.domain.Course;
import cn.sims.tool.PageModel;

public interface CourseDao {

	// 课程的增删改查 //////////////////////////////////////////

	/**
	 * 增加课程
	 * @param course 课程对象
	 * @return
	 */
	public boolean insert(Course course);

	/**
	 * 删除
	 * @param id  课程id
	 * @return
	 */
	public boolean delete(int id);

	/**
	 * 更新
	 * @param course 课程对象
	 * @return
	 */
	public boolean update(Course course);

	/**
	 * 根据id查询
	 * @param id 课程id
	 * @return
	 */
	public Course query(int id);

	/**
	 * 查询所有
	 * @return
	 */
	public List<Course> findAll();

}
