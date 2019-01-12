package cn.sims.services;

import java.util.List;

import cn.sims.domain.Classes;

public interface ClassesService {

	// 增加班级
	public boolean add(Classes classes);

	// 删除
	public boolean del(int id);

	// 更新
	public boolean modify(Classes classes);

	// 根据id查询
	public Classes find(int id);

	// 查询所有
	public List<Classes> findAll();

}
