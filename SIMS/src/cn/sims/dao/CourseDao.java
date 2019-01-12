package cn.sims.dao;

import java.util.List;

import cn.sims.domain.Course;
import cn.sims.tool.PageModel;

public interface CourseDao {

	// �γ̵���ɾ�Ĳ� //////////////////////////////////////////

	/**
	 * ���ӿγ�
	 * @param course �γ̶���
	 * @return
	 */
	public boolean insert(Course course);

	/**
	 * ɾ��
	 * @param id  �γ�id
	 * @return
	 */
	public boolean delete(int id);

	/**
	 * ����
	 * @param course �γ̶���
	 * @return
	 */
	public boolean update(Course course);

	/**
	 * ����id��ѯ
	 * @param id �γ�id
	 * @return
	 */
	public Course query(int id);

	/**
	 * ��ѯ����
	 * @return
	 */
	public List<Course> findAll();

}
