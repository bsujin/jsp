<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>run</title>
</head>
<body>
		//강제로 예외 발생 - 메소드 실행 
	<%
		throw new RuntimeException();
	%>

</body>
</html>