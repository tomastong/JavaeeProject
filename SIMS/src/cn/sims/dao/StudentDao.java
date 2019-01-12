package cn.sims.dao;

import java.util.List;

import cn.sims.domain.Grade;
import cn.sims.domain.Student;
import cn.sims.tool.PageModel;

public interface StudentDao {
	/**
	 * ��¼
	 * @param username ��¼��
	 * @param password ����
	 * @return
	 */
	public Student login(String username, String password);

	// ѧ���������ɾ�Ĳ� //////////////////////////////////////////

	/**
	 * ����ѧ��
	 * @param student ѧ������
	 * @return
	 */
	public boolean insert(Student student);

	/**
	 * ɾ��
	 * @param id  ѧ��id
	 * @return
	 */
	public boolean delete(int id);

	/**
	 * ����
	 * @param student ѧ������
	 * @return
	 */
	public boolean update(Student student);

	/**
	 * ����id��ѯ
	 * @param id ѧ��id
	 * @return
	 */
	public Student query(int id);

	/**
	 * ��ѯ����
	 * @return
	 */
	public List<Student> findAll();

	/**
	 * ��ҳ
	 * @param pageNo  
	 * @param pageSize
	 * @param queryStr
	 * @return
	 */
	public PageModel findAll(int pageNo, int pageSize, String queryStr, Grade grade);


}
