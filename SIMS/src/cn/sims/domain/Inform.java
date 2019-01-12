package cn.sims.domain;

import java.util.Date;

public class Inform {

	public Inform() {
	}

	public Inform(int id, String title, int scope, String descr, Date date,
			Grade grade) {
		super();
		this.id = id;
		this.title = title;
		this.scope = scope;
		this.descr = descr;
		this.date = date;
		this.grade = grade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public int getScope() {
		return scope;
	}

	public void setScope(int scope) {
		this.scope = scope;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	/**
	 * ��Ϣid
	 */
	private int id;
	/**
	 * ����
	 */
	private String title;
	/**
	 * ��Χ 0,1,2,3 �ֱ����ȫ��ѧ���͸�����ѧ��
	 */
	private int scope;
	/**
	 * ����
	 */
	private String descr;
	/**
	 * ��������
	 */
	private Date date;
	/**
	 * �꼶
	 */
	private Grade grade;

}
