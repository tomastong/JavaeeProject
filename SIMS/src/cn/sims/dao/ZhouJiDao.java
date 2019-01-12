package cn.sims.dao;
import java.util.List;

import cn.sims.domain.Grade;
import cn.sims.domain.Student;
import cn.sims.domain.ZhouJi;
import cn.sims.tool.PageModel;

public interface ZhouJiDao {
	
	// 周记的增删改查 //////////////////////////////////////////
	
	/**
	 * 增加周记
	 * @param zhouji zhouji对象
	 * @return
	 */
	public boolean insert(ZhouJi zhouji);
 
	/**
	 * 删除
	 * @param id zhoujiid
	 * @return
	 */
	public boolean delete(int id);

	/**
	 * 更新 
	 * @param zhouji 周记对象
	 * @return
	 */
	public boolean update(ZhouJi zhouji);
	
	/**
	 * 根据id查询
	 * @param id 周记id
	 * @return
	 */
	public ZhouJi query(int id);

	/**
	 * 查询所有
	 * @return
	 */
	public List<ZhouJi> findOwnAll(Student student);

	/**
	 * 分页
	 */
	public PageModel findAll(int pageNo, int pageSize, String queryStr, Grade grade);
	
}
