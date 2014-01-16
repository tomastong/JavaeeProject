package cn.itjava.service;

import java.util.List;

import cn.itjava.domain.GCate;
import cn.itjava.domain.News;
import cn.itjava.util.PageModel;

public interface GCateService {

	// 添加类别
	public boolean addGCate(GCate gcate);

	// 删除单个类别
	public int delGCate(int id);

	// 批量删除类别
	public int delGCate(int[] ids);

	// 更新类别
	public boolean updGCate(GCate gcate, int id);

	// 查询类别
	public GCate queGCate(int id);

	// 返回分页模型
	public PageModel pageGCates(String str, int pageNo);

	// 返回所有类别集合，用来添加商品
	public List<GCate> queryList();
}
