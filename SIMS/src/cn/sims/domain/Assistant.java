package cn.sims.domain;

import java.util.Set;

public class Assistant {
	
	public Assistant() {}

	public Assistant(int id, String name, String sex, String tel,
			String jobNum, String address, String imgSrc, String password,
			Grade grade) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.tel = tel;
		this.jobNum = jobNum;
		this.address = address;
		this.imgSrc = imgSrc;
		this.password = password;
		this.grade = grade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getJobNum() {
		return jobNum;
	}

	public void setJobNum(String jobNum) {
		this.jobNum = jobNum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getImgSrc() {
		return imgSrc;
	}

	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}


	/**
	 * ����Աid
	 */
	private int id;
	/**
	 * ����
	 */
	private String name;
	/**
	 * �Ա�
	 */
	private String sex;
	/**
	 * ��ϵ�绰
	 */
	private String tel;
	/**
	 * ����
	 */
	private String jobNum;
	/**
	 * ��ͥסַ
	 */
	private String address;
	/**
	 * ͷ��·��
	 */
	private String imgSrc;
	/**
	 * ����
	 */
	private String password;
	/**
	 * �����꼶
	 */
	private Grade grade;
	/**
	 * ӵ��ѧ��
	 */
	private Set<Student> students;
}
