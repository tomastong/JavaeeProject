package cn.sims.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cn.sims.domain.Assistant;
import cn.sims.domain.Classes;
import cn.sims.domain.Inform;
import cn.sims.domain.InternshipDirection;
import cn.sims.domain.Student;
import cn.sims.domain.ZhouJi;
import cn.sims.services.AssistantService;
import cn.sims.services.ClassesService;
import cn.sims.services.InformService;
import cn.sims.services.InternshipDirectionService;
import cn.sims.services.StudentService;
import cn.sims.services.ZhouJiService;
import cn.sims.tool.PageModel;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AssistantAction extends ActionSupport {

	public String modifyPassword() {
		ActionContext ac = ActionContext.getContext();
		Assistant assistant = (Assistant) ac.getSession().get("user");
		if (oldpassword.equals(assistant.getPassword())) {
			assistant.setPassword(password);
			assistantService.modify(assistant);
			ac.put("prompt", "密码修改成功！");
			ac.put("flag", 1);
		} else {
			ac.put("prompt", "原密码不正确！");
			ac.put("oldpassword", oldpassword);
			ac.put("password", password);
		}
		return "alterpwd";
	}

	public String listZj() {
		ActionContext ac = ActionContext.getContext();
		Assistant assistant = (Assistant) ac.getSession().get("user");
		try {
			int pageNo = (pageModel == null ? 1 : pageModel.getPageNo());
			int pageSize = (pageModel == null ? 5 : pageModel.getPageSize());
			pageModel = zjService.findAll(pageNo, pageSize, 1 + "",
					assistant.getGrade());
			List<ZhouJi> list = pageModel.getList();
			ac.put("pageModel", pageModel);
		} catch (Exception e) {
			return "listzj";
		}
		return "listzj";
	}

	public String listZjHistory() {
		ActionContext ac = ActionContext.getContext();
		Assistant assistant = (Assistant) ac.getSession().get("user");
		try {
			int pageNo = (pageModel == null ? 1 : pageModel.getPageNo());
			int pageSize = (pageModel == null ? 5 : pageModel.getPageSize());
			// 传入null是为了实现中，修改查询语句
			pageModel = zjService.findAll(pageNo, pageSize, null,
					assistant.getGrade());
			ac.put("pageModel", pageModel);
		} catch (Exception e) {
			return "listzjhistory";
		}
		return "listzjhistory";
	}

	public String listSbHistory() {
		HttpServletRequest request = ServletActionContext.getRequest();
		try {
			String studentid = request.getParameter("studentid");
			Student student = new Student();
			student.setSno(studentid);
			list = zjService.findOwnAll(student);
			request.setAttribute("studentid", studentid);
			request.setAttribute("list", list);
		} catch (Exception e) {
			return "listsbhistory";
		}
		return "listsbhistory";
	}

	public String modZj() {
		HttpServletRequest request = ServletActionContext.getRequest();
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			int status = Integer.parseInt(request.getParameter("status"));
			zj = zjService.find(id);
			zj.setStatus(status);
			zjService.modify(zj);
			request.setAttribute("prompt", "保存成功！");
		} catch (Exception e) {
			return "modzj";
		}
		return "modzj";
	}

	public String seeZj() {
		HttpServletRequest request = ServletActionContext.getRequest();
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			zj = zjService.find(id);
			System.out.println(zj.getTitle());
		} catch (Exception e) {
			return "seezj";
		}
		return "seezj";
	}

	public String ownProfile() {
		ActionContext ac = ActionContext.getContext();
		try {
			Assistant t = (Assistant) ac.getSession().get("user");
			assistant = assistantService.find(t.getId());
			ac.put("assistant", assistant);
		} catch (Exception e) {
			return "ownprofile";
		}
		return "ownprofile";
	}

	public String addInform() {
		ActionContext ac = ActionContext.getContext();
		try {
			Assistant t = (Assistant) ac.getSession().get("user");
			assistant = assistantService.find(t.getId());
			inform.setGrade(assistant.getGrade());
			inform.setDate(new Date());
			informService.add(inform);
			ac.put("prompt", "发表成功！");
		} catch (Exception e) {
			ac.put("prompt", "发表失败！");
			return "addinform";
		}
		return "addinform";
	}

	public String listInform() {
		ActionContext ac = ActionContext.getContext();
		try {
			Assistant t = (Assistant) ac.getSession().get("user");
			assistant = assistantService.find(t.getId());
			List<Inform> list = informService.findAll(assistant, -1);
			ac.put("list", list);
		} catch (Exception e) {
			return "listinform";
		}
		return "listinform";
	}

	public String delInform() {
		HttpServletRequest request = ServletActionContext.getRequest();
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			informService.del(id);
		} catch (Exception e) {
			return "delinform";
		}
		return "delinform";
	}

	public String modInform() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		Inform i = informService.find(id);
		i.setScope(inform.getScope());
		i.setDescr(inform.getDescr());
		i.setTitle(inform.getTitle());
		informService.modify(i);
		return "modinform";
	}

	public String seeInform() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		String flag = request.getParameter("flag");
		inform = informService.find(id);
		request.setAttribute("inform", inform);
		if ("see".equals(flag)) {
			return "seeinform";
		} else {
			return "go-alterinform";
		}
	}

	public String listShiXunStudent() {
		ActionContext ac = ActionContext.getContext();
		assistant = (Assistant) ac.getSession().get("user");
		pageModel = studentService.findAll(pageModel.getPageNo(),
				pageModel.getPageSize(), "shixun", assistant.getGrade());
		ac.put("pageModel", pageModel);
		return "listshixunstudent";
	}

	public String modShiXun() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		int studentid = Integer.parseInt(request.getParameter("studentid"));
		Student student = studentService.find(studentid);
		Classes c = classesService.find(id);
		student.setClasses(c);
		student.setDirection(c.getDirection());
		student.setGrade(c.getDirection().getGrade());
		student.setAssistant(c.getDirection().getGrade().getAssistant());
		studentService.modify(student);
		request.setAttribute("prompt", "修改成功！");
		return "modshixun";
	}

	public String seeShiXun() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		student = studentService.find(id);
		request.setAttribute("student", student);
		return "seeshixun";
	}

	public String listShiXiStudent() {
		ActionContext ac = ActionContext.getContext();
		assistant = (Assistant) ac.getSession().get("user");
		int pageNo = (pageModel == null ? 1 : pageModel.getPageNo());
		int pageSize = (pageModel == null ? 5 : pageModel.getPageSize());
		pageModel = studentService.findAll(pageNo, pageSize, "shixi",
				assistant.getGrade());
		ac.put("pageModel", pageModel);
		return "listshixistudent";
	}

	public String seeShiXi() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		student = studentService.find(id);
		request.setAttribute("student", student);
		return "seeshixi";
	}

	public String modShiXi() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		int status = Integer.parseInt(request.getParameter("status"));
		student = studentService.find(id);
		student.getInternshipDirection().setStatus(status);
		studentService.modify(student);
		request.setAttribute("prompt", "保存成功！");
		return "modshixi";
	}

	public String listShiXiHistory() {
		ActionContext ac = ActionContext.getContext();
		assistant = (Assistant) ac.getSession().get("user");
		int pageNo = (pageModel == null ? 1 : pageModel.getPageNo());
		int pageSize = (pageModel == null ? 5 : pageModel.getPageSize());
		pageModel = studentService.findAll(pageNo, pageSize, "shixihistory",
				assistant.getGrade());
		ac.put("pageModel", pageModel);
		return "listshixihistory";
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

	public List<ZhouJi> getList() {
		return list;
	}

	public void setList(List<ZhouJi> list) {
		this.list = list;
	}

	public ZhouJi getZj() {
		return zj;
	}

	public void setZj(ZhouJi zj) {
		this.zj = zj;
	}

	public Inform getInform() {
		return inform;
	}

	public void setInform(Inform inform) {
		this.inform = inform;
	}

	public PageModel getPageModel() {
		return pageModel;
	}

	public void setPageModel(PageModel pageModel) {
		this.pageModel = pageModel;
	}

	public Assistant getAssistant() {
		return assistant;
	}

	public void setAssistant(Assistant assistant) {
		this.assistant = assistant;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public InternshipDirection getInternship() {
		return internship;
	}

	public void setInternship(InternshipDirection internship) {
		this.internship = internship;
	}

	// //////////////////////////////////////////////////////////////////////////////////

	public AssistantService getAssistantService() {
		return assistantService;
	}

	public void setAssistantService(AssistantService assistantService) {
		this.assistantService = assistantService;
	}

	public ZhouJiService getZjService() {
		return zjService;
	}

	public void setZjService(ZhouJiService zjService) {
		this.zjService = zjService;
	}

	public InformService getInformService() {
		return informService;
	}

	public void setInformService(InformService informService) {
		this.informService = informService;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public ClassesService getClassesService() {
		return classesService;
	}

	public void setClassesService(ClassesService classesService) {
		this.classesService = classesService;
	}

	public InternshipDirectionService getShixiService() {
		return shixiService;
	}

	public void setShixiService(InternshipDirectionService shixiService) {
		this.shixiService = shixiService;
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
	 * 周记集合
	 */
	private List<ZhouJi> list;
	/**
	 * 周记对象
	 */
	private ZhouJi zj;
	/**
	 * 通知对象
	 */
	private Inform inform;
	/**
	 * 分页对象
	 */
	private PageModel pageModel;
	/**
	 * 辅导员对象
	 */
	private Assistant assistant;
	/**
	 * 学生对象
	 */
	private Student student;
	/**
	 * 学生对象
	 */
	private InternshipDirection internship;
	// ///////////////////////////////////////////////////////////////////////////////////

	/**
	 * 引用辅导员service
	 */
	private AssistantService assistantService;
	/**
	 * 引用周记service
	 */
	private ZhouJiService zjService;
	/**
	 * 引用通知service
	 */
	private InformService informService;
	/**
	 * 引用通知service
	 */
	private StudentService studentService;
	/**
	 * 引用班级service
	 */
	private ClassesService classesService;
	/**
	 * 引用实习service
	 */
	private InternshipDirectionService shixiService;
}
