<%@page import="com.zh.model.TeacherBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ManaShowTea.jsp' starting page</title>
    
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

   <h1></h1>
   <h1>��ʦ��Ϣ�б�</h1>
   
  		 <%  
 
   		
   		//����UserBeanCl�ķ���������һ��ʵ��UserBeanCl��ʵ����Ȼ��������ķ�����
//    		UserBeanCl ubc = new UserBeanCl();
//    		ArrayList al = ubc.getUsersByPage(pageNow);

	    //��request��ȡ��Ҫ��ʾ���û���Ϣ
	    ArrayList al=(ArrayList)request.getAttribute("result");
	    //��ʾ
	    %>
	    <table border="1">
	    <tr><td>��ʦ���</td><td>��ʦ����</td><td>��ʦ����</td><td>��ʦ�Ա�</td><td>��ʦ����</td><td>��ʦ�绰</td>
	    <td>�޸���ʦ</td><td>ɾ����ʦ</td></tr>
	    
	    	<%	    
	    	for(int i=0;i<al.size();i++){
	    		//��al��ȡ��UserBean
	    		TeacherBean tb = (TeacherBean)al.get(i);	  	    		  		
	    	%>
	    		
	    		<tr><td><%=tb.getT_no() %></td><td><%=tb.getT_name() %></td>
	    		<td><%=tb.getT_pwd() %></td><td><%=tb.getT_sex() %></td>
	    		<td><%=tb.getT_age() %></td><td><%=tb.getT_tel() %></td>
	    		<td><a href="updateTeacher.jsp?T_no=<%=tb.getT_no() %>&T_name=<%=tb.getT_name() %>&T_pwd=<%=tb.getT_pwd() %>&T_sex=<%=tb.getT_sex() %>&T_age=<%=tb.getT_age() %>&T_tel=<%=tb.getT_tel() %>">�޸���ʦ</a></td><td><a href="ManaClServlet?flag=delTeacher&T_no=<%=tb.getT_no()%>">ɾ����ʦ</a></td>
	    		</tr>
	    		
	    	<%	    	
	    	}	    	
	    	%>
	    
	   	</table>
	   	 	   	
	   	<% 
	   	//��request��ȡ��pageNow
	   	int pageNow=Integer.parseInt((String)request.getAttribute("pageNow"));  	
	   	//��һҳ
	   	if(pageNow!=1){	   	
	   	out.println("<a href=ManaClServlet?flag=laoshifenye&pageNow="+(pageNow-1)+">��һҳ</a>");
		}
		
		//�õ�pageCount
		String s_pageCount=(String)request.getAttribute("pageCount");
		int pageCount=Integer.parseInt(s_pageCount);
		
	    //��ʾ������
	    for(int i=1;i<=pageCount;i++){
	    
	    	out.println("<a href=ManaClServlet?flag=laoshifenye&pageNow="+i+">["+i+"]</a>");
	    }
	    
	    //��һҳ
	    if(pageNow!=pageCount){
	    out.println("<a href=ManaClServlet?flag=laoshifenye&pageNow="+(pageNow+1)+">��һҳ</a>");
	    }	   	        
	   %>
	   <br><br>
	    <a href="ManaMain.jsp">����������</a>
	   </center>
  </body>
</html>
