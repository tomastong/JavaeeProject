package cn.itjava.service.impl;

import java.util.Date;
import java.util.List;

import cn.itjava.dao.LogDao;
import cn.itjava.dao.impl.LogDaoImpl;
import cn.itjava.domain.Log;
import cn.itjava.service.LogService;
import cn.itjava.util.PageModel;

public class LogServiceImpl implements LogService {

	@Override
	public void addRecord(Log log) {
		logDao.insertRecord(log);
	}
	
	@Override
	public PageModel pageLog(String name, int pageNo) {
		return logDao.pageLog(name, pageNo);
	}

	@Override
	public List<Log> searchByDate(String name, Date d1, Date d2) {
		return logDao.searchByDate(name, d1, d2);
	}

	LogDao logDao = new LogDaoImpl();
}
