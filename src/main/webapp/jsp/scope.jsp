<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>scope.jsp</title>
</head>
<body>
	<form action="${cp }/scope" method="post">
	<input type="text" name="scope" value="brown"/>
	<br>
	<input type="submit" value="전송"/>
	</form>
</body>
</html>