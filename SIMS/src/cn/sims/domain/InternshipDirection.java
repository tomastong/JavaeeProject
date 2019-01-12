package cn.sims.domain;

import java.util.Set;

public class InternshipDirection {

	public InternshipDirection() {
	}

	
	public InternshipDirection(int id, String type, String companyName,
			int status, String internshipPosition, String companyAddress,
			String companyUrl, String addInformation, Set<Student> students,
			Grade grade) {
		super();
		this.id = id;
		this.type = type;
		this.companyName = companyName;
		this.status = status;
		this.internshipPosition = internshipPosition;
		this.companyAddress = companyAddress;
		this.companyUrl = companyUrl;
		this.addInformation = addInformation;
		this.students = students;
		this.grade = grade;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getInternshipPosition() {
		return internshipPosition;
	}

	public void setInternshipPosition(String internshipPosition) {
		this.internshipPosition = internshipPosition;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getCompanyUrl() {
		return companyUrl;
	}

	public void setCompanyUrl(String companyUrl) {
		this.companyUrl = companyUrl;
	}

	public String getAddInformation() {
		return addInformation;
	}

	public void setAddInformation(String addInformation) {
		this.addInformation = addInformation;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	/**
	 * ʵϰȥ��id
	 */
	private int id;
	/**
	 * ����
	 */
	private String type;
	/**
	 * ��λ����
	 */
	private String companyName;
	/**
	 * ���״̬ 0�����,1ͨ��,2δ��
	 */
	private int status;
	/**
	 * ʵϰ��λ
	 */
	private String internshipPosition;
	/**
	 * ��λ��ַ
	 */
	private String companyAddress;
	/**
	 * ��λ��ַ
	 */
	private String companyUrl;
	/**
	 * ������Ϣ
	 */
	private String addInformation;
	/**
	 * ӵ��ѧ��
	 */
	private Set<Student> students;
	/**
	 * �����꼶
	 */
	private Grade grade;

}
