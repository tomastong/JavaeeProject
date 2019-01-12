package cn.sims.services;

import java.util.List;

import cn.sims.domain.Assistant;
import cn.sims.domain.Inform;
import cn.sims.tool.PageModel;

public interface InformService {

	// 增加通知
	public boolean add(Inform inform);

	// 删除
	public boolean del(int id);

	// 更新
	public boolean modify(Inform inform);

	// 根据id查询
	public Inform find(int id);

	// 查询所有
	public List<Inform> findAll(Assistant assistant, int scope);

	// 分页
	public PageModel findAll(int pageNo, int pageSize, String queryStr);

}
