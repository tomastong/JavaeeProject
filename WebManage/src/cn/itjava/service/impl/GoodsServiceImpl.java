package cn.itjava.service.impl;

import java.util.List;

import cn.itjava.dao.GoodsDao;
import cn.itjava.dao.impl.GoodsDaoImpl;
import cn.itjava.domain.Goods;
import cn.itjava.service.GoodsService;
import cn.itjava.util.PageModel;

public class GoodsServiceImpl implements GoodsService {

	@Override
	public boolean addGoods(Goods goods) {
		return goodsDao.addGoods(goods);
	}

	@Override
	public boolean delGoods(int id) {
		return goodsDao.deleteGoods(id);
	}

	@Override
	public boolean delGoods(int[] ids) {
		return goodsDao.deleteGoods(ids);
	}

	@Override
	public boolean updGoods(Goods goods, int id) {
		return goodsDao.updateGoods(goods, id);
	}

	@Override
	public Goods queGoods(int id) {
		return goodsDao.queryGoods(id);
	}

	@Override
	public PageModel pageGoods(String str, int pageNo) {
		return goodsDao.pageQueryGoods(str, pageNo);
	}
	
	@Override
	public List<Goods> getGoodsList() {
		return goodsDao.getGoodsList();
	}

	GoodsDao goodsDao = new GoodsDaoImpl();
}
