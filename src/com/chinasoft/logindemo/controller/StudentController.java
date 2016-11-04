package com.chinasoft.logindemo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasoft.logindemo.biz.ApplicationBiz;
import com.chinasoft.logindemo.biz.C_courseBiz;
import com.chinasoft.logindemo.biz.CourseBiz;
import com.chinasoft.logindemo.biz.ProjectBiz;
import com.chinasoft.logindemo.biz.Student1Biz;
import com.chinasoft.logindemo.biz.Student2Biz;
import com.chinasoft.logindemo.biz.Teacher2Biz;
import com.chinasoft.logindemo.biz.impl.ApplicationBizimpl;
import com.chinasoft.logindemo.biz.impl.C_courseBizimpl;
import com.chinasoft.logindemo.biz.impl.CourseBizimpl;
import com.chinasoft.logindemo.biz.impl.ProjectBizimpl;
import com.chinasoft.logindemo.biz.impl.Student1Bizimpl;
import com.chinasoft.logindemo.biz.impl.Student2Bizimpl;
import com.chinasoft.logindemo.biz.impl.Teacher2Bizimpl;
import com.chinasoft.logindemo.po.C_course;
import com.chinasoft.logindemo.po.Course;
import com.chinasoft.logindemo.po.Project;
import com.chinasoft.logindemo.po.Student1;
import com.chinasoft.logindemo.po.Student2;
import com.chinasoft.logindemo.po.Teacher2;
import com.chinasoft.logindemo.vo.C_coursePageBean;
import com.chinasoft.logindemo.vo.CoursePageBean;
import com.chinasoft.logindemo.vo.Teacher2PageBean;

/**
 * Servlet implementation class UserController
 */
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 处理以GET方式提交的请求
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置响应类型和字符集
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// 获取OUT对象
		PrintWriter out = response.getWriter();
		// 处理以POST方式提交的请求
		String option = request.getParameter("option");
		// 用户登录
		if(option.equals("login")){
			// 提取表单参数
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			// 调用service验证
			Student2Biz userBiz = new Student2Bizimpl();
			Student2 user = userBiz.userLogin(username, password);
			// 判断结果返回
			if(user!=null){
				
				request.getSession().setAttribute("user", user);
				response.sendRedirect("index.jsp");
			}else{
				out.println("<script>alert('用户名或密码错误！');history.back();</script>");
			}
		}
		// 用户登出
		if(option.equals("logout")){
			request.getSession().removeAttribute("user");
			response.sendRedirect("login.jsp");
		}
		
		if(option.equals("getstudent1")){
			String st_ID=request.getParameter("st_ID");
			Student1Biz student1Biz = new Student1Bizimpl();
			Student1 student1 =student1Biz.findStudentByStID(st_ID);
			Student2Biz student2Biz = new Student2Bizimpl();
			String name=student2Biz.findNameByStID(st_ID);
			request.setAttribute("name",name);
			request.setAttribute("student1", student1);
			request.getRequestDispatcher("stidentify.jsp").forward(request, response);
				
		
			
		}
		if(option.equals("getc_courses"))
		{
	     String st_ID= request.getParameter("st_ID");
	     C_courseBiz c_courseBiz=new C_courseBizimpl();
	     CourseBiz courseBiz=new CourseBizimpl();
	     Teacher2Biz teacher2Biz=new Teacher2Bizimpl();
	     
         List<C_course> c_courses = c_courseBiz.FindCcoursesByStID(st_ID);
         List<String> c_names=new ArrayList<String>();
         List<String> t_names=new ArrayList<String>();
         float max,min,avg,GPA,sum1,sum2,i,j,cre;
         max=0;
         sum1=0;
         sum2=0;
         i=0;
         j=0;
         min=100;
         cre=0;
             
         for(C_course c_course:c_courses)
         {
        	 i++;
        	 String s1=new String();
        	 String t=new String();
        	 String s2=new String();
        	 s1=(courseBiz.findCourseByCID(c_course.getC_ID())).getC_name();
        	 if(c_course.getFinish()!=null)
        	 {
        	 cre=cre+c_course.getCredit();
        	 sum1=sum1+c_course.getGrade();
        	 sum2=sum2+c_course.getGrade()*c_course.getCredit();
        	 j=j+c_course.getCredit();
        	 if(max<c_course.getGrade())
        		 max=c_course.getGrade();
        	 if(min>c_course.getGrade())
        		 min=c_course.getGrade();
        	 }
        	 c_names.add(s1);
        	 t=c_course.getTh_ID();
 
        	 s2=teacher2Biz.getThnameByThID(t);
        	 t_names.add(s2);
       	 
         }
         if(max<min)
        	 {
        	 max=0;
        	 min=0;
        	 }
         avg=sum1/i;
         GPA=sum2/j;
         String min1=min+"";
         String max1=max+"";
         String GPA1=GPA+"";
         String avg1=avg+"";
         String cre1=cre+"";
        request.getSession().setAttribute("min",min1);
        request.getSession().setAttribute("max",max1);
        request.getSession().setAttribute("GPA",GPA1);
        request.getSession().setAttribute("avg",avg1);
        request.getSession().setAttribute("cre",cre1);
 		request.getSession().setAttribute("c_courses",c_courses);
 		request.getSession().setAttribute("cnames", c_names);
 		request.getSession().setAttribute("tnames", t_names);
 		response.sendRedirect("course.jsp");
		}
		if(option.equals("choosecourse")){
			CourseBiz courseBiz=new CourseBizimpl();
			List<Course> courses=courseBiz.findAllCourses();
			request.getSession().setAttribute("courses",courses);
		
			response.sendRedirect("choose.jsp");
			}
		if(option.equals("choose"))
		{
	       String c_id= request.getParameter("c_ID");
	       String st_id=request.getParameter("st_ID");
	       String p=request.getParameter("page");
	       int page=Integer.parseInt(p);

	       CourseBiz courseBiz=new CourseBizimpl();
	       Course course=courseBiz.findCourseByCID(c_id);
	       if(course.getApp_num()<course.getMax_num())
	       {
	    	   boolean flag2=courseBiz.addAppNum(c_id, course.getApp_num());
	    	   System.out.println(flag2);
	       float credit=course.getCredit();
	       String t_id=course.getTh_ID();
	       C_courseBiz c_courseBiz=new C_courseBizimpl();
	       boolean flag=c_courseBiz.addCCourse(c_id,t_id, st_id, credit);
	       if(flag){
		      out.println("<script>alert('添加成功！');location.href='StudentController?option=getcoursepage&page=<%=page%>';</script>");
	      }else{
		   out.println("<script>alert('添加失败！');history.back();</script>");
	      }
	       }else{ out.println("<script>alert('人数已满，添加失败！');history.back();</script>");}
	    }
		if(option.equals("getproject")){
			String st_id=request.getParameter("st_ID");
			ProjectBiz projectBiz = new ProjectBizimpl();
			Project	 project =projectBiz.findProjectByStID(st_id);
			if(project!=null){
				
			    String tid=new String();
			    tid=project.getTh_ID();
			    Teacher2Biz teacher2Biz=new Teacher2Bizimpl();
			    String th_name=teacher2Biz.getThnameByThID(tid);
			    
			
				request.getSession().setAttribute("tname",th_name);
				request.getSession().setAttribute("project", project);
				response.sendRedirect("project.jsp");
			}
			else
				{
				out.println("<script>alert('没有课题，请选择导师申请课题！');location.href='StudentController?option=getteacher2page';</script>");
				}
			
		}
		if(option.equals("chooseth")){
				Teacher2Biz teacher2Biz=new Teacher2Bizimpl();
				List<Teacher2> teacher2s=teacher2Biz.findAllTeachers();
				request.setAttribute("teacher2s", teacher2s);
				request.getRequestDispatcher("th_app.jsp").forward(request, response);
				}
				
		if(option.equals("app")){
			String th_id=request.getParameter("th_ID");
			request.getSession().setAttribute("th_id", th_id);
			response.sendRedirect("app.jsp");
			}
		if(option.equals("appproject")){
			String th_id=request.getParameter("th_ID");
			String st_id=request.getParameter("st_ID");
			String p_name=request.getParameter("p_name");
			ApplicationBiz appBiz=new ApplicationBizimpl();
			boolean flag=appBiz.addApp(st_id, p_name, th_id);
			if(flag){
			      out.println("<script>alert('申请成功！');location.href='app.jsp';</script>");
		      }else{
			   out.println("<script>alert('申请失败！');history.back();</script>");
		      }
			}
		if(option.equals("getcoursepage"))
		{
			int pagesize=10;
			int currpage=request.getParameter("page")==null?1:Integer.parseInt(request.getParameter("page"));
			CourseBiz courseBiz=new CourseBizimpl();
			CoursePageBean coursePageBean=new CoursePageBean();
			coursePageBean=courseBiz.getCoursesByPage(pagesize, currpage);
			request.setAttribute("coursepageBean", coursePageBean);
			request.getRequestDispatcher("choosepage.jsp").forward(request, response);
		}
		if(option.equals("getccoursepage"))
		{
			int pagesize=10;
			int currpage=request.getParameter("page")==null?1:Integer.parseInt(request.getParameter("page"));
			C_courseBiz c_courseBiz=new C_courseBizimpl();
			C_coursePageBean c_coursePageBean=new C_coursePageBean();
			c_coursePageBean=c_courseBiz.getC_coursesByPage(pagesize, currpage);
			request.setAttribute("c_coursepageBean", c_coursePageBean);
			request.getRequestDispatcher("bookshowpage.jsp").forward(request, response);

		}
		if(option.equals("getteacher2page"))
		{
			int pagesize=10;
			int currpage=request.getParameter("page")==null?1:Integer.parseInt(request.getParameter("page"));
			Teacher2Biz teacher2Biz=new Teacher2Bizimpl();
			Teacher2PageBean teacher2PageBean=new Teacher2PageBean();
			teacher2PageBean=teacher2Biz.getTeacger2sByPage(pagesize, currpage);
			request.setAttribute("teacger2pageBean", teacher2PageBean);
			request.getRequestDispatcher("th_apppage.jsp").forward(request, response);
		}
		
		
		
	}

}






