package cn.itjava.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itjava.domain.Log;
import cn.itjava.service.LogService;
import cn.itjava.service.impl.LogServiceImpl;
import cn.itjava.util.PageModel;

/**
 * Servlet implementation class LogServlet
 */
@WebServlet("/log.do")
public class LogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LogServlet() {
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
		LogService logService = new LogServiceImpl();

		int pageNo = 0;
		String queBy = request.getParameter("queBy");
		if (queBy == null) {
			String str = request.getParameter("pageNo");
			if (request.getParameter("pageNo") != null) {
				try {
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
			PageModel pageModel = logService.pageLog(name, pageNo);

			request.setAttribute("pageModel", pageModel);
			request.getRequestDispatcher("/auth/LogManage.jsp").forward(
					request, response);
		}else{
			String startDate = request.getParameter("startDate");
			String endDate = request.getParameter("endDate");
			
			String[] s1 = startDate.split("-");
			int y1 = Integer.parseInt(s1[0]); 
			int m1 = Integer.parseInt(s1[1]); 
			int d1 = Integer.parseInt(s1[2]); 
			Calendar c1 = Calendar.getInstance();
			c1.set(y1, m1-1, d1);
			
			String[] s2 = endDate.split("-");
			int y2 = Integer.parseInt(s2[0]); 
			int m2 = Integer.parseInt(s2[1]); 
			int d2 = Integer.parseInt(s2[2]); 
			Calendar c2 = Calendar.getInstance();
			c2.set(y2, m2-1, d2);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			System.out.println(sdf.format(c2.getTime()));
			String name = request.getSession().getAttribute("name").toString();
			if (name.charAt(0) == '@') {
				name = "";
			}
			List<Log> list = logService.searchByDate(name, c1.getTime(), c2.getTime());
			request.setAttribute("list", list);
			request.getRequestDispatcher("/auth/DateLog.jsp").forward(
					request, response);
		}
	}

}
