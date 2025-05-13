<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 정보</title>
</head>
<body>
	<h1>학생 정보</h1>
	<hr>
	<table>
		<tr>
			<th>id</th>
			<th>이름</th>
			<th>대학</th>
			<th>생일</th>
			<th>이메일</th>
		</tr>
		<c:forEach items="${students}" var="s">
		<tr>
			<td>${s.id}</td>
			<td>${s.username}</td>
			<td>${s.univ}</td>
			<td>${s.birth}</td>
			<td>${s.email}</td>
		</tr>
		</c:forEach>
	</table>
	<hr>
	<h1>학생 추가</h1>
	<hr>
	<form action="/studentControl?action=insert" method="post">
		<label>이름</label>
		<input type="text" name="username"><br>
		<label>대학</label>
		<input type="text" name="univ"><br>
		<label>생일</label>
		<input type="text" name="birth"><br>
		<label>이메일</label>
		<input type="email" name="email"><br>
		<input type="submit" value="추가">
	</form>
</body>
</html>