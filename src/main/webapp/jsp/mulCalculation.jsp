<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=request.getContextPath() %>/mulCalculation" method="post">
		<input type="text" name="param1" value="">	<br>
		<input type="text" name="param2" value="">	<br>
		<input type="submit">
	</form>
</body>
</html>