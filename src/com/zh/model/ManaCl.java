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
	private int rowCount=0;//通过查询数据库
	private int pageCount=0;//通过pageSize和rowCount	
	
	
	public boolean checkMana(String u,String p){
		
		boolean b=false;
		
		//
		try {
			
		    //到数据库中验证管理员
		    ct=new ConnDB().getConn();
		    
		    //3.创建Statement
		    sm=ct.createStatement();
		    //4.查询
		    rs=sm.executeQuery("select M_pwd from Manatb where M_no='"+u+"'");
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
	
	/**
	 * 对Usertb表的操作
	 */
    //添加用户
	public boolean addUser(String no,String name,String pwd,String sex,String age,String tel){
		
		boolean b=false;
		
		try {
			//得到连接
			ct=new ConnDB().getConn();
			
			sm=ct.createStatement();
			//执行
			int a=sm.executeUpdate("insert into usertb values('"+no+"','"+name+"','"+pwd+"','"+sex+"','"+age+"','"+tel+"')");
			
			if(a==1){
				//添加成功
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
	
	//删除用户
	public boolean delUserByNo(String no){
		
		boolean b=false;
		
		try {
			//得到连接
			ct=new ConnDB().getConn();
			
			sm=ct.createStatement();
			//执行
			int a=sm.executeUpdate("delete from usertb where U_no='"+no+"'");
			
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
	
	//修改用户
	public boolean updateUser(String no,String name,String pwd,String sex,String age,String tel){
	
		boolean b=false;
		
		try {
			//得到连接
			ct=new ConnDB().getConn();
			
			sm=ct.createStatement();
			
			//执行		
			int a=sm.executeUpdate("update usertb set U_no='"+no+"',U_name='"+name+"',U_pwd='"+pwd+"',U_sex='"+sex+"',U_age='"+age+"',U_tel='"+tel+"' where U_no='"+no+"'");
		
			if(a==1){
				//添加成功
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
	public int getUserPageCount(){
		
		try {
			
			//得到链接
			ct=new ConnDB().getConn();
		    //创建Statement			
			sm=ct.createStatement();
		    //4.查询	   
		    ResultSet rs=sm.executeQuery("select count(*) from usertb");
		   
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
	public ArrayList getUserByPage(int pageNow){
		

		ArrayList al=new ArrayList();
		try {
			ct=new ConnDB().getConn();
			
		    //创建Statement
		    sm=ct.createStatement();
		    
		    //查询出需要显示的记录
//	 	    rs=sm.executeQuery("select top "+pageSize+" * from userinfo where userId not in (select top "+pageSize*(pageNow-1)+" userId from userinfo)");
		    rs=sm.executeQuery("select * from usertb where U_no not in (select U_no from (select * from usertb limit "+pageSize*(pageNow-1)+") as temp) limit "+pageSize+"");	    
		    
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
	
	
	/**
	 * 对Teachertb表的操作
	 */
    //添加老师
	public boolean addTeacher(String no,String name,String pwd,String sex,String age,String tel){
		
		boolean b=false;
		
		try {
			//得到连接
			ct=new ConnDB().getConn();
			
			sm=ct.createStatement();
			//执行
			int a=sm.executeUpdate("insert into teachertb values('"+no+"','"+name+"','"+pwd+"','"+sex+"','"+age+"','"+tel+"')");
			
			if(a==1){
				//添加成功
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
	
	//删除老师
	public boolean delTeacherByNo(String no){
		
		boolean b=false;
		
		try {
			//得到连接
			ct=new ConnDB().getConn();
			
			sm=ct.createStatement();
			//执行
			int a=sm.executeUpdate("delete from teachertb where Tea_no='"+no+"'");
			
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
	
	//修改老师
	public boolean updateTeacher(String no,String name,String pwd,String sex,String age,String tel){
	
		boolean b=false;
		
		try {
			//得到连接
			ct=new ConnDB().getConn();
			
			sm=ct.createStatement();
			
			//执行		
			int a=sm.executeUpdate("update teachertb set Tea_no='"+no+"',Tea_name='"+name+"',Tea_pwd='"+pwd+"',Tea_sex='"+sex+"',Tea_age='"+age+"',Tea_tel='"+tel+"' where Tea_no='"+no+"'");
		
			if(a==1){
				//添加成功
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
	
	
	//返回老师分页的总页数
	public int getTeacherPageCount(){
		
		try {
			
			//得到链接
			ct=new ConnDB().getConn();
		    //创建Statement			
			sm=ct.createStatement();
		    //4.查询	   
		    ResultSet rs=sm.executeQuery("select count(*) from teachertb");
		   
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
	
	//得到老师需要显示的老师信息（分页）	
	public ArrayList getTeacherByPage(int pageNow){
		

		ArrayList al=new ArrayList();
		try {
			ct=new ConnDB().getConn();
			
		    //创建Statement
		    sm=ct.createStatement();
		    
		    //查询出需要显示的记录
//	 	    rs=sm.executeQuery("select top "+pageSize+" * from userinfo where userId not in (select top "+pageSize*(pageNow-1)+" userId from userinfo)");
		    rs=sm.executeQuery("select * from teachertb where Tea_no not in (select Tea_no from (select * from teachertb limit "+pageSize*(pageNow-1)+") as temp) limit "+pageSize+"");	    
		    
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
	
	
	/**
	 * 对Coursetb表的操作
	 */
    //添加用户
	public boolean addCourse(String no,String name,String price,String T_no){
		
		boolean b=false;
		
		try {
			//得到连接
			ct=new ConnDB().getConn();
			
			sm=ct.createStatement();
			//执行
			int a=sm.executeUpdate("insert into coursetb values('"+no+"','"+name+"','"+price+"','"+T_no+"')");
			
			if(a==1){
				//添加成功
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
	
	//删除用户
	public boolean delCourseByNo(String no){
		
		boolean b=false;
		
		try {
			//得到连接
			ct=new ConnDB().getConn();
			
			sm=ct.createStatement();
			//执行
			int a=sm.executeUpdate("delete from coursetb where C_no='"+no+"'");
			
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
	
	//修改用户
	public boolean updateCourse(String no,String name,String price,String T_no){
	
		boolean b=false;
		
		try {
			//得到连接
			ct=new ConnDB().getConn();
			
			sm=ct.createStatement();
			
			//执行		
			int a=sm.executeUpdate("update coursetb set C_no='"+no+"',C_name='"+name+"',C_price='"+price+"',Tea_no='"+T_no+"' where C_no='"+no+"'");
		
			if(a==1){
				//添加成功
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
	public int getCoursePageCount(){
		
		try {
			
			//得到链接
			ct=new ConnDB().getConn();
		    //创建Statement			
			sm=ct.createStatement();
		    //4.查询	   
		    ResultSet rs=sm.executeQuery("select count(*) from coursetb");
		   
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
	public ArrayList getCourseByPage(int pageNow){
		

		ArrayList al=new ArrayList();
		try {
			ct=new ConnDB().getConn();
			
		    //创建Statement
		    sm=ct.createStatement();
		    
		    //查询出需要显示的记录
//	 	    rs=sm.executeQuery("select top "+pageSize+" * from userinfo where userId not in (select top "+pageSize*(pageNow-1)+" userId from userinfo)");
		    rs=sm.executeQuery("select * from coursetb where C_no not in (select C_no from (select * from coursetb limit "+pageSize*(pageNow-1)+") as temp) limit "+pageSize+"");	    
		    
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
}


