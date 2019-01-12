package cn.sims.domain;

import java.util.Set;

public class Grade {

	public Grade() {
	}

	public Grade(int id, String name, Set<Student> students,
			Set<Teacher> teachers, Set<Direction> directions, Set<Time> times,
			Assistant assistant) {
		super();
		this.id = id;
		this.name = name;
		this.students = students;
		this.teachers = teachers;
		this.directions = directions;
		this.times = times;
		this.assistant = assistant;
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

	public Set<Direction> getDirections() {
		return directions;
	}

	public void setDirections(Set<Direction> directions) {
		this.directions = directions;
	}

	public Set<Time> getTimes() {
		return times;
	}

	public void setTimes(Set<Time> times) {
		this.times = times;
	}

	public Assistant getAssistant() {
		return assistant;
	}

	public void setAssistant(Assistant assistant) {
		this.assistant = assistant;
	}

	public Set<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}

	/**
	 * 年级id
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
	 * 拥有的方向
	 */
	private Set<Direction> directions;
	/**
	 * 平台开放时间
	 */
	private Set<Time> times;
	/**
	 * 辅导员
	 */
	private Assistant assistant;

}
