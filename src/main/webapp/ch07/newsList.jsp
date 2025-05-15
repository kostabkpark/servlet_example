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
	<h2>뉴스 목록</h2>
	<hr>
	<ul>
		<c:forEach items="${newsList}" var="news">
			<li>
				<a href="/news?action=view&aid=${news.aid}">${news.aid}</a>
				<a href="/news?action=view&aid=${news.aid}">${news.title}</a>
				<span>${news.date}</span>
			</li>		
		</c:forEach>
	</ul>
</body>
</html>