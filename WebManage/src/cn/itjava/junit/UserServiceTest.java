package cn.itjava.junit;

import org.junit.Test;

import cn.itjava.domain.User;
import cn.itjava.service.UserService;
import cn.itjava.service.impl.UserServiceImpl;

public class UserServiceTest {
	
	@Test
	public void del(){
		UserService userService = new UserServiceImpl();
		boolean flag = userService.delUser(3);
		System.out.println(flag);
	}
/*	@Test
	public void upd(){
		User user = new User();
		user.setName("nana");
		user.setPassword("nana");
		UserService userService = new UserServiceImpl();
		boolean flag = userService.updUser(user, 3);
		System.out.println(flag);
	}
*//*	@Test
	public void query(){
		User user = null;
		
		UserService userService = new UserServiceImpl();
		user = userService.queUser(3);
		System.out.println(user.getName()+":"+user.getPassword());
	}
*//*	@Test
	public void add(){
		User user = new User();
		user.setName("nana");
		user.setPassword("nana");
		
		UserService userService = new UserServiceImpl();
		boolean flag = userService.addUser(user);
		System.out.println(flag);
	}
*/}
