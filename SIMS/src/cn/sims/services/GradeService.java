package cn.sims.services;

import java.util.List;

import cn.sims.domain.Grade;

public interface GradeService {

	// �����꼶
	public boolean add(Grade grade);

	// ɾ��
	public boolean del(int id);

	// ����
	public boolean modify(Grade grade);

	// ����id��ѯ
	public Grade find(int id);

	// ��ѯ����
	public List<Grade> findAll();

}
