<%@ page language="java" import="java.util.*,java.sql.*,com.zh.model.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'TeacherMC.jsp' starting page</title>
    
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
   %>
	<h1></h1>
	   <h1>ѡ������б�</h1>
   
  		 <%  
 
   		
   		//����UserBeanCl�ķ���������һ��ʵ��UserBeanCl��ʵ����Ȼ��������ķ�����
//    		UserBeanCl ubc = new CourseBeanCl();
//    		ArrayList al = ubc.getUsersByPage(pageNow);

	    //��request��ȡ��Ҫ��ʾ���û��γ���Ϣ
	    ArrayList al=(ArrayList)request.getAttribute("result");
	   String C_no=(String)request.getAttribute("C_no");
	    //��ʾ
	    %>
	    <table border="1">
		<tr><td>�û����</td><td>�û�����</td><td>�û��Ա�</td><td>�û�����</td><td>�û��绰</td></tr>
	    
	    	<%	    
	    	for(int i=0;i<al.size();i++){
	    		//��al��ȡ��UserBean
	    		UserBean ub = (UserBean)al.get(i);	    		
	    	%>
	    		
	    		<tr><td><%=ub.getU_no() %></td><td><%=ub.getU_name() %></td><td><%=ub.getU_sex() %></td><td><%=ub.getU_age() %></td><td><%=ub.getU_tel() %></td>
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
	   	out.println("<a href=TeacherClServlet?C_no="+C_no+"&flag=xuankeqk&pageNow="+(pageNow-1)+">��һҳ</a>");
		}
		
		//�õ�pageCount
		String s_pageCount=(String)request.getAttribute("pageCount");
		int pageCount=Integer.parseInt(s_pageCount);
		
	    //��ʾ������
	    for(int i=1;i<=pageCount;i++){
	    
	    	out.println("<a href=TeacherClServlet?C_no="+C_no+"&flag=xuankeqk&pageNow="+i+">["+i+"]</a>");
	    }
	    
	    //��һҳ
	    if(pageNow!=pageCount){
	    out.println("<a href=TeacherClServlet?C_no="+C_no+"&flag=xuankeqk&pageNow="+(pageNow+1)+">��һҳ</a>");
	    }	   	        
	   %>
	   <br><br>
	   
	    <a href="TeacherMain.jsp">������ʦ������</a>
  </center>
  </body>
</html>
