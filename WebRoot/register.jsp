<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
    <form name="frm1" action="${pageContext.request.contextPath}/admin?method=register"  method="post">
    	<table>
    		<tr>
	    		<td>用户名</td>
	  			<td>
	  				<input type="text" name="userName"/>
	  				${requestScope.message } <!-- 如果用户名存在注册失败，给用户提示 -->
	  			</td>
    		</tr>
    	
    		<tr>
	    		<td>密码</td>
  				<td><input type="password" name="pwd"/></td>
    		</tr>
    		
    		<tr>
  				<td colspan="2">
  					<input type="submit" value="亲，点我注册！">
  				</td>
  			</tr>
    	
    	</table>
    
    </form>
  </body>
</html>
