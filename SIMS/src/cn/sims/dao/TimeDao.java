package cn.sims.dao;

import java.util.Date;
import java.util.List;

import cn.sims.domain.Grade;
import cn.sims.domain.Time;

public interface TimeDao {
	
	// ʱ�����ɾ�Ĳ� //////////////////////////////////////////

	/**
	 * ����ʱ��
	 * 
	 * @param  time ʱ�����
	 * @return
	 */
	public boolean insert(Time time);

	/**
	 * ɾ��
	 * @param id ʱ��id
	 * @return
	 */
	public boolean delete(int id);

	/**
	 * ����
	 * @param time ʱ�����
	 * @return
	 */
	public boolean update(Time time);

	/**
	 * ����id��ѯ
	 * @param id ʱ��id
	 * @return
	 */
	public Time query(int id);

	/**
	 * ��ѯ����
	 * @return
	 */
	public List<Time> findAll();
	
	// ��������Ƿ���Ч//////////////////////////////////////////////////
	
	 /**
	  * ������ƽ̨ʱ���Ƿ���Ч
	  * @param grade ��ǰ�꼶
	  * @param grade ��ǰʱ��
	  * @return true��Ч false ��Ч
	  */
	public boolean checkShiXunValidate(Grade grade, Date date);
	 /**
	  * ������ƽ̨ʱ���Ƿ���Ч
	  * @param grade ��ǰ�꼶
	  * @param grade ��ǰʱ��
	  * @return true��Ч false ��Ч
	  */
	public boolean checkShiXiValidate(Grade grade, Date date);
	
}
