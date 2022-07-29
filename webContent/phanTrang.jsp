<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<p></p>
<div class="phanTrang">
		<a class="${Trang==trangCuoi?"
			none":""}" href="home?Trang=${soTrang+1}"><span
			class="material-icons icon  " style="font-size: 12px;">arrow_forward_ios</span></a>
		<c:forEach begin="1" end="${trangCuoi}" var="i">
			<a class="${Trang==i?" ativeva":""}" href="home?Trang=${i}">${i}</a>

		</c:forEach>
		<a class="${Trang==1?" none":""}" href="home?Trang=${soTrang-1}"><span
			class="material-icons icon  " style="font-size: 12px;">arrow_back_ios</span></a>
	</div>