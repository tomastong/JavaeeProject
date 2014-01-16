package cn.itjava.service;

import java.util.List;

import cn.itjava.domain.Goods;
import cn.itjava.util.PageModel;

public interface GoodsService {

	// 添加类别
	public boolean addGoods(Goods goods);

	// 删除单个类别
	public boolean delGoods(int id);

	// 批量删除类别
	public boolean delGoods(int[] ids);

	// 更新类别
	public boolean updGoods(Goods goods, int id);

	// 查询类别
	public Goods queGoods(int id);

	// 返回分页模型
	public PageModel pageGoods(String str, int pageNo);
	
	public List<Goods> getGoodsList();
}
