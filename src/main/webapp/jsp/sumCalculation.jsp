<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sumCalculation </title>
</head>
<body>
	<form action="<%=request.getContextPath() %>/sumCalculation" method="post">
		<input type="text" name="start" value="">	<br>
		<input type="text" name="end" value="">	<br>
		<input type="submit">
	</form>
</body>
</html>