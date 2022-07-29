<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<div class="header">
	<div class="search ">
		<div class="welcome">
			<h3 style="color: blue;">Welcome to my Wepsite</h3>
		</div>
		<div class="divformSearch">
			<form class="formSearch" action="search" method="get">
				<span id="spanFormSearch">Categories</span> <input name="search"
					type="text" class="input_search" id="idSearch"
					placeholder="What are you loking for">
			</form>
		</div>
	</div>

	<div class="menu">
		<div class="menu1">
			<a href="${pageContext.request.contextPath}/home"
				class="menuLink Home">Home</a> <a href="#" class="menuLink">Products</a>
			<a href="#" class="menuLink">About Us</a>
		</div>
		<div class="menu2">
         <c:if test="${sessionScope.account == null}">
			<a href="${pageContext.request.contextPath}/login" class="menuLink">Login</a>
			<a class="menuLink" href="${pageContext.request.contextPath}/register">Register</a>
			</c:if>
			<c:if test="${sessionScope.account != null}">
			<a href="${pageContext.request.contextPath}/logout" class="menuLink">Logout</a>
			</c:if>
			
		</div>
	</div>
</div>
