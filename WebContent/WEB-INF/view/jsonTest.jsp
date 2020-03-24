<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
	$(function(){
		$("#btn1").click(function() {
			$.ajax({
				url : "jsonData1.do",
				type : "get",
				dataType : "json",
				success: function(res){
					console.log(res);
					$(res).each(function(i, obj){
						$("#result").append(obj.articleNo + " / " 
											+ obj.writerId + " / " 
											+ obj.writerName + " / "
											+ obj.title + " / "
											+ obj.reqdate + " / "
											+ obj.moddate + " / "
											+ obj.readCnt + " / "
											+ obj.content + "<br>");
					})
				}
			})
		})
		
		$("#btn2").click(function() {
			// 선택된 게시글을 가져옴
			var articleNo = $("#articleNo").val();
			
			$.ajax({
				url : "jsonData2.do",
				type : "get",
				data: {"no" : articleNo}, //<input type="text" name="no" value="5">
				dataType : "json",
				success: function(res){
					console.log(res);
					$("#result").append(res.articleNo + " / "
										+ res.writerId + " / "
										+ res.writerName + " / "
										+ res.title + " / "
										+ new Date(res.reqdate) + " / "
										+ new Date(res.moddate) + " / "
										+ res.readCnt + " <br> "
										+ res.content + "<br>")
				}
			})
		})
		
		$("#btn3").click(function() {
			var no = $("#no").val();
			var title = $("#title").val();
			var content = $("#content").val();
			
			$.ajax({
				url : "jsonData3.do",
				type : "get", 
				data : {"no":no, "title":title, "content":content},
				dataType : "json",
				success : function(res){
					console.log(res);
				}
			})
		})
		
		$("#btn4").click(function() {
			var no = $("#number").val();
			$.ajax({
				url: "jsonData4.do",
				type : "get",
				data : {"no": no},
				dataType : "json",
				success : function(res){
					console.log(res);
				}
			}) 
		})
	})
</script>
</head>
<body>
	<p><button id="btn1">게시글 리스트 가져오기</button></p>	
	<p>
		<input type="text" id="articleNo"/>
		<button id="btn2">한개의 게시글 가져오기</button>
	</p>
	<p>
		번호 : <input type="text" id="no"/><br>
		제목 : <input type="text" id="title"/><br>
		내용 : <textarea id="content" cols="30" rows="5"></textarea><br>
		<button id="btn3">수정</button>
	</p>
	
	<h1>삭제</h1>
	게시글 번호 : <input type="text" id="number"/>
	<button id="btn4">삭제</button>
	
	<div id="result"></div>
</body>
</html>