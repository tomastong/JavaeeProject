package cn.itjava.service;

import cn.itjava.domain.User;
import cn.itjava.util.PageModel;

public interface UserService {
	// 这里检验登录信息，返回用户等级
	public int searchInfo(User user);

	// 修改密码
	public boolean modifyPassword(User user, String newpwd);

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
