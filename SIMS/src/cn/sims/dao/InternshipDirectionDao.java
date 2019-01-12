package cn.sims.dao;

import java.util.List;

import cn.sims.domain.InternshipDirection;
import cn.sims.tool.PageModel;

public interface InternshipDirectionDao {
	
	// 实习的增删改查 //////////////////////////////////////////

	/**
	 * 增加实习
	 * @param  internshipDirection 实习对象
	 * @return
	 */
	public boolean insert(InternshipDirection internshipDirection);

	/**
	 * 删除
	 * @param id 实习id
	 * @return
	 */
	public boolean delete(int id);

	/**
	 * 更新
	 * @param internshipDirection 实习对象
	 * @return
	 */
	public boolean update(InternshipDirection internshipDirection);

	/**
	 * 根据id查询
	 * @param id 实习id
	 * @return
	 */
	public InternshipDirection query(int id);

	/**
	 * 查询实习申请方向分页模型
	 * @param pageNo
	 * @param pageSize
	 * @param queryStr
	 * @return
	 */
	public PageModel findInternshipDirectionAll(int pageNo, int pageSize, String queryStr);

}
