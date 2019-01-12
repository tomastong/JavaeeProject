package cn.sims.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import cn.sims.domain.Resources;
import cn.sims.services.ResourcesService;

import com.opensymphony.xwork2.ActionSupport;

public class DownloadAction extends ActionSupport {

	// �������ļ�ԭʼ���·����ȡ�õ��ļ������
	public InputStream getInputStream() throws Exception {

		Resources res = resourcesService.find(id);
		fileName = new String(res.getFileName().getBytes(), "ISO8859-1");
		File file = new File(res.getFileUrl());
		InputStream inputStream = null;

		try {
			inputStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			System.out.println("DownloadAction��" + e.getMessage());

		}
		return inputStream;
	}

	public String execute() {
		return "success";
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

	// /////////////////////////////////////////////////////////////////////////////////

	public ResourcesService getResourcesService() {
		return resourcesService;
	}

	public void setResourcesService(ResourcesService resourcesService) {
		this.resourcesService = resourcesService;
	}

	/**
	 * �ļ����
	 */
	private int id;
	/**
	 * �ļ�����
	 */
	private String fileName;
	/**
	 * ������Դservice
	 */
	private ResourcesService resourcesService;
}
