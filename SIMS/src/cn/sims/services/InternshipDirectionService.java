package cn.sims.services;

import cn.sims.domain.InternshipDirection;
import cn.sims.tool.PageModel;

public interface InternshipDirectionService {

	// 增加实习
	public boolean add(InternshipDirection internshipDirection);

	// 删除
	public boolean del(int id);

	// 更新
	public boolean modify(InternshipDirection internshipDirection);

	// 根据id查询
	public InternshipDirection find(int id);

	// 查询实习申请方向分页模型
	public PageModel findInternshipDirectionAll(int pageNo, int pageSize,
			String queryStr);

}
