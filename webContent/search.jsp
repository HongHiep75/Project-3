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
<title>${name}</title>

</head>
<body class="grid">
	<%@ include file="/hearder.jsp"%>
	<div class="Nav">
		
		<c:if test="${trangCuoi == 0 }">
			<h1>Không tìm thấy sản phẩm</h1>
		</c:if>

		<%@ include file="/list1.jsp"%>
		<c:if test="${trangCuoi > 1 }">
			<div class="phanTrang">
				<a class="${soTrang==trangCuoi?"
					none":""}" href="search?search=${name}&Trang=${soTrang+1}"><span
					class="material-icons icon  " style="font-size: 12px;">arrow_forward_ios</span></a>

				<c:forEach begin="1" end="${trangCuoi}" var="i">
					<a class="${soTrang==i?"
						ativeva":""}" href="search?search=${name}&Trang=${i}">${i}</a>

				</c:forEach>
				<a class="${(soTrang==1)?"
					none":""}" href="search?search=${name}&Trang=${soTrang-1}"><span
					class="material-icons icon  " style="font-size: 12px;">arrow_back_ios</span></a>
			</div>
		</c:if>
	</div>
	<%@ include file="/footer.jsp"%>
</body>
</html>