package cn.sims.services;

import java.util.List;

import cn.sims.domain.Grade;

public interface GradeService {

	// 增加年级
	public boolean add(Grade grade);

	// 删除
	public boolean del(int id);

	// 更新
	public boolean modify(Grade grade);

	// 根据id查询
	public Grade find(int id);

	// 查询所有
	public List<Grade> findAll();

}
