<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addCourse.jsp' starting page</title>
    
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
	    <h1>������γ���Ϣ</h1>
		<form action="ManaClServlet?flag=addCourse" method="post">
		<table border="1">
			<tr><td>�γ̱��</td><td><input type="text" name="C_no"></td></tr>
			<tr><td>�γ�����</td><td><input type="text" name="C_name"></td></tr>
			<tr><td>�γ̼۸�</td><td><input type="text" name="C_price"></td></tr>
			<tr><td>��ʦ���</td><td><input type="text" name="T_no"></td></tr>		
			<tr><td><input type="submit" value="��ӿγ�"></td><td><input type="reset" value="����"></td></tr>
		</table>
		</form>
	    <a href="ManaMain.jsp">����������</a>
	  </center><hr>
  </body>
</html>
