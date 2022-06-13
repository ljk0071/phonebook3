<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="../update" method="post">
		<table border="1">
			<tr>
				<td>이름(name)</td>
				<td><input type="text" name="name" value="${pVo.name }"></td>
			</tr>
			<tr>
				<td>핸드폰(hp)</td>
				<td><input type="text" name="hp" value="${pVo.hp }"></td>
			</tr>
			<tr>
				<td>회사(company)</td>
				<td><input type="text" name="company" value="${pVo.company }"></td>
			</tr>
		</table>
		<button type="submit">등록</button>
		<input type="hidden" name="personId" value="${pVo.personId }">
	</form>

</body>
</html>