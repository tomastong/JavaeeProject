package cn.sims.services;

import java.util.List;

import cn.sims.domain.Direction;
import cn.sims.domain.Grade;

public interface DirectionService {

	// ����ʵѵ
	public boolean add(Direction direction);

	// ɾ��
	public boolean del(int id);

	// ����
	public boolean modify(Direction direction);

	// ����id��ѯ
	public Direction find(int id);

	// ��ѯ���з���
	public List<Direction> findAll(Grade grade);
	
	// ��ѯ���з���
	public List<Direction> findAll();

}
