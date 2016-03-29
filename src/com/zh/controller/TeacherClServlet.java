//这个控制器将处理为用户的分页显示，用户的增删改
package com.zh.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.net.httpserver.Authenticator.Success;
import com.zh.model.*;
public class TeacherClServlet extends HttpServlet {

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
		
		//解决的是servlet页面显示的乱码
		response.setContentType("text/html;charset=gbk"); 
		//解决post方式参数传递的参数乱码  
		 request.setCharacterEncoding("gbk");  
		  
		//获得标识值
		String flag=request.getParameter("flag");
		String pageNow=request.getParameter("pageNow");
		
	  	String u=(String)request.getSession().getAttribute("myNo");
	  	
//		if(flag.equals("yonghuxingxi")){
//					
//			try {
//				
//				//调用UserBeanCl
//				UserCl uCl=new UserCl();
//				
//				//在跳转到wel.jsp页面时，就把要显示的数据准备好
//				ArrayList al=uCl.getUserLogin(u);
//				//将al,pageCount,pageNow放入request中
//				request.setAttribute("result", al);
//				
//				//重新跳转回wel.jsp
//				request.getRequestDispatcher("UserInfo.jsp").forward(request,response);
//			} catch (Exception e) {
//				e.printStackTrace();
//				// TODO: handle exception
//			}
//		}
	
		if(flag.equals("kechengfenye")){
		//得到用户希望显示的pageNow
		
			try {
				
				//调用UserBeanCl
				TeacherCl tCl=new TeacherCl();
				
				//在跳转到wel.jsp页面时，就把要显示的数据准备好
				ArrayList al=tCl.getTeacherLogin(u);
				//将al,pageCount,pageNow放入request中
				request.setAttribute("result", al);
				
//				//调用UserBeanCl
//				UserCl uCl=new UserCl();
				
				//在跳转到wel.jsp页面时，就把要显示的数据准备好
				ArrayList all=tCl.getTCourseByPage(Integer.parseInt(pageNow),u);
				int pageCount=tCl.getTCoursePageCount(u);
				//将al,pageCount,pageNow放入request中
				request.setAttribute("Sresult", all);
				request.setAttribute("pageCount", pageCount+"");
				request.setAttribute("pageNow", pageNow+"");
				
				//重新跳转回wel.jsp
				request.getRequestDispatcher("TeacherInfo.jsp").forward(request,response);
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}
		else if(flag.equals("xuankeqk")){
		//得到用户希望显示的pageNow
		
			try {
				//得到用户输入的信息
				String C_no=request.getParameter("C_no");
//				System.out.println(C_no);
				
				//调用UserBeanCl
				TeacherCl tCl=new TeacherCl();
								
//				//调用UserBeanCl
//				UserCl uCl=new UserCl();
				
				//在跳转到wel.jsp页面时，就把要显示的数据准备好
				ArrayList al=tCl.getTUserByPage(Integer.parseInt(pageNow),C_no);
				int pageCount=tCl.getTUserPageCount(C_no);
				//将al,pageCount,pageNow放入request中
				request.setAttribute("C_no", C_no);				
				request.setAttribute("result", al);
				request.setAttribute("pageCount", pageCount+"");
				request.setAttribute("pageNow", pageNow+"");
				
				//重新跳转回wel.jsp
				request.getRequestDispatcher("TeacherMC.jsp").forward(request,response);
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
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

		this.doGet(request, response);
	}

}
