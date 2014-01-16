package cn.itjava.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itjava.domain.News;
import cn.itjava.service.NewsService;
import cn.itjava.service.impl.NewsServiceImpl;
import cn.itjava.util.PageModel;

/**
 * Servlet implementation class PreNews
 */
@WebServlet("/PreNews.do")
public class PreNews extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PreNews() {
		super();
		// TODO Auto-generated constructor stub
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

		if ("justSee".equals(method)) {
			int id = Integer.parseInt(request.getParameter("id"));
			System.out.println(id);
			News news = newsService.queNews(id);
			request.setAttribute("news", news);
			request.getRequestDispatcher("/JustDispNews.jsp").forward(request,
					response);
			
		} else if("seeAll".equals(method)){
			List<News> list = newsService.getNewsList();
			request.setAttribute("list", list);
			request.getRequestDispatcher("/DownBody.jsp").forward(request,
					response);
		} else{
			int pageNo = 0;
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
			PageModel pageModel = newsService.pageNews("", "", pageNo);

			request.setAttribute("pageModel", pageModel);
			request.getRequestDispatcher("/SeeNews.jsp").forward(request,
					response);
		}
	}

}
