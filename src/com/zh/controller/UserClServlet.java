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
public class UserClServlet extends HttpServlet {

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
				UserCl uCl=new UserCl();
				
				//在跳转到wel.jsp页面时，就把要显示的数据准备好
				ArrayList al=uCl.getUSCourseByPage(Integer.parseInt(pageNow),u);
				int pageCount=uCl.getUSCoursePageCount(u);
				//将al,pageCount,pageNow放入request中
				request.setAttribute("result", al);
				request.setAttribute("pageCount", pageCount+"");
				request.setAttribute("pageNow", pageNow+"");
				
				//重新跳转回wel.jsp
				request.getRequestDispatcher("UserMC.jsp").forward(request,response);
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}
		else if(flag.equals("SelectC")){
		//得到用户希望显示的pageNow
		
			try {
				
				//1.得到要删除的用户的id
				String C_no=request.getParameter("C_no");
				System.out.println(u);
				System.out.println(C_no);
				
				//调用UserBeanCl
				UserCl uCl=new UserCl();
							
				if(uCl.SelectCByNo(u,C_no)){
					
					//删除成功
					request.getRequestDispatcher("Usuc.jsp").forward(request, response);
				}else{
					
					//删除不成功
					request.getRequestDispatcher("Uerr.jsp").forward(request, response);

				}

			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}
		else if(flag.equals("Skechengfenye")){
		//得到用户希望显示的pageNow
		
			try {
				
				//调用UserBeanCl
				UserCl uCl=new UserCl();
				
				//在跳转到wel.jsp页面时，就把要显示的数据准备好
				ArrayList al=uCl.getUserLogin(u);
				//将al,pageCount,pageNow放入request中
				request.setAttribute("result", al);
				
//				//调用UserBeanCl
//				UserCl uCl=new UserCl();
				
				//在跳转到wel.jsp页面时，就把要显示的数据准备好
				ArrayList all=uCl.getSCourseByPage(Integer.parseInt(pageNow),u);
				int pageCount=uCl.getSCoursePageCount(u);
				//将al,pageCount,pageNow放入request中
				request.setAttribute("Sresult", all);
				request.setAttribute("pageCount", pageCount+"");
				request.setAttribute("pageNow", pageNow+"");
				
				//重新跳转回wel.jsp
				request.getRequestDispatcher("UserInfo.jsp").forward(request,response);
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}
		else if(flag.equals("delSCourse")){
			
			//完成删除操作
			//1.得到要删除的用户的id
			String C_no=request.getParameter("C_no");
			
			//调用UserBeanCl
			UserCl uCl=new UserCl();
						
			if(uCl.delSCourseByNo(u,C_no)){
				
				//删除成功
				request.getRequestDispatcher("Usuc.jsp").forward(request, response);
			}else{
				
				//删除不成功
				request.getRequestDispatcher("Uerr.jsp").forward(request, response);

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
