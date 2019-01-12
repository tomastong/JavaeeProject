package cn.sims.dao;

import java.util.List;

import cn.sims.domain.Assistant;
import cn.sims.domain.Direction;
import cn.sims.domain.Inform;
import cn.sims.domain.InternshipDirection;
import cn.sims.domain.ZhouJi;
import cn.sims.tool.PageModel;

public interface AssistantDao {
	
	/**
	 * ��¼
	 * @param username     ��¼��
	 * @param password     ����
	 * @return
	 */
	public Assistant login(String username, String password);
	
	
	// ����Ա�������ɾ�Ĳ� //////////////////////////////////////////
	
	/**
	 * ���Ӹ���Ա
	 * @param assistant    ����Ա����
	 * @return
	 */
	public boolean insert(Assistant assistant);
 
	/**
	 * ɾ��
	 * @param id      ����Աid
	 * @return
	 */
	public boolean delete(int id);

	/**
	 * ���� 
	 * @param assistant    ����Ա����
	 * @return
	 */
	public boolean update(Assistant assistant);
	
	/**
	 * ����id��ѯ
	 * @param id      ����Աid
	 * @return
	 */
	public Assistant query(int id);

	/**
	 * ��ѯ����
	 * @return
	 */
	public List<Assistant> findAll();

}
