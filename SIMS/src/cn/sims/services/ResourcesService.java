package cn.sims.services;

import java.util.List;

import cn.sims.domain.Resources;

public interface ResourcesService {

	// ������Դ
	public boolean add(Resources resources);

	// ɾ��
	public boolean del(int id);

	// ����
	public boolean modify(Resources resources);

	// ����id��ѯ
	public Resources find(int id);

	// ��ѯ����
	public List<Resources> findAll();

}
