<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'updateCourse.jsp' starting page</title>
    
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
	    <h1>请输入课程信息</h1>
		<form action="ManaClServlet?flag=updateCourse" method="post">
		<table border="1">		
			<tr><td>课程编号</td><td><input type="text" name="C_no" value=<%=request.getParameter("C_no") %>></td></tr>
			<tr><td>课程名称</td><td><input type="text" name="C_name" value=<%=request.getParameter("C_name") %>></td></tr>
			<tr><td>课程价格</td><td><input type="text" name="C_price" value=<%=request.getParameter("C_price") %>></td></tr>
			<tr><td>老师编号</td><td><input type="text" name="T_no" value=<%=request.getParameter("T_no") %>></td></tr>							
			<tr><td><input type="submit" value="更改课程信息"></td><td><input type="reset" value="重置"></td></tr>
		</table>
		</form>
	    <a href="ManaMain.jsp">返回主界面</a>
	  </center><hr>
  </body>
</html>
