package cn.sims.junit;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.sims.domain.Student;
import cn.sims.tool.HibernateTool;

public class TestStudentDao {

	@Test
	public void addStudent() {
		SessionFactory sessionFactory = HibernateTool.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		tran.begin();
		try {
			Student s = new Student();
			s.setName("tomastong");
			s.setSno("11031702");
			s.setPassword("962464");
			s.setSex("man");
			s.setAddress("shenzhen");
			s.setTel("18944630503");
			s.setAge(21);
			s.setImgSrc("/imgs/tomastong.jpg");
			session.save(s);
		} catch (HibernateException e) {
			e.printStackTrace();
			tran.rollback();
		}
		tran.commit();
	}

	@Test
	public void findPageStudent() {
		SessionFactory sessionFactory = HibernateTool.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		List<Student> list = null;
		tran.begin();
		try {
			// 这里的HQL语句，书写，还需要将对象交换多的关联少的，麻烦
			list = session
					.createQuery(" select s from Student s order by s.id")
					.setFirstResult(0).setMaxResults(5).list();

		} catch (HibernateException e) {
			e.printStackTrace();
			tran.rollback();
		}
		for (Student s : list) {
			System.out.println("姓名：" + s.getName() + "   年级:"
					+ s.getGrade().getName() + "   方向:"
					+ s.getDirection().getName() + "   班级:"
					+ s.getClasses().getName());
		}
		tran.commit();
	}
}
