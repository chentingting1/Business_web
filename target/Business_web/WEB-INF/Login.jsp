<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="login.css"/>
</head>
<body>
<!--   <h1>Hello! JSP! </h1> -->

	
	
<div class="Login">
			<form action="Login.do" method="get">
    			<fieldset style="width: 300px;height: 250px;">
				<!-- <legend>密码登录</legend> -->
			<input class="inp" name="username" type="text" placeholder="用户名"/><br /><br />
			<input class="inp"  type="password" name="password" placeholder="密码"/><br /><br />
			<a href="#"><input class="denglu" style="width: 250px;cursor: pointer;" type="submit" value="登  录" /></a><br /><br />
			<!-- <a class="_regester" href="register.html" target="_blank">立即注册</a> -->
			</fieldset>
		   </form>
</div>


</body>
</html>