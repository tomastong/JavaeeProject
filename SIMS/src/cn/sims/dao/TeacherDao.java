package cn.sims.dao;

import java.util.List;
import cn.sims.domain.Teacher;
import cn.sims.tool.PageModel;

public interface TeacherDao {
	/**
	 * 登录
	 * @param username 登录名
	 * @param password 密码
	 * @return
	 */
	public Teacher login(String username, String password);

	// 老师自身的增删改查 //////////////////////////////////////////

	/**
	 * 增加老师
	 * @param teacher 老师对象
	 * @return
	 */
	public boolean insert(Teacher teacher);

	/**
	 * 删除
	 * @param id 老师id
	 * @return
	 */
	public boolean delete(int id);

	/**
	 * 更新
	 * @param teacher 老师对象
	 * @return
	 */

	public boolean update(Teacher teacher);

	/**
	 * 根据id查询
	 * @param id 老师id
	 * @return
	 */
	public Teacher query(int id);

	/**
	 * 查询所有
	 * @return
	 */
	public List<Teacher> findAll();


}
