package cn.sims.dao;

import java.util.List;

import cn.sims.domain.Post;
import cn.sims.domain.Resources;
import cn.sims.tool.PageModel;

public interface ResourcesDao {

	// 资源的增删改查 //////////////////////////////////////////

	/**
	 * 增加资源
	 * @param  resources    资源对象
	 * @return
	 */
	public boolean insert(Resources resources);

	/**
	 * 删除
	 * @param id 资源id
	 * @return
	 */
	public boolean delete(int id);

	/**
	 * 更新
	 * @param resources 资源对象
	 * @return
	 */
	public boolean update(Resources resources);

	/**
	 * 根据id查询
	 * @param id 资源id
	 * @return
	 */
	public Resources query(int id);

	/**
	 * 查询所有
	 * @return
	 */
	public List<Resources> findAll();

}
