package cn.sims.services;

import java.util.List;

import cn.sims.domain.Classes;

public interface ClassesService {

	// ���Ӱ༶
	public boolean add(Classes classes);

	// ɾ��
	public boolean del(int id);

	// ����
	public boolean modify(Classes classes);

	// ����id��ѯ
	public Classes find(int id);

	// ��ѯ����
	public List<Classes> findAll();

}
