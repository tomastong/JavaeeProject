package cn.itjava.service.impl;

import cn.itjava.dao.UserDao;
import cn.itjava.dao.impl.UserDaoImpl;
import cn.itjava.domain.User;
import cn.itjava.service.UserService;
import cn.itjava.util.PageModel;

public class UserServiceImpl implements UserService {

	/**
	 * 这里返回用户等级
	 * 0  查询失败
	 * 1  查询为普通用户
	 * 2 查询管理员
	 */
	@Override	
	public int searchInfo(User user) {
		boolean flag_rs = false;
		
		// 这里通过@符号标记，对管理员表进行操作
		if(user.getName().charAt(0)=='@'){
			user.setFlag(true);
			String name = user.getName().substring(1);
			user.setName(name);
			flag_rs = userDao.queryInfo(user);
			if(flag_rs){
				return 2;
			}
		}else{
			user.setFlag(false);
			flag_rs = userDao.queryInfo(user);
			if(flag_rs){
				return 1;
			}
		}
		return 0;
	}

	@Override
	public boolean modifyPassword(User user, String newpwd) {
		boolean flag = user.isFlag();
		boolean flag_rs = false;
		if(flag){
			return false;
		}
		flag_rs = userDao.updatePassword(user, newpwd);
		return flag_rs;
	}

	@Override
	public boolean addUser(User user) {
		
		return userDao.addUser(user);
	}

	@Override
	public boolean delUser(int id) {
		return userDao.delUser(id);
	}

	@Override
	public boolean updUser(User user, int id) {
		return userDao.updUser(user, id);
	}

	@Override
	public User queUser(int id) {
		return userDao.queUser(id);
	}
	

	@Override
	public PageModel pageQueryUsers(int pageNo) {
		return userDao.pageQueryUsers(pageNo);
	}

	/**
	 * 这里是user的数据访问对象
	 */
	UserDao userDao = new UserDaoImpl();
}
