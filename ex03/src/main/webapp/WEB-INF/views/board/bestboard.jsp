<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>1시간 이내 실시간 인기글</h3>
<div id="rank">
</div>

<script src="/resources/vendor/jquery/jquery.min.js"></script>


<script>
	var preResult;
	function bestbno(){
		
		$.ajax({
		url:"/myapi/bestboard.json",
		success:function(result){		
			var htmlStr=""
			console.log(result);
			//이전데이터와 현재데이터를 비교해서 순위변경 표시
			if(preResult){ //preResult 존재한다면
				console.log("변경순위확인");
				for(var rank=0; rank<result.length; rank++){ //현재데이터 가지고 이전데이터와 비교
					for(var i=0; i<preResult.length;i++){ //각각의 현재값이 이전에 어디에 있는지 확인
						if(result[rank].title == preResult[i].title){
							var diffRank=0; //순위가 같을때
							//찾았다.
							if(rank>i){ //순위가 떨어졌다.
								diffRank=i-rank; //ex rank=7, i=3 => 3-7=-4
							}else if(rank<i){ //순위가 올라갔다.
								diffRank="+"+rank-i;
							}
							htmlStr += (rank+1)+"등글: "+result[rank].title+"("+diffRank+")<br>";						
							break;
						}
					}//for문
					if(i==preResult.length){ //break로 탈출한게 아님
						htmlStr += (rank+1)+"등글: "+result[rank].title+"(new)<br>";							
					}
					
				}
			}else{ //최초 로딩 시 
				for(var i=0; i<result.length; i++){
					htmlStr += (rank+1)+"등글: "+result[i].title+"(-)<br>"
				}
			}			
			//화면출력
			$("#rank").html(htmlStr);		
			
			preResult=result; //이전데이터 보관
			
		}
	})
}
	bestbno(); //최초 바로한번 실행하고
	//함수를 특정시간에 반복
	setInterval(bestbno,10000); //10초에 한번씩 bestbno함수를 수행

</script>
</body>
</html>