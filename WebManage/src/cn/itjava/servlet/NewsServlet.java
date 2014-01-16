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
import cn.itjava.domain.News;
import cn.itjava.service.LogService;
import cn.itjava.service.NewsService;
import cn.itjava.service.impl.LogServiceImpl;
import cn.itjava.service.impl.NewsServiceImpl;
import cn.itjava.util.PageModel;

/**
 * Servlet implementation class NewsServlet
 */
@WebServlet(description = "增删改查 新闻", urlPatterns = { "/news.do" })
public class NewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NewsServlet() {
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
		NewsService newsService = new NewsServiceImpl();

		LogService logService = new LogServiceImpl();
		Date time = new Date();
		Log log = new Log();
		log.setName(request.getSession().getAttribute("name").toString());
		log.setTime(new Timestamp(time.getTime()));
		if ("add".equals(method)) {
			log.setOpera("添加新闻");
		} else if ("see".equals(method)) {
			log.setOpera("查看新闻");
		} else if ("seePage".equals(method)) {
			log.setOpera("浏览新闻");
		} else if ("del".equals(method)) {
			log.setOpera("删除新闻");
		} else if ("delPage".equals(method)) {
			log.setOpera("批量删除新闻");
		} else if ("upd".equals(method)) {
			log.setOpera("修改新闻");
		}
		logService.addRecord(log);

		if ("add".equals(method)) {
			String title = request.getParameter("NewsTitle");
			String author = request.getParameter("NewsAuthor");
			String content = request.getParameter("NewsContent");

			News news = new News();

			news.setTitle(title);
			news.setAuthor(author);
			news.setContent(content);

			boolean flag = newsService.addNews(news);
			if (flag) {
				request.setAttribute("ans", "success");
			} else {
				request.setAttribute("ans", "error");
			}
			request.getRequestDispatcher("/auth/AddNews.jsp").forward(request,
					response);

		} else if ("del".equals(method)) {
			int id = Integer.parseInt(request.getParameter("id"));
			System.out.println(id);
			boolean flag = newsService.delNews(id);
			if (flag) {
				request.setAttribute("delAns", "success");
			} else {
				request.setAttribute("delAns", "error");
			}
			request.getRequestDispatcher("/news.do?method=seePage").forward(
					request, response);
		} else if ("delPage".equals(method)) {
			String str = request.getParameter("ids");
			String[] arr = str.split(",");
			int[] ids = new int[arr.length];
			for (int i = 0; i < ids.length; i++) {
				ids[i] = Integer.parseInt(arr[i]);
			}
			boolean flag = newsService.delNews(ids);
			if (flag) {
				request.setAttribute("delPageAns", "success");
			} else {
				request.setAttribute("delPageAns", "error");
			}
			request.getRequestDispatcher("/news.do?method=seePage").forward(
					request, response);
		} else if ("see".equals(method)) {
			int id = Integer.parseInt(request.getParameter("id"));
			News news = newsService.queNews(id);
			request.setAttribute("news", news);
			String fg = request.getParameter("flag");
			if (fg != null) {
				request.getRequestDispatcher("/auth/SeeNews.jsp").forward(
						request, response);
			} else {
				request.getRequestDispatcher("/auth/DispNews.jsp").forward(
						request, response);
			}
		} else if ("seePage".equals(method)) {
			int pageNo = 0;
			String str = request.getParameter("str");
			if (str == null) {
				str = "";
			}
			if (request.getParameter("pageNo") != null) {
				try {
					// 把接收到的页号参数转换成整形 ，并赋值给pageNo
					pageNo = Integer.parseInt(request.getParameter("pageNo"));
				} catch (Exception e) {
					pageNo = 1;
				}
			} else {
				pageNo = 1;
			}
			String name = request.getSession().getAttribute("name").toString();
			if (name.charAt(0) == '@') {
				name = "";
			}
			PageModel pageModel = newsService.pageNews(name, str, pageNo);

			request.setAttribute("pageModel", pageModel);
			request.setAttribute("str", str);
			request.getRequestDispatcher("/auth/CheckNews.jsp").forward(
					request, response);
		} else if ("upd".equals(method)) {
			String title = request.getParameter("NewsTitle");
			String author = request.getParameter("NewsAuthor");
			String content = request.getParameter("NewsContent");
			int id = Integer.parseInt(request.getParameter("NewsId"));
			News news = new News(id, title, author, content);
			boolean flag = newsService.updNews(news, id);
			if (flag) {
				request.setAttribute("updAns", "success");
			} else {
				request.setAttribute("updAns", "error");
			}
			request.getRequestDispatcher("/news.do?method=seePage").forward(
					request, response);
		}
	}
}
