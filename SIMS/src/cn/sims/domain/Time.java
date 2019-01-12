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
	 * ʱ�䣨ƽ̨���ţ�id
	 */
	private int id;
	/**
	 * ��ʼʱ��
	 */
	private Date startTime;
	/**
	 * ����ʱ��
	 */
	private Date endTime;
	/**
	 * ƽ̨���ʵϰ��ʵѵ��
	 */
	private String type;
	/**
	 * ���Ƶ��꼶
	 */
	private Grade grade;
	 

}
