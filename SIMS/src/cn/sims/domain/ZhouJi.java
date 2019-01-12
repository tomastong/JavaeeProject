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
	 * 周记id
	 */
	private int id;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 描述
	 */
	private String content;
	/**
	 * 审核状态 1未审核,2通过,3未过
	 */
	private int status;
	/**
	 * 日期
	 */
	private Date date;
	/**
	 * 周记拥有者
	 */
	private Student student; 
}
