<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--
	for(1.초기화; 2.조건체크; 4.증감식){
		3. 반복할 문장
	}
	순서 ) 1-2-3-4-2-3-4-2-3-4...3번 문장이 2번에 만족할 때 까지 반복 
	begin : 시작인덱스 값
	end :  종료 인덱스 값 
	step : 증감값 ( default값 1,  특별한 경우가 아니면 사용하지 않는다)
	var : 인덱스 변수 or 향상된 for문에서 사용될 경우 collection 객체에서 꺼낸 값 설정
		--> 인덱스의 값을 가져오려면 변수를 선언, loop 안에서만 사용
	varStatus : 루프 변수 - 객체라서 그안에 필드가 있다 (임으로 지정 가능)  
		index - 현재 인덱스 값 
		count - 루프 실행 횟수  
		being, end - 루프의 begin, end 값 	  
 --%>
	<h3>일반 for문 형태</h3>
	<c:forEach begin="0" end="10" var="i" varStatus="loop">
 		${i} : 반복시킬 문장 <br>
 		${loop.index } : index / ${loop.count } : count<br>
	</c:forEach>
	<br><hr><br>
	<%
		List<String> rangers = new ArrayList<String>();	//string 제네릭 List
			rangers.add("brown");
			rangers.add("sally");
			rangers.add("cony");
			rangers.add("moon");
			rangers.add("james");
			request.setAttribute("rangers",rangers);	//속성 저장
			
		/*
			for(String ranger : ((List<String>)request.getAttribute("rangers")) ){
				ranger
			}
			루프를 돌 컬렉션 객체를 가져올 수 있다 ( 여기서는 속성의 값을 가져오기 )
			<c:forEach items="${rangers}" var="ranger">
			</c:forEach>
		*/
	%>
	<h3>향상된 for문 형태</h3>
	rangers 속성 값 : ${rangers} <br>
	<c:forEach items="${rangers }" var="ranger" varStatus="i">
		${ranger }<br>
		index : ${i.index }<br>
	</c:forEach>
	
	
</body>
</html>