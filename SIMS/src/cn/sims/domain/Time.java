package cn.sims.domain;

import java.util.Date;

public class Time {
	
	public Time(){}
	
	public Time(int id, Date startTime, Date endTime, Grade grade, String type) {
		super();
		this.id = id;
		this.startTime = startTime;
		this.endTime = endTime;
		this.grade = grade;
		this.type = type;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	/**
	 * 时间（平台开放）id
	 */
	private int id;
	/**
	 * 起始时间
	 */
	private Date startTime;
	/**
	 * 结束时间
	 */
	private Date endTime;
	/**
	 * 平台类别（实习或实训）
	 */
	private String type;
	/**
	 * 控制的年级
	 */
	private Grade grade;
	 

}
