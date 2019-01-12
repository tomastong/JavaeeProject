package cn.sims.dao;

import java.util.List;

import cn.sims.domain.Grade;
import cn.sims.domain.Student;
import cn.sims.tool.PageModel;

public interface StudentDao {
	/**
	 * 登录
	 * @param username 登录名
	 * @param password 密码
	 * @return
	 */
	public Student login(String username, String password);

	// 学生自身的增删改查 //////////////////////////////////////////

	/**
	 * 增加学生
	 * @param student 学生对象
	 * @return
	 */
	public boolean insert(Student student);

	/**
	 * 删除
	 * @param id  学生id
	 * @return
	 */
	public boolean delete(int id);

	/**
	 * 更新
	 * @param student 学生对象
	 * @return
	 */
	public boolean update(Student student);

	/**
	 * 根据id查询
	 * @param id 学生id
	 * @return
	 */
	public Student query(int id);

	/**
	 * 查询所有
	 * @return
	 */
	public List<Student> findAll();

	/**
	 * 分页
	 * @param pageNo  
	 * @param pageSize
	 * @param queryStr
	 * @return
	 */
	public PageModel findAll(int pageNo, int pageSize, String queryStr, Grade grade);


}
