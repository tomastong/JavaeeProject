package cn.sims.action;

import org.apache.struts2.ServletActionContext;

import cn.sims.services.AdminService;
import cn.sims.services.AssistantService;
import cn.sims.services.StudentService;
import cn.sims.services.TeacherService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	
	public String dealLogin(){
		Object obj = null;
		String role = "";
		ActionContext ac = ActionContext.getContext();
		String rightcode = (String)ac.getSession().get("rightcode");
		if(verifycode.equals(rightcode)){
			if(1 == level){
				obj = studentService.login(username, password);
				if(obj != null){
					role = "student";
				}
			}else if(2 == level){
				obj = assistantService.login(username, password);
				if(obj != null){
					role = "assistant";
				}
			}else if(3 == level){
				obj = teacherService.login(username, password);
				if(obj != null){
					role = "teacher";
				}
			}else if(4 == level){
				obj = adminService.login(username, password);
				if(obj != null){
					role = "admin";
				}
			}
			if(obj != null){
				ac.getSession().put("user", obj);
				return role;
			}else{
				ac.put("prompt", "�û������������!");
				ac.put("username", username);
				ac.put("password", password);
				ac.put("level", level);
				return ERROR;
			}
		}else{
			ac.put("prompt", "��֤�����!");
			ac.put("username", username);
			ac.put("password", password);
			ac.put("level", level);
			return ERROR;
		}
		
	}
	
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getVerifycode() {
		return verifycode;
	}
	public void setVerifycode(String verifycode) {
		this.verifycode = verifycode;
	}

	/////////////////////////////////////////////////////////////////////////////////////////
	
	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	public AssistantService getAssistantService() {
		return assistantService;
	}

	public void setAssistantService(AssistantService assistantService) {
		this.assistantService = assistantService;
	}

	public TeacherService getTeacherService() {
		return teacherService;
	}

	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}


	/**
	 * �û�����
	 */
	private int level;
	/**
	 * �û�����
	 */
	private String username;
	/**
	 * �û�����
	 */
	private String password;
	/**
	 * ��֤��
	 */
	private String verifycode;
	
	////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * ���ù���ԱService
	 */
	private AdminService adminService;
	/**
	 * ���ø���ԱService
	 */
	private AssistantService assistantService;
	/**
	 * ���ý�ʦService
	 */
	private TeacherService teacherService;
	/**
	 * ����ѧ��Service
	 */
	private StudentService studentService;
}
