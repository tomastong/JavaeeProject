package cn.sims.dao;
import java.util.List;

import cn.sims.domain.Direction;
import cn.sims.domain.Grade;
public interface DirectionDao {
	
	// 实训的增删改查 //////////////////////////////////////////

	/**
	 * 增加实训
	 * @param  direction 实训对象
	 * @return
	 */
	public boolean insert(Direction direction);

	/**
	 * 删除
	 * @param id 实训id
	 * @return
	 */
	public boolean delete(int id);

	/**
	 * 更新
	 * @param direction 实训对象
	 * @return
	 */
	public boolean update(Direction direction);

	/**
	 * 根据id查询
	 * @param id 实训id
	 * @return
	 */
	public Direction query(int id);

	/**
	 * 查询所有方向
	 */
	public List<Direction> findAll(Grade grade);

	/**
	 * 查询所有方向
	 */
	public List<Direction> findAll();
	// //////////////////////////////////////////////////////////////

}
