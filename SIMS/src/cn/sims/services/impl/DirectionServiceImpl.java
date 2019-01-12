package cn.sims.services.impl;

import java.util.List;

import cn.sims.dao.DirectionDao;
import cn.sims.domain.Direction;
import cn.sims.domain.Grade;
import cn.sims.services.DirectionService;

public class DirectionServiceImpl implements DirectionService {

	@Override
	public boolean add(Direction direction) {
		return shixunDao.insert(direction);
	}

	@Override
	public boolean del(int id) {
		return shixunDao.delete(id);
	}

	@Override
	public boolean modify(Direction direction) {
		return shixunDao.update(direction);
	}

	@Override
	public Direction find(int id) {
		return shixunDao.query(id);
	}

	@Override
	public List<Direction> findAll(Grade grade) {
		return shixunDao.findAll(grade);
	}
	
	@Override
	public List<Direction> findAll() {
		return shixunDao.findAll();
	}
	
////////////////////////////////////////////////////////////////////////////////
	
	public DirectionDao getShixunDao() {
		return shixunDao;
	}

	public void setShixunDao(DirectionDao shixunDao) {
		this.shixunDao = shixunDao;
	}

	/**
	 * 实训Dao的引用
	 */
	private DirectionDao shixunDao;

}
