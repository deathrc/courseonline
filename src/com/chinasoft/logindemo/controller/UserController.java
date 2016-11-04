package com.chinasoft.logindemo.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasoft.logindemo.biz.Student2Biz;
import com.chinasoft.logindemo.biz.impl.Student2Bizimpl;
import com.chinasoft.logindemo.po.Student2;

/**
 * Servlet implementation class UserController
 */
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
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
	}

}






