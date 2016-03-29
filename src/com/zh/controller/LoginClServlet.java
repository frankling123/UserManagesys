package com.zh.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.registry.infomodel.User;


import com.zh.model.*;

public class LoginClServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//得到用户名和密码
		String u=request.getParameter("username");
		String p=request.getParameter("passwd");
		
		//获得标识值
		String who=request.getParameter("who");
		
//		u=Tools.getNewString(u);		
		 

		if(who.equals("user")){
		
			//使用模型（UserBeanCl）完成对用户的验证
			//1.创建一个UserBeanCl对象
			UserCl uCl=new UserCl();
			//调用方法
			if(uCl.checkUser(u, p)){
				
				//将登录编号放入session 
				request.getSession().setAttribute("myNo", u);
				//request.getSession().setMaxInactiveInterval(30);
				//在软件公司内 常常采用 转发 方法 跳转
				//这种方法效率高  request中的对象还可以在下一页面使用
				request.getRequestDispatcher("UserMain.jsp").forward(request, response);								
			}
			else{
	
				//不合法			
				//response.sendRedirect("login.jsp");
				request.getRequestDispatcher("Login.jsp").forward(request, response);//跳转到主界面				
			}				
		}
		else if(who.equals("teacher")){
			//使用模型（UserBeanCl）完成对用户的验证
			//1.创建一个UserBeanCl对象
			TeacherCl tCl=new TeacherCl();
			//调用方法
			if(tCl.checkTeacher(u, p)){
				
				//将登录编号放入session 
				request.getSession().setAttribute("myNo", u);
				//request.getSession().setMaxInactiveInterval(30);
				//在软件公司内 常常采用 转发 方法 跳转
				//这种方法效率高  request中的对象还可以在下一页面使用
				request.getRequestDispatcher("TeacherMain.jsp").forward(request, response);								
			}
			else{
	
				//不合法			
				//response.sendRedirect("login.jsp");
				request.getRequestDispatcher("Login.jsp").forward(request, response);//跳转到主界面				
			}
		}
		else if(who.equals("manager")){
			
			//使用模型（ManaCl）完成对用户的验证
			//1.创建一个ManaCl对象
			ManaCl mCl=new ManaCl();

			//调用方法
			if(mCl.checkMana(u, p)){

				//将登录编号放入session 
				request.getSession().setAttribute("myNo", u);
				//request.getSession().setMaxInactiveInterval(30);
				//在软件公司内 常常采用 转发 方法 跳转
				//这种方法效率高  request中的对象还可以在下一页面使用
				request.getRequestDispatcher("ManaMain.jsp").forward(request, response);								
			}
			else{
	
				//不合法			
				//response.sendRedirect("login.jsp");
				request.getRequestDispatcher("Login.jsp").forward(request, response);//跳转到主界面				
			}
		}
		else{
			request.getRequestDispatcher("Login.jsp").forward(request, response);//跳转到主界面	
		}

	}


	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//合二为一
		this.doGet(request, response);
	}

}
