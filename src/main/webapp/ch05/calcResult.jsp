<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>계산 결과 : <%=request.getAttribute("result") %></h2>
	<h2>계산 결과(EL) : ${result}</h2>
</body>
</html>