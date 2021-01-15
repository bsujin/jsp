<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--  servlet (	원래는 servlet에 있어야하는 코드 ) -->
	<%
		//컨트롤러에서 조회된 데이터를 request에 저장했다라는 가정 -controller를 안거치고 jsp에서 실행
		
		UserVo userVo = new UserVo();
		userVo.setUserid("brown");
		userVo.setUsernm("브라운");
		userVo.setAlias("곰");
		
		request.setAttribute("userVo", userVo);
	%>

	<!-- 	view -->
	<h3>표현식 - userVo</h3>
	userVo :
	<%=request.getAttribute("userVo") %><br> userVo.getUserid() :
	<%=((UserVo)request.getAttribute("userVo")).getUserid() %><br>

	<h3>EL 표현식 - userVo</h3>
	userVo : ${userVo}
	<br> userVo.getUserid() : ${userVo.userid } / ${userVo.getUserid() }
	<br>
	<br>
	
	<h3>산술연산</h3>
	${5+5 }
	${5*5 }

</body>
</html>