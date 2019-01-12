package cn.sims.services;

import java.util.Date;
import java.util.List;

import cn.sims.domain.Grade;
import cn.sims.domain.Time;

public interface TimeService {

	// 增加时间
	public boolean add(Time time);

	// 删除
	public boolean del(int id);

	// 更新
	public boolean modify(Time time);

	// 根据id查询
	public Time find(int id);

	// 查询所有
	public List<Time> findAll();

	// 检查访问平台时间是否有效
	public boolean checkShiXunValidate(Grade grade, Date date);

	// 检查访问平台时间是否有效
	public boolean checkShiXiValidate(Grade grade, Date date);

}
