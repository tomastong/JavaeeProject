package cn.itjava.junit;

import java.util.List;

import org.junit.Test;

import cn.itjava.dao.GoodsDao;
import cn.itjava.dao.impl.GoodsDaoImpl;
import cn.itjava.domain.Goods;
import cn.itjava.util.PageModel;

public class GoodsDaoTest {
	
	@Test
	public void updGoods(){
		
		GoodsDao goodsDao = new GoodsDaoImpl();
		PageModel pageModel = goodsDao.pageQueryGoods("",1);
		List<Goods> list = pageModel.getList();
		for(Goods goods:list)
		System.out.println(goods.getDesc());
	}
/*	@Test
	public void updGoods(){
		
		GoodsDao goodsDao = new GoodsDaoImpl();
		Goods goods = goodsDao.queryGoods(4);
		System.out.println(goods.getDesc());
	}
*//*	@Test
	public void updGoods(){
		Goods goods = new Goods();
		goods.setName("beauty");
		GCate gcate = new GCate();
		gcate.setId(3);
		goods.setGCate(gcate);
		goods.setDesc("junit test");
		GoodsDao goodsDao = new GoodsDaoImpl();
		boolean flag = goodsDao.updateGoods(goods, 4);
		System.out.println(flag);
	}
*//*	@Test
	public void addGoods(){
		Goods goods = new Goods();
		goods.setName("schoolbag");
		GCate gcate = new GCate();
		gcate.setId(3);
		goods.setGCate(gcate);
		goods.setDesc("junit test");
		GoodsDao goodsDao = new GoodsDaoImpl();
		boolean flag = goodsDao.addGoods(goods);
		System.out.println(flag);
	}
*/}
