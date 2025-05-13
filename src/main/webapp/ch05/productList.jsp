<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 목록</title>
</head>
<body>
	<h2>상품 목록</h2>
	<hr>
	<table>
		<tr>
			<th>번호</th>
			<th>상품명</th>
			<th>가격</th>
		</tr>
		<c:forEach var="product" items="${plist}" varStatus="vs">
			<tr>
				<td>${product.id}</td>
				<td>
					<a href="/pcontrol?action=info&pid=${product.id}">${product.name}</a>
				</td>
				<td>${product.price}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>