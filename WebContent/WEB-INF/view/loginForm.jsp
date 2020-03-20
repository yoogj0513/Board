<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	label {
		width: 100px;
		float: left;
	}
	
	.error {
		color: red;
	}
</style>
</head>
<body>
	<form action="login.do" method="post">
		<p>
			<label>아이디</label>
			<input type="text" name="id"/>
		</p>
		<p>
			<label>비밀번호</label>
			<input type="password" name="password"/>
		</p>
		<p>
			<input type="submit" value="로그인"/>
		</p>
	</form>
	<c:if test="${notMatch != null }">
		<p class="error">아이디와 비밀번호가 일치하지 않습니다.</p>
	</c:if>
</body>
</html>