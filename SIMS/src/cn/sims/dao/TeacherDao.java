package cn.sims.dao;

import java.util.List;
import cn.sims.domain.Teacher;
import cn.sims.tool.PageModel;

public interface TeacherDao {
	/**
	 * ��¼
	 * @param username ��¼��
	 * @param password ����
	 * @return
	 */
	public Teacher login(String username, String password);

	// ��ʦ�������ɾ�Ĳ� //////////////////////////////////////////

	/**
	 * ������ʦ
	 * @param teacher ��ʦ����
	 * @return
	 */
	public boolean insert(Teacher teacher);

	/**
	 * ɾ��
	 * @param id ��ʦid
	 * @return
	 */
	public boolean delete(int id);

	/**
	 * ����
	 * @param teacher ��ʦ����
	 * @return
	 */

	public boolean update(Teacher teacher);

	/**
	 * ����id��ѯ
	 * @param id ��ʦid
	 * @return
	 */
	public Teacher query(int id);

	/**
	 * ��ѯ����
	 * @return
	 */
	public List<Teacher> findAll();


}
