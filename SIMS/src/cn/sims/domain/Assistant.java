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
	 * 辅导员id
	 */
	private int id;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 联系电话
	 */
	private String tel;
	/**
	 * 工号
	 */
	private String jobNum;
	/**
	 * 家庭住址
	 */
	private String address;
	/**
	 * 头像路径
	 */
	private String imgSrc;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 负责年级
	 */
	private Grade grade;
	/**
	 * 拥有学生
	 */
	private Set<Student> students;
}
