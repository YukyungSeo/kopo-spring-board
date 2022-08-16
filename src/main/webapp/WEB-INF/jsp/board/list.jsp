<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" >
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" ></script>
</head>
<body>
	<h1>list.jsp입니다</h1>
	<h2>${ loginVO.name }님 반갑습니다.</h2>
	<table class="table table-striped" style="width: 80%; margin: auto;">
		<tr>
			<th>번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>제목2</th>
			<th>내용</th>
			<th>등록일</th>
		</tr>
		<c:forEach items="${ boardList }" var="board">
			<tr>
				<td>${ board.no }</td>
				<td> ${ board.writer }</td>
				<td><a href="${ pageContext.request.contextPath}/board/detail?boardNo=${ board.no}"> ${ board.title }</a></td>
				<td><a href="${ pageContext.request.contextPath}/board/detail/${ board.no}"> ${ board.title }</a></td>
				<td>${ board.content }</td>
				<td>${ board.regDate }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>