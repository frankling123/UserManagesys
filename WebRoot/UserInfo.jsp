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
    //防止用户非法登录	
  	String u=(String)session.getAttribute("myNo");
   %>


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
	    <tr><td>用户编号</td><td>用户名字</td><td>用户密码</td><td>用户性别</td><td>用户年龄</td><td>用户电话</td></tr>
	    
	    	<%	    
	    	for(int i=0;i<al.size();i++){
	    		//从al中取出UserBean
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

	   <h1>已选课程列表</h1>
   
  		 <%  
 
   		
   		//调用UserBeanCl的方法（创建一个实例UserBeanCl的实例，然后调用他的方法）
//    		UserBeanCl ubc = new CourseBeanCl();
//    		ArrayList al = ubc.getUsersByPage(pageNow);

	    //从request中取出要显示的用户课程信息
	    ArrayList all=(ArrayList)request.getAttribute("Sresult");
	    //显示
	    %>
	    <table border="1">
	    <tr><td>课程编号</td><td>课程名字</td><td>课程价格</td><td>老师编号</td><td>操作</td></tr>
	    
	    	<%	    
	    	for(int i=0;i<all.size();i++){
	    		//从al中取出UserBean
	    		CourseBean cb = (CourseBean)all.get(i);	    		
	    	%>	    		
	    		<tr><td><%=cb.getC_no() %></td><td><%=cb.getC_name() %></td>
	    		<td><%=cb.getC_price() %></td><td><%=cb.getT_no() %></td>
	    		<td><a href="UserClServlet?flag=delSCourse&C_no=<%=cb.getC_no()%>">删除课程</a></td>
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
	   	out.println("<a href=UserClServlet?flag=Skechengfenye&pageNow="+(pageNow-1)+">上一页</a>");
		}
		
		//得到pageCount
		String s_pageCount=(String)request.getAttribute("pageCount");
		int pageCount=Integer.parseInt(s_pageCount);
		
	    //显示超链接
	    for(int i=1;i<=pageCount;i++){
	    
	    	out.println("<a href=UserClServlet?flag=Skechengfenye&pageNow="+i+">["+i+"]</a>");
	    }
	    
	    //下一页
	    if(pageNow!=pageCount){
	    out.println("<a href=UserClServlet?flag=Skechengfenye&pageNow="+(pageNow+1)+">下一页</a>");
	    }	   	        
	   %>
	   <br><br>
	   
	    <a href="UserMain.jsp">返回用户主界面</a>
  </center>
  </body>
</html>

	

