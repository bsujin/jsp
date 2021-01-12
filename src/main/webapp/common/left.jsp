<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<ul class="nav nav-sidebar">
	<li class="active"><a href="#">Main <span class="sr-only">(current)</span></a></li>
	<li class="active"><a href="<%=request.getContextPath()%>/allUser">전체 사용자</a></li>
	<li class="active"><a href="<%=request.getContextPath()%>/allEmpList">회원 목록</a></li>
	<li class="active"><a href="<%=request.getContextPath()%>/pagingUser?page=1&pageSize=5">사용자 페이징 리스트</a></li>
	
	
	
	
	
<!-- 	localhost/pasingUser?page=1&pageSize=5 로 요청시
		pagingUser.jsp에서 페이지에 해당하는 사용자 5명만 출력되도록 개발
		(kr.or.ddit.user.coyntroller.PagingUser.jaca, webapp/user/pagingUser.jsp) -->
	
	
	
	<%--
		/alluser 요청을 처리할 servlet(controller)
		kr.or.ddit.user.controller.AllUser
		기본으로 get-> 재정의 
		doGet(){
			1. service 객체를 통해 전체 사용자 정보를 조회
			2. request객체에 userList라는 속성명으로 1번에서 조회한 데이터를 설정 
			3. webapp/user/allUser.jsp로 응답을 생성하도록 forward
				allUser.jsp에서는 user.html을 참고하여 생성
				header.jsp, left.jsp 를 재활용하여 생성
				
				- user.html의 사용자 정보를 표현하는 테이블 태그의 tr부분을
					request에 저장된 userList 속성 값으로 동적 생성하여
					화면에 출력하기 
					
					--------과제
			4. 회원 관리목록 만들기 (emp테이블 정보 가져오기)
				
		}
	 --%>
</ul>
