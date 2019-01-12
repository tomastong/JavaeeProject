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
	 * ����id
	 */
	private int id;
	/**
	 * ����
	 */
	private String title;
	/**
	 * ����
	 */
	private String descr;
	/**
	 * ��������
	 */
	private Date createDate;
	/**
	 * ������ѧ��
	 */
	private Student student;

}
