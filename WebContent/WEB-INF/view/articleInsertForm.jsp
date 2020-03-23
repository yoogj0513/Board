<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	form {
		width: 500px;
	}
	
	label {
		width: 120px;
		float: left;
	}
	
	.error {
		color: red;
		font-size: 12px;
		display: none;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
	$(function(){		
		$("form").submit(function() {
			var title = $("input[name='title']").val();
			var content = $("textarea[name='content']").val();
			
			$(".error").hide();
			
			if(title == "") {
				$("input[name='title']").next().show();
				return false;
			}
			
			if(content == "") {
				$("textarea").nextAll(".error").show();
				return false;
			}
		})
	})
</script>
</head>
<body>
	<form action="add.do" method="post">
		<fieldset>
			<p>
				<label>제목</label>
				<input type="text" name="title"/>
				<span class="error">제목을 입력하세요.</span>
			</p>
			<p>
				<label>내용</label>
				<textarea name="content" cols="50" rows="10"></textarea><br>
				<span class="error">내용을 입력하세요.</span>
			</p>
			<p>
				<input type="submit" value="등록"/>
			</p>
		</fieldset>
	</form>
</body>
</html>