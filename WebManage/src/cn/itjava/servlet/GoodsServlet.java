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

import cn.itjava.dao.impl.GCateDaoImpl;
import cn.itjava.domain.GCate;
import cn.itjava.domain.Goods;
import cn.itjava.domain.Log;
import cn.itjava.service.GCateService;
import cn.itjava.service.GoodsService;
import cn.itjava.service.LogService;
import cn.itjava.service.impl.GCateServiceImpl;
import cn.itjava.service.impl.GoodsServiceImpl;
import cn.itjava.service.impl.LogServiceImpl;
import cn.itjava.util.PageModel;

/**
 * Servlet implementation class GoodsServlet
 */
@WebServlet("/goods.do")
public class GoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GoodsServlet() {
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
		GoodsService goodsService = new GoodsServiceImpl();
		Date time = new Date();
		LogService logService = new LogServiceImpl();
		Log log = new Log();
		log.setName(request.getSession().getAttribute("name").toString());
		log.setTime(new Timestamp(time.getTime()));
		if ("add".equals(method)) {
			log.setOpera("添加商品");
		} else if ("see".equals(method)) {
			log.setOpera("查看商品");
		} else if ("seePage".equals(method)) {
			log.setOpera("浏览商品");
		} else if ("del".equals(method)) {
			log.setOpera("删除商品");
		} else if ("delPage".equals(method)) {
			log.setOpera("批量删除商品");
		} else if ("upd".equals(method)) {
			log.setOpera("修改商品信息");
		}
		logService.addRecord(log);

		if ("add".equals(method)) {
			String name = request.getParameter("GoodsName");
			int gcateid = Integer.parseInt(request
					.getParameter("GoodsCategory"));
			String desc = request.getParameter("GoodsDescribe");

			Goods goods = new Goods();
			GCate gcate = new GCate();
			gcate.setId(gcateid);
			goods.setName(name);
			goods.setGcate(gcate);
			goods.setDesc(desc);
			boolean flag = goodsService.addGoods(goods);
			if (flag) {
				request.setAttribute("addAns", "success");
			} else {
				request.setAttribute("addAns", "error");
			}
			request.getRequestDispatcher("/auth/AddGoods.jsp").forward(request,
					response);

		} else if ("del".equals(method)) {
			int id = Integer.parseInt(request.getParameter("id"));
			boolean flag = goodsService.delGoods(id);
			if (flag) {
				request.setAttribute("delAns", "success");
			} else {
				request.setAttribute("delAns", "error");
			}
			request.getRequestDispatcher("/goods.do?method=seePage").forward(
					request, response);
		} else if ("delPage".equals(method)) {
			String str = request.getParameter("ids");
			String[] arr = str.split(",");
			int[] ids = new int[arr.length];
			for (int i = 0; i < ids.length; i++) {
				ids[i] = Integer.parseInt(arr[i]);
			}
			boolean flag = goodsService.delGoods(ids);
			if (flag) {
				request.setAttribute("delPageAns", "success");
			} else {
				request.setAttribute("delPageAns", "error");
			}
			request.getRequestDispatcher("/goods.do?method=seePage").forward(
					request, response);
		} else if ("see".equals(method)) {

			int id = Integer.parseInt(request.getParameter("id"));
			String fg = request.getParameter("flag");
			if (fg != null) {
				Goods goods = goodsService.queGoods(id);
				request.setAttribute("goods", goods);
				request.getRequestDispatcher(
						"/gcate.do?method=dispGCate&dir=SeeGoods").forward(
						request, response);
			} else {
				Goods goods = goodsService.queGoods(id);
				request.setAttribute("goods", goods);
				request.getRequestDispatcher(
						"/gcate.do?method=dispGCate&dir=DispGoods").forward(
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
			PageModel pageModel = goodsService.pageGoods(str, pageNo);

			request.setAttribute("pageModel", pageModel);
			request.setAttribute("str", str);
			request.getRequestDispatcher("/auth/CheckGoods.jsp").forward(
					request, response);
		} else if ("upd".equals(method)) {
			int id = Integer.parseInt(request.getParameter("GoodsId"));
			String name = request.getParameter("GoodsName");
			int gcateId = Integer.parseInt(request
					.getParameter("GoodsCategory"));
			String desc = request.getParameter("GoodsDescribe");
			GCate gcate = new GCate();
			gcate.setId(gcateId);
			Goods goods = new Goods(id, name, gcate, desc);
			boolean flag = goodsService.updGoods(goods, id);
			if (flag) {
				request.setAttribute("updAns", "success");
			} else {
				request.setAttribute("updAns", "error");
			}
			request.getRequestDispatcher("/goods.do?method=seePage").forward(
					request, response);
		}
	}
}
