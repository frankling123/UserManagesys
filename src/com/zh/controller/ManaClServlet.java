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
		
		//�������servletҳ����ʾ������
		response.setContentType("text/html;charset=gbk"); 
		//���post��ʽ�������ݵĲ�������  
		 request.setCharacterEncoding("gbk");  
		  
		//��ñ�ʶֵ
		String flag=request.getParameter("flag");
		String pageNow=request.getParameter("pageNow");		

		/**
		 * ��Usertb��Ĳ���
		 */
		//�����Ҫ��ҳ
		if(flag.equals("yonghufenye")){
		//�õ��û�ϣ����ʾ��pageNow
		
			try {
				
				//����UserBeanCl
				ManaCl mCl=new ManaCl();
				
				//����ת��wel.jspҳ��ʱ���Ͱ�Ҫ��ʾ������׼����
				ArrayList al=mCl.getUserByPage(Integer.parseInt(pageNow));
				int pageCount=mCl.getUserPageCount();
				//��al,pageCount,pageNow����request��
				request.setAttribute("result", al);
				request.setAttribute("pageCount", pageCount+"");
				request.setAttribute("pageNow", pageNow+"");
				
				//������ת��wel.jsp
				request.getRequestDispatcher("ManaShowUse.jsp").forward(request,response);
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}
		else if(flag.equals("delUser")){
			
			//���ɾ������
			//1.�õ�Ҫɾ�����û���id
			String U_no=request.getParameter("U_no");
			
			//����UserBeanCl
			ManaCl mCl=new ManaCl();
						
			if(mCl.delUserByNo(U_no)){
				
				//ɾ���ɹ�
				request.getRequestDispatcher("suc.jsp").forward(request, response);
			}else{
				
				//ɾ�����ɹ�
				request.getRequestDispatcher("err.jsp").forward(request, response);

			}
		}		
		else if(flag.equals("addUser")){
			
			//�������û�
			//�õ��û��������Ϣ
			String U_no=request.getParameter("U_no");
			String U_name=request.getParameter("U_name");
			String U_pwd=request.getParameter("U_pwd");
			String U_sex=request.getParameter("U_sex");
			String U_age=request.getParameter("U_age");
			String U_tel=request.getParameter("U_tel");
			
			//����ManaCl
			ManaCl mCl=new ManaCl();
						
			if(mCl.addUser(U_no,U_name,U_pwd,U_sex,U_age, U_tel)){
				
				//��ӳɹ�
				request.getRequestDispatcher("suc.jsp").forward(request, response);
			}else{
				
				//��Ӳ��ɹ�
				request.getRequestDispatcher("err.jsp").forward(request, response);

			}
		}
		else if(flag.equals("updateUser")){
			
			//����޸��û�
			//�õ��û��������Ϣ
			String U_no=request.getParameter("U_no");
			String U_name=request.getParameter("U_name");
			String U_pwd=request.getParameter("U_pwd");
			String U_sex=request.getParameter("U_sex");
			String U_age=request.getParameter("U_age");
			String U_tel=request.getParameter("U_tel");
			//����ManaCl
			ManaCl mCl=new ManaCl();
						
			if(mCl.updateUser(U_no,U_name,U_pwd,U_sex,U_age, U_tel)){
				
				//��ӳɹ�
				request.getRequestDispatcher("suc.jsp").forward(request, response);
			}else{
				
				//��Ӳ��ɹ�
				request.getRequestDispatcher("err.jsp").forward(request, response);

			}
			
		}
		
		/**
		 * ��Teachertb��Ĳ���
		 */
		else if(flag.equals("laoshifenye")){
		//�õ��û�ϣ����ʾ��pageNow
		
			try {
				
				//����UserBeanCl
				ManaCl mCl=new ManaCl();
				
				//����ת��wel.jspҳ��ʱ���Ͱ�Ҫ��ʾ������׼����
				ArrayList al=mCl.getTeacherByPage(Integer.parseInt(pageNow));
				int pageCount=mCl.getTeacherPageCount();
				//��al,pageCount,pageNow����request��
				request.setAttribute("result", al);
				request.setAttribute("pageCount", pageCount+"");
				request.setAttribute("pageNow", pageNow+"");
				
				//������ת��wel.jsp
				request.getRequestDispatcher("ManaShowTea.jsp").forward(request,response);
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}
		else if(flag.equals("delTeacher")){
			
			//���ɾ������
			//1.�õ�Ҫɾ�����û���id
			String T_no=request.getParameter("T_no");
			
			//����UserBeanCl
			ManaCl mCl=new ManaCl();
						
			if(mCl.delTeacherByNo(T_no)){
				
				//ɾ���ɹ�
				request.getRequestDispatcher("suc.jsp").forward(request, response);
			}else{
				
				//ɾ�����ɹ�
				request.getRequestDispatcher("err.jsp").forward(request, response);

			}
		}		
		else if(flag.equals("addTeacher")){
			
			//�������û�
			//�õ��û��������Ϣ
			String T_no=request.getParameter("T_no");
			String T_name=request.getParameter("T_name");
			String T_pwd=request.getParameter("T_pwd");
			String T_sex=request.getParameter("T_sex");
			String T_age=request.getParameter("T_age");
			String T_tel=request.getParameter("T_tel");
			
			//����ManaCl
			ManaCl mCl=new ManaCl();
						
			if(mCl.addTeacher(T_no,T_name,T_pwd,T_sex,T_age, T_tel)){
				
				//��ӳɹ�
				request.getRequestDispatcher("suc.jsp").forward(request, response);
			}else{
				
				//��Ӳ��ɹ�
				request.getRequestDispatcher("err.jsp").forward(request, response);

			}
		}
		else if(flag.equals("updateTeacher")){
			
			//����޸��û�
			//�õ��û��������Ϣ
			String T_no=request.getParameter("T_no");
			String T_name=request.getParameter("T_name");
			String T_pwd=request.getParameter("T_pwd");
			String T_sex=request.getParameter("T_sex");
			String T_age=request.getParameter("T_age");
			String T_tel=request.getParameter("T_tel");
			//����ManaCl
			ManaCl mCl=new ManaCl();
						
			if(mCl.updateTeacher(T_no,T_name,T_pwd,T_sex,T_age, T_tel)){
				
				//��ӳɹ�
				request.getRequestDispatcher("suc.jsp").forward(request, response);
			}else{
				
				//��Ӳ��ɹ�
				request.getRequestDispatcher("err.jsp").forward(request, response);

			}						
		}
		
		
		/**
		 * ��Coursetb��Ĳ���
		 */
		else if(flag.equals("kechengfenye")){
		//�õ��û�ϣ����ʾ��pageNow
		
			try {
				
				//����UserBeanCl
				ManaCl mCl=new ManaCl();
				
				//����ת��wel.jspҳ��ʱ���Ͱ�Ҫ��ʾ������׼����
				ArrayList al=mCl.getCourseByPage(Integer.parseInt(pageNow));
				int pageCount=mCl.getCoursePageCount();
				//��al,pageCount,pageNow����request��
				request.setAttribute("result", al);
				request.setAttribute("pageCount", pageCount+"");
				request.setAttribute("pageNow", pageNow+"");
				
				//������ת��wel.jsp
				request.getRequestDispatcher("ManaShowCou.jsp").forward(request,response);
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}
		else if(flag.equals("delCourse")){
			
			//���ɾ������
			//1.�õ�Ҫɾ�����û���id
			String C_no=request.getParameter("C_no");
			
			//����UserBeanCl
			ManaCl mCl=new ManaCl();
						
			if(mCl.delCourseByNo(C_no)){
				
				//ɾ���ɹ�
				request.getRequestDispatcher("suc.jsp").forward(request, response);
			}else{
				
				//ɾ�����ɹ�
				request.getRequestDispatcher("err.jsp").forward(request, response);

			}
		}		
		else if(flag.equals("addCourse")){
			
			//�������û�
			//�õ��û��������Ϣ
			String C_no=request.getParameter("C_no");
			String C_name=request.getParameter("C_name");
			String C_price=request.getParameter("C_price");
			String T_no=request.getParameter("T_no");
			
			//����ManaCl
			ManaCl mCl=new ManaCl();
						
			if(mCl.addCourse(C_no,C_name,C_price,T_no)){
				
				//��ӳɹ�
				request.getRequestDispatcher("suc.jsp").forward(request, response);
			}else{
				
				//��Ӳ��ɹ�
				request.getRequestDispatcher("err.jsp").forward(request, response);

			}
		}
		else if(flag.equals("updateCourse")){
			
			//����޸��û�
			//�õ��û��������Ϣ
			String C_no=request.getParameter("C_no");
			String C_name=request.getParameter("C_name");
			String C_price=request.getParameter("C_price");
			String T_no=request.getParameter("T_no");
			//����ManaCl
			ManaCl mCl=new ManaCl();
						
			if(mCl.updateCourse(C_no,C_name,C_price,T_no)){
				
				//��ӳɹ�
				request.getRequestDispatcher("suc.jsp").forward(request, response);
			}else{
				
				//��Ӳ��ɹ�
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
