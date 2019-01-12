package cn.sims.domain;

import java.util.Set;

public class Classes {

	public Classes() {
	}

	public Classes(int id, String name, int maxNum, Set<Student> students,
			Direction direction, Set<Teacher> teachers) {
		super();
		this.id = id;
		this.name = name;
		this.maxNum = maxNum;
		this.students = students;
		this.direction = direction;
		this.teachers = teachers;
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

	public int getMaxNum() {
		return maxNum;
	}

	public void setMaxNum(int maxNum) {
		this.maxNum = maxNum;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public Set<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}

	/**
	 * �༶id
	 */
	private int id;
	/**
	 * ����
	 */
	private String name;
	/**
	 * ��������
	 */
	private int maxNum;
	/**
	 * ӵ��ѧ��
	 */
	private Set<Student> students;
	/**
	 * ˫����������ʷ���
	 */
	private Direction direction;
	/**
	 * ��ʦ����
	 */
	private Set<Teacher> teachers;

}
