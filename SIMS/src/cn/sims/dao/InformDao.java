package cn.sims.dao;

import java.util.List;

import cn.sims.domain.Assistant;
import cn.sims.domain.Inform;
import cn.sims.tool.PageModel;

public interface InformDao {
	
	// ֪ͨ����ɾ�Ĳ� //////////////////////////////////////////

	/**
	 * ����֪ͨ
	 * @param  inform    ֪ͨ����
	 * @return
	 */
	public boolean insert(Inform inform);

	/**
	 * ɾ��
	 * @param id ʱ��id
	 * @return
	 */
	public boolean delete(int id);

	/**
	 * ����
	 * @param inform ֪ͨ����
	 * @return
	 */
	public boolean update(Inform inform);

	/**
	 * ����id��ѯ
	 * @param id ֪ͨid
	 * @return
	 */
	public Inform query(int id);

	/**
	 * �����ܼ�
	 * @param assistant ͨ������Ա��ȡ��Ӧ�꼶
	 * @param scope ȡֵ0��1��2��3��Ӧ��ͬ����
	 * @return
	 */
	public List<Inform> findAll(Assistant assistant, int scope);

	/**
	 * ��ҳ
	 */
	public PageModel findAll(int pageNo, int pageSize, String queryStr);

	// //////////////////////////////////////////////////////////////
}
