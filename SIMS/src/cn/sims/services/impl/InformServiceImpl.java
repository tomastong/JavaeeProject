package cn.sims.services.impl;

import java.util.List;

import cn.sims.dao.InformDao;
import cn.sims.domain.Assistant;
import cn.sims.domain.Inform;
import cn.sims.services.InformService;
import cn.sims.tool.PageModel;

public class InformServiceImpl implements InformService {

	@Override
	public boolean add(Inform inform) {
		return informDao.insert(inform);
	}

	@Override
	public boolean del(int id) {
		return informDao.delete(id);
	}

	@Override
	public boolean modify(Inform inform) {
		return informDao.update(inform);
	}

	@Override
	public Inform find(int id) {
		return informDao.query(id);
	}

	@Override
	public List<Inform> findAll(Assistant assistant, int scope) {
		return informDao.findAll(assistant, scope);
	}

	@Override
	public PageModel findAll(int pageNo, int pageSize, String queryStr) {
		return informDao.findAll(pageNo, pageSize, queryStr);
	}
	
////////////////////////////////////////////////////////////////////////////////
	
	public InformDao getInformDao() {
		return informDao;
	}

	public void setInformDao(InformDao informDao) {
		this.informDao = informDao;
	}



	/**
	 * 通知Dao的引用
	 */
     private InformDao informDao;
}
