<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	param1 : <%=request.getAttribute("param1") %>
	param2 : <%=request.getAttribute("param2") %>
	mulResult : <%=session.getAttribute("mulResult") %>
</body>
</html>