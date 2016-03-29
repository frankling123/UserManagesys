package com.zh.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class TeacherCl {

	private Statement sm=null;
	private ResultSet rs=null;
	private Connection ct=null;
	private int pageSize=3;
	private int rowCount=0;//通过查询数据库
	private int pageCount=0;//通过pageSize和rowCount
	

	//关闭资源
	public void close(){
	
		//关闭打开的资源
		
		try {
			
			if (rs != null) {
				rs.close();
				rs = null;//加速资源释放
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
	
	//验证老师是否存在	
	public boolean checkTeacher(String u,String p){
	
		boolean b=false;
		
		//
		try {
			
		    //到数据库中验证用户
		    ct=new ConnDB().getConn();
		    
		    //3.创建Statement
		    sm=ct.createStatement();
		    //4.查询
		    rs=sm.executeQuery("select Tea_pwd from teachertb where Tea_no='"+u+"'");
		    //根据结果判断
		    if(rs.next()){
		    
		    	//说明用户名存在
		    	if(rs.getString(1).equals(p)){
		    	
		    		//一定合法
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

	public ArrayList getTeacherLogin(String no){
		

		ArrayList al=new ArrayList();
		try {
			ct=new ConnDB().getConn();
			
		    //创建Statement
		    sm=ct.createStatement();
		    
		    //查询出需要显示的记录
//	 	    rs=sm.executeQuery("select top "+pageSize+" * from userinfo where userId not in (select top "+pageSize*(pageNow-1)+" userId from userinfo)");
		    rs=sm.executeQuery("select * from teachertb where Tea_no='"+no+"'");
		    
		    //开始将rs封装到ArrayList
		    while(rs.next()){
		    	
	        	TeacherBean tb = new TeacherBean();
	        	tb.setT_no(rs.getString(1));
	        	tb.setT_name(rs.getString(2));
	        	tb.setT_pwd(rs.getString(3));
	        	tb.setT_sex(rs.getString(4));
	        	tb.setT_age(rs.getInt(5));
	        	tb.setT_tel(rs.getString(6));
	        	
	        	
	        	//将ub放入到arraylist中
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

	public int getTCoursePageCount(String u){
		
		try {
			
			//得到链接
			ct=new ConnDB().getConn();
		    //创建Statement			
			sm=ct.createStatement();
		    //4.查询	   
		    ResultSet rs=sm.executeQuery("select count(*) from coursetb where Tea_no='"+u+"'");
		   
		    //注意 一定要rs.next	    
		    if(rs.next()){
		    
		    	rowCount=rs.getInt(1);
		    
		    }
		    
		    //计算pageCount
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
	
	//得到用户需要显示的用户信息（分页）	
	public ArrayList getTCourseByPage(int pageNow,String u){
		

		ArrayList al=new ArrayList();
		try {
			ct=new ConnDB().getConn();
			
		    //创建Statement
		    sm=ct.createStatement();
		    
		    //查询出需要显示的记录
//	 	    rs=sm.executeQuery("select top "+pageSize+" * from userinfo where userId not in (select top "+pageSize*(pageNow-1)+" userId from userinfo)");
//		    rs=sm.executeQuery("select * from usc where C_no not in (select C_no from(select C_no from((select * from coursetb where C_no not in(select C_no from sctb where U_no='"+u+"'))as usc) limit "+pageSize*(pageNow-1)+")as temp) limit "+pageSize+"");	    
		    rs=sm.executeQuery("select * from ((select * from coursetb where Tea_no ='"+u+"')as usc) where C_no not in (select C_no from (select * from ((select * from coursetb where Tea_no ='"+u+"')as usc) limit "+pageSize*(pageNow-1)+") as temp) limit "+pageSize+"");	    

		    //开始将rs封装到ArrayList
		    while(rs.next()){
		    	
	        	CourseBean cb = new CourseBean();
	        	cb.setC_no(rs.getString(1));
	        	cb.setC_name(rs.getString(2));
	        	cb.setC_price(rs.getInt(3));
	        	cb.setT_no(rs.getString(4));

	        	
	        	
	        	//将ub放入到arraylist中
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
	
	public int getTUserPageCount(String u){
		
		try {
			
			//得到链接
			ct=new ConnDB().getConn();
		    //创建Statement			
			sm=ct.createStatement();
		    //4.查询	   
		    ResultSet rs=sm.executeQuery("select count(*) from sctb where C_no='"+u+"'");
		   
		    //注意 一定要rs.next	    
		    if(rs.next()){
		    
		    	rowCount=rs.getInt(1);
		    
		    }
		    
		    //计算pageCount
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
	
	//得到用户需要显示的用户信息（分页）	
	public ArrayList getTUserByPage(int pageNow,String u){
		

		ArrayList al=new ArrayList();
		try {
			ct=new ConnDB().getConn();
			
		    //创建Statement
		    sm=ct.createStatement();
		    
		    //查询出需要显示的记录
//	 	    rs=sm.executeQuery("select top "+pageSize+" * from userinfo where userId not in (select top "+pageSize*(pageNow-1)+" userId from userinfo)");
//		    rs=sm.executeQuery("select * from usc where C_no not in (select C_no from(select C_no from((select * from coursetb where C_no not in(select C_no from sctb where U_no='"+u+"'))as usc) limit "+pageSize*(pageNow-1)+")as temp) limit "+pageSize+"");	    
		    rs=sm.executeQuery("select * from ((select * from usertb where U_no in(select U_no from sctb where C_no='"+u+"'))as usc) where U_no not in (select U_no from (select * from ((select * from usertb where U_no in(select U_no from sctb where C_no='"+u+"'))as usc) limit "+pageSize*(pageNow-1)+") as temp) limit "+pageSize+"");	    

		    //开始将rs封装到ArrayList
		    while(rs.next()){
		    	
	        	UserBean ub = new UserBean();
	        	ub.setU_no(rs.getString(1));
	        	ub.setU_name(rs.getString(2));
	        	ub.setU_pwd(rs.getString(3));
	        	ub.setU_sex(rs.getString(4));
	        	ub.setU_age(rs.getInt(5));
	        	ub.setU_tel(rs.getString(6));
	        	
	        	
	        	//将ub放入到arraylist中
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
}