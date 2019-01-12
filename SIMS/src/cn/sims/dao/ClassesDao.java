package cn.sims.dao;

import java.util.List;


import cn.sims.domain.Classes;
import cn.sims.tool.PageModel;

public interface ClassesDao {
	
	/**
	 * 增加班级
	 * @param  classes  班级对象
	 * @return
	 */
	public boolean insert(Classes classes);

	/**
	 * 删除
	 * @param id  时间id
	 * @return
	 */
	public boolean delete(int id);

	/**
	 * 更新
	 * @param classes 班级对象
	 * @return
	 */
	public boolean update(Classes classes);

	/**
	 * 根据id查询
	 * @param id 班级id
	 * @return
	 */
	public Classes query(int id);

	/**
	 * 查询所有
	 * @return
	 */
	public List<Classes> findAll();

}
