<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TimesTableJSTL</title>

<style>
td {
	border: 1px solid black;
}

table {
	width: 100%;
	text-align: center;
}
</style>
</head>
<body>
	<h3>EL, JSTL 사용하기</h3>

	<table>
		<c:forEach begin="1" end="9" var="j">
			<tr>
				<c:forEach begin="2" end="9" var="i">
					<td>${i }* ${j } = ${i*j }</td>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>
	<br>
	<hr>
	<br>
	<table>
		<c:forEach begin="1" end="9" varStatus="loopI">
			<tr>
				<c:forEach begin="2" end="9" varStatus="loopJ">
					<th>i${loopI.count } / j${loopJ.count }</th>
					<td>${loopJ.index }* ${loopI.index } = ${j*i }</td>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>
</body>
</html>



