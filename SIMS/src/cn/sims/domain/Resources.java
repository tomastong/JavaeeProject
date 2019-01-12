package cn.sims.domain;

import java.util.Date;

public class Resources {

	public Resources() {
	}

	
	public Resources(int id, String fileName, String fileSize, String fileUrl,
			Date date) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.fileSize = fileSize;
		this.fileUrl = fileUrl;
		this.date = date;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * ��Դid
	 */
	private int id;
	/**
	 * �ļ���
	 */
	private String fileName;
	/**
	 * �ļ���С
	 */
	private String fileSize;
	/**
	 * �ļ�·��
	 */
	private String fileUrl;
	/**
	 * �޸�����
	 */
	private Date date;

}
