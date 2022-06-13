<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="./list" method="post">
		이름으로 검색<input type="text" name="name" value=""> <br> <br>
		핸드폰번호로 검색<input type="text" name="hp" value=""> <br> <br>
		회사번호로 검색<input type="text" name="company" value=""> <br> <br>
		<button type="submit">검색</button>
		
	</form>
	
</body>
</html>