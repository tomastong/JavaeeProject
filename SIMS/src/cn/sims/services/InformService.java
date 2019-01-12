package cn.sims.services;

import java.util.List;

import cn.sims.domain.Assistant;
import cn.sims.domain.Inform;
import cn.sims.tool.PageModel;

public interface InformService {

	// ����֪ͨ
	public boolean add(Inform inform);

	// ɾ��
	public boolean del(int id);

	// ����
	public boolean modify(Inform inform);

	// ����id��ѯ
	public Inform find(int id);

	// ��ѯ����
	public List<Inform> findAll(Assistant assistant, int scope);

	// ��ҳ
	public PageModel findAll(int pageNo, int pageSize, String queryStr);

}
