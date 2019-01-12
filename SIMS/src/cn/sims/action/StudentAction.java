package cn.sims.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cn.sims.domain.Classes;
import cn.sims.domain.Direction;
import cn.sims.domain.Inform;
import cn.sims.domain.InternshipDirection;
import cn.sims.domain.Resources;
import cn.sims.domain.Student;
import cn.sims.domain.Time;
import cn.sims.domain.ZhouJi;
import cn.sims.services.ClassesService;
import cn.sims.services.DirectionService;
import cn.sims.services.InformService;
import cn.sims.services.InternshipDirectionService;
import cn.sims.services.ResourcesService;
import cn.sims.services.StudentService;
import cn.sims.services.TimeService;
import cn.sims.services.ZhouJiService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class StudentAction extends ActionSupport {

	public String modifyPassword() {
		ActionContext ac = ActionContext.getContext();
		Student student = (Student) ac.getSession().get("user");
		if (oldpassword.equals(student.getPassword())) {
			student.setPassword(password);
			studentService.modify(student);
			ac.put("prompt", "�����޸ĳɹ���");
			ac.put("flag", 1);
		} else {
			ac.put("prompt", "ԭ���벻��ȷ��");
			ac.put("oldpassword", oldpassword);
			ac.put("password", password);
		}
		return "alterpwd";
	}

	public String addZj() {
		ActionContext ac = ActionContext.getContext();
		try {
			Student student = (Student) ac.getSession().get("user");
			zj.setDate(new Date());
			zj.setStatus(1);
			zj.setStudent(student);
			zjService.add(zj);
		} catch (Exception e) {
			ac.put("prompt", "�ύ�ܼ�ʧ�ܣ�");
			return "addzj";
		}
		ac.put("prompt", "�ύ�ܼǳɹ���");
		return "addzj";
	}

	public String listZj() {
		ActionContext ac = ActionContext.getContext();
		try {
			Student student = (Student) ac.getSession().get("user");
			List<ZhouJi> list = zjService.findOwnAll(student);
			ac.put("list", list);
		} catch (Exception e) {
			return "listzj";
		}
		return "listzj";
	}

	public String modZj() {
		HttpServletRequest request = ServletActionContext.getRequest();
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			zj = zjService.find(id);
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
			Student stu = (Student) ac.getSession().get("user");
			Student student = studentService.find(stu.getId());
			ac.put("student", student);
		} catch (Exception e) {
			return "ownprofile";
		}
		return "ownprofile";
	}

	public String listInform() {
		ActionContext ac = ActionContext.getContext();
		try {
			Student s = (Student) ac.getSession().get("user");
			student = studentService.find(s.getId());
			String dirname = student.getDirection().getName();
			int scope = 0;
			if ("Java".equals(dirname)) {
				scope = 1;
			} else if ("DotNet".equals(dirname)) {
				scope = 2;
			} else if ("������".equals(dirname)) {
				scope = 3;
			}
			List<Inform> list = informService.findAll(student.getAssistant(),
					scope);
			ac.put("list", list);

		} catch (Exception e) {
			return "listinform";
		}
		return "listinform";
	}

	public String seeInform() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		String flag = request.getParameter("flag");
		inform = informService.find(id);
		request.setAttribute("inform", inform);
		return "seeinform";
	}

	public String listDirections() {
		ActionContext ac = ActionContext.getContext();
		Student s = (Student) ac.getSession().get("user");
		List<Direction> shixun = shixunService.findAll(s.getGrade());
		ac.put("directions", shixun);

		return "listdirections";
	}

	public String seeDirection() {
		ActionContext ac = ActionContext.getContext();
		Student s = (Student) ac.getSession().get("user");
		student = studentService.find(s.getId());
		Classes classes = classesService.find(student.getClasses().getId());
		ac.put("classes", classes);
		
		return "seedirection";
	}

	public String addShiXunClasses() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		Student s = (Student) request.getSession().getAttribute("user");
		Student student = studentService.find(s.getId());
		Classes c = classesService.find(id);
		student.setClasses(c);
		student.setDirection(c.getDirection());
		student.setGrade(c.getDirection().getGrade());
		student.setAssistant(c.getDirection().getGrade().getAssistant());
		studentService.modify(student);
		return "addshixunclass";
	}

	public String addShiXi() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Student s = (Student) request.getSession().getAttribute("user");
		student = studentService.find(s.getId());
		internship.setStatus(0);
		internship.setGrade(s.getGrade());
		shixiService.add(internship);
		student.setInternshipDirection(internship);
		studentService.modify(student);
		request.setAttribute("internship", internship);
		return "seeshixi";
	}

	public String seeShiXi() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Student s = (Student) request.getSession().getAttribute("user");
		student = studentService.find(s.getId());
		internship = student.getInternshipDirection();
		System.out.println("��ӡ��Ϣ:");
		System.out.println(internship.getType());
		request.setAttribute("internship", internship);
		return "seeshixi";
	}
	
	public String judgeShiXunTime(){
		HttpServletRequest request = ServletActionContext.getRequest();
		Student s = (Student) request.getSession().getAttribute("user");
		student = studentService.find(s.getId());
		boolean flag = timeService.checkShiXunValidate(student.getGrade(), new Date());
		if(flag){
			return "openshixunplatform";
		}else{
			return ERROR;
		}
	}

	public String judgeShiXiTime(){
		HttpServletRequest request = ServletActionContext.getRequest();
		Student s = (Student) request.getSession().getAttribute("user");
		student = studentService.find(s.getId());
		boolean flag = timeService.checkShiXiValidate(student.getGrade(), new Date());
		if(flag){
			return "openshixiplatform";
		}else{
			return ERROR;
		}
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
	
	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}	

	// //////////////////////////////////////////////////////////////////////////////////


	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public ZhouJiService getZjService() {
		return zjService;
	}

	public void setZjService(ZhouJiService zjService) {
		this.zjService = zjService;
	}

	public ResourcesService getResourcesService() {
		return resourcesService;
	}

	public void setResourcesService(ResourcesService resourcesService) {
		this.resourcesService = resourcesService;
	}

	public InformService getInformService() {
		return informService;
	}

	public void setInformService(InformService informService) {
		this.informService = informService;
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

	public InternshipDirectionService getShixiService() {
		return shixiService;
	}

	public void setShixiService(InternshipDirectionService shixiService) {
		this.shixiService = shixiService;
	}

	public TimeService getTimeService() {
		return timeService;
	}

	public void setTimeService(TimeService timeService) {
		this.timeService = timeService;
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
	 * �ܼǶ���
	 */
	private ZhouJi zj;
	/**
	 * ֪ͨ����
	 */
	private Inform inform;
	/**
	 * ѧ������
	 */
	private Student student;
	/**
	 * ʵϰ����
	 */
	private InternshipDirection internship;
	/**
	 * ƽ̨����
	 */
	private Time time;
	// ///////////////////////////////////////////////////////////////////////////////////

	/**
	 * ����ѧ��service
	 */
	private StudentService studentService;
	/**
	 * �����ܼ�service
	 */
	private ZhouJiService zjService;
	/**
	 * ������Դservice
	 */
	private ResourcesService resourcesService;
	/**
	 * ����֪ͨservice
	 */
	private InformService informService;
	/**
	 * ���÷���service
	 */
	private DirectionService shixunService;
	/**
	 * ���ð༶service
	 */
	private ClassesService classesService;
	/**
	 * ����ʵϰservice
	 */
	private InternshipDirectionService shixiService;
	/**
	 * ����ʵϰservice
	 */
	private TimeService timeService;
}
