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

import cn.itjava.domain.GCate;
import cn.itjava.domain.Log;
import cn.itjava.service.GCateService;
import cn.itjava.service.LogService;
import cn.itjava.service.impl.GCateServiceImpl;
import cn.itjava.service.impl.LogServiceImpl;
import cn.itjava.util.PageModel;

/**
 * Servlet implementation class GCateServlet
 */
@WebServlet(description = "处理商品类别管理", urlPatterns = { "/gcate.do" })
public class GCateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GCateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		GCateService gcateService = new GCateServiceImpl();
		
		LogService logService = new LogServiceImpl();
		Date time = new Date();
		Log log = new Log();
		log.setName(request.getSession().getAttribute("name").toString());
		log.setTime(new Timestamp(time.getTime()));
		if ("add".equals(method)) {
			log.setOpera("添加商品类别");
		} else if ("see".equals(method)) {
			log.setOpera("查看商品类别");
		} else if ("seePage".equals(method)) {
			log.setOpera("浏览商品类别");
		} else if ("del".equals(method)) {
			log.setOpera("删除商品类别");
		} else if ("delPage".equals(method)) {
			log.setOpera("批量删除商品类别");
		} else if ("upd".equals(method)) {
			log.setOpera("修改商品类别信息");
		} else if ("dispGCate".equals(method)) {
			log.setOpera("读取下拉式商品类别列表");
		}
		logService.addRecord(log);
		
		if ("add".equals(method)) {
			String category = request.getParameter("category");
			GCate gcate = new GCate();
			gcate.setName(category);

			boolean flag = gcateService.addGCate(gcate);
			if (flag) {
				request.setAttribute("addAns", "success");
			} else {
				request.setAttribute("addAns", "error");
			}
			
			request.getRequestDispatcher("/auth/AddCategory.jsp").forward(request,
					response);

		} else if ("del".equals(method)) {
			int id = Integer.parseInt(request.getParameter("id"));
			System.out.println(id);
			int flag = gcateService.delGCate(id);
			if (flag==1) {
				request.setAttribute("delAns", "success");
			} else if(flag==0){
				request.setAttribute("delAns", "error");
			} else{
				request.setAttribute("delAns", "other");
			}
			request.getRequestDispatcher("/gcate.do?method=seePage").forward(request,
					response);
		} else if ("delPage".equals(method)) {
			String str = request.getParameter("ids");
			String[] arr = str.split(",");
			int [] ids = new int[arr.length];
			for (int i=0; i<ids.length; i++){
				ids[i] = Integer.parseInt(arr[i]);
			}
			int flag = gcateService.delGCate(ids);
			if (flag==1) {
				request.setAttribute("delPageAns", "success");
			} else if(flag==0){
				request.setAttribute("delPageAns", "error");
			} else{
				request.setAttribute("delPageAns", "other");
			}
			request.getRequestDispatcher("/gcate.do?method=seePage").forward(request,
					response);
		} else if ("see".equals(method)) {
			int id = Integer.parseInt(request.getParameter("id"));
			GCate gcate = gcateService.queGCate(id);
			request.setAttribute("gcate", gcate);
			request.getRequestDispatcher("/auth/DispGCate.jsp").forward(request,
					response);
		} else if ("seePage".equals(method)) {
			int pageNo = 0;
			String str = request.getParameter("str");
			if(str==null){
				str="";
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
			
			PageModel pageModel = gcateService.pageGCates(str, pageNo);

			request.setAttribute("pageModel", pageModel);
			request.setAttribute("str", str);
			request.getRequestDispatcher("/auth/CheckGoodsCategory.jsp").forward(request, response);
		} else if ("upd".equals(method)) {
			String category = request.getParameter("category");
			int id = Integer.parseInt(request.getParameter("GCateId"));
			GCate gcate = new GCate(id, category);
			boolean flag = gcateService.updGCate(gcate, id);
			if (flag) {
				request.setAttribute("updAns", "success");
			} else {
				request.setAttribute("updAns", "error");
			}
			request.getRequestDispatcher("/gcate.do?method=seePage").forward(request,
					response);
		} else if("dispGCate".equals(method)){
			String dir = request.getParameter("dir");
			List<GCate> list = gcateService.queryList();
			request.setAttribute("list", list);
			
			if("DispGoods".equals(dir)){
				request.getRequestDispatcher("/auth/DispGoods.jsp").forward(request, response);
			}else if("SeeGoods".equals(dir)){
				request.getRequestDispatcher("/auth/SeeGoods.jsp").forward(request, response);
			}else{
				request.getRequestDispatcher("/auth/AddGoods.jsp").forward(request, response);
			}
		}
	}

}
