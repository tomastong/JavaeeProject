package cn.sims.dao;

import java.util.List;

import cn.sims.domain.Grade;
import cn.sims.tool.PageModel;

public interface GradeDao {

	// 年级的增删改查 //////////////////////////////////////////

	/**
	 * 增加年级
	 * 
	 * @param  grade    年级对象
	 * @return
	 */
	public boolean insert(Grade grade);

	/**
	 * 删除
	 * @param id 年级id
	 * @return
	 */
	public boolean delete(int id);

	/**
	 * 更新
	 * @param grade 年级对象
	 * @return
	 */
	public boolean update(Grade grade);

	/**
	 * 根据id查询
	 * @param id 年级id
	 * @return
	 */
	public Grade query(int id);

	/**
	 * 查询所有
	 * @return
	 */
	public List<Grade> findAll();

}
