package cn.sims.services;

import java.util.List;

import cn.sims.domain.Teacher;
import cn.sims.tool.PageModel;

public interface TeacherService {

	// 登录
	public Teacher login(String username, String password);

	// 增加老师
	public boolean add(Teacher teacher);

	// 删除
	public boolean del(int id);

	// 更新
	public boolean modify(Teacher teacher);

	// 根据id查询
	public Teacher find(int id);

	// 查询所有
	public List<Teacher> findAll();

}
