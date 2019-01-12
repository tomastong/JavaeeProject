package cn.sims.services;

import cn.sims.domain.InternshipDirection;
import cn.sims.tool.PageModel;

public interface InternshipDirectionService {

	// ����ʵϰ
	public boolean add(InternshipDirection internshipDirection);

	// ɾ��
	public boolean del(int id);

	// ����
	public boolean modify(InternshipDirection internshipDirection);

	// ����id��ѯ
	public InternshipDirection find(int id);

	// ��ѯʵϰ���뷽���ҳģ��
	public PageModel findInternshipDirectionAll(int pageNo, int pageSize,
			String queryStr);

}
