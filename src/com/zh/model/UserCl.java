//这是一个处理类，主要是封装对userinfo表的各种操作
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
	private int rowCount=0;//通过查询数据库
	private int pageCount=0;//通过pageSize和rowCount
	
	//添加用户
	/**
	 * @author zh
	 * @param name
	 * @param passwd
	 * @param email
	 * @param grade
	 * @return
	 */

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
	
	//验证用户是否存在	
	public boolean checkUser(String u,String p){
	
		boolean b=false;
		
		//
		try {
			
		    //到数据库中验证用户
		    ct=new ConnDB().getConn();
		    
		    //3.创建Statement
		    sm=ct.createStatement();
		    //4.查询
		    rs=sm.executeQuery("select U_pwd from usertb where U_no='"+u+"'");
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
	
	//得到登录用户信息	
	public ArrayList getUserLogin(String no){
		

		ArrayList al=new ArrayList();
		try {
			ct=new ConnDB().getConn();
			
		    //创建Statement
		    sm=ct.createStatement();
		    
		    //查询出需要显示的记录
//	 	    rs=sm.executeQuery("select top "+pageSize+" * from userinfo where userId not in (select top "+pageSize*(pageNow-1)+" userId from userinfo)");
		    rs=sm.executeQuery("select * from usertb where U_no='"+no+"'");
		    
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

	//返回分页的总页数
	public int getUSCoursePageCount(String u){
		
		try {
			
			//得到链接
			ct=new ConnDB().getConn();
		    //创建Statement			
			sm=ct.createStatement();
		    //4.查询	   
		    ResultSet rs=sm.executeQuery("select count(*) from coursetb where C_no not in(select C_no from sctb where U_no='"+u+"')");
		   
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
	public ArrayList getUSCourseByPage(int pageNow,String u){
		

		ArrayList al=new ArrayList();
		try {
			ct=new ConnDB().getConn();
			
		    //创建Statement
		    sm=ct.createStatement();
		    
		    //查询出需要显示的记录
//	 	    rs=sm.executeQuery("select top "+pageSize+" * from userinfo where userId not in (select top "+pageSize*(pageNow-1)+" userId from userinfo)");
//		    rs=sm.executeQuery("select * from usc where C_no not in (select C_no from(select C_no from((select * from coursetb where C_no not in(select C_no from sctb where U_no='"+u+"'))as usc) limit "+pageSize*(pageNow-1)+")as temp) limit "+pageSize+"");	    
		    rs=sm.executeQuery("select * from ((select * from coursetb where C_no not in(select C_no from sctb where U_no='"+u+"'))as usc) where C_no not in (select C_no from (select * from ((select * from coursetb where C_no not in(select C_no from sctb where U_no='"+u+"'))as usc) limit "+pageSize*(pageNow-1)+") as temp) limit "+pageSize+"");	    

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
	
	public boolean SelectCByNo(String U_no,String C_no){
		
		boolean b=false;
		
		try {
			//得到连接
			ct=new ConnDB().getConn();
			
			sm=ct.createStatement();
			//执行
			int a=sm.executeUpdate("insert into sctb values('"+U_no+"','"+C_no+"')");
			
			if(a==1){
				//删除成功
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
			//得到连接
			ct=new ConnDB().getConn();
			
			sm=ct.createStatement();
			//执行
			int a=sm.executeUpdate("delete from sctb where U_no='"+U_no+"' and C_no='"+C_no+"'");
			
			if(a==1){
				//删除成功
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
	
	//返回分页的总页数
	public int getSCoursePageCount(String u){
		
		try {
			
			//得到链接
			ct=new ConnDB().getConn();
		    //创建Statement			
			sm=ct.createStatement();
		    //4.查询	   
		    ResultSet rs=sm.executeQuery("select count(*) from coursetb where C_no in(select C_no from sctb where U_no='"+u+"')");
		   
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
	public ArrayList getSCourseByPage(int pageNow,String u){
		

		ArrayList al=new ArrayList();
		try {
			ct=new ConnDB().getConn();
			
		    //创建Statement
		    sm=ct.createStatement();
		    
		    //查询出需要显示的记录
//	 	    rs=sm.executeQuery("select top "+pageSize+" * from userinfo where userId not in (select top "+pageSize*(pageNow-1)+" userId from userinfo)");
		    rs=sm.executeQuery("select * from ((select * from coursetb where C_no in (select C_no from sctb where U_no='"+u+"'))as usc) where C_no not in (select C_no from (select * from ((select * from coursetb where C_no in(select C_no from sctb where U_no='"+u+"'))as usc) limit "+pageSize*(pageNow-1)+") as temp) limit "+pageSize+"");	    
		    
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
	
}
