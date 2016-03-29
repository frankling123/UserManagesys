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

		//�õ��û���������
		String u=request.getParameter("username");
		String p=request.getParameter("passwd");
		
		//��ñ�ʶֵ
		String who=request.getParameter("who");
		
//		u=Tools.getNewString(u);		
		 

		if(who.equals("user")){
		
			//ʹ��ģ�ͣ�UserBeanCl����ɶ��û�����֤
			//1.����һ��UserBeanCl����
			UserCl uCl=new UserCl();
			//���÷���
			if(uCl.checkUser(u, p)){
				
				//����¼��ŷ���session 
				request.getSession().setAttribute("myNo", u);
				//request.getSession().setMaxInactiveInterval(30);
				//�������˾�� �������� ת�� ���� ��ת
				//���ַ���Ч�ʸ�  request�еĶ��󻹿�������һҳ��ʹ��
				request.getRequestDispatcher("UserMain.jsp").forward(request, response);								
			}
			else{
	
				//���Ϸ�			
				//response.sendRedirect("login.jsp");
				request.getRequestDispatcher("Login.jsp").forward(request, response);//��ת��������				
			}				
		}
		else if(who.equals("teacher")){
			//ʹ��ģ�ͣ�UserBeanCl����ɶ��û�����֤
			//1.����һ��UserBeanCl����
			TeacherCl tCl=new TeacherCl();
			//���÷���
			if(tCl.checkTeacher(u, p)){
				
				//����¼��ŷ���session 
				request.getSession().setAttribute("myNo", u);
				//request.getSession().setMaxInactiveInterval(30);
				//�������˾�� �������� ת�� ���� ��ת
				//���ַ���Ч�ʸ�  request�еĶ��󻹿�������һҳ��ʹ��
				request.getRequestDispatcher("TeacherMain.jsp").forward(request, response);								
			}
			else{
	
				//���Ϸ�			
				//response.sendRedirect("login.jsp");
				request.getRequestDispatcher("Login.jsp").forward(request, response);//��ת��������				
			}
		}
		else if(who.equals("manager")){
			
			//ʹ��ģ�ͣ�ManaCl����ɶ��û�����֤
			//1.����һ��ManaCl����
			ManaCl mCl=new ManaCl();

			//���÷���
			if(mCl.checkMana(u, p)){

				//����¼��ŷ���session 
				request.getSession().setAttribute("myNo", u);
				//request.getSession().setMaxInactiveInterval(30);
				//�������˾�� �������� ת�� ���� ��ת
				//���ַ���Ч�ʸ�  request�еĶ��󻹿�������һҳ��ʹ��
				request.getRequestDispatcher("ManaMain.jsp").forward(request, response);								
			}
			else{
	
				//���Ϸ�			
				//response.sendRedirect("login.jsp");
				request.getRequestDispatcher("Login.jsp").forward(request, response);//��ת��������				
			}
		}
		else{
			request.getRequestDispatcher("Login.jsp").forward(request, response);//��ת��������	
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

		//�϶�Ϊһ
		this.doGet(request, response);
	}

}
