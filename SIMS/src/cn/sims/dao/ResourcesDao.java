package cn.sims.dao;

import java.util.List;

import cn.sims.domain.Post;
import cn.sims.domain.Resources;
import cn.sims.tool.PageModel;

public interface ResourcesDao {

	// ��Դ����ɾ�Ĳ� //////////////////////////////////////////

	/**
	 * ������Դ
	 * @param  resources    ��Դ����
	 * @return
	 */
	public boolean insert(Resources resources);

	/**
	 * ɾ��
	 * @param id ��Դid
	 * @return
	 */
	public boolean delete(int id);

	/**
	 * ����
	 * @param resources ��Դ����
	 * @return
	 */
	public boolean update(Resources resources);

	/**
	 * ����id��ѯ
	 * @param id ��Դid
	 * @return
	 */
	public Resources query(int id);

	/**
	 * ��ѯ����
	 * @return
	 */
	public List<Resources> findAll();

}
