package cn.sims.domain;

public class Admin {

	public Admin() {
	}

	public Admin(int id, String name, String sex, int age, String position,
			String username, String password) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.position = position;
		this.username = username;
		this.password = password;
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

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 管理员id
	 */
	private int id;
	/**
	 * 管理员名字
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
	 * 职位
	 */
	private String position;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 密码
	 */
	private String password;
}
