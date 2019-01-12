package cn.sims.dao;
import java.util.List;

import cn.sims.domain.Direction;
import cn.sims.domain.Grade;
public interface DirectionDao {
	
	// ʵѵ����ɾ�Ĳ� //////////////////////////////////////////

	/**
	 * ����ʵѵ
	 * @param  direction ʵѵ����
	 * @return
	 */
	public boolean insert(Direction direction);

	/**
	 * ɾ��
	 * @param id ʵѵid
	 * @return
	 */
	public boolean delete(int id);

	/**
	 * ����
	 * @param direction ʵѵ����
	 * @return
	 */
	public boolean update(Direction direction);

	/**
	 * ����id��ѯ
	 * @param id ʵѵid
	 * @return
	 */
	public Direction query(int id);

	/**
	 * ��ѯ���з���
	 */
	public List<Direction> findAll(Grade grade);

	/**
	 * ��ѯ���з���
	 */
	public List<Direction> findAll();
	// //////////////////////////////////////////////////////////////

}
