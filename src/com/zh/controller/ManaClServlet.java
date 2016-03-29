package com.zh.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zh.model.*;

public class ManaClServlet extends HttpServlet {

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

		/**
		 * 对Usertb表的操作
		 */
		//如果是要分页
		if(flag.equals("yonghufenye")){
		//得到用户希望显示的pageNow
		
			try {
				
				//调用UserBeanCl
				ManaCl mCl=new ManaCl();
				
				//在跳转到wel.jsp页面时，就把要显示的数据准备好
				ArrayList al=mCl.getUserByPage(Integer.parseInt(pageNow));
				int pageCount=mCl.getUserPageCount();
				//将al,pageCount,pageNow放入request中
				request.setAttribute("result", al);
				request.setAttribute("pageCount", pageCount+"");
				request.setAttribute("pageNow", pageNow+"");
				
				//重新跳转回wel.jsp
				request.getRequestDispatcher("ManaShowUse.jsp").forward(request,response);
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}
		else if(flag.equals("delUser")){
			
			//完成删除操作
			//1.得到要删除的用户的id
			String U_no=request.getParameter("U_no");
			
			//调用UserBeanCl
			ManaCl mCl=new ManaCl();
						
			if(mCl.delUserByNo(U_no)){
				
				//删除成功
				request.getRequestDispatcher("suc.jsp").forward(request, response);
			}else{
				
				//删除不成功
				request.getRequestDispatcher("err.jsp").forward(request, response);

			}
		}		
		else if(flag.equals("addUser")){
			
			//完成添加用户
			//得到用户输入的信息
			String U_no=request.getParameter("U_no");
			String U_name=request.getParameter("U_name");
			String U_pwd=request.getParameter("U_pwd");
			String U_sex=request.getParameter("U_sex");
			String U_age=request.getParameter("U_age");
			String U_tel=request.getParameter("U_tel");
			
			//调用ManaCl
			ManaCl mCl=new ManaCl();
						
			if(mCl.addUser(U_no,U_name,U_pwd,U_sex,U_age, U_tel)){
				
				//添加成功
				request.getRequestDispatcher("suc.jsp").forward(request, response);
			}else{
				
				//添加不成功
				request.getRequestDispatcher("err.jsp").forward(request, response);

			}
		}
		else if(flag.equals("updateUser")){
			
			//完成修改用户
			//得到用户输入的信息
			String U_no=request.getParameter("U_no");
			String U_name=request.getParameter("U_name");
			String U_pwd=request.getParameter("U_pwd");
			String U_sex=request.getParameter("U_sex");
			String U_age=request.getParameter("U_age");
			String U_tel=request.getParameter("U_tel");
			//调用ManaCl
			ManaCl mCl=new ManaCl();
						
			if(mCl.updateUser(U_no,U_name,U_pwd,U_sex,U_age, U_tel)){
				
				//添加成功
				request.getRequestDispatcher("suc.jsp").forward(request, response);
			}else{
				
				//添加不成功
				request.getRequestDispatcher("err.jsp").forward(request, response);

			}
			
		}
		
		/**
		 * 对Teachertb表的操作
		 */
		else if(flag.equals("laoshifenye")){
		//得到用户希望显示的pageNow
		
			try {
				
				//调用UserBeanCl
				ManaCl mCl=new ManaCl();
				
				//在跳转到wel.jsp页面时，就把要显示的数据准备好
				ArrayList al=mCl.getTeacherByPage(Integer.parseInt(pageNow));
				int pageCount=mCl.getTeacherPageCount();
				//将al,pageCount,pageNow放入request中
				request.setAttribute("result", al);
				request.setAttribute("pageCount", pageCount+"");
				request.setAttribute("pageNow", pageNow+"");
				
				//重新跳转回wel.jsp
				request.getRequestDispatcher("ManaShowTea.jsp").forward(request,response);
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}
		else if(flag.equals("delTeacher")){
			
			//完成删除操作
			//1.得到要删除的用户的id
			String T_no=request.getParameter("T_no");
			
			//调用UserBeanCl
			ManaCl mCl=new ManaCl();
						
			if(mCl.delTeacherByNo(T_no)){
				
				//删除成功
				request.getRequestDispatcher("suc.jsp").forward(request, response);
			}else{
				
				//删除不成功
				request.getRequestDispatcher("err.jsp").forward(request, response);

			}
		}		
		else if(flag.equals("addTeacher")){
			
			//完成添加用户
			//得到用户输入的信息
			String T_no=request.getParameter("T_no");
			String T_name=request.getParameter("T_name");
			String T_pwd=request.getParameter("T_pwd");
			String T_sex=request.getParameter("T_sex");
			String T_age=request.getParameter("T_age");
			String T_tel=request.getParameter("T_tel");
			
			//调用ManaCl
			ManaCl mCl=new ManaCl();
						
			if(mCl.addTeacher(T_no,T_name,T_pwd,T_sex,T_age, T_tel)){
				
				//添加成功
				request.getRequestDispatcher("suc.jsp").forward(request, response);
			}else{
				
				//添加不成功
				request.getRequestDispatcher("err.jsp").forward(request, response);

			}
		}
		else if(flag.equals("updateTeacher")){
			
			//完成修改用户
			//得到用户输入的信息
			String T_no=request.getParameter("T_no");
			String T_name=request.getParameter("T_name");
			String T_pwd=request.getParameter("T_pwd");
			String T_sex=request.getParameter("T_sex");
			String T_age=request.getParameter("T_age");
			String T_tel=request.getParameter("T_tel");
			//调用ManaCl
			ManaCl mCl=new ManaCl();
						
			if(mCl.updateTeacher(T_no,T_name,T_pwd,T_sex,T_age, T_tel)){
				
				//添加成功
				request.getRequestDispatcher("suc.jsp").forward(request, response);
			}else{
				
				//添加不成功
				request.getRequestDispatcher("err.jsp").forward(request, response);

			}						
		}
		
		
		/**
		 * 对Coursetb表的操作
		 */
		else if(flag.equals("kechengfenye")){
		//得到用户希望显示的pageNow
		
			try {
				
				//调用UserBeanCl
				ManaCl mCl=new ManaCl();
				
				//在跳转到wel.jsp页面时，就把要显示的数据准备好
				ArrayList al=mCl.getCourseByPage(Integer.parseInt(pageNow));
				int pageCount=mCl.getCoursePageCount();
				//将al,pageCount,pageNow放入request中
				request.setAttribute("result", al);
				request.setAttribute("pageCount", pageCount+"");
				request.setAttribute("pageNow", pageNow+"");
				
				//重新跳转回wel.jsp
				request.getRequestDispatcher("ManaShowCou.jsp").forward(request,response);
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}
		else if(flag.equals("delCourse")){
			
			//完成删除操作
			//1.得到要删除的用户的id
			String C_no=request.getParameter("C_no");
			
			//调用UserBeanCl
			ManaCl mCl=new ManaCl();
						
			if(mCl.delCourseByNo(C_no)){
				
				//删除成功
				request.getRequestDispatcher("suc.jsp").forward(request, response);
			}else{
				
				//删除不成功
				request.getRequestDispatcher("err.jsp").forward(request, response);

			}
		}		
		else if(flag.equals("addCourse")){
			
			//完成添加用户
			//得到用户输入的信息
			String C_no=request.getParameter("C_no");
			String C_name=request.getParameter("C_name");
			String C_price=request.getParameter("C_price");
			String T_no=request.getParameter("T_no");
			
			//调用ManaCl
			ManaCl mCl=new ManaCl();
						
			if(mCl.addCourse(C_no,C_name,C_price,T_no)){
				
				//添加成功
				request.getRequestDispatcher("suc.jsp").forward(request, response);
			}else{
				
				//添加不成功
				request.getRequestDispatcher("err.jsp").forward(request, response);

			}
		}
		else if(flag.equals("updateCourse")){
			
			//完成修改用户
			//得到用户输入的信息
			String C_no=request.getParameter("C_no");
			String C_name=request.getParameter("C_name");
			String C_price=request.getParameter("C_price");
			String T_no=request.getParameter("T_no");
			//调用ManaCl
			ManaCl mCl=new ManaCl();
						
			if(mCl.updateCourse(C_no,C_name,C_price,T_no)){
				
				//添加成功
				request.getRequestDispatcher("suc.jsp").forward(request, response);
			}else{
				
				//添加不成功
				request.getRequestDispatcher("err.jsp").forward(request, response);

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
