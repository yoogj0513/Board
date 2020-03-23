<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="update.do" method="post">
		<input type="hidden" name="no" value="${item.articleNo}"/>
		<input type="hidden" name="readCnt"	value="${item.readCnt }" />
		<p>번호 : ${item.articleNo }</p>
		<p>제목 : <input type="text" name="title" value="${item.title }"/></p>
		<p>
			내용 : <br>
			<textarea name="content" cols="50" rows="10">${item.content }</textarea>
		</p>
		<p><input type="submit" value="글 수정"/></p>
	</form>
</body>
</html>