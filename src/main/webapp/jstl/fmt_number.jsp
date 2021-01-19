<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>fmt_number</title>
</head>
<body>
	<%-- page scope에 속성 이름 price, 값은 100000 추가 --%>

	<%
	pageContext.setAttribute("price", 100000);
	%>
	<c:set var="price" value="100000" /><%-- 숫자가 많아지면 , 로 표시 100000(숫자) ==> 100,000(문자)	==> 화면에 출력될 때 포맷을 해준다 <fmt:formatNumber> 사용 --%>
	<c:set var="priceStr" value="100,000"/> <%-- 100,000(문자) --> 100000(숫자) --%>

	<!-- 	locale설정이 한국어로 되어있어 자동으로 100,000 으로 나온다  -->
	price : ${price }
	<br> price fmt :
	<fmt:formatNumber value="${price }" />
	<br> price fmt-num :
	<fmt:formatNumber value="${price }" type="number" />
	<br> price fmt-curr :
	<fmt:formatNumber value="${price }" type="currency" />
	<br> price fmt-per :
	<fmt:formatNumber value="${price }" type="percent" />
	<br> price fmt-pattern :
	<fmt:formatNumber value="${price }" pattern="00000000000.00" />
	<br> priceStr parse : <fmt:parseNumber value="${priceStr }"/>
	

	<h4>de-germany (독일의 통화 사용)</h4>
	<fmt:setLocale value="de"/>
	price : ${price }
	<br> price fmt :
	<fmt:formatNumber value="${price }" />
	<br> price fmt-num :
	<fmt:formatNumber value="${price }" type="number" />
	<br> price fmt-curr :
	<fmt:formatNumber value="${price }" type="currency" />
	<br> price fmt-per :
	<fmt:formatNumber value="${price }" type="percent" />
	<br> price fmt-pattern :
	<fmt:formatNumber value="${price }" pattern="00000000000.00" />
	<br>



</body>
</html>