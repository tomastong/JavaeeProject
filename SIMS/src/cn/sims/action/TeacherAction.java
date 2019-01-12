package cn.sims.action;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import cn.sims.domain.Resources;
import cn.sims.domain.Student;
import cn.sims.domain.Teacher;
import cn.sims.services.ResourcesService;
import cn.sims.services.TeacherService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class TeacherAction extends ActionSupport {

	public String modifyPassword() {
		ActionContext ac = ActionContext.getContext();
		Teacher teacher = (Teacher) ac.getSession().get("user");
		if (oldpassword.equals(teacher.getPassword())) {
			teacher.setPassword(password);
			teacherService.modify(teacher);
			ac.put("prompt", "�����޸ĳɹ���");
			ac.put("flag", 1);
		} else {
			ac.put("prompt", "ԭ���벻��ȷ��");
			ac.put("oldpassword", oldpassword);
			ac.put("password", password);
		}
		return "alterpwd";
	}

	public String uploadFile() throws Exception {
		System.out.println("�����������");
		String realPath = ServletActionContext.getServletContext().getRealPath(
				"/resources");
		File dest = new File(realPath, uploadFileName);
		if (!dest.getParentFile().exists()) {
			dest.getParentFile().mkdirs();
		}
		FileUtils.copyFile(upload, dest);
		
		System.out.println("�����������");
		
		Resources resources = new Resources();
		resources.setFileName(uploadFileName);
		resources.setFileSize(upload.length() / (1024) + "KB");
		resources.setDate(new Date());
		resources.setFileUrl(realPath + "/" + uploadFileName);
		resourcesService.add(resources);

		return "uploadfile";
	}

	public String deleteFile() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		Resources res = resourcesService.find(id);
		File file = new File(res.getFileUrl());
		if (file.isFile() && file.exists()) {
			file.delete();
		}
		resourcesService.del(id);
		return "deletefile";
	}

	public String listRes() {
		ActionContext ac = ActionContext.getContext();
		try {
			List<Resources> list = resourcesService.findAll();
			ac.put("list", list);
		} catch (Exception e) {
			return "listfile";
		}
		return "listfile";
	}
	
	public String ownProfile() {
		ActionContext ac = ActionContext.getContext();
		try {
			Teacher t = (Teacher) ac.getSession().get("user");
			teacher = teacherService.find(t.getId());
			ac.put("teacher", teacher);
		} catch (Exception e) {
			return "ownprofile";
		}
		return "ownprofile";
	}
	
	public String getOldpassword() {
		return oldpassword;
	}

	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}	
	
	// //////////////////////////////////////////////////////////////////////////////////
	// �ļ��ϴ�

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	// //////////////////////////////////////////////////////////////////////////////////

	public TeacherService getTeacherService() {
		return teacherService;
	}

	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}

	public ResourcesService getResourcesService() {
		return resourcesService;
	}

	public void setResourcesService(ResourcesService resourcesService) {
		this.resourcesService = resourcesService;
	}

	/**
	 * ������
	 */
	private String oldpassword;
	/**
	 * ������
	 */
	private String password;
	/**
	 * ��ʦ����
	 */
	private Teacher teacher;
	// ////////////////////////////////////////////////////////////////////////////////////

	/**
	 * ���似����ȡ�ļ�
	 */
	private File upload;
	/**
	 * ��ȡ�ļ�ȫ��
	 */
	private String uploadFileName;
	/**
	 * ��ȡ�ļ���������
	 */
	private String uploadContentType;

	// ///////////////////////////////////////////////////////////////////////////////////

	/**
	 * ���ý�ʦservice
	 */
	private TeacherService teacherService;
	/**
	 * ������Դservice
	 */
	private ResourcesService resourcesService;
}
