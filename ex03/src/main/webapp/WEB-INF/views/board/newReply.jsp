<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

오늘의 리플개수: <span id="todayCount"></span><br>
<button id="todayBtn">확인</button><br>

<div>
</div>

<script src="/resources/vendor/jquery/jquery.min.js"></script>

<script>
$(document).ready(function() { 
	console.log("오늘의 리플 5초마다 갱신");
	//setInterval("todayCount()", 5000);  //5초마다 실행
	
	//serInterval(function(){	},5000);
	
});
</script>

<script>
$(function(){
	$("#todayBtn").on("click",function(e){
		$.ajax({
			url:"/myapi/todayCount",
			type:"get",
			success:function(result){
				console.log("요청성공",result);
				
				$("#todayCount").html(result);
			}		
		});
	});
});
</script>



<script>
$(function(){
	$("#todayBtn").on("click",function(e){

		$.ajax({
			url:"/myapi/todayReply",
			type:"get",
			success:function(result){
				console.log("요청성공",result);
				var htmlStr="";
				for(var i=0; i<result.length; i++){
					htmlStr += (i+1)+". "+result[i].reply+"("+result[i].replyer+")"+"<br>";
				}
				$("div").html(htmlStr);				
			}
			
		});
		
	});
});
</script>



</body>
</html>