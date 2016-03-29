<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'updateUser.jsp' starting page</title>
    
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
	    <h1>请输入用户信息</h1>
		<form action="ManaClServlet?flag=updateUser" method="post">
		<table border="1">
			<tr><td>用户编号</td><td><input type="text" name="U_no" value=<%=request.getParameter("U_no") %>></td></tr>		
			<tr><td>用户姓名</td><td><input type="text" name="U_name" value=<%=request.getParameter("U_name") %>></td></tr>
			<tr><td>用户密码</td><td><input type="text" name="U_pwd" value=<%=request.getParameter("U_pwd") %>></td></tr>
			<tr><td>用户性别</td><td><input type="text" name="U_sex" value=<%=request.getParameter("U_sex") %>></td></tr>
			<tr><td>用户年龄</td><td><input type="text" name="U_age" value=<%=request.getParameter("U_age") %>></td></tr>
			<tr><td>用户电话</td><td><input type="text" name="U_tel" value=<%=request.getParameter("U_tel") %>></td></tr>			
			<tr><td><input type="submit" value="更改用户信息"></td><td><input type="reset" value="重置"></td></tr>
		</table>
		</form>
	    <a href="ManaMain.jsp">返回主界面</a>
	  </center><hr>
  </body>
</html>
