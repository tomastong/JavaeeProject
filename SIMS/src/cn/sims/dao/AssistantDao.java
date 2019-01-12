package cn.sims.dao;

import java.util.List;

import cn.sims.domain.Assistant;
import cn.sims.domain.Direction;
import cn.sims.domain.Inform;
import cn.sims.domain.InternshipDirection;
import cn.sims.domain.ZhouJi;
import cn.sims.tool.PageModel;

public interface AssistantDao {
	
	/**
	 * 登录
	 * @param username     登录名
	 * @param password     密码
	 * @return
	 */
	public Assistant login(String username, String password);
	
	
	// 辅导员自身的增删改查 //////////////////////////////////////////
	
	/**
	 * 增加辅导员
	 * @param assistant    辅导员对象
	 * @return
	 */
	public boolean insert(Assistant assistant);
 
	/**
	 * 删除
	 * @param id      辅导员id
	 * @return
	 */
	public boolean delete(int id);

	/**
	 * 更新 
	 * @param assistant    辅导员对象
	 * @return
	 */
	public boolean update(Assistant assistant);
	
	/**
	 * 根据id查询
	 * @param id      辅导员id
	 * @return
	 */
	public Assistant query(int id);

	/**
	 * 查询所有
	 * @return
	 */
	public List<Assistant> findAll();

}
