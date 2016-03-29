//���������������Ϊ�û��ķ�ҳ��ʾ���û�����ɾ��
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
		
		//�������servletҳ����ʾ������
		response.setContentType("text/html;charset=gbk"); 
		//���post��ʽ�������ݵĲ�������  
		 request.setCharacterEncoding("gbk");  
		  
		//��ñ�ʶֵ
		String flag=request.getParameter("flag");
		String pageNow=request.getParameter("pageNow");
		
	  	String u=(String)request.getSession().getAttribute("myNo");
	  	
//		if(flag.equals("yonghuxingxi")){
//					
//			try {
//				
//				//����UserBeanCl
//				UserCl uCl=new UserCl();
//				
//				//����ת��wel.jspҳ��ʱ���Ͱ�Ҫ��ʾ������׼����
//				ArrayList al=uCl.getUserLogin(u);
//				//��al,pageCount,pageNow����request��
//				request.setAttribute("result", al);
//				
//				//������ת��wel.jsp
//				request.getRequestDispatcher("UserInfo.jsp").forward(request,response);
//			} catch (Exception e) {
//				e.printStackTrace();
//				// TODO: handle exception
//			}
//		}
	
		if(flag.equals("kechengfenye")){
		//�õ��û�ϣ����ʾ��pageNow
		
			try {
				
				//����UserBeanCl
				TeacherCl tCl=new TeacherCl();
				
				//����ת��wel.jspҳ��ʱ���Ͱ�Ҫ��ʾ������׼����
				ArrayList al=tCl.getTeacherLogin(u);
				//��al,pageCount,pageNow����request��
				request.setAttribute("result", al);
				
//				//����UserBeanCl
//				UserCl uCl=new UserCl();
				
				//����ת��wel.jspҳ��ʱ���Ͱ�Ҫ��ʾ������׼����
				ArrayList all=tCl.getTCourseByPage(Integer.parseInt(pageNow),u);
				int pageCount=tCl.getTCoursePageCount(u);
				//��al,pageCount,pageNow����request��
				request.setAttribute("Sresult", all);
				request.setAttribute("pageCount", pageCount+"");
				request.setAttribute("pageNow", pageNow+"");
				
				//������ת��wel.jsp
				request.getRequestDispatcher("TeacherInfo.jsp").forward(request,response);
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}
		else if(flag.equals("xuankeqk")){
		//�õ��û�ϣ����ʾ��pageNow
		
			try {
				//�õ��û��������Ϣ
				String C_no=request.getParameter("C_no");
//				System.out.println(C_no);
				
				//����UserBeanCl
				TeacherCl tCl=new TeacherCl();
								
//				//����UserBeanCl
//				UserCl uCl=new UserCl();
				
				//����ת��wel.jspҳ��ʱ���Ͱ�Ҫ��ʾ������׼����
				ArrayList al=tCl.getTUserByPage(Integer.parseInt(pageNow),C_no);
				int pageCount=tCl.getTUserPageCount(C_no);
				//��al,pageCount,pageNow����request��
				request.setAttribute("C_no", C_no);				
				request.setAttribute("result", al);
				request.setAttribute("pageCount", pageCount+"");
				request.setAttribute("pageNow", pageNow+"");
				
				//������ת��wel.jsp
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
