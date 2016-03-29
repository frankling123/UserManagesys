<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addTeacher.jsp' starting page</title>
    
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
	    <h1>请输入老师信息</h1>
		<form action="ManaClServlet?flag=addTeacher" method="post">
		<table border="1">
			<tr><td>老师编号</td><td><input type="text" name="T_no"></td></tr>
			<tr><td>老师密码</td><td><input type="text" name="T_pwd"></td></tr>
			<tr><td>老师姓名</td><td><input type="text" name="T_name"></td></tr>
			<tr><td>老师性别</td><td><input type="text" name="T_sex"></td></tr>
			<tr><td>老师年龄</td><td><input type="text" name="T_age"></td></tr>
			<tr><td>老师电话</td><td><input type="text" name="T_tel"></td></tr>			
			<tr><td><input type="submit" value="添加老师"></td><td><input type="reset" value="重置"></td></tr>
		</table>
		</form>
	    <a href="ManaMain.jsp">返回主界面</a>
	  </center><hr>
  </body>
</html>
