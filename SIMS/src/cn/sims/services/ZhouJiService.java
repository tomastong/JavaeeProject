package cn.sims.services;

import java.util.List;

import cn.sims.domain.Grade;
import cn.sims.domain.Student;
import cn.sims.domain.ZhouJi;
import cn.sims.tool.PageModel;

public interface ZhouJiService {

	// �����ܼ�
	public boolean add(ZhouJi zhouji);

	// ɾ��
	public boolean del(int id);

	// ����
	public boolean modify(ZhouJi zhouji);

	// ����id��ѯ
	public ZhouJi find(int id);

	// ��ѯ����
	public List<ZhouJi> findOwnAll(Student student);

	// ��ҳ
	public PageModel findAll(int pageNo, int pageSize, String queryStr, Grade grade);

}
