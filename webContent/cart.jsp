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
<title>Cart</title>

</head>
<body class="grid">
	<%@ include file="/hearder.jsp"%>
	<div class="Nav">
		<table class="cart">
			<tr>
				<th>Products in cart:</th>
				<th>Price</th>
				<th>Quantity</th>
				<th>Amoutn</th>
			</tr>
			<c:forEach var="product" items="${Cart.getItems()}">
				<tr>
					<td><p>${product.getName()}</p>
						<p>Id: ${product.getId()}</p></td>
					<td>${product.getPrice()}</td>
					<td>${product.getNumber()}</td>
					<td>${product.getAmoutn()}</td>
				</tr>
			</c:forEach>
			<tr>
				<th colspan="4" class="total">Total: ${Cart.getAmount()} $</th>
			</tr>
		</table>
		<h2>${err}</h2>
		<form action="pay" method="get">
			<table class="cart_khachHang">
				<tr>
					<th>Customer name</th>
					<td>${account.getName()}</td>
				</tr>

				<tr>
					<th>Customer adderss</th>
					<td><input type="text" class="input_adderss" name="adderss"
						placeholder="Nhập địa chỉ" value="${account.getAddress()}"></td>
				</tr>
				<tr>
					<th>Discount code(if any)</th>
					<td><input type="text" class="input_adderss" name="Discount"
						placeholder="Nhập Discount"></td>
				</tr>
			</table>
			<input type="submit" class="cart_supmit" value="Pay">
	</div>
	</form>
	<%@ include file="/footer.jsp"%>
</body>
</html>