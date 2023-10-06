<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>


<html>
<head>
	<title>Home</title>
</head>
<body>

<h1>이건 깃에서 작업!</h1>

<h1>Hello world!!</h1>
<p>${server.Time}</p>

<h1>안녕안녕~</h1>

<h1><a href="board/list">스프링 웹 프로젝트 바로가기</a></h1>


<h3>[왼편바]</h3>
<h5>-첫페이지로 이동메뉴추가(게시글 페이지 뒤쪽으로 이동 시 한번에 처음으로 돌아가기)</h5>
<h5>-검색기능 추가</h5>
<h5>-전체게시글 표시</h5>

<h3>[게시판]</h3>
<h5>-게시판 페이지 박스처리</h5>
<h5>-게시판목록 우측상단 현재페이지 표기</h5>

<h3>[댓글기능]</h3>
<h5>-게시물을 클릭해서 해당글의 댓글보기 가능</h5>
<h5>-댓글읽고,</h5>
<h5>-댓글을 클릭해서 수정도 가능하고,</h5>
<h5>-우측 휴지통 클릭하면 삭제도 가능</h5>



</body>
</html>
