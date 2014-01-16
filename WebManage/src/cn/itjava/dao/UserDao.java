package cn.itjava.dao;

import cn.itjava.domain.User;
import cn.itjava.util.PageModel;

public interface UserDao {
	// 这里检验登录信息
	public boolean queryInfo(User user);
	// 更新用户密码
	public boolean updatePassword(User user, String newpwd);
	// 添加用户
	public boolean addUser(User user);
	// 删除用户
	public boolean delUser(int id);
	// 更新用户
	public boolean updUser(User user, int id);
	// 查询用户
	public User queUser(int id);
	// 返回分页模型
	public PageModel pageQueryUsers(int pageNo);
}
