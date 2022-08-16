<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" >
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" ></script>

</head>
<body>
<h2>상세게시글 detail.jsp 입니다.</h2>
${ board }

<table class="table table-striped" style="width: 80%; margin: auto;">
	<tr>
		<th>제목</th>
		<td>${ board.title }</td>
	</tr>
	<tr>
		<th>작성자</th>
		<td>${ board.writer }</td>
	</tr>
	<tr>
		<th>등록일</th>
		<td>${ board.regDate }</td>
	</tr>
	<tr>
		<th>내용</th>
		<td>${ board.content }</td>
	</tr>
</table>
</body>
</html>