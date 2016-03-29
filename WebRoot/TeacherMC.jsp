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
    //防止用户非法登录	
  	String u=(String)session.getAttribute("myNo");
   %>
	<h1></h1>
	   <h1>选课情况列表</h1>
   
  		 <%  
 
   		
   		//调用UserBeanCl的方法（创建一个实例UserBeanCl的实例，然后调用他的方法）
//    		UserBeanCl ubc = new CourseBeanCl();
//    		ArrayList al = ubc.getUsersByPage(pageNow);

	    //从request中取出要显示的用户课程信息
	    ArrayList al=(ArrayList)request.getAttribute("result");
	   String C_no=(String)request.getAttribute("C_no");
	    //显示
	    %>
	    <table border="1">
		<tr><td>用户编号</td><td>用户名字</td><td>用户性别</td><td>用户年龄</td><td>用户电话</td></tr>
	    
	    	<%	    
	    	for(int i=0;i<al.size();i++){
	    		//从al中取出UserBean
	    		UserBean ub = (UserBean)al.get(i);	    		
	    	%>
	    		
	    		<tr><td><%=ub.getU_no() %></td><td><%=ub.getU_name() %></td><td><%=ub.getU_sex() %></td><td><%=ub.getU_age() %></td><td><%=ub.getU_tel() %></td>
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
	   	out.println("<a href=TeacherClServlet?C_no="+C_no+"&flag=xuankeqk&pageNow="+(pageNow-1)+">上一页</a>");
		}
		
		//得到pageCount
		String s_pageCount=(String)request.getAttribute("pageCount");
		int pageCount=Integer.parseInt(s_pageCount);
		
	    //显示超链接
	    for(int i=1;i<=pageCount;i++){
	    
	    	out.println("<a href=TeacherClServlet?C_no="+C_no+"&flag=xuankeqk&pageNow="+i+">["+i+"]</a>");
	    }
	    
	    //下一页
	    if(pageNow!=pageCount){
	    out.println("<a href=TeacherClServlet?C_no="+C_no+"&flag=xuankeqk&pageNow="+(pageNow+1)+">下一页</a>");
	    }	   	        
	   %>
	   <br><br>
	   
	    <a href="TeacherMain.jsp">返回老师主界面</a>
  </center>
  </body>
</html>
