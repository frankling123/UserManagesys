<%@ page language="java" import="java.util.*,java.sql.*,com.zh.model.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'UserMC.jsp' starting page</title>
    
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
   <h1>未选课程列表</h1>
   
  		 <%  
 
   		
   		//调用UserBeanCl的方法（创建一个实例UserBeanCl的实例，然后调用他的方法）
//    		UserBeanCl ubc = new CourseBeanCl();
//    		ArrayList al = ubc.getUsersByPage(pageNow);

	    //从request中取出要显示的用户课程信息
	    ArrayList al=(ArrayList)request.getAttribute("result");
	    //显示
	    %>
	    <table border="1">
	    <tr><td>课程编号</td><td>课程名字</td><td>课程价格</td><td>老师编号</td><td>操作</td></tr>
	    
	    	<%	    
	    	for(int i=0;i<al.size();i++){
	    		//从al中取出UserBean
	    		CourseBean cb = (CourseBean)al.get(i);	    		
	    	%>	    		
	    		<tr><td><%=cb.getC_no() %></td><td><%=cb.getC_name() %></td>
	    		<td><%=cb.getC_price() %></td><td><%=cb.getT_no() %></td>
	    		<td><a href="UserClServlet?flag=SelectC&C_no=<%=cb.getC_no()%>">选修课程</a></td>
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
	   	out.println("<a href=UserClServlet?flag=kechengfenye&pageNow="+(pageNow-1)+">上一页</a>");
		}
		
		//得到pageCount
		String s_pageCount=(String)request.getAttribute("pageCount");
		int pageCount=Integer.parseInt(s_pageCount);
		
	    //显示超链接
	    for(int i=1;i<=pageCount;i++){
	    
	    	out.println("<a href=UserClServlet?flag=kechengfenye&pageNow="+i+">["+i+"]</a>");
	    }
	    
	    //下一页
	    if(pageNow!=pageCount){
	    out.println("<a href=UserClServlet?flag=kechengfenye&pageNow="+(pageNow+1)+">下一页</a>");
	    }	   	        
	   %>
	   <br><br>
	    <a href="UserMain.jsp">返回用户主界面</a>
	    	    
	    	    
	   </center>
  </body>
</html>
