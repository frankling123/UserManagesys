//����һ�������࣬��Ҫ�Ƿ�װ��userinfo��ĸ��ֲ���
package com.zh.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class UserCl {
	
	private Statement sm=null;
	private ResultSet rs=null;
	private Connection ct=null;
	private int pageSize=3;
	private int rowCount=0;//ͨ����ѯ���ݿ�
	private int pageCount=0;//ͨ��pageSize��rowCount
	
	//����û�
	/**
	 * @author zh
	 * @param name
	 * @param passwd
	 * @param email
	 * @param grade
	 * @return
	 */

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
	
	//��֤�û��Ƿ����	
	public boolean checkUser(String u,String p){
	
		boolean b=false;
		
		//
		try {
			
		    //�����ݿ�����֤�û�
		    ct=new ConnDB().getConn();
		    
		    //3.����Statement
		    sm=ct.createStatement();
		    //4.��ѯ
		    rs=sm.executeQuery("select U_pwd from usertb where U_no='"+u+"'");
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
	
	//�õ���¼�û���Ϣ	
	public ArrayList getUserLogin(String no){
		

		ArrayList al=new ArrayList();
		try {
			ct=new ConnDB().getConn();
			
		    //����Statement
		    sm=ct.createStatement();
		    
		    //��ѯ����Ҫ��ʾ�ļ�¼
//	 	    rs=sm.executeQuery("select top "+pageSize+" * from userinfo where userId not in (select top "+pageSize*(pageNow-1)+" userId from userinfo)");
		    rs=sm.executeQuery("select * from usertb where U_no='"+no+"'");
		    
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

	//���ط�ҳ����ҳ��
	public int getUSCoursePageCount(String u){
		
		try {
			
			//�õ�����
			ct=new ConnDB().getConn();
		    //����Statement			
			sm=ct.createStatement();
		    //4.��ѯ	   
		    ResultSet rs=sm.executeQuery("select count(*) from coursetb where C_no not in(select C_no from sctb where U_no='"+u+"')");
		   
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
	public ArrayList getUSCourseByPage(int pageNow,String u){
		

		ArrayList al=new ArrayList();
		try {
			ct=new ConnDB().getConn();
			
		    //����Statement
		    sm=ct.createStatement();
		    
		    //��ѯ����Ҫ��ʾ�ļ�¼
//	 	    rs=sm.executeQuery("select top "+pageSize+" * from userinfo where userId not in (select top "+pageSize*(pageNow-1)+" userId from userinfo)");
//		    rs=sm.executeQuery("select * from usc where C_no not in (select C_no from(select C_no from((select * from coursetb where C_no not in(select C_no from sctb where U_no='"+u+"'))as usc) limit "+pageSize*(pageNow-1)+")as temp) limit "+pageSize+"");	    
		    rs=sm.executeQuery("select * from ((select * from coursetb where C_no not in(select C_no from sctb where U_no='"+u+"'))as usc) where C_no not in (select C_no from (select * from ((select * from coursetb where C_no not in(select C_no from sctb where U_no='"+u+"'))as usc) limit "+pageSize*(pageNow-1)+") as temp) limit "+pageSize+"");	    

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
	
	public boolean SelectCByNo(String U_no,String C_no){
		
		boolean b=false;
		
		try {
			//�õ�����
			ct=new ConnDB().getConn();
			
			sm=ct.createStatement();
			//ִ��
			int a=sm.executeUpdate("insert into sctb values('"+U_no+"','"+C_no+"')");
			
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

	public boolean delSCourseByNo(String U_no,String C_no){
		
		boolean b=false;
		
		try {
			//�õ�����
			ct=new ConnDB().getConn();
			
			sm=ct.createStatement();
			//ִ��
			int a=sm.executeUpdate("delete from sctb where U_no='"+U_no+"' and C_no='"+C_no+"'");
			
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
	
	//���ط�ҳ����ҳ��
	public int getSCoursePageCount(String u){
		
		try {
			
			//�õ�����
			ct=new ConnDB().getConn();
		    //����Statement			
			sm=ct.createStatement();
		    //4.��ѯ	   
		    ResultSet rs=sm.executeQuery("select count(*) from coursetb where C_no in(select C_no from sctb where U_no='"+u+"')");
		   
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
	public ArrayList getSCourseByPage(int pageNow,String u){
		

		ArrayList al=new ArrayList();
		try {
			ct=new ConnDB().getConn();
			
		    //����Statement
		    sm=ct.createStatement();
		    
		    //��ѯ����Ҫ��ʾ�ļ�¼
//	 	    rs=sm.executeQuery("select top "+pageSize+" * from userinfo where userId not in (select top "+pageSize*(pageNow-1)+" userId from userinfo)");
		    rs=sm.executeQuery("select * from ((select * from coursetb where C_no in (select C_no from sctb where U_no='"+u+"'))as usc) where C_no not in (select C_no from (select * from ((select * from coursetb where C_no in(select C_no from sctb where U_no='"+u+"'))as usc) limit "+pageSize*(pageNow-1)+") as temp) limit "+pageSize+"");	    
		    
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
	
}
