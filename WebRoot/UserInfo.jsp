<%@ page language="java" import="java.util.*,java.sql.*,com.zh.model.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'UserInfo.jsp' starting page</title>
    
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
   <h1>�û���Ϣ�б�</h1>
   
  		 <%  
 
   		
   		//����UserBeanCl�ķ���������һ��ʵ��UserBeanCl��ʵ����Ȼ��������ķ�����
//    		UserBeanCl ubc = new UserBeanCl();
//    		ArrayList al = ubc.getUsersByPage(pageNow);

	    //��request��ȡ��Ҫ��ʾ���û���Ϣ
	    ArrayList al=(ArrayList)request.getAttribute("result");
	    //��ʾ
	    %>
	    <table border="1">
	    <tr><td>�û����</td><td>�û�����</td><td>�û�����</td><td>�û��Ա�</td><td>�û�����</td><td>�û��绰</td></tr>
	    
	    	<%	    
	    	for(int i=0;i<al.size();i++){
	    		//��al��ȡ��UserBean
	    		UserBean ub = (UserBean)al.get(i);	    		
	    	%>
	    		
	    		<tr><td><%=ub.getU_no() %></td><td><%=ub.getU_name() %></td>
	    		<td><%=ub.getU_pwd() %></td><td><%=ub.getU_sex() %></td>
	    		<td><%=ub.getU_age() %></td><td><%=ub.getU_tel() %></td>
	    		</tr>
	    		
	    	<%
	    	}	    	
	    	%>
	    
	   	</table>

	   <h1>��ѡ�γ��б�</h1>
   
  		 <%  
 
   		
   		//����UserBeanCl�ķ���������һ��ʵ��UserBeanCl��ʵ����Ȼ��������ķ�����
//    		UserBeanCl ubc = new CourseBeanCl();
//    		ArrayList al = ubc.getUsersByPage(pageNow);

	    //��request��ȡ��Ҫ��ʾ���û��γ���Ϣ
	    ArrayList all=(ArrayList)request.getAttribute("Sresult");
	    //��ʾ
	    %>
	    <table border="1">
	    <tr><td>�γ̱��</td><td>�γ�����</td><td>�γ̼۸�</td><td>��ʦ���</td><td>����</td></tr>
	    
	    	<%	    
	    	for(int i=0;i<all.size();i++){
	    		//��al��ȡ��UserBean
	    		CourseBean cb = (CourseBean)all.get(i);	    		
	    	%>	    		
	    		<tr><td><%=cb.getC_no() %></td><td><%=cb.getC_name() %></td>
	    		<td><%=cb.getC_price() %></td><td><%=cb.getT_no() %></td>
	    		<td><a href="UserClServlet?flag=delSCourse&C_no=<%=cb.getC_no()%>">ɾ���γ�</a></td>
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
	   	out.println("<a href=UserClServlet?flag=Skechengfenye&pageNow="+(pageNow-1)+">��һҳ</a>");
		}
		
		//�õ�pageCount
		String s_pageCount=(String)request.getAttribute("pageCount");
		int pageCount=Integer.parseInt(s_pageCount);
		
	    //��ʾ������
	    for(int i=1;i<=pageCount;i++){
	    
	    	out.println("<a href=UserClServlet?flag=Skechengfenye&pageNow="+i+">["+i+"]</a>");
	    }
	    
	    //��һҳ
	    if(pageNow!=pageCount){
	    out.println("<a href=UserClServlet?flag=Skechengfenye&pageNow="+(pageNow+1)+">��һҳ</a>");
	    }	   	        
	   %>
	   <br><br>
	   
	    <a href="UserMain.jsp">�����û�������</a>
  </center>
  </body>
</html>

	

