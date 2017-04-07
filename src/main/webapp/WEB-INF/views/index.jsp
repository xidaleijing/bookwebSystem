<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <% 
 	String path=request.getContextPath();
 	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=basePath %>/jquery/jquery-1.9.1.js"></script>
<script type="text/javascript">
function  test(){
	alert("刘超辉，猪宝宝，下午好~");
}
</script>
<title>Insert title here</title>
</head>
<body>
	<p>静静的网站fdhfdifwie</p>
	<p>初始访问地址:<%=basePath+"index" %></p>
	<input type="text" value="刘超辉"/>
	<input type="button" value="我是淘气按钮，点我有惊喜" onclick="test();">
	${message} 
</body>
</html>