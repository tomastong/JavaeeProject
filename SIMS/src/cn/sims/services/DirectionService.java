package cn.sims.services;

import java.util.List;

import cn.sims.domain.Direction;
import cn.sims.domain.Grade;

public interface DirectionService {

	// 增加实训
	public boolean add(Direction direction);

	// 删除
	public boolean del(int id);

	// 更新
	public boolean modify(Direction direction);

	// 根据id查询
	public Direction find(int id);

	// 查询所有方向
	public List<Direction> findAll(Grade grade);
	
	// 查询所有方向
	public List<Direction> findAll();

}
