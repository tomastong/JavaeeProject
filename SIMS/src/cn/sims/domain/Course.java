package cn.sims.domain;

public class Course {
	
	public Course(){}
	
	public Course(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	
	
	/**
	 * ¿Î³Ìid
	 */
	private int id;
	/**
	 * Ãû³Æ
	 */
    private String name;
}
