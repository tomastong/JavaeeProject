package cn.sims.dao;

import java.util.List;


import cn.sims.domain.Classes;
import cn.sims.tool.PageModel;

public interface ClassesDao {
	
	/**
	 * ���Ӱ༶
	 * @param  classes  �༶����
	 * @return
	 */
	public boolean insert(Classes classes);

	/**
	 * ɾ��
	 * @param id  ʱ��id
	 * @return
	 */
	public boolean delete(int id);

	/**
	 * ����
	 * @param classes �༶����
	 * @return
	 */
	public boolean update(Classes classes);

	/**
	 * ����id��ѯ
	 * @param id �༶id
	 * @return
	 */
	public Classes query(int id);

	/**
	 * ��ѯ����
	 * @return
	 */
	public List<Classes> findAll();

}
