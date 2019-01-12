package cn.sims.services.impl;

import java.util.List;

import cn.sims.dao.AssistantDao;
import cn.sims.dao.DirectionDao;
import cn.sims.dao.InformDao;
import cn.sims.dao.InternshipDirectionDao;
import cn.sims.dao.ZhouJiDao;
import cn.sims.domain.Assistant;
import cn.sims.domain.Direction;
import cn.sims.domain.Grade;
import cn.sims.domain.Inform;
import cn.sims.domain.InternshipDirection;
import cn.sims.domain.ZhouJi;
import cn.sims.services.AssistantService;
import cn.sims.tool.PageModel;

public class AssistantServiceImpl implements AssistantService {

	@Override
	public Assistant login(String username, String password) {
		return assistantDao.login(username, password);
	}

	@Override
	public boolean add(Assistant assistant) {
		
		return assistantDao.insert(assistant);
	}

	@Override
	public boolean del(int id) {
		
		return assistantDao.delete(id);
	}

	@Override
	public boolean modify(Assistant assistant) {
		return assistantDao.update(assistant);
	}

	@Override
	public Assistant find(int id) {
		return assistantDao.query(id);
	}

	@Override
	public List<Assistant> findAll() {
		return assistantDao.findAll();
	}

	@Override
	public boolean addInform(Inform inform) {
		return informDao.insert(inform);
	}

	@Override
	public boolean modifyShiXun(Direction direction) {
		return shixunDao.update(direction);
	}

	@Override
	public boolean checkZjStatus(ZhouJi zhouJi) {
		return zjDao.update(zhouJi);
	}

	@Override
	public boolean checkShiXiStatus(InternshipDirection internshipDirection) {
		return shixiDao.update(internshipDirection);
	}

	@Override
	public PageModel findZjAll(int pageNo, int pageSize, String queryStr, Grade grade) {
		return zjDao.findAll(pageNo, pageSize, queryStr, grade);
	}

	@Override
	public PageModel findShiXiHistory(int pageNo, int pageSize, String queryStr) {
		return shixiDao.findInternshipDirectionAll(pageNo, pageSize, queryStr);
	}
	
////////////////////////////////////////////////////////////////////////////////
	

	public InformDao getInformDao() {
		return informDao;
	}

	public void setInformDao(InformDao informDao) {
		this.informDao = informDao;
	}

	public ZhouJiDao getZjDao() {
		return zjDao;
	}

	public void setZjDao(ZhouJiDao zjDao) {
		this.zjDao = zjDao;
	}

	public InternshipDirectionDao getShixiDao() {
		return shixiDao;
	}

	public void setShixiDao(InternshipDirectionDao shixiDao) {
		this.shixiDao = shixiDao;
	}

	public DirectionDao getShixunDao() {
		return shixunDao;
	}

	public void setShixunDao(DirectionDao shixunDao) {
		this.shixunDao = shixunDao;
	}

	public AssistantDao getAssistantDao() {
		return assistantDao;
	}

	public void setAssistantDao(AssistantDao assistantDao) {
		this.assistantDao = assistantDao;
	}

	/**
	 * 通知的引用
	 */
	private InformDao informDao;
	/**
	 * 周记dao的引用
	 */
	private ZhouJiDao zjDao;
	/**
	 * 实习dao的引用
	 */
	private InternshipDirectionDao shixiDao;
	/**
	 * 实训dao的引用
	 */
	private DirectionDao shixunDao;
	/**
	 * 辅导员dao的引用
	 */
	private AssistantDao assistantDao;
}
