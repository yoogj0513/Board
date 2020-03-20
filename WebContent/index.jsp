<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<a href="memberList.do">[회원리스트보기]</a>

	<c:if test="${Auth != null }"> <!-- 로그인 상태 -->
		<a href="changePwd.do">[비밀번호 변경]</a>
		<a href="">[게시판 작성]</a>		
		<a href="logout.do">[로그아웃]</a>
		[${Auth }]님. 로그인한 상태
	</c:if>
	<c:if test="${Auth == null }"><!-- 로그아웃 상태 -->
		<a href="join.do">[회원가입]</a>
		<a href="login.do">[로그인]</a>
	</c:if>
</body>
</html>