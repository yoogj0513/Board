<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	fieldset {
		width: 480px;
	}
	
	label {
		width: 120px;
		display: inline-block;
	}
	
	.error {
		display: none;
		color: red;
		font-size: 8px;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
	$(function(){
		
		$("form").submit(function(){			
			$(".error").css("display", "none");
			
			var idReg = /^[a-z0-9]{6,15}$/i; //영어, 숫자 6~1
			var id = $("input[name='id']").val();
			if(idReg.test(id) == false || id == "") {
				$("input[name='id']").next().css("display", "inline");
				return false; // 서버 전송 막음
			}
			
			var nameReg = /^[가-힣]{2,5}$/;
			var name = $("input[name='name']").val();
			if(nameReg.test(name) == false || name == "") {
				$("input[name='name']").next().css("display", "inline");
				return false;
			}
			
			var passReg = /^[a-z0-9]{4,20}$/i;
			var pass = $("input[name='password']").val();
			if(passReg.test(pass) == false || pass == ""){
				$("input[name='password']").next().css("display", "inline");
				return false;
			}
			
			var passChk = $("input[name='confirmPassword']").val();
			if(pass != passChk) {
				$("input[name='confirmPassword']").next().css("display", "inline");
				return false;
			} 

		})
	})
</script>
</head>
<body>
	<form action="join.do" method="post">
		<fieldset>			
			<p>
				<label>아이디</label>
				<input type="text" name="id"/>
				<span class="error">ID(영어, 숫자 6~15자)를 입력하세요.</span>
			</p>
			<p>
				<label>이름</label>
				<input type="text" name="name"/>
				<span class="error">한글(2~5)를 입력하세요.</span>
			</p>
			<p>
				<label>비밀번호</label>
				<input type="password" name="password"/>
				<span class="error">비밀번호(영어, 숫자 4~20자)를 입력하세요.</span>
			</p>
			<p>
				<label>비밀번호 확인</label>
				<input type="password" name="confirmPassword"/>
				<span class="error">비밀번호가 일치하지 않습니다.</span>
			</p>
			<p>
				<input type="submit" value="가입"/>
			</p>
		</fieldset>
	</form>
</body>
</html>