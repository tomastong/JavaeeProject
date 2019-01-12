package cn.sims.services;

import java.util.List;

import cn.sims.domain.Assistant;
import cn.sims.domain.Direction;
import cn.sims.domain.Grade;
import cn.sims.domain.Inform;
import cn.sims.domain.InternshipDirection;
import cn.sims.domain.ZhouJi;
import cn.sims.tool.PageModel;

public interface AssistantService {
	
	// 登录
	public Assistant login(String username, String password);

	// 增加辅导员
	public boolean add(Assistant assistant);

	// 删除
	public boolean del(int id);

	// 更新
	public boolean modify(Assistant assistant);

	// 根据id查询
	public Assistant find(int id);

	// 查询所有
	public List<Assistant> findAll();

	// 发送通知
	public boolean addInform(Inform inform);

	// 修改实训方向
	public boolean modifyShiXun(Direction direction);

	// 审核周记
	public boolean checkZjStatus(ZhouJi zhouJi);

	// 审核实习去向
	public boolean checkShiXiStatus(InternshipDirection internshipDirection);

	// 查看周记的审核历史
	public PageModel findZjAll(int pageNo, int pageSize, String queryStr, Grade grade);

	// 查看实习申请
	public PageModel findShiXiHistory(int pageNo, int pageSize, String queryStr);

}
