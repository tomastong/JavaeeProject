package cn.sims.dao;

import java.util.Date;
import java.util.List;

import cn.sims.domain.Grade;
import cn.sims.domain.Time;

public interface TimeDao {
	
	// 时间的增删改查 //////////////////////////////////////////

	/**
	 * 增加时间
	 * 
	 * @param  time 时间对象
	 * @return
	 */
	public boolean insert(Time time);

	/**
	 * 删除
	 * @param id 时间id
	 * @return
	 */
	public boolean delete(int id);

	/**
	 * 更新
	 * @param time 时间对象
	 * @return
	 */
	public boolean update(Time time);

	/**
	 * 根据id查询
	 * @param id 时间id
	 * @return
	 */
	public Time query(int id);

	/**
	 * 查询所有
	 * @return
	 */
	public List<Time> findAll();
	
	// 审核日期是否有效//////////////////////////////////////////////////
	
	 /**
	  * 检查访问平台时间是否有效
	  * @param grade 当前年级
	  * @param grade 当前时间
	  * @return true有效 false 无效
	  */
	public boolean checkShiXunValidate(Grade grade, Date date);
	 /**
	  * 检查访问平台时间是否有效
	  * @param grade 当前年级
	  * @param grade 当前时间
	  * @return true有效 false 无效
	  */
	public boolean checkShiXiValidate(Grade grade, Date date);
	
}
