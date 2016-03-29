package com.zh.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ManaCl {
	
	private Statement sm=null;
	private ResultSet rs=null;
	private Connection ct=null;
	private int pageSize=3;
	private int rowCount=0;//ͨ����ѯ���ݿ�
	private int pageCount=0;//ͨ��pageSize��rowCount	
	
	
	public boolean checkMana(String u,String p){
		
		boolean b=false;
		
		//
		try {
			
		    //�����ݿ�����֤����Ա
		    ct=new ConnDB().getConn();
		    
		    //3.����Statement
		    sm=ct.createStatement();
		    //4.��ѯ
		    rs=sm.executeQuery("select M_pwd from Manatb where M_no='"+u+"'");
		    //���ݽ���ж�
		    if(rs.next()){
		    
		    	//˵���û�������
		    	if(rs.getString(1).equals(p)){
		    	
		    		//һ���Ϸ�
		    		b=true;
		    	}
		    		
		    }
		    
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally{
		
			this.close();
		}
				
		return b;
	}
	
	/**
	 * ��Usertb��Ĳ���
	 */
    //����û�
	public boolean addUser(String no,String name,String pwd,String sex,String age,String tel){
		
		boolean b=false;
		
		try {
			//�õ�����
			ct=new ConnDB().getConn();
			
			sm=ct.createStatement();
			//ִ��
			int a=sm.executeUpdate("insert into usertb values('"+no+"','"+name+"','"+pwd+"','"+sex+"','"+age+"','"+tel+"')");
			
			if(a==1){
				//��ӳɹ�
				b=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			
			this.close();
		}
		return b;
		
	}
	
	//ɾ���û�
	public boolean delUserByNo(String no){
		
		boolean b=false;
		
		try {
			//�õ�����
			ct=new ConnDB().getConn();
			
			sm=ct.createStatement();
			//ִ��
			int a=sm.executeUpdate("delete from usertb where U_no='"+no+"'");
			
			if(a==1){
				//ɾ���ɹ�
				b=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			
			this.close();
		}
		return b;
	}
	
	//�޸��û�
	public boolean updateUser(String no,String name,String pwd,String sex,String age,String tel){
	
		boolean b=false;
		
		try {
			//�õ�����
			ct=new ConnDB().getConn();
			
			sm=ct.createStatement();
			
			//ִ��		
			int a=sm.executeUpdate("update usertb set U_no='"+no+"',U_name='"+name+"',U_pwd='"+pwd+"',U_sex='"+sex+"',U_age='"+age+"',U_tel='"+tel+"' where U_no='"+no+"'");
		
			if(a==1){
				//��ӳɹ�
				b=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			
			this.close();
		}
		return b;
	}
	
	
	//���ط�ҳ����ҳ��
	public int getUserPageCount(){
		
		try {
			
			//�õ�����
			ct=new ConnDB().getConn();
		    //����Statement			
			sm=ct.createStatement();
		    //4.��ѯ	   
		    ResultSet rs=sm.executeQuery("select count(*) from usertb");
		   
		    //ע�� һ��Ҫrs.next	    
		    if(rs.next()){
		    
		    	rowCount=rs.getInt(1);
		    
		    }
		    
		    //����pageCount
		    if(rowCount%pageSize==0){
		    
		    	pageCount=rowCount/pageSize;	        
		    }else{
		    	
		    	pageCount=rowCount/pageSize+1;
		    }

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			
			this.close();
		}
		
		return pageCount;
	}
	
	//�õ��û���Ҫ��ʾ���û���Ϣ����ҳ��	
	public ArrayList getUserByPage(int pageNow){
		

		ArrayList al=new ArrayList();
		try {
			ct=new ConnDB().getConn();
			
		    //����Statement
		    sm=ct.createStatement();
		    
		    //��ѯ����Ҫ��ʾ�ļ�¼
//	 	    rs=sm.executeQuery("select top "+pageSize+" * from userinfo where userId not in (select top "+pageSize*(pageNow-1)+" userId from userinfo)");
		    rs=sm.executeQuery("select * from usertb where U_no not in (select U_no from (select * from usertb limit "+pageSize*(pageNow-1)+") as temp) limit "+pageSize+"");	    
		    
		    //��ʼ��rs��װ��ArrayList
		    while(rs.next()){
		    	
	        	UserBean ub = new UserBean();
	        	ub.setU_no(rs.getString(1));
	        	ub.setU_name(rs.getString(2));
	        	ub.setU_pwd(rs.getString(3));
	        	ub.setU_sex(rs.getString(4));
	        	ub.setU_age(rs.getInt(5));
	        	ub.setU_tel(rs.getString(6));
	        	
	        	
	        	//��ub���뵽arraylist��
				al.add(ub);
		    }
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally{
		
			this.close();
		}
		
		return al;
	}
	
	
	/**
	 * ��Teachertb��Ĳ���
	 */
    //�����ʦ
	public boolean addTeacher(String no,String name,String pwd,String sex,String age,String tel){
		
		boolean b=false;
		
		try {
			//�õ�����
			ct=new ConnDB().getConn();
			
			sm=ct.createStatement();
			//ִ��
			int a=sm.executeUpdate("insert into teachertb values('"+no+"','"+name+"','"+pwd+"','"+sex+"','"+age+"','"+tel+"')");
			
			if(a==1){
				//��ӳɹ�
				b=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			
			this.close();
		}
		return b;
		
	}
	
	//ɾ����ʦ
	public boolean delTeacherByNo(String no){
		
		boolean b=false;
		
		try {
			//�õ�����
			ct=new ConnDB().getConn();
			
			sm=ct.createStatement();
			//ִ��
			int a=sm.executeUpdate("delete from teachertb where Tea_no='"+no+"'");
			
			if(a==1){
				//ɾ���ɹ�
				b=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			
			this.close();
		}
		return b;
	}
	
	//�޸���ʦ
	public boolean updateTeacher(String no,String name,String pwd,String sex,String age,String tel){
	
		boolean b=false;
		
		try {
			//�õ�����
			ct=new ConnDB().getConn();
			
			sm=ct.createStatement();
			
			//ִ��		
			int a=sm.executeUpdate("update teachertb set Tea_no='"+no+"',Tea_name='"+name+"',Tea_pwd='"+pwd+"',Tea_sex='"+sex+"',Tea_age='"+age+"',Tea_tel='"+tel+"' where Tea_no='"+no+"'");
		
			if(a==1){
				//��ӳɹ�
				b=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			
			this.close();
		}
		return b;
	}
	
	
	//������ʦ��ҳ����ҳ��
	public int getTeacherPageCount(){
		
		try {
			
			//�õ�����
			ct=new ConnDB().getConn();
		    //����Statement			
			sm=ct.createStatement();
		    //4.��ѯ	   
		    ResultSet rs=sm.executeQuery("select count(*) from teachertb");
		   
		    //ע�� һ��Ҫrs.next	    
		    if(rs.next()){
		    
		    	rowCount=rs.getInt(1);
		    
		    }
		    
		    //����pageCount
		    if(rowCount%pageSize==0){
		    
		    	pageCount=rowCount/pageSize;	        
		    }else{
		    	
		    	pageCount=rowCount/pageSize+1;
		    }

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			
			this.close();
		}
		
		return pageCount;
	}
	
	//�õ���ʦ��Ҫ��ʾ����ʦ��Ϣ����ҳ��	
	public ArrayList getTeacherByPage(int pageNow){
		

		ArrayList al=new ArrayList();
		try {
			ct=new ConnDB().getConn();
			
		    //����Statement
		    sm=ct.createStatement();
		    
		    //��ѯ����Ҫ��ʾ�ļ�¼
//	 	    rs=sm.executeQuery("select top "+pageSize+" * from userinfo where userId not in (select top "+pageSize*(pageNow-1)+" userId from userinfo)");
		    rs=sm.executeQuery("select * from teachertb where Tea_no not in (select Tea_no from (select * from teachertb limit "+pageSize*(pageNow-1)+") as temp) limit "+pageSize+"");	    
		    
		    //��ʼ��rs��װ��ArrayList
		    while(rs.next()){
		    	
		    	TeacherBean tb = new TeacherBean();
	        	tb.setT_no(rs.getString(1));
	        	tb.setT_name(rs.getString(2));		
	        	tb.setT_pwd(rs.getString(3));
	        	tb.setT_sex(rs.getString(4));
	        	tb.setT_age(rs.getInt(5));
	        	tb.setT_tel(rs.getString(6));
	        	
	        	
	        	//��ub���뵽arraylist��
				al.add(tb);
		    }
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally{
		
			this.close();
		}
		
		return al;
	}
	
	
	/**
	 * ��Coursetb��Ĳ���
	 */
    //����û�
	public boolean addCourse(String no,String name,String price,String T_no){
		
		boolean b=false;
		
		try {
			//�õ�����
			ct=new ConnDB().getConn();
			
			sm=ct.createStatement();
			//ִ��
			int a=sm.executeUpdate("insert into coursetb values('"+no+"','"+name+"','"+price+"','"+T_no+"')");
			
			if(a==1){
				//��ӳɹ�
				b=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			
			this.close();
		}
		return b;
		
	}
	
	//ɾ���û�
	public boolean delCourseByNo(String no){
		
		boolean b=false;
		
		try {
			//�õ�����
			ct=new ConnDB().getConn();
			
			sm=ct.createStatement();
			//ִ��
			int a=sm.executeUpdate("delete from coursetb where C_no='"+no+"'");
			
			if(a==1){
				//ɾ���ɹ�
				b=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			
			this.close();
		}
		return b;
	}
	
	//�޸��û�
	public boolean updateCourse(String no,String name,String price,String T_no){
	
		boolean b=false;
		
		try {
			//�õ�����
			ct=new ConnDB().getConn();
			
			sm=ct.createStatement();
			
			//ִ��		
			int a=sm.executeUpdate("update coursetb set C_no='"+no+"',C_name='"+name+"',C_price='"+price+"',Tea_no='"+T_no+"' where C_no='"+no+"'");
		
			if(a==1){
				//��ӳɹ�
				b=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			
			this.close();
		}
		return b;
	}
	
	
	//���ط�ҳ����ҳ��
	public int getCoursePageCount(){
		
		try {
			
			//�õ�����
			ct=new ConnDB().getConn();
		    //����Statement			
			sm=ct.createStatement();
		    //4.��ѯ	   
		    ResultSet rs=sm.executeQuery("select count(*) from coursetb");
		   
		    //ע�� һ��Ҫrs.next	    
		    if(rs.next()){
		    
		    	rowCount=rs.getInt(1);
		    
		    }
		    
		    //����pageCount
		    if(rowCount%pageSize==0){
		    
		    	pageCount=rowCount/pageSize;	        
		    }else{
		    	
		    	pageCount=rowCount/pageSize+1;
		    }

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			
			this.close();
		}
		
		return pageCount;
	}
	
	//�õ��û���Ҫ��ʾ���û���Ϣ����ҳ��	
	public ArrayList getCourseByPage(int pageNow){
		

		ArrayList al=new ArrayList();
		try {
			ct=new ConnDB().getConn();
			
		    //����Statement
		    sm=ct.createStatement();
		    
		    //��ѯ����Ҫ��ʾ�ļ�¼
//	 	    rs=sm.executeQuery("select top "+pageSize+" * from userinfo where userId not in (select top "+pageSize*(pageNow-1)+" userId from userinfo)");
		    rs=sm.executeQuery("select * from coursetb where C_no not in (select C_no from (select * from coursetb limit "+pageSize*(pageNow-1)+") as temp) limit "+pageSize+"");	    
		    
		    //��ʼ��rs��װ��ArrayList
		    while(rs.next()){
		    	
	        	CourseBean cb = new CourseBean();
	        	cb.setC_no(rs.getString(1));
	        	cb.setC_name(rs.getString(2));
	        	cb.setC_price(rs.getInt(3));
	        	cb.setT_no(rs.getString(4));

	        	
	        	
	        	//��ub���뵽arraylist��
				al.add(cb);
		    }
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally{
		
			this.close();
		}
		
		return al;
	}
	
	
	//�ر���Դ
	public void close(){

		//�رմ򿪵���Դ
		
		try {
			
			if (rs != null) {
				rs.close();
				rs = null;//������Դ�ͷ�
			}
			if (sm != null) {
				sm.close();
				sm = null;
			}
			if (ct != null) {
				ct.close();
				ct = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
}


