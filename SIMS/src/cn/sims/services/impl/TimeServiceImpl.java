package cn.sims.services.impl;

import java.util.Date;
import java.util.List;

import cn.sims.dao.TimeDao;
import cn.sims.domain.Grade;
import cn.sims.domain.Time;
import cn.sims.services.TimeService;

public class TimeServiceImpl implements TimeService {

	@Override
	public boolean add(Time time) {
		return timeDao.insert(time);
	}

	@Override
	public boolean del(int id) {
		return timeDao.delete(id);
	}

	@Override
	public boolean modify(Time time) {
		return timeDao.update(time);
	}

	@Override
	public Time find(int id) {
		return timeDao.query(id);
	}

	@Override
	public List<Time> findAll() {
		return timeDao.findAll();
	}

	@Override
	public boolean checkShiXunValidate(Grade grade, Date date) {
		return timeDao.checkShiXunValidate(grade, date);
	}

	@Override
	public boolean checkShiXiValidate(Grade grade, Date date) {
		return timeDao.checkShiXiValidate(grade, date);
	}
	
////////////////////////////////////////////////////////////////////////////////
	
	public TimeDao getTimeDao() {
		return timeDao;
	}

	public void setTimeDao(TimeDao timeDao) {
		this.timeDao = timeDao;
	}



	/**
	 * 引用时间dao
	 */
	private TimeDao timeDao;

}
