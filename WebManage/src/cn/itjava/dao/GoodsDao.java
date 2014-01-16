package cn.itjava.dao;

import java.util.List;

import cn.itjava.domain.Goods;
import cn.itjava.util.PageModel;

public interface GoodsDao {
	// 添加类别
	public boolean addGoods(Goods goods);

	// 删除单个类别
	public boolean deleteGoods(int id);

	// 批量删除类别
	public boolean deleteGoods(int[] ids);

	// 更新类别
	public boolean updateGoods(Goods goods, int id);

	// 查询类别
	public Goods queryGoods(int id);

	// 返回分页模型
	public PageModel pageQueryGoods(String str, int pageNo);
	
	 public List<Goods> getGoodsList();
}
