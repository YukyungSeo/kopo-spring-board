<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>board list</h1>
	<c:forEach var="board" items="${ boardList }">
		no : ${ board.no }, title : ${ board.title }, writer :  ${ board.writer } <br>
	</c:forEach>
</body>
</html>