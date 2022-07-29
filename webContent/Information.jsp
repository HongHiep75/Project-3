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
<title>${product.getName()}</title>

</head>
<body class="grid">
	<%@ include file="/hearder.jsp"%>
	<div class="Nav">
	<div class="tenSanPham">
		<h3>${product.getName()}</h3>
	</div>

	<div class="sanPham row">
		<div class="sanPham_anh col l-3 m-3 c-10">
			<img class="anhNoiDung" src="${product.getSrc()}"
				alt="anh dien thoai">
		</div>
		<div class="thongTin_May col l-2 m-3 c-6">
			<h2 style="color: rgb(238, 50, 50);">${product.getPrice()} $</h2>
			<p>${product.getDescription()}</p>
			<br> <a href="${pageContext.request.contextPath}/cart?id=${product.getId()}">Add to cart</a>
		</div>
	</div>
</div>
	<%@ include file="/footer.jsp"%>
</body>
</html>