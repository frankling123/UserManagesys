<%@ page language="java" import="java.util.*,java.sql.*,com.zh.model.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ManaShowCou.jsp' starting page</title>
    
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
   <h1>�γ���Ϣ�б�</h1>
   
  		 <%  
 
   		
   		//����UserBeanCl�ķ���������һ��ʵ��UserBeanCl��ʵ����Ȼ��������ķ�����
//    		UserBeanCl ubc = new CourseBeanCl();
//    		ArrayList al = ubc.getUsersByPage(pageNow);

	    //��request��ȡ��Ҫ��ʾ���û���Ϣ
	    ArrayList al=(ArrayList)request.getAttribute("result");
	    //��ʾ
	    %>
	    <table border="1">
	    <tr><td>�γ̱��</td><td>�γ�����</td><td>�γ̼۸�</td><td>��ʦ���</td>
	    <td>�޸Ŀγ�</td><td>ɾ���γ�</td></tr>
	    
	    	<%	    
	    	for(int i=0;i<al.size();i++){
	    		//��al��ȡ��UserBean
	    		CourseBean cb = (CourseBean)al.get(i);	    		
	    	%>
	    		
	    		<tr><td><%=cb.getC_no() %></td><td><%=cb.getC_name() %></td>
	    		<td><%=cb.getC_price() %></td><td><%=cb.getT_no() %></td>
	    		<td><a href="updateCourse.jsp?C_no=<%=cb.getC_no() %>&C_name=<%=cb.getC_name() %>&C_price=<%=cb.getC_price() %>&T_no=<%=cb.getT_no() %>">�޸Ŀγ�</a></td><td><a href="ManaClServlet?flag=delCourse&C_no=<%=cb.getC_no()%>">ɾ���γ�</a></td>
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
	   	out.println("<a href=ManaClServlet?flag=kechengfenye&pageNow="+(pageNow-1)+">��һҳ</a>");
		}
		
		//�õ�pageCount
		String s_pageCount=(String)request.getAttribute("pageCount");
		int pageCount=Integer.parseInt(s_pageCount);
		
	    //��ʾ������
	    for(int i=1;i<=pageCount;i++){
	    
	    	out.println("<a href=ManaClServlet?flag=kechengfenye&pageNow="+i+">["+i+"]</a>");
	    }
	    
	    //��һҳ
	    if(pageNow!=pageCount){
	    out.println("<a href=ManaClServlet?flag=kechengfenye&pageNow="+(pageNow+1)+">��һҳ</a>");
	    }	   	        
	   %>
	   <br><br>
	    <a href="ManaMain.jsp">����������</a>
	   </center>
  </body>
</html>
