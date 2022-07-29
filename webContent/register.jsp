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
<title>Register</title>
</head>
<body>
	<div class="register">
		<form action="register" method="post">
			<h2>Register</h2>
			
			<input type="text" class="input_Register" id="input_Name"
				name="username" placeholder=" Họ và tên"><br> <input
				type="text" class="input_Register" id="input_Name" name="userGmail"
				placeholder=" Email"><br> <input type="password"
				class="input_Register" name="password" id="input_Pass"
				placeholder=" Mật khẩu"><br> <input type="password"
				class="input_Register" id="re_pass" name="Repass"
				placeholder=" Nhập lại mật khẩu"><br>
			<h7 style="color: red">${requestScope.mess}</h7><br>
			<input class="input_Register Register_submit" type="submit"
				value="Register">

		</form>
		<p></p>
		<a href="${pageContext.request.contextPath}/login">Login</a>
	</div>


</body>
</html>