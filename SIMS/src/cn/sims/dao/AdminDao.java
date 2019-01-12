package cn.sims.dao;

import java.util.List;

import cn.sims.domain.Admin;
import cn.sims.domain.Assistant;
import cn.sims.domain.Student;
import cn.sims.domain.Teacher;
import cn.sims.domain.Time;
import cn.sims.tool.PageModel;

public interface AdminDao {

	/**
	 * ��¼
	 * @param username  ��¼��
	 * @param password ����
	 * @return
	 */
	public Admin login(String username, String password);

	/**
	 * ����
	 */
	public Admin findAdmin(int id);
	/**
	 * ���¹���Ա���޸����룩
	 * @param admin ����Ա����
	 * @return
	 */
	public boolean update(Admin admin);

}
