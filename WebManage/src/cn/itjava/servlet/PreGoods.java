package cn.itjava.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itjava.domain.Goods;
import cn.itjava.domain.News;
import cn.itjava.service.GoodsService;
import cn.itjava.service.impl.GoodsServiceImpl;
import cn.itjava.util.PageModel;

/**
 * Servlet implementation class PreGoods
 */
@WebServlet("/PreGoods.do")
public class PreGoods extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PreGoods() {
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
		GoodsService goodsService = new GoodsServiceImpl();

		if ("justSee".equals(method)) {
			int id = Integer.parseInt(request.getParameter("id"));
			System.out.println(id);
			Goods goods = goodsService.queGoods(id);
			request.setAttribute("goods", goods);
			request.getRequestDispatcher("/JustDispGoods.jsp").forward(request,
					response);
			
		} else if("seeAll".equals(method)){
			List<Goods> list = goodsService.getGoodsList();
			request.setAttribute("list", list);
			request.getRequestDispatcher("/DownBody2.jsp").forward(request,
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
			PageModel pageModel = goodsService.pageGoods("", pageNo);
			request.setAttribute("pageModel", pageModel);
			request.getRequestDispatcher("/SeeGoods.jsp").forward(request,
					response);
		}
	}

}
