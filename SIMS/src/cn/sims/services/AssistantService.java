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
	
	// ��¼
	public Assistant login(String username, String password);

	// ���Ӹ���Ա
	public boolean add(Assistant assistant);

	// ɾ��
	public boolean del(int id);

	// ����
	public boolean modify(Assistant assistant);

	// ����id��ѯ
	public Assistant find(int id);

	// ��ѯ����
	public List<Assistant> findAll();

	// ����֪ͨ
	public boolean addInform(Inform inform);

	// �޸�ʵѵ����
	public boolean modifyShiXun(Direction direction);

	// ����ܼ�
	public boolean checkZjStatus(ZhouJi zhouJi);

	// ���ʵϰȥ��
	public boolean checkShiXiStatus(InternshipDirection internshipDirection);

	// �鿴�ܼǵ������ʷ
	public PageModel findZjAll(int pageNo, int pageSize, String queryStr, Grade grade);

	// �鿴ʵϰ����
	public PageModel findShiXiHistory(int pageNo, int pageSize, String queryStr);

}
