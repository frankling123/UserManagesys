<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'updateTeacher.jsp' starting page</title>
    
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
	    <h1>��������ʦ��Ϣ</h1>
		<form action="ManaClServlet?flag=updateTeacher" method="post">
		<table border="1">
			<tr><td>��ʦ���</td><td><input type="text" name="T_no" value=<%=request.getParameter("T_no") %>></td></tr>		
			<tr><td>��ʦ����</td><td><input type="text" name="T_name" value=<%=request.getParameter("T_name") %>></td></tr>
			<tr><td>��ʦ����</td><td><input type="text" name="T_pwd" value=<%=request.getParameter("T_pwd") %>></td></tr>
			<tr><td>��ʦ�Ա�</td><td><input type="text" name="T_sex" value=<%=request.getParameter("T_sex") %>></td></tr>
			<tr><td>��ʦ����</td><td><input type="text" name="T_age" value=<%=request.getParameter("T_age") %>></td></tr>
			<tr><td>��ʦ�绰</td><td><input type="text" name="T_tel" value=<%=request.getParameter("T_tel") %>></td></tr>			
			<tr><td><input type="submit" value="������ʦ��Ϣ"></td><td><input type="reset" value="����"></td></tr>
		</table>
		</form>
	    <a href="ManaMain.jsp">����������</a>
	  </center><hr>
  </body>
</html>