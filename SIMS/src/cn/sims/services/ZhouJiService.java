package cn.sims.services;

import java.util.List;

import cn.sims.domain.Grade;
import cn.sims.domain.Student;
import cn.sims.domain.ZhouJi;
import cn.sims.tool.PageModel;

public interface ZhouJiService {

	// 增加周记
	public boolean add(ZhouJi zhouji);

	// 删除
	public boolean del(int id);

	// 更新
	public boolean modify(ZhouJi zhouji);

	// 根据id查询
	public ZhouJi find(int id);

	// 查询所有
	public List<ZhouJi> findOwnAll(Student student);

	// 分页
	public PageModel findAll(int pageNo, int pageSize, String queryStr, Grade grade);

}
