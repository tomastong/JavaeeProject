package cn.itjava.domain;

public class User {
	
	public User() {}
	
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	/**
	 * 用户级别：true 管理员，false 普通用户
	 */
	private boolean flag;
	/**
	 * 用户编号
	 */
	private int id;
	/**
	 * 用户名
	 */
	private String name;
	/**
	 * 用户密码
	 */
	private String password;
}
