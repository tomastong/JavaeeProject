package cn.itjava.dao;

import java.util.List;

import cn.itjava.domain.GCate;
import cn.itjava.util.PageModel;

public interface GCateDao {
		// 添加类别
		public boolean addGCate(GCate gcate);

		// 删除单个类别
		public int deleteGCate(int id);

		// 批量删除类别
		public int deleteGCate(int[] ids);

		// 更新类别
		public boolean updateGCate(GCate gcate, int id);

		// 查询类别
		public GCate queryGCate(int id);

		// 返回分页模型
		public PageModel pageQueryGCate(String str, int pageNo);
		
		// 返回所有类别集合，用来添加商品
		public List<GCate> queryList();
}
