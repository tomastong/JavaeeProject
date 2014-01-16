package cn.itjava.view;

import cn.itjava.domain.User;
import cn.itjava.service.UserService;
import cn.itjava.service.impl.UserServiceImpl;

public class Login {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		UserService userservice = new UserServiceImpl();
		User user = new User();
		user.setName("zhangsan");
		user.setPassword("zhangsan");
		int leval = userservice.searchInfo(user);
		System.out.println(leval);
	}

}
