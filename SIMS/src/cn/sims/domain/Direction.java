package cn.sims.domain;

import java.util.Set;

public class Direction {

	public Direction() {
	}

	public Direction(int id, String name, Set<Student> students,
			Set<Teacher> teachers, Set<Classes> classes, Grade grade) {
		super();
		this.id = id;
		this.name = name;
		this.students = students;
		this.teachers = teachers;
		this.classes = classes;
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

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public Set<Classes> getClasses() {
		return classes;
	}

	public void setClasses(Set<Classes> classes) {
		this.classes = classes;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public Set<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}

	/**
	 * 方向id
	 */
	private int id;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 拥有学生
	 */
	private Set<Student> students;
	/**
	 * 拥有教师
	 */
	private Set<Teacher> teachers;
	/**
	 * 拥有班级
	 */
	private Set<Classes> classes;
	/**
	 * 双向关联，访问年级
	 */
	private Grade grade;

}
