package cn.sims.dao;
import java.util.List;

import cn.sims.domain.Grade;
import cn.sims.domain.Student;
import cn.sims.domain.ZhouJi;
import cn.sims.tool.PageModel;

public interface ZhouJiDao {
	
	// �ܼǵ���ɾ�Ĳ� //////////////////////////////////////////
	
	/**
	 * �����ܼ�
	 * @param zhouji zhouji����
	 * @return
	 */
	public boolean insert(ZhouJi zhouji);
 
	/**
	 * ɾ��
	 * @param id zhoujiid
	 * @return
	 */
	public boolean delete(int id);

	/**
	 * ���� 
	 * @param zhouji �ܼǶ���
	 * @return
	 */
	public boolean update(ZhouJi zhouji);
	
	/**
	 * ����id��ѯ
	 * @param id �ܼ�id
	 * @return
	 */
	public ZhouJi query(int id);

	/**
	 * ��ѯ����
	 * @return
	 */
	public List<ZhouJi> findOwnAll(Student student);

	/**
	 * ��ҳ
	 */
	public PageModel findAll(int pageNo, int pageSize, String queryStr, Grade grade);
	
}
