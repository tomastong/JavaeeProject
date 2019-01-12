package cn.sims.domain;

import java.util.Date;

public class Post {

	public Post() {
	}

	public Post(int id, String title, String descr, Date createDate,
			Student student) {
		super();
		this.id = id;
		this.title = title;
		this.descr = descr;
		this.createDate = createDate;
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

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	/**
	 * 帖子id
	 */
	private int id;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 描述
	 */
	private String descr;
	/**
	 * 创建日期
	 */
	private Date createDate;
	/**
	 * 发贴的学生
	 */
	private Student student;

}
