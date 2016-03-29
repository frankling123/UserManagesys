//得到数据库的链接
package com.zh.model;

import java.sql.*;
public class ConnDB {
	
	private Connection ct=null;
	private Statement sm=null;
	
	public Connection getConn(){
	
		try {
			
			String user = "root";
		    String passwd = "199110";
		    String url = "jdbc:mysql://localhost:3306/users"; //useUnicode=true&amp;characterEncoding=gbk
		    String driver = "com.mysql.jdbc.Driver";    
		    //1.加载驱动
		    Class.forName(driver);
		    //2.得到连接
		    ct=DriverManager.getConnection(url,user,passwd);
		    
		} catch (Exception e) {
			//一定写上
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return ct;
	}
	

}
