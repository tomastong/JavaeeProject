package cn.sims.services;

import java.util.List;

import cn.sims.domain.Resources;

public interface ResourcesService {

	// 增加资源
	public boolean add(Resources resources);

	// 删除
	public boolean del(int id);

	// 更新
	public boolean modify(Resources resources);

	// 根据id查询
	public Resources find(int id);

	// 查询所有
	public List<Resources> findAll();

}
