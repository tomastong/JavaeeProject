package cn.sims.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import cn.sims.domain.Admin;
import cn.sims.domain.Assistant;
import cn.sims.domain.Classes;
import cn.sims.domain.Direction;
import cn.sims.domain.Grade;
import cn.sims.domain.Student;
import cn.sims.domain.Teacher;
import cn.sims.domain.Time;
import cn.sims.services.AdminService;
import cn.sims.services.ClassesService;
import cn.sims.services.DirectionService;
import cn.sims.services.GradeService;
import cn.sims.services.TimeService;
import cn.sims.tool.PageModel;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AdminAction extends ActionSupport {

	public String modifyPassword() {
		ActionContext ac = ActionContext.getContext();
		Admin admin = (Admin) ac.getSession().get("user");
		if (oldpassword.equals(admin.getPassword())) {
			admin.setPassword(password);
			adminService.modify(admin);
			ac.put("prompt", "密码修改成功！");
			ac.put("flag", 1);
		} else {
			ac.put("prompt", "原密码不正确！");
			ac.put("oldpassword", oldpassword);
			ac.put("password", password);
		}
		return "alterpwd";
	}

	public String ownProfile() {
		ActionContext ac = ActionContext.getContext();
		try {
			admin = (Admin) ac.getSession().get("user");
			admin = adminService.findAdmin(admin.getId());
			ac.put("admin", admin);
		} catch (Exception e) {
			return "ownprofile";
		}
		return "ownprofile";
	}

	// ///////////////////////////////////////////////////////////////////////////////////////

	public String addStudent() {
		ActionContext ac = ActionContext.getContext();
		List<Grade> list1 = gradeService.findAll();
		List<Direction> list2 = shixunService.findAll();
		List<Classes> list3 = classesService.findAll();

		// 处理上传头像
		for (Grade g : list1) {
			if (gradeName.equals(g.getName())) {
				student.setGrade(g);
				student.setAssistant(g.getAssistant());
			}
		}
		for (Direction d : list2) {
			if (directionName.equals(d.getName())
					&& gradeName.equals(d.getGrade().getName())) {
				student.setDirection(d);
			}
		}
		for (Classes c : list3) {
			if (classesName.equals(c.getName())
					&& directionName.equals(c.getDirection().getName())
					&& gradeName.equals(c.getDirection().getGrade().getName())) {
				student.setClasses(c);
			}
		}

		if (upload != null && upload.exists()) {
			try {
				String realPath = ServletActionContext.getServletContext()
						.getRealPath("/avatar");
				File dest = new File(realPath, uploadFileName);
				if (!dest.getParentFile().exists()) {
					dest.getParentFile().mkdirs();
				}
				FileUtils.copyFile(upload, dest);
				student.setImgSrc("avatar/" + uploadFileName);
			} catch (IOException e) {
				System.out.println("添加学生-上传头像:" + e.getMessage());
			}
		}

		student.setPassword(student.getSno());
		adminService.addStudent(student);
		ac.put("prompt", "添加成功！");
		return "addstudent";
	}

	public String listStudent() {
		ActionContext ac = ActionContext.getContext();
		int pageNo = (pageModel == null ? 1 : pageModel.getPageNo());
		int pageSize = (pageModel == null ? 5 : pageModel.getPageSize());
		pageModel = adminService.findAllStudent(pageNo, pageSize, null, null);
		ac.put("pageModel", pageModel);
		return "liststudent";
	}

	public String modStudent() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		Student s = adminService.findStudent(id);
		if (upload != null && upload.exists()) {
			try {
				String realPath = ServletActionContext.getServletContext()
						.getRealPath("/avatar");
				File dest = new File(realPath, uploadFileName);
				if (!dest.getParentFile().exists()) {
					dest.getParentFile().mkdirs();
				}
				FileUtils.copyFile(upload, dest);
				s.setImgSrc("avatar/" + uploadFileName);
			} catch (IOException e) {
				System.out.println("添加学生-上传头像:" + e.getMessage());
			}
		}

		List<Grade> list1 = gradeService.findAll();
		List<Direction> list2 = shixunService.findAll();
		List<Classes> list3 = classesService.findAll();

		// 处理班级年级方向
		for (Grade g : list1) {
			if (gradeName.equals(g.getName())) {
				s.setGrade(g);
				s.setAssistant(g.getAssistant());
			}
		}
		for (Direction d : list2) {
			if (directionName.equals(d.getName())
					&& gradeName.equals(d.getGrade().getName())) {
				s.setDirection(d);
			}
		}
		for (Classes c : list3) {
			if (classesName.equals(c.getName())
					&& directionName.equals(c.getDirection().getName())
					&& gradeName.equals(c.getDirection().getGrade().getName())) {
				s.setClasses(c);
			}
		}
		s.setName(student.getName());
		s.setSex(student.getSex());
		s.setAddress(student.getAddress());
		s.setAge(student.getAge());
		s.setTel(student.getTel());
		s.setSno(student.getSno());
		adminService.modStudent(s);
		return "modstudent";
	}

	public String seeStudent() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		String flag = request.getParameter("flag");
		student = adminService.findStudent(id);
		request.setAttribute("student", student);
		if ("see".equals(flag)) {
			return "seestudent";
		} else {
			return "go-alterstudent";
		}
	}

	public String delStudent() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		boolean flag = adminService.delStudent(id);
		if (flag) {
			return "delstudent";
		} else {
			return "delstudent";
		}
	}

	// ////////////////////////////////////////////////////////////////////////////////////////

	public String addTeacher() {
		ActionContext ac = ActionContext.getContext();
		List<Grade> list1 = gradeService.findAll();
		List<Direction> list2 = shixunService.findAll();
		List<Classes> list3 = classesService.findAll();

		// 处理方向和班级
		for (Grade g : list1) {
			if (gradeName.equals(g.getName())) {
				teacher.setGrade(g);
			}
		}
		for (Direction d : list2) {
			if (directionName.equals(d.getName())
					&& gradeName.equals(d.getGrade().getName())) {
				teacher.setDirection(d);
			}
		}
		for (Classes c : list3) {
			if (classesName.equals(c.getName())
					&& directionName.equals(c.getDirection().getName())
					&& gradeName.equals(c.getDirection().getGrade().getName())) {
				teacher.setClasses(c);
			}
		}
		if (upload != null && upload.exists()) {
			try {
				String realPath = ServletActionContext.getServletContext()
						.getRealPath("/avatar");
				File dest = new File(realPath, uploadFileName);
				if (!dest.getParentFile().exists()) {
					dest.getParentFile().mkdirs();
				}
				FileUtils.copyFile(upload, dest);
				teacher.setImgSrc("avatar/" + uploadFileName);
			} catch (IOException e) {
				System.out.println("添加教师-上传头像:" + e.getMessage());
			}
		}

		teacher.setPassword(teacher.getJobNum());
		adminService.addTeacher(teacher);

		return "addteacher";
	}

	public String listTeacher() {
		ActionContext ac = ActionContext.getContext();
		List<Teacher> list = adminService.findAllTeacher();
		ac.put("list", list);
		return "listteacher";
	}

	public String modTeacher() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		Teacher t = adminService.findTeacher(id);
		if (upload != null && upload.exists()) {
			try {
				String realPath = ServletActionContext.getServletContext()
						.getRealPath("/avatar");
				File dest = new File(realPath, uploadFileName);
				if (!dest.getParentFile().exists()) {
					dest.getParentFile().mkdirs();
				}
				FileUtils.copyFile(upload, dest);
				t.setImgSrc("avatar/" + uploadFileName);
			} catch (IOException e) {
				System.out.println("添加教师-上传头像:" + e.getMessage());
			}
		}

		List<Grade> list1 = gradeService.findAll();
		List<Direction> list2 = shixunService.findAll();
		List<Classes> list3 = classesService.findAll();

		// 处理班级年级方向
		for (Grade g : list1) {
			if (gradeName.equals(g.getName())) {
				t.setGrade(g);
			}
		}
		for (Direction d : list2) {
			if (directionName.equals(d.getName())
					&& gradeName.equals(d.getGrade().getName())) {
				t.setDirection(d);
			}
		}
		for (Classes c : list3) {
			if (classesName.equals(c.getName())
					&& directionName.equals(c.getDirection().getName())
					&& gradeName.equals(c.getDirection().getGrade().getName())) {
				t.setClasses(c);
			}
		}
		t.setName(teacher.getName());
		t.setSex(teacher.getSex());
		t.setAddress(teacher.getAddress());
		t.setAge(teacher.getAge());
		t.setTel(teacher.getTel());
		t.setJobNum(teacher.getJobNum());
		adminService.modTeacher(t);
		return "modteacher";
	}

	public String seeTeacher() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		String flag = request.getParameter("flag");
		teacher = adminService.findTeacher(id);
		request.setAttribute("teacher", teacher);
		if ("see".equals(flag)) {
			return "seeteacher";
		} else {
			return "go-alterteacher";
		}
	}

	public String delTeacher() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		boolean flag = adminService.delTeacher(id);
		if (flag) {
			return "delteacher";
		} else {
			return "delteacher";
		}
	}

	// //////////////////////////////////////////////////////////////////////////////////////

	public String addAssistant() {
		ActionContext ac = ActionContext.getContext();
		List<Grade> list = gradeService.findAll();

		// 处理方向和班级
		for (Grade g : list) {
			if (gradeName.equals(g.getName())) {
				assistant.setGrade(g);
			}
		}

		if (upload != null && upload.exists()) {
			try {
				String realPath = ServletActionContext.getServletContext()
						.getRealPath("/avatar");
				File dest = new File(realPath, uploadFileName);
				if (!dest.getParentFile().exists()) {
					dest.getParentFile().mkdirs();
				}
				FileUtils.copyFile(upload, dest);
				assistant.setImgSrc("avatar/" + uploadFileName);
			} catch (IOException e) {
				System.out.println("添加辅导员-上传头像:" + e.getMessage());
			}
		}

		assistant.setPassword(assistant.getJobNum());
		adminService.addAssistant(assistant);

		return "addassistant";
	}

	public String listAssistant() {
		ActionContext ac = ActionContext.getContext();
		List<Assistant> list = adminService.findAllAssistant();
		ac.put("list", list);
		return "listassistant";
	}

	public String modAssistant() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		Assistant a = adminService.findAssistant(id);
		if (upload != null && upload.exists()) {
			try {
				String realPath = ServletActionContext.getServletContext()
						.getRealPath("/avatar");
				File dest = new File(realPath, uploadFileName);
				if (!dest.getParentFile().exists()) {
					dest.getParentFile().mkdirs();
				}
				FileUtils.copyFile(upload, dest);
				a.setImgSrc("avatar/" + uploadFileName);
			} catch (IOException e) {
				System.out.println("添加辅导员-上传头像:" + e.getMessage());
			}
		}
		List<Grade> list = gradeService.findAll();

		// 处理班级年级方向
		for (Grade g : list) {
			if (gradeName.equals(g.getName())) {
				a.setGrade(g);
			}
		}
		a.setName(assistant.getName());
		a.setSex(assistant.getSex());
		a.setAddress(assistant.getAddress());
		a.setTel(assistant.getTel());
		a.setJobNum(assistant.getJobNum());
		adminService.modAssistant(a);
		return "modassistant";
	}

	public String seeAssistant() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		String flag = request.getParameter("flag");
		assistant = adminService.findAssistant(id);
		request.setAttribute("assistant", assistant);
		if ("see".equals(flag)) {
			return "seeassistant";
		} else {
			return "go-alterassistant";
		}
	}

	public String delAssistant() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		boolean flag = adminService.delAssistant(id);
		if (flag) {
			return "delassistant";
		} else {
			return "delassistant";
		}
	}

	public String shixunPlatform() {
		HttpServletRequest request = ServletActionContext.getRequest();
		List<Grade> list = gradeService.findAll();
		request.setAttribute("list", list);
		return "shixunlistgrade";
	}

	public String addShiXunTime() {
		HttpServletRequest request = ServletActionContext.getRequest();
		time.setType("shixun");
		timeService.add(time);
		request.setAttribute("prompt", "添加成功！");
		return "addshixuntime";
	}

	public String shixiPlatform() {
		HttpServletRequest request = ServletActionContext.getRequest();
		List<Grade> list = gradeService.findAll();
		request.setAttribute("list", list);
		return "shixilistgrade";
	}

	public String addShiXiTime() {
		HttpServletRequest request = ServletActionContext.getRequest();
		time.setType("shixi");
		timeService.add(time);
		request.setAttribute("prompt", "添加成功！");
		return "addshixitime";
	}

	public String searchAllGrade() {
		HttpServletRequest request = ServletActionContext.getRequest();
		gradeList = gradeService.findAll();
		directionList = shixunService.findAll();
		request.setAttribute("gradeList", gradeList);
		request.setAttribute("directionList", directionList);
		return "newallgrade";
	}

	public String addGrade() {
		HttpServletRequest request = ServletActionContext.getRequest();
		gradeService.add(grade);
		return "newsession";
	}

	public String addDirection() {
		HttpServletRequest request = ServletActionContext.getRequest();
		shixunService.add(direction);
		return "newsession";
	}

	public String addClasses() {
		HttpServletRequest request = ServletActionContext.getRequest();
		classes.setMaxNum(33);
		classesService.add(classes);
		return "newsession";
	}

	// //////////////////////////////////////////////////////////////////////////////////////

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

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	public String getDirectionName() {
		return directionName;
	}

	public void setDirectionName(String directionName) {
		this.directionName = directionName;
	}

	public String getClassesName() {
		return classesName;
	}

	public void setClassesName(String classesName) {
		this.classesName = classesName;
	}

	public PageModel getPageModel() {
		return pageModel;
	}

	public void setPageModel(PageModel pageModel) {
		this.pageModel = pageModel;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Assistant getAssistant() {
		return assistant;
	}

	public void setAssistant(Assistant assistant) {
		this.assistant = assistant;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	// //////////////////////////////////////////////////////////////////////////////////
	// 头像上传

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

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public Classes getClasses() {
		return classes;
	}

	public void setClasses(Classes classes) {
		this.classes = classes;
	}

	// //////////////////////////////////////////////////////////////////////////////////

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	public GradeService getGradeService() {
		return gradeService;
	}

	public void setGradeService(GradeService gradeService) {
		this.gradeService = gradeService;
	}

	public DirectionService getShixunService() {
		return shixunService;
	}

	public void setShixunService(DirectionService shixunService) {
		this.shixunService = shixunService;
	}

	public ClassesService getClassesService() {
		return classesService;
	}

	public void setClassesService(ClassesService classesService) {
		this.classesService = classesService;
	}

	public TimeService getTimeService() {
		return timeService;
	}

	public void setTimeService(TimeService timeService) {
		this.timeService = timeService;
	}
	
	///////////////////////////////这里为了添加年级着想
	
	public List<Grade> getGradeList() {
		return gradeList;
	}

	public void setGradeList(List<Grade> gradeList) {
		this.gradeList = gradeList;
	}

	public List<Direction> getDirectionList() {
		return directionList;
	}

	public void setDirectionList(List<Direction> directionList) {
		this.directionList = directionList;
	}



	/**
	 * 旧密码
	 */
	private String oldpassword;
	/**
	 * 新密码
	 */
	private String password;
	/**
	 * 年级名字
	 */
	private String gradeName;
	/**
	 * 方向名字
	 */
	private String directionName;
	/**
	 * 班级名字
	 */
	private String classesName;
	/**
	 * 年级名字
	 */
	private List<Grade> gradeList;
	/**
	 * 方向名字
	 */
	private List<Direction> directionList;
	/**
	 * 分页模型
	 */
	private PageModel pageModel;
	/**
	 * 学生对象
	 */
	private Student student;
	/**
	 * 教师对象
	 */
	private Teacher teacher;
	/**
	 * 教师对象
	 */
	private Assistant assistant;
	/**
	 * 教师对象
	 */
	private Admin admin;
	/**
	 * 平台时间
	 */
	private Time time;

	/**
	 * 年级对象
	 */
	private Grade grade;
	/**
	 * 方向对象
	 */
	private Direction direction;
	/**
	 * 班级对象
	 */
	private Classes classes;
	// ///////////////////////////////////////////////////////////////////////////////////

	// 头像上传
	/**
	 * 反射技术获取文件
	 */
	private File upload;
	/**
	 * 获取文件全名
	 */
	private String uploadFileName;
	/**
	 * 获取文件内容类型
	 */
	private String uploadContentType;

	// ///////////////////////////////////////////////////////////////////////////////////

	/**
	 * 引用管理员service
	 */
	private AdminService adminService;
	/**
	 * 引用年级service
	 */
	private GradeService gradeService;
	/**
	 * 引用方向service
	 */
	private DirectionService shixunService;
	/**
	 * 引用班级service
	 */
	private ClassesService classesService;
	/**
	 * 引用时间service
	 */
	private TimeService timeService;
}
