<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 확인</title>
</head>
<body>
	<h4>${boardDto.bnum }번 글 내용</h4>
		글 제목 : ${boardDto.btitle } <br>
		글 내용 : ${boardDto.bcontent } <br>
		이름 : ${boardDto.bname } <br>
		조회수 : ${boardDto.bhit } <br>
		등록일 : ${boardDto.bdate } <br>
	<hr/>
	<input type="button" value="글목록" onclick="javascript:window.location.href='boardlist'">
</body>
</html>
