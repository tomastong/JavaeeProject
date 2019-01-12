package cn.sims.domain;

import java.util.Set;

public class Teacher {

	public Teacher() {
	}

	public Teacher(int id, String name, String sex, int age, String tel,
			String jobNum, String password, String address, String imgSrc,
			Set<Course> courses, Grade grade, Direction direction,
			Classes classes) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.tel = tel;
		this.jobNum = jobNum;
		this.password = password;
		this.address = address;
		this.imgSrc = imgSrc;
		this.courses = courses;
		this.grade = grade;
		this.direction = direction;
		this.classes = classes;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public Classes getClasses() {
		return classes;
	}

	public void setClasses(Classes classes) {
		this.classes = classes;
	}

	/**
	 * 教师id
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
	 * 年龄
	 */
	private int age;
	/**
	 * 联系方式
	 */
	private String tel;
	/**
	 * 工号
	 */
	private String jobNum;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 家庭住址
	 */
	private String address;
	/**
	 * 头像路径
	 */
	private String imgSrc;
	/**
	 * 负责课程
	 */
	private Set<Course> courses;
	/**
	 * 所在年级
	 */
	private Grade grade;
	/**
	 * 所在方向
	 */
	private Direction direction;
	/**
	 * 所在班级
	 */
	private Classes classes;

}
