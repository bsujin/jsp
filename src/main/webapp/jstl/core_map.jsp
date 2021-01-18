<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>map 타입 객체 루프를 통해 담겨진 값 확인하기</h3>
	<%
		Map<String, String> map = new HashMap<String,String>();
			map.put("userid","brown");
			map.put("usernm", "브라운");
			map.put("alias", "곰");
		// map, list? 차이
		// map : 순차적으로 접근이 아닌, 특정 키에 의해 원하는 값으 확인하고 싶을 때 
		// list : 순차적으로 접근하고 싶을 때 
		  // list의 경우 향상된 for문 많이 사용 :  for(String str : list ){ } ==> 리스트에 담겨잇는 모든 값에 대해 처리
		  // map에 담겨진 모든 값을 확인 ?? -iterater
				  // keySet, entrySet   -> 키를 저장하는 값 (반환하는것) 을 순차적으로 출력 할 수 있다 
		for(String key : map.keySet()){
			map.get(key);	
		}
				 //request-속성에 넣지 않으면 el로 사용할 수 없다
				 request.setAttribute("ranger", map);
	%>
	
	${map }
	
	<c:forEach items="${ranger }" var="entry">
		${entry.key } / ${entry.value }
	</c:forEach>
	
	<br><hr><br>
	<h3>url 작성</h3> 
	
	방법 1 : <a href="<c:url value="/userRegist"/>">사용자 등록 </a>
	방법 2 : <a href="${cp }/userRegist">사용자 등록 </a>
	방법 3 : <a href="${pageContext.request.contextPath }/userRegist">사용자 등록 </a>
	
	var 속성을 적용하지 않은 경우 : 태그를 작성한 곳에 출력 <c:url value="/userRegist"/><br>
	var 속성을 적용한 경우 : var 속성으로 저장만 된다 (el을 통해 활용)<c:url value="/userRegist" var="url"/><br>
	${url }
	<c:url value="/userRegist" var="url"/> 
	<!-- 결과값을 var에 저장한다 -->
</html>