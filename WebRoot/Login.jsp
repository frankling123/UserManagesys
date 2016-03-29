<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Login.jsp' starting page</title>
    
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
<h1><font Color="red" Size=6>健身房选课管理系统</font></h1><hr>
          登录界面<br>
   <hr>
   <form name="form1" action="LoginClServlet" method="post">
   	编号<input type="text" name="username"><br>
   	密码<input type="password" name="passwd"><br>
   	<input type="radio" name="who" value = "user" checked>用户
	<input type="radio" name="who" value = "teacher">老师
	<input type="radio" name="who" value = "manager">管理员<br>
    <input type="submit" value="登录">
   	&nbsp;<input type="reset" value="重置">
   </form>
   </center>
  </body>
</html>
