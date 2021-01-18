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
	<%-- 
	application 영역에 저장된 requestCountMap 객체를 forEach를 통해 tr태그로 생성 
		출력할 정보 : uri, 반복횟수 
		
		==> for문을 통하여 Filter에서 생성한 requestCountMap의 모든 값을 가져오는것 
			- map은 순서 보장이 안된다 
	--%>

	<table>
		<tr>
			<th>uri</th>
			<th>반복 횟수</th>
		</tr>
		<c:forEach items="${requestCountMap }" var="entry">
			<tr>
				<td>${entry.key }</td>
				<td>${entry.value }</td>
			</tr>
		</c:forEach>
	</table>


</body>
</html>