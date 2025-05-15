<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>뉴스 상세 보기</h2>
	<hr>
	<ul>
			<li>${news.aid}</li>
			<li>${news.title}</li>
			<li>${news.date}</li>
			<li>${news.content}</li>	
	</ul>
</body>
</html>