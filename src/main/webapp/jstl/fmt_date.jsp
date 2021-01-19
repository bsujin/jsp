<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>fmt_date</title>
</head>
<body>
	<%-- 날짜(java.utill.Date) 객체를 생성하여 속성이름 date로 pageContext에 저장 
		value에 표현식을 쓰는것이 가능핟 
	--%>
	<c:set var="date" value="<%=new Date() %>"/>
	date : ${date } <br>
	
	date fmt : <fmt:formatDate value="${date }" /> <br>
	date fmt_date-full : <fmt:formatDate value="${date }" type="date" dateStyle="full"/> <br>
	date fmt_date-mid : <fmt:formatDate value="${date }" type="date" dateStyle="medium"/> <br>
	date fmt_date-short : <fmt:formatDate value="${date }" type="date" dateStyle="short"/> <br>
	date fmt_time : <fmt:formatDate value="${date }" type="time" /> <br>
	date fmt_both : <fmt:formatDate value="${date }" type="both"/> <br>
	
<!-- 	패턴을 지정해준다 -->
<br><br>
	date fmt(custom pattern) : <fmt:formatDate value="${date }" pattern="yyyy-MM-dd"/><br>
	date fmt(custom pattern) : <fmt:formatDate value="${date }" pattern="yyyy.MM.dd"/>
	
	
<br><br>
	<c:set var="dateStr" value="2021.01.19"/>
	parse dateString : <fmt:parseDate value="${dateStr }" pattern="yyyy.MM.dd"/> <br>
</body>
</html>