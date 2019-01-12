package cn.sims.dao;

import java.util.List;

import cn.sims.domain.InternshipDirection;
import cn.sims.tool.PageModel;

public interface InternshipDirectionDao {
	
	// ʵϰ����ɾ�Ĳ� //////////////////////////////////////////

	/**
	 * ����ʵϰ
	 * @param  internshipDirection ʵϰ����
	 * @return
	 */
	public boolean insert(InternshipDirection internshipDirection);

	/**
	 * ɾ��
	 * @param id ʵϰid
	 * @return
	 */
	public boolean delete(int id);

	/**
	 * ����
	 * @param internshipDirection ʵϰ����
	 * @return
	 */
	public boolean update(InternshipDirection internshipDirection);

	/**
	 * ����id��ѯ
	 * @param id ʵϰid
	 * @return
	 */
	public InternshipDirection query(int id);

	/**
	 * ��ѯʵϰ���뷽���ҳģ��
	 * @param pageNo
	 * @param pageSize
	 * @param queryStr
	 * @return
	 */
	public PageModel findInternshipDirectionAll(int pageNo, int pageSize, String queryStr);

}
