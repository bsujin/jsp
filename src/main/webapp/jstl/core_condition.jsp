<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>if</h3>
	<c:set var="userid" value="brown"/>
<%-- 	특정조건일 때만 실행, 만족하지 않으면 실행하지 않는다  
		java
			if() ==> test 속성에 검사할 조건식을 기술 
		userid 속성의 값이 brown인지 체크하고 brown일 때만 화면에 userid 속성을 출력
		
--%>
		  <%
		  		if( ((String)pageContext.getAttribute("userid")).equals("brown")){
		  				out.write("user-id-스크립틀릿 : " +(String)pageContext.getAttribute("userid"));
		  			}
		  %>
		  <br>
		<c:if test="${userid } == 'brown'">
			틀린 예)  userid : ${userid }<br>			
		</c:if>
		  
	<c:set var="userid" value="brown"/>
		<c:if test="${userid == 'brown' }">
<%-- 		<c:if test="${userid == 'brown' } ">  } 뒤에 공백이 있으면 안된다 --%>
			올바른 예)  userid : ${userid }<br>			
		</c:if>
	<br><br>
	<hr>
	<br><br>
	<h3>choose : 일반 if, else if, else</h3>
	<c:choose>
		<c:when test="${userid == 'sally' }">sally 사용자 입니다 </c:when>
		<c:when test="${userid == 'moon' }">moon 사용자 입니다 </c:when>
		<c:when test="${userid == 'brown' }">brown 사용자 입니다 </c:when>
		<c:when test="${userid == 'cony' }">cony 사용자 입니다 </c:when>
		<c:otherwise>when절에 매칭되는 조건이 없습니다 </c:otherwise>
	</c:choose>
</body>
</html>