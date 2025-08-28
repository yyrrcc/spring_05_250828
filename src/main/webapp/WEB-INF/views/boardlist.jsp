<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
</head>
<body>
	<h3>게시판</h3>
	<table border="1" cellspacing="0" cellpadding="0" width="800">
	    <thead>
	      <tr>
	        <th>No</th>
	        <th width="500">제목</th>
	        <th>이름</th>
	        <th>조회수</th>
	        <th>날짜</th>
	      </tr>
	    </thead>
	    <tbody>
			<c:forEach items="${boardDtos }" var="boardDtos">
	      		<tr>
			      	<td>${boardDtos.bnum }</td>
			        <td><a href="contentview?bnum=${boardDtos.bnum }">${boardDtos.btitle }</a></td>
			        <td>${boardDtos.bname }</td>
			        <td>${boardDtos.bhit }</td>
			        <td>${boardDtos.bdate }</td>
		        </tr>
	      	</c:forEach>
	    </tbody>
	  </table>
		
	  <hr/>
	<form action="writeForm">
		<input type="submit" value="글쓰기">
	</form>

</body>
</html>