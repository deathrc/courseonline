package com.chinasoft.logindemo.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartFile;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

/**
 * Servlet implementation class UploadController
 */
public class UploadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		//准备文件的存储目录
		String path=getServletContext().getRealPath("userphoto");
		File filePath=new File(path);
		if(!filePath.exists()){filePath.mkdir();}
		//实例化上传组件
		SmartUpload su=new SmartUpload("utf-8");
		su.initialize(getServletConfig(), request, response);
		try {
			su.setAllowedFilesList("jpg,png,gif");
			su.setMaxFileSize(1024*1024);
			su.upload();
			SmartFile file=su.getFiles().getFile(0);
			String fileName=System.currentTimeMillis()+"."+file.getFileExt();
			file.saveAs(path+"/"+fileName);
			out.println("<script>alert('文件上传成功！');location.href='upload.jsp';</script>");
		}catch(SecurityException e)
		{
			out.println("<script>alert('只能上传小于1M的jpg，png，gif文件1');history.back();</script>");
		}
		catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.println("<script>alert('上传失败');history.back();</script>");
		}
		String nickname=su.getRequest().getParameter("nickname");
		System.out.println(">>>"+nickname);
	}

}
