package cn.sims.services.impl;

import java.util.List;

import cn.sims.dao.ResourcesDao;
import cn.sims.domain.Resources;
import cn.sims.services.ResourcesService;

public class ResourcesServiceImpl implements ResourcesService {

	@Override
	public boolean add(Resources resources) {
		return resourcesDao.insert(resources);
	}

	@Override
	public boolean del(int id) {
		return resourcesDao.delete(id);
	}

	@Override
	public boolean modify(Resources resources) {
		return resourcesDao.update(resources);
	}

	@Override
	public Resources find(int id) {
		return resourcesDao.query(id);
	}

	@Override
	public List<Resources> findAll() {
		return resourcesDao.findAll();
	}

////////////////////////////////////////////////////////////////////////////////
	
	
	public ResourcesDao getResourcesDao() {
		return resourcesDao;
	}

	public void setResourcesDao(ResourcesDao resourcesDao) {
		this.resourcesDao = resourcesDao;
	}




	/**
	 * 资源Dao的引用
	 */
	private ResourcesDao resourcesDao;
}
