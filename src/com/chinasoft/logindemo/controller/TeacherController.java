package com.chinasoft.logindemo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasoft.logindemo.biz.ApplicationBiz;
import com.chinasoft.logindemo.biz.ProjectBiz;
import com.chinasoft.logindemo.biz.Teacher1Biz;
import com.chinasoft.logindemo.biz.Teacher2Biz;
import com.chinasoft.logindemo.biz.C_courseBiz;
import com.chinasoft.logindemo.biz.CourseBiz;
import com.chinasoft.logindemo.biz.impl.ApplicationBizimpl;
import com.chinasoft.logindemo.biz.impl.CourseBizimpl;
import com.chinasoft.logindemo.biz.impl.ProjectBizimpl;
import com.chinasoft.logindemo.biz.impl.Teacher1Bizimpl;
import com.chinasoft.logindemo.biz.impl.Teacher2Bizimpl;
import com.chinasoft.logindemo.biz.impl.C_courseBizimpl;
import com.chinasoft.logindemo.po.Application;
import com.chinasoft.logindemo.po.C_course;
import com.chinasoft.logindemo.po.Course;
import com.chinasoft.logindemo.po.Project;
import com.chinasoft.logindemo.po.Teacher1;
import com.chinasoft.logindemo.po.Teacher2;

/**
 * Servlet implementation class TeacherController
 */
public class TeacherController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// 获取OUT对象
		PrintWriter out = response.getWriter();
		// 处理以POST方式提交的请求
		String option = request.getParameter("option");

		if(option.equals("login")){
			String th_ID = request.getParameter("th_ID");
			String password = request.getParameter("password");
			
			Teacher2Biz teacherbiz = new Teacher2Bizimpl();
			Teacher2 teacher2 = teacherbiz.findUserByUsernameAndPassword(th_ID, password);
					if(teacher2 !=null)
			{
				request.getSession().setAttribute("teacher2", teacher2);
				response.sendRedirect("teacher.jsp");					
			}
			
			else
			{
				out.println("<script>alert('用户名或者密码错误');history.back();</script>");
			}		
		}
		if(option.equals("logout"))
		{
			request.getSession().removeAttribute("teacher2");
			response.sendRedirect("th_login.jsp");
		}
		if(option.equals("showthinfo"))
		{
			String th_ID = request.getParameter("th_ID");
			Teacher1Biz teacher1biz = new Teacher1Bizimpl();
			Teacher1 teacher = teacher1biz.findthinfo(th_ID);
			if(teacher != null)
			{
				request.getSession().setAttribute("teacher", teacher);
				response.sendRedirect("th_mod.jsp");
			
			}
		}
	
		if(option.equals("showthcourse"))
		{
			String th_ID = request.getParameter("th_ID");
		    CourseBiz Coursebiz = new CourseBizimpl();
			List<Course> courses = Coursebiz.findCoursesByTh_id(th_ID);
			request.getSession().setAttribute("courses",courses);
			response.sendRedirect("th_course.jsp");
		
			
		}
		if(option.equals("showthgrade"))
		{
		
			String c_ID = request.getParameter("c_ID");
			C_courseBiz ccoursebiz = new C_courseBizimpl();
			List<C_course> ccourses =ccoursebiz.FindCcoursesByCID(c_ID); 
			request.getSession().setAttribute("ccourses",ccourses);
			response.sendRedirect("grade.jsp");
		}
		if(option.equals("grade1"))
		{
			String c_ID = request.getParameter("c_ID");
			String st_ID = request.getParameter("st_ID");
			request.getSession().setAttribute("c_ID",c_ID);
			request.getSession().setAttribute("st_ID",st_ID);		
			response.sendRedirect("th_grade.jsp");
		}
		if(option.equals("setgrade"))
		{
			String c_ID = request.getParameter("c_ID");
			String st_ID = request.getParameter("st_ID");
			String score = request.getParameter("grade");
			float grade = Float.parseFloat(score);
			C_courseBiz ccourseBiz = new C_courseBizimpl();
			C_course ccourse=ccourseBiz.findCcourseByCIDSTID(c_ID, st_ID);
			boolean n = ccourseBiz.gradeCcourse(ccourse, grade);
			if(n=true)
			{
				out.println("<script>alert('修改成绩成功！');location.href ='teacher.jsp';</script>");
			}
			else{out.println("<script>alert('修改成绩失败！');history.back();</script>");}
		}
		if(option.equals("showthproject"))
		{
			String th_ID = request.getParameter("th_ID");
			ProjectBiz projectbiz = new ProjectBizimpl();
			List<Project> projects = projectbiz.findProjectsByThID(th_ID);
			request.getSession().setAttribute("projects",projects);
			response.sendRedirect("th_project.jsp");
			
		}
		if(option.equals("gradepro"))
		{
			String st_ID = request.getParameter("st_ID");
			System.out.println(st_ID);
			request.setAttribute("st_ID",st_ID);
			request.getRequestDispatcher("th_prograde.jsp").forward(request, response);
		}
		if(option.equals("gradeproject"))
		{
			String st_ID=request.getParameter("st_ID");
			String score = request.getParameter("grade");
			ProjectBiz projectbiz = new ProjectBizimpl();
			Project project=projectbiz.findProjectByStID(st_ID);
			boolean n = projectbiz.gradeProject(project, score);
			if(n=true)
			{out.println("<script>alert('修改课设成绩成功！');location.href ='teacher.jsp';</script>");
			}
			else{out.println("<script>alert('修改课设成绩失败！');history.back();</script>");}
		}
		
		if(option.equals("showapp"))
		{
			String th_ID = request.getParameter("th_ID");
			
			ApplicationBiz appBiz=new ApplicationBizimpl();
			List<Application> apps = appBiz.findAppsByThID(th_ID);
			request.getSession().setAttribute("apps",apps);
			response.sendRedirect("th_acc.jsp");
		}
		if(option.equals("accept"))
		{
			String th_ID = request.getParameter("th_ID");
			String st_ID = request.getParameter("st_ID");
			String p_name1 = request.getParameter("p_name");
			String p_name=new String(p_name1.getBytes("ISO-8859-1"),"UTF-8"); 
			
			ProjectBiz projectBiz=new ProjectBizimpl();
			boolean flag=projectBiz.addProject(p_name, st_ID, th_ID);
			System.out.println(flag);
			
			if(flag)
			{		
				ApplicationBiz appBiz=new ApplicationBizimpl();
				boolean flag2=appBiz.deleteApp(st_ID, p_name, th_ID);
				System.out.println(flag2);
		
				if(flag2)
				{
					out.println("<script>alert('允许申请成功！');location.href='teacher.jsp';</script>");
				}else
				{out.println("<script>alert('允许申请失败！该课题已经有导师或者取消申请！');history.back();</script>");}
			}
			else
			{
				out.println("<script>alert('允许申请失败！该课题已经有导师或者取消申请！');history.back();</script>");
			}
			
			
		}
	}
	

}
