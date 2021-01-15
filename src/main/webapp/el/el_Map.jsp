<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
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
		
		Map<String, String> map = new HashMap<String,String>();
		map.put("userid","brown");
		map.put("usernm","브라운");
		map.put("alias","곰");
		
		request.setAttribute("map", map);
	%>

	<!-- 	view -->
	<h3>표현식 - map</h3>
	 map :	<%=map %><br>
	 map.get("userid"):<%= map.get("userid")%><br>

	<h3>EL 표현식 - map</h3>
	map : ${map}
	<br> map.get("userid") : ${map.userid } / ${map.get("userid") }
	<br>
	<br>

</body>
</html>