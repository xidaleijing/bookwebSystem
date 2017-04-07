<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <% 
 	String path=request.getContextPath();
 	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="<%=basePath %>/jquery/jquery-1.9.1.js"></script>
<title>登录</title>
</head>
<body>
 <div>
 <form action="login" method="post">
 	<div>
 		<label >用户名：</label>
 		<input type="text" name="userName" value=""/>
 		<label style="color: red" for="userName" >${message}</label>
 	</div>
 	<p>
 	<div>
 		<label>密 &nbsp&nbsp&nbsp码：</label>
 		<input type="password" name="passWord" value=""/>
 		
 	</div>
 	<p>
 	<div>
 		<input type="submit" value="登录" />
 		<input type="button" value="注册" onclick="window.location='<%=basePath %>signin'"/>
 	</div>
 </form>
 </div>
</body>
</html>