<%@ page language="java" import="java.util.*,java.sql.*,com.zh.model.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%-- <%@ page contentType="text/html;charset=gbk"%> --%>
<%-- <%request.setCharacterEncoding("gbk");%> --%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ManaShowUse.jsp' starting page</title>
    
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
	    <tr><td>�û����</td><td>�û�����</td><td>�û�����</td><td>�û��Ա�</td><td>�û�����</td><td>�û��绰</td>
	    <td>�޸��û�</td><td>ɾ���û�</td></tr>
	    
	    	<%	    
	    	for(int i=0;i<al.size();i++){
	    		//��al��ȡ��UserBean
	    		UserBean ub = (UserBean)al.get(i);	    		
	    	%>
	    		
	    		<tr><td><%=ub.getU_no() %></td><td><%=ub.getU_name() %></td>
	    		<td><%=ub.getU_pwd() %></td><td><%=ub.getU_sex() %></td>
	    		<td><%=ub.getU_age() %></td><td><%=ub.getU_tel() %></td>
	    		<td><a href="updateUser.jsp?U_no=<%=ub.getU_no() %>&U_name=<%=ub.getU_name() %>&U_pwd=<%=ub.getU_pwd() %>&U_sex=<%=ub.getU_sex() %>&U_age=<%=ub.getU_age() %>&U_tel=<%=ub.getU_tel() %>">�޸��û�</a></td><td><a href="ManaClServlet?flag=delUser&U_no=<%=ub.getU_no()%>">ɾ���û�</a></td>
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
	   	out.println("<a href=ManaClServlet?flag=yonghufenye&pageNow="+(pageNow-1)+">��һҳ</a>");
		}
		
		//�õ�pageCount
		String s_pageCount=(String)request.getAttribute("pageCount");
		int pageCount=Integer.parseInt(s_pageCount);
		
	    //��ʾ������
	    for(int i=1;i<=pageCount;i++){
	    
	    	out.println("<a href=ManaClServlet?flag=yonghufenye&pageNow="+i+">["+i+"]</a>");
	    }
	    
	    //��һҳ
	    if(pageNow!=pageCount){
	    out.println("<a href=ManaClServlet?flag=yonghufenye&pageNow="+(pageNow+1)+">��һҳ</a>");
	    }	   	        
	   %>
	   <br><br>
	    <a href="ManaMain.jsp">����������</a>
	   </center>
  </body>
</html>
