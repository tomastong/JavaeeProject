package cn.itjava.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itjava.domain.Log;
import cn.itjava.domain.User;
import cn.itjava.service.LogService;
import cn.itjava.service.UserService;
import cn.itjava.service.impl.LogServiceImpl;
import cn.itjava.service.impl.UserServiceImpl;
import cn.itjava.util.PageModel;

/**
 * Servlet implementation class UsersServlet
 */
@WebServlet(description = "用于处理用用户管理的操作", urlPatterns = { "/users.do" })
public class UsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsersServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		UserService userService = new UserServiceImpl();

		LogService logService = new LogServiceImpl();
		Date time = new Date();
		Log log = new Log();
		log.setName(request.getSession().getAttribute("name").toString());
		log.setTime(new Timestamp(time.getTime()));
		if ("modPass".equals(method)) {
			log.setOpera("修改密码");
		} else if ("add".equals(method)) {
			log.setOpera("添加用户");
		} else if ("see".equals(method)) {
			log.setOpera("查看用户");
		} else if ("seePage".equals(method)) {
			log.setOpera("浏览用户");
		} else if ("del".equals(method)) {
			log.setOpera("删除用户");
		} else if ("delPage".equals(method)) {
			log.setOpera("批量删除用户");
		} else if ("upd".equals(method)) {
			log.setOpera("修改用户");
		}
		logService.addRecord(log);
		
		if ("modPass".equals(method)) {
			String pwd = request.getParameter("pwd");
			String newpwd = request.getParameter("newpwd");
			String renewpwd = request.getParameter("renewpwd");

			String name = request.getSession().getAttribute("name").toString();
			User user = new User();
			user.setFlag(false);
			user.setName(name);
			user.setPassword(pwd);

			boolean flag = userService.modifyPassword(user, newpwd);
			if (flag) {
				request.setAttribute("passAns", "success");
			} else {
				request.setAttribute("passAns", "error");
			}
			request.getRequestDispatcher("/auth/Welcome.jsp").forward(request,
					response);
		} else if ("add".equals(method)) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			User user = new User();
			user.setFlag(false);
			user.setName(username);
			user.setPassword(password);

			boolean flag = userService.addUser(user);
			if (flag) {
				request.setAttribute("addAns", "success");
			} else {
				request.setAttribute("addAns", "error");
			}
			request.getRequestDispatcher("/auth/AddUsers.jsp").forward(request,
					response);
		} else if ("see".equals(method)) {
			int id = Integer.parseInt(request.getParameter("id"));
			User user = new User();
			user = userService.queUser(id);
			request.setAttribute("user", user);
			request.getRequestDispatcher("/auth/DispUser.jsp").forward(request,
					response);

		} else if ("seePage".equals(method)) {
			int pageNo = 0;
			if (request.getParameter("pageNo") != null) {
				try {
					pageNo = Integer.parseInt(request.getParameter("pageNo"));
				} catch (Exception e) {
					pageNo = 1;
				}
			} else {
				pageNo = 1;
			}
			PageModel pageModel = userService.pageQueryUsers(pageNo);
			request.setAttribute("pageModel", pageModel);
			request.getRequestDispatcher("/auth/CheckUsers.jsp").forward(request,
					response);
		} else if ("del".equals(method)) {
			int id = Integer.parseInt(request.getParameter("id"));
			boolean flag = false;
			flag = userService.delUser(id);
			if (flag) {
				request.setAttribute("delAns", "success");
			} else {
				request.setAttribute("delAns", "error");
			}
			request.getRequestDispatcher("/users.do?method=seePage").forward(request,
					response);

		} else if ("upd".equals(method)) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			int id = Integer.parseInt(request.getParameter("userid"));
			User user = new User();
			user.setName(username);
			user.setPassword(password);
			boolean flag = userService.updUser(user, id);
			if (flag) {
				request.setAttribute("updAns", "success");
			} else {
				request.setAttribute("updAns", "error");
			}
			request.getRequestDispatcher("/users.do?method=seePage").forward(request,
					response);
		}
	}
}
