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
<title>注册</title>
<script type="text/javascript" src="<%=basePath %>/jquery/jquery-1.9.1.js"></script>
</head>
<body>
<form action="signin" method="post">
 	<div>
 		<label>用户名：</label>
 		<input type="text" name="userName" value=""/>
 		<label name="errorMessage" style="color: red" for="userName">${message}</label>
 	</div>
 	<p/>
 	<div>
 		<label>密&nbsp&nbsp&nbsp码：</label>
 		<input type="password" name="passWord" value=""/>
 	</div>
 	<p/>
 	<div>
 		<label>真实姓名：</label>
 		<input type="text" name="realName" value=""/>
 	</div>
 	<p/>
 	
 	<div>
 		<label>年&nbsp&nbsp&nbsp龄：</label>
 		<input type="text" name="age" value=""/>
 	</div>
 	<p/>
 	<div>
 		<label>性&nbsp&nbsp&nbsp别：</label>
 		<input type="text" name="sex" value=""/>
 	</div>
 	<p/>
 		<div>
 		<label>电&nbsp&nbsp&nbsp话：</label>
 		<input type="text" name="telephone" value=""/>
 	</div>
 	<p/>
 	<div>
 		<label>邮箱：</label>
 		<input type="text" name="email" value=""/>
 	</div>
 	<p/>
 	<div>
 		<input type="submit" value="提交" />
 		<input type="button" value="登录" onclick="window.location='<%=basePath %>login'"/>
 	</div>
 </form>
</body>
</html>