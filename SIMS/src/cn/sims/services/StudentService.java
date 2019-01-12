package cn.sims.services;

import java.util.Date;
import java.util.List;

import cn.sims.domain.Direction;
import cn.sims.domain.Grade;
import cn.sims.domain.InternshipDirection;
import cn.sims.domain.Student;
import cn.sims.domain.ZhouJi;
import cn.sims.tool.PageModel;

public interface StudentService {

	// 登录
	public Student login(String username, String password);

	// 增加学生
	public boolean add(Student student);

	// 删除
	public boolean del(int id);

	// 更新
	public boolean modify(Student student);

	// 根据id查询
	public Student find(int id);

	// 查询所有
	public List<Student> findAll();
	
	// 查询学生自己的周记
	public List<ZhouJi> findAllZj(Student student);
	
	// 分页
	public PageModel findAll(int pageNo, int pageSize, String queryStr, Grade grade);

	// 查看实习申请的结果
	public Direction findShiXunResult(Student s);

	// 查看实习申请的结果
	public InternshipDirection findShiXiResult(Student s);

	// 查看实训平台能否访问
	public boolean shixunPlatform(Student s, Date date);

	// 查看实习平台能否访问
	public boolean shixiPlatform(Student s, Date date);

}
