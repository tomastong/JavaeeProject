package cn.sims.dao;

import java.util.List;

import cn.sims.domain.Grade;
import cn.sims.tool.PageModel;

public interface GradeDao {

	// �꼶����ɾ�Ĳ� //////////////////////////////////////////

	/**
	 * �����꼶
	 * 
	 * @param  grade    �꼶����
	 * @return
	 */
	public boolean insert(Grade grade);

	/**
	 * ɾ��
	 * @param id �꼶id
	 * @return
	 */
	public boolean delete(int id);

	/**
	 * ����
	 * @param grade �꼶����
	 * @return
	 */
	public boolean update(Grade grade);

	/**
	 * ����id��ѯ
	 * @param id �꼶id
	 * @return
	 */
	public Grade query(int id);

	/**
	 * ��ѯ����
	 * @return
	 */
	public List<Grade> findAll();

}
