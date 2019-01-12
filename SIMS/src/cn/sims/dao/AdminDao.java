package cn.sims.dao;

import java.util.List;

import cn.sims.domain.Admin;
import cn.sims.domain.Assistant;
import cn.sims.domain.Student;
import cn.sims.domain.Teacher;
import cn.sims.domain.Time;
import cn.sims.tool.PageModel;

public interface AdminDao {

	/**
	 * 登录
	 * @param username  登录名
	 * @param password 密码
	 * @return
	 */
	public Admin login(String username, String password);

	/**
	 * 查找
	 */
	public Admin findAdmin(int id);
	/**
	 * 更新管理员（修改密码）
	 * @param admin 管理员对象
	 * @return
	 */
	public boolean update(Admin admin);

}
