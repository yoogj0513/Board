<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table {
		border-collapse: collapse;
	}

	td {
		border: 1px solid #000;
		padding: 5px;
	}
	
</style>
</head>
<body>
	<table>
		<c:forEach var="member" items="${list }">
			<tr>
				<td>${member.memberId }</td>
				<td>${member.name }</td>
				<td>${member.password }</td>
				<td>
					<fmt:formatDate value="${member.reqdate }" pattern="yyyy년 MM월 dd일 HH시 mm분"/>
				</td>
			</tr>
		</c:forEach>
	</table>
	<a href="index.jsp">홈으로 이동</a>
</body>
</html>