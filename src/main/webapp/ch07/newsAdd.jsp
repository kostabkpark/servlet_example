<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>뉴스 등록</h2>
	<hr>
	<form action="/news?action=addNews" method="post" enctype="multipart/form-data">
		<label>뉴스 제목</label>
		<input type="text" name="title"><br>
		<label>뉴스 내용</label>
		<textarea rows="5" cols="20" name="content"></textarea><br>
		<input type="file" name="img" accept="image/*">
		<input type="submit" value="전송">
	</form>
</body>
</html>