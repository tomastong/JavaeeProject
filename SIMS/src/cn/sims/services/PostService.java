package cn.sims.services;

import java.util.List;

import cn.sims.domain.Post;
import cn.sims.tool.PageModel;

public interface PostService {

	// ��������
	public boolean add(Post post);

	// ɾ��
	public boolean del(int id);

	// ����
	public boolean modify(Post post);

	// ����id��ѯ
	public Post find(int id);

	// ��ѯ����
	public List<Post> findAll();

	// ��ҳ
	public PageModel findAll(int pageNo, int pageSize, String queryStr);

}
