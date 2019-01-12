package cn.sims.dao;

import java.util.List;

import cn.sims.domain.Assistant;
import cn.sims.domain.Inform;
import cn.sims.tool.PageModel;

public interface InformDao {
	
	// 通知的增删改查 //////////////////////////////////////////

	/**
	 * 增加通知
	 * @param  inform    通知对象
	 * @return
	 */
	public boolean insert(Inform inform);

	/**
	 * 删除
	 * @param id 时间id
	 * @return
	 */
	public boolean delete(int id);

	/**
	 * 更新
	 * @param inform 通知对象
	 * @return
	 */
	public boolean update(Inform inform);

	/**
	 * 根据id查询
	 * @param id 通知id
	 * @return
	 */
	public Inform query(int id);

	/**
	 * 返回周记
	 * @param assistant 通过辅导员获取对应年级
	 * @param scope 取值0，1，2，3对应不同方向
	 * @return
	 */
	public List<Inform> findAll(Assistant assistant, int scope);

	/**
	 * 分页
	 */
	public PageModel findAll(int pageNo, int pageSize, String queryStr);

	// //////////////////////////////////////////////////////////////
}
