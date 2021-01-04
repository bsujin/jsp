<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>scopeResult</title>

<script type="text/javascript">
	var test = "<%=application.getAttribute("application") %>";
	var test = "sally_application";
	
<%-- 	<%String a%> = test; --%>
	
<%-- 	클라이언트에서는 서버 사이드 변수 값을 활용 할 수 있으나
 	서버 사이드 변수에 클라이언트 사이드 변수 값을 대입 할 수는 없다  
 	주석 사용시에는 //가 아니라 jsp주석 '<%-- --%>' 을 사용해야 한다 --%>
	
</script>
</head>
<body>
	<!-- <br>태그를 써야 줄바꿈이 된다  -->
	request : <%=request.getAttribute("request") %>	<br>  
	session :	<%=session.getAttribute("session") %> <br> 
	application : <%=application.getAttribute("application") %><br> 
</body>
</html>