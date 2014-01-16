package cn.itjava.service.impl;

import java.util.List;

import cn.itjava.dao.GCateDao;
import cn.itjava.dao.impl.GCateDaoImpl;
import cn.itjava.domain.GCate;
import cn.itjava.service.GCateService;
import cn.itjava.util.PageModel;

public class GCateServiceImpl implements GCateService {

	@Override
	public boolean addGCate(GCate gcate) {
		return gcateDao.addGCate(gcate);
	}

	@Override
	public int delGCate(int id) {
		return gcateDao.deleteGCate(id);
	}

	@Override
	public int delGCate(int[] ids) {
		return gcateDao.deleteGCate(ids);
	}

	@Override
	public boolean updGCate(GCate gcate, int id) {
		return gcateDao.updateGCate(gcate, id);
	}

	@Override
	public GCate queGCate(int id) {
		return gcateDao.queryGCate(id);
	}

	@Override
	public PageModel pageGCates(String str, int pageNo) {
		return gcateDao.pageQueryGCate(str, pageNo);
	}
	

	@Override
	public List<GCate> queryList() {
		return gcateDao.queryList();
	}
	
	GCateDao gcateDao = new GCateDaoImpl();
}
