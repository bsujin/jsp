<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- core태그 라이브러리를 사용하기 위해 제일 처음 해야되는것 - 선언   -->
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>core_set</title>
</head>
<body>
	<h3>set</h3>
	속성을 생성하는 태그
	<%-- 
		request.setAttribute("속성명", 속성값);		==> set태그 (여기에 해당하는것) 
			
		${속성명}, <%=request.getAttribute("속성명");
	 --%>
	 
	 var : 속성명 <br>
	 value : 속성값 <br>
	 scope : 저장할 scope (page, request, session, application)<br>
	 	* scope를 지정하지 않을 경우 page scope가 적용됨 <br>
	 <c:set var="userid" value="brown"/> 
	  <%-- userid라는 속성명으로 값은 brown 으로 속성을 저장 
	  		안쪽에 값을 넣지않고 사용 가능(single)
	  		==> 이렇게는 잘 사용하지 않는다 
	  --%>
	  
	   userid-el : ${userid };
	   userid-pageContext : <%=pageContext.getAttribute("userid") %> <br>

	<h3>remove</h3>
	scope에 저장된 속성을 제거 : request.removeAttribute("속성명");	<br>
	<c:remove var="userid"/>
	
	userid-el : ${userid }<br>
	userid-pageContext : <%=pageContext.getAttribute("userid") %> <br>
</body>
</html>