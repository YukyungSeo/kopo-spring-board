<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>index.jsp 입니다.</h1>

<h2><a href="${ pageContext.request.contextPath }/board">게시판</a></h2>
<h2><a href="${ pageContext.request.contextPath }/board/write">새글쓰기</a></h2>
<h2><a href="${ pageContext.request.contextPath }/login">로그인</a></h2>
<h2><a href="${ pageContext.request.contextPath }/logout">로그아웃</a></h2>
<h2><a href="${ pageContext.request.contextPath }/register">회원가입</a></h2>
</body>
</html>