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

  	//��ֹ�û��Ƿ���¼	
  	String u=(String)session.getAttribute("myNo");
  	
  	//����û�û�е�¼
  	if(u==null){
  	
  		//���ص�¼����
  		response.sendRedirect("Login.jsp?err=1");
  		return;
  	}
   %>
	    <h1><font Color="red" Size=6>�û�������</font></h1><br><hr>
	    <a href="UserClServlet?pageNow=1&flag=Skechengfenye">�û���Ϣ</a><br>
	    <a href="UserClServlet?pageNow=1&flag=kechengfenye">ѡ�޿γ�</a><br>	    
	    <a href="Login.jsp">��ȫ�˳�</a><br>
	  </center><hr>
  </body>
</html>
