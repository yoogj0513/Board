<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<a href="add.do">게시글 작성</a>
	<table>
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>조회수</td>
		</tr>
		<c:forEach var="article" items="${list }" >
			<tr>
				<td>${article.articleNo }</td>
				<td><a href="read.do?no=${article.articleNo }">${article.title }</a></td>
				<td>${article.writerId }</td>
				<td>${article.readCnt }</td>
			</tr>
		</c:forEach>
	</table>
	<a href="index.jsp">[홈으로 이동]</a>
</body>
</html>