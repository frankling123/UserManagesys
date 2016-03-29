<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ManaMain.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
	  <center>
	<%

  	//防止用户非法登录	
  	String u=(String)session.getAttribute("myNo");
  	
  	//如果用户没有登录
  	if(u==null){
  	
  		//返回登录界面
  		response.sendRedirect("Login.jsp?err=1");
  		return;
  	}
   %>
	    <h1><font Color="red" Size=6>管理员主界面</font></h1><br><hr>
	    <a href="ManaClServlet?pageNow=1&flag=yonghufenye">管理用户</a><br>
	    <a href="addUser.jsp">添加用户</a><br><hr>
	    
	    <a href="ManaClServlet?pageNow=1&flag=laoshifenye">管理老师</a><br>
	    <a href="addTeacher.jsp">添加老师</a><br><hr>
 	    
	    <a href="ManaClServlet?pageNow=1&flag=kechengfenye">管理课程</a><br>
	    <a href="addCourse.jsp">添加课程</a><br><hr>
	    
	    <a href="Login.jsp">安全退出</a><br>
	  </center><hr>
  </body>
</html>
