package cn.sims.services;

import java.util.Date;
import java.util.List;

import cn.sims.domain.Grade;
import cn.sims.domain.Time;

public interface TimeService {

	// ����ʱ��
	public boolean add(Time time);

	// ɾ��
	public boolean del(int id);

	// ����
	public boolean modify(Time time);

	// ����id��ѯ
	public Time find(int id);

	// ��ѯ����
	public List<Time> findAll();

	// ������ƽ̨ʱ���Ƿ���Ч
	public boolean checkShiXunValidate(Grade grade, Date date);

	// ������ƽ̨ʱ���Ƿ���Ч
	public boolean checkShiXiValidate(Grade grade, Date date);

}
