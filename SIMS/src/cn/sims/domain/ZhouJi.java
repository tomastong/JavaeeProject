package cn.sims.domain;

import java.util.Date;

public class ZhouJi {
	
	public ZhouJi(){}
	
	public ZhouJi(int id, String title, String content, int status, Date date,
			Student student) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.status = status;
		this.date = date;
		this.student = student;
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}


	/**
	 * �ܼ�id
	 */
	private int id;
	/**
	 * ����
	 */
	private String title;
	/**
	 * ����
	 */
	private String content;
	/**
	 * ���״̬ 1δ���,2ͨ��,3δ��
	 */
	private int status;
	/**
	 * ����
	 */
	private Date date;
	/**
	 * �ܼ�ӵ����
	 */
	private Student student; 
}
