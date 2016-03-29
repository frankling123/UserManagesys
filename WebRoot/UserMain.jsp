<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'UserMain.jsp' starting page</title>
    
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
	    <h1><font Color="red" Size=6>用户主界面</font></h1><br><hr>
	    <a href="UserClServlet?pageNow=1&flag=Skechengfenye">用户信息</a><br>
	    <a href="UserClServlet?pageNow=1&flag=kechengfenye">选修课程</a><br>	    
	    <a href="Login.jsp">安全退出</a><br>
	  </center><hr>
  </body>
</html>
