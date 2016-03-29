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
   <h1>用户信息列表</h1>
   
  		 <%  
 
   		
   		//调用UserBeanCl的方法（创建一个实例UserBeanCl的实例，然后调用他的方法）
//    		UserBeanCl ubc = new UserBeanCl();
//    		ArrayList al = ubc.getUsersByPage(pageNow);

	    //从request中取出要显示的用户信息
	    ArrayList al=(ArrayList)request.getAttribute("result");
	    //显示
	    %>
	    <table border="1">
	    <tr><td>用户编号</td><td>用户名字</td><td>用户密码</td><td>用户性别</td><td>用户年龄</td><td>用户电话</td>
	    <td>修改用户</td><td>删除用户</td></tr>
	    
	    	<%	    
	    	for(int i=0;i<al.size();i++){
	    		//从al中取出UserBean
	    		UserBean ub = (UserBean)al.get(i);	    		
	    	%>
	    		
	    		<tr><td><%=ub.getU_no() %></td><td><%=ub.getU_name() %></td>
	    		<td><%=ub.getU_pwd() %></td><td><%=ub.getU_sex() %></td>
	    		<td><%=ub.getU_age() %></td><td><%=ub.getU_tel() %></td>
	    		<td><a href="updateUser.jsp?U_no=<%=ub.getU_no() %>&U_name=<%=ub.getU_name() %>&U_pwd=<%=ub.getU_pwd() %>&U_sex=<%=ub.getU_sex() %>&U_age=<%=ub.getU_age() %>&U_tel=<%=ub.getU_tel() %>">修改用户</a></td><td><a href="ManaClServlet?flag=delUser&U_no=<%=ub.getU_no()%>">删除用户</a></td>
	    		</tr>
	    		
	    	<%
	    	}	    	
	    	%>
	    
	   	</table>
	   	 	   	
	   	<% 
	   	//从request中取出pageNow
	   	int pageNow=Integer.parseInt((String)request.getAttribute("pageNow"));  	
	   	//上一页
	   	if(pageNow!=1){	   	
	   	out.println("<a href=ManaClServlet?flag=yonghufenye&pageNow="+(pageNow-1)+">上一页</a>");
		}
		
		//得到pageCount
		String s_pageCount=(String)request.getAttribute("pageCount");
		int pageCount=Integer.parseInt(s_pageCount);
		
	    //显示超链接
	    for(int i=1;i<=pageCount;i++){
	    
	    	out.println("<a href=ManaClServlet?flag=yonghufenye&pageNow="+i+">["+i+"]</a>");
	    }
	    
	    //下一页
	    if(pageNow!=pageCount){
	    out.println("<a href=ManaClServlet?flag=yonghufenye&pageNow="+(pageNow+1)+">下一页</a>");
	    }	   	        
	   %>
	   <br><br>
	    <a href="ManaMain.jsp">返回主界面</a>
	   </center>
  </body>
</html>
