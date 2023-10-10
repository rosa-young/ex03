<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	페이지 번호: <input type="text" id="page"><br>
	보여줄 개수: <input type="text" id="amount"><br>
	검색할 종류: <select class="form-control" name="type">
              	<option value="T" <c:if test='${pagemaker.cri.type=="T"}'>selected</c:if>>제목</option>
                <option value="C" <c:if test='${pagemaker.cri.type=="C"}'>selected</c:if>>내용</option>
                <option value="W" <c:if test='${pagemaker.cri.type=="W"}'>selected</c:if>>작성자</option>
                <option value="TC" <c:if test='${pagemaker.cri.type=="TC"}'>selected</c:if>>제목 or 내용</option>
                <option value="TW" <c:if test='${pagemaker.cri.type=="TW"}'>selected</c:if>>제목 or 작성자</option>
                <option value="CW" <c:if test='${pagemaker.cri.type=="CW"}'>selected</c:if>>내용 or 작성자</option>
                <option value="TCW" <c:if test='${pagemaker.cri.type=="TWC"}'>selected</c:if>>제목 or 내용 or 작성자</option>                          		
              </select><br>
	검색할 내용: <input type="text"><br>
	<input type="submit" value="확인" id="search">


</body>
</html>