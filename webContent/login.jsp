<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/grid.css">
<link rel="stylesheet" href="css/main.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<title>Login</title>
</head>
<body>
	<div style="margin-left: 40%">
		<h3 style="color: red">${err}</h3>
	</div>
	<div class="login">
		<span id="icon_Close_Login" class="material-icons icon  "
			style="font-size: 20px;"></span>
		<div class="avata">
			<img
				src="data:image/png;base64,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"
				alt="">
		</div>
		<%--from dang nhap --%>
		<form class="form_Login" action="login" method="post">
			<label for="input_Name">Email</label><br> <input type="text"
				class="input_login" id="input_Name" name="username"
				placeholder="Email" value="${requestScope.gmail}"><br>
			<label for="input_Pass">Password</label><br> <input
				type="password" class="input_login" name="password" id="input_Pass"
				placeholder="Mật khẩu" value="${requestScope.pass}"><br>
			<h7 style="color: red">${requestScope.mess}</h7>
			<br> <input type="submit" class="input_login" id="input_Submit"
				value="Login"><br> <label for="user_Remembere">Remembere
				me</label> <input type="checkbox" id="user_Remembere" name="remembere"
				value="1"><br>
		</form>
		<div>
			<div class="login_Footer">
				<p>
					<span><a href="register.jsp">Register</a></span>
				</p>
				<p>
					Forgot <a href="#">password?</a>
				</p>
			</div>
		</div>
	</div>
</body>
</html>