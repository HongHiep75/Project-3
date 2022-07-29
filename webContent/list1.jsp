<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<p></p>
<div class="noiDung row">

<c:forEach var="product" items="${products}">

<a class="LinkProduct col l-3 m-5 c-12" href="${pageContext.request.contextPath}/Information?id=${product.getId()}"><div class="thongTin ">
 <img class="anhNoiDung" src="${product.getSrc()}" alt="">
<p class="thongTinProduct Type " style="color: rgb(121, 208, 230);">${product.getType() }</p>
<p class="thongTinProduct"  style="color: rgb(16, 77, 158);">${product.getName()}</p>
<p class="thongTinProduct"  style="color: red;">$ ${product.getPrice()}</</p>
</div></a>

</c:forEach>
</div>


