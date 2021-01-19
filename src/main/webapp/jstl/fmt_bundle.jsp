<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 	번들 등록하기 -->
	<fmt:bundle basename="kr.or.ddit.msg.msg">
		<fmt:message key="LANG" />
		<br>
		<fmt:message key="GREETING">
			<fmt:param value="brown" />
		</fmt:message>
		<br>
	</fmt:bundle>

	<h3>ENGLISH</h3>
	<!-- 로케일 설정 변경 -->
	<fmt:setLocale value="en" />
	<fmt:bundle basename="kr.or.ddit.msg.msg">
		<fmt:message key="LANG" />
		<br>
		<fmt:message key="GREETING">
			<fmt:param value="brown" />
		</fmt:message>
		<br>
	</fmt:bundle>

	<h3>
		setBundle : 번들 값을 속성에 저장 message 태그를 사용할 때 번들을 저장 ==> bundle 태그 없이 사용
		가능  
		var : 출력하는 값을 담아줌 
		
		<h3>
			<fmt:setBundle basename="kr.or.ddit.msg.msg" var="msg" />
			<fmt:message key="LANG" bundle="${msg }" vaqr="lang" /> ${lang }
				<fmt:message key="GREETING" bundle="${msg }">
					<fmt:param value="brown" />
				</fmt:message>
				<br>
</body>
</html>