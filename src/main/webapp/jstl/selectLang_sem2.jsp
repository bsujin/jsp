<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/common_lib.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>select_ang.jsp</title>
</head>
<script type="text/javascript">
$(function() {
	$("select").on("change", function() {
		$("form").submit();
	})
// 	상황에 따라 에러가 발생되므로 ""로 감싸줘야한다 안감사주면 변수명으로 가므로 에러 
// 	$("select").val("${param.lang}"); ==> $("select").val("en");
// 	$("select").val(${param.lang}); ==> $("select").val(en);
	$("select").val("${param.lang}");

})
</script>
<body>
	<!-- select box로 설정한 언어로 Greetting, Lang 값을 표현 -->
	<!-- select box는 사용자가 설정한 언어 값으로 선택되어있게 설정  
		1. 변경버튼을 누르면 그 값을 바꿔준다 - 전송해줘야 한다  
		
	-->
	param : [${param.lang}]
	<form action="${cp }/jstl/selectLang_sem2.jsp">
	<select name="lang">
		<option value="ko">한국어</option>
		<option value="en">english</option>
		<option value="ja">日本語</option>
		<option value="etc">기타</option>	 <!-- 아무 값이나 써도 된다 없는 값으로 나올 경우 공통 값으로 나온다  -->
	</select>
	</form>
	<!-- 로케일 설정 변경 -->
	
	<fmt:setLocale value="${param.lang}"  />
	<fmt:bundle basename="kr.or.ddit.msg.msg">
		<fmt:message key="LANG" />
		<br>
		<fmt:message key="GREETING">
			<fmt:param value="brown" />
		</fmt:message>
		<br>
	</fmt:bundle>

</body>
</html>