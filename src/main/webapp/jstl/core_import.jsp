<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>core_import.jsp</title>
</head>
<body>
<!-- 구글은 안된다  -->
	<c:import url="https://search.naver.com/search.naver">
		<c:param name="query" value="코로나"/>
	</c:import>
</body>
</html>