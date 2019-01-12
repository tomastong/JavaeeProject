package cn.sims.domain;

import java.util.Set;

public class Student {

	public Student() {
	}

	public Student(int id, String name, String tel, String sno,
			String password, String sex, int age, String address,
			String imgSrc, Grade grade, Set<ZhouJi> zjs, Set<Post> posts,
			InternshipDirection internshipDirection, Direction direction,
			Classes classes) {
		super();
		this.id = id;
		this.name = name;
		this.tel = tel;
		this.sno = sno;
		this.password = password;
		this.sex = sex;
		this.age = age;
		this.address = address;
		this.imgSrc = imgSrc;
		this.grade = grade;
		this.zjs = zjs;
		this.posts = posts;
		this.internshipDirection = internshipDirection;
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

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public Set<ZhouJi> getZjs() {
		return zjs;
	}

	public void setZjs(Set<ZhouJi> zjs) {
		this.zjs = zjs;
	}

	public Set<Post> getPosts() {
		return posts;
	}

	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}

	public InternshipDirection getInternshipDirection() {
		return internshipDirection;
	}

	public void setInternshipDirection(InternshipDirection internshipDirection) {
		this.internshipDirection = internshipDirection;
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

	public Assistant getAssistant() {
		return assistant;
	}

	public void setAssistant(Assistant assistant) {
		this.assistant = assistant;
	}

	/**
	 * 学生id
	 */
	private int id;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 联系方式
	 */
	private String tel;
	/**
	 * 学号
	 */
	private String sno;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 年龄
	 */
	private int age;
	/**
	 * 家庭住址
	 */
	private String address;
	/**
	 * 头像路径
	 */
	private String imgSrc;
	/**
	 * 所属年级对象
	 */
	private Grade grade;
	/**
	 * 发布的周记
	 */
	private Set<ZhouJi> zjs;
	/**
	 * 发布的帖子
	 */
	private Set<Post> posts;
	/**
	 * 实习方向
	 */
	private InternshipDirection internshipDirection;
	/**
	 * 实训方向
	 */
	private Direction direction;
	/**
	 * 所属班级
	 */
	private Classes classes;
	/**
	 * 所属辅导员
	 */
	private Assistant assistant;

}
