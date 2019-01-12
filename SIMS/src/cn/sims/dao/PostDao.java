package cn.sims.dao;

import java.util.List;

import cn.sims.domain.Post;
import cn.sims.tool.PageModel;

public interface PostDao {

	
	// ���ӵ���ɾ�Ĳ� //////////////////////////////////////////

	/**
	 * ��������
	 * @param  post ���Ӷ���
	 * @return
	 */
	public boolean insert(Post post);

	/**
	 * ɾ��
	 * @param id ����id
	 * @return
	 */
	public boolean delete(int id);

	/**
	 * ����
	 * @param post ���Ӷ���
	 * @return
	 */
	public boolean update(Post post);

	/**
	 * ����id��ѯ
	 * @param id ����id
	 * @return
	 */
	public Post query(int id);

	/**
	 * ��ѯ����
	 * @return
	 */
	public List<Post> findAll();

	/**
	 * ��ҳ
	 */
	public PageModel findAll(int pageNo, int pageSize, String queryStr);

}
