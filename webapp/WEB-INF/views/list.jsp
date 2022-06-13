<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>전화번호부</h1>
	<h2>등록폼</h2>
	<p>입력하신 정보입니다.</p>
	
	<c:forEach items="${pList}" var="pVo">
	<table border="1">
		<tr>
			<td>이름(name)</td>
			<td>${pVo.name }</td>
		</tr>
		<tr>
			<td>핸드폰(hp)</td>
			<td>${pVo.hp }</td>
		</tr>
		<tr>
			<td>회사(company)</td>
			<td>${pVo.company }</td>
		</tr>
		<tr>
			<td><a href="./modify/${pVo.personId }">수정</a></td>
			<td><a href="./delete/${pVo.personId }">삭제</a></td>
		</tr>
	</table>
	<br>
	</c:forEach>
	<a href="./writeform">추가</a>
	<a href="./search" style="float:right">검색</a>
	<a href="./list">목록</a>
</body>
</html>