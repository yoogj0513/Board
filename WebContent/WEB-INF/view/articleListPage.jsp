<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table {
		border-collapse: collapse;
		width: 600px;
	}
	
	td {
		border : 1px solid #000;
		padding: 5px;
	}
</style>
</head>
<body>
	<table>
		<tr>
			<td>번호</td>
			<td>${item.articleNo }</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${item.writerName}</td>
		</tr>
		<tr>
			<td>제목</td>
			<td>${item.title }</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>${item.content }</td>
		</tr>
		<tr>
			<td colspan="2">
				<a href="list.do">[목록]</a>
				<a href="update.do?no=${item.articleNo }">[게시글수정]</a>
				<a href="delete.do?no=${item.articleNo }">[게시글삭제]</a>
			</td>
		</tr>
	</table>
</body>
</html>