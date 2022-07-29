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
<title>home</title>

</head>
<body class="grid">
	<%@ include file="/hearder.jsp"%>
   <div class="Nav">
	<%@ include file="list1.jsp"%>
	<%@ include file="phanTrang.jsp"%>
    </div>
	<%@ include file="/footer.jsp"%>
</body>
</html>