<%@page import="java.text.SimpleDateFormat"%>
<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>AllUser.Jsp</title>



<%@include file="/common/common_lib.jsp"%>
<link href="<%=request.getContextPath()%>/css/dashboard.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/blog.css" rel="stylesheet">
</head>
<script>

</script>

<body>


	<%@include file="/common/header.jsp"%>

	<div class="container-fluid">
		<div class="row">

			<div class="col-sm-3 col-md-2 sidebar">
				<%@include file="/common/left.jsp"%>
			</div>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">


				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">사용자</h2>
						<div class="table-responsive">
							<table class="table table-striped">
								<tr>
									<th>사용자 아이디</th>
									<th>사용자 이름</th>
									<th>사용자 별명</th>
									<th>등록일시</th>
								</tr>
								
								<!-- import유의 -->
								<%
// 								SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
// 								==> 메소드가 문자열을 리턴하므로 바로 reg_dt에 적용해주면 된다
								List<UserVo> userList = (List<UserVo>) request.getAttribute("userlist");
								if(userList!=null){
								
									//방법 1
								for (int i = 0; i < userList.size(); i++) {
									
									//방법2 :  향상된 for문 사용
						// for (UserVo vo :(List<UserVo>) request.getAttribute("userlist") ) {
									UserVo vo = userList.get(i);
								
									%>
								
								<tr>
									<td><%=vo.getUserid() %></td>
									<td><%=vo.getUsernm() %></td>
									<td><%=vo.getAlias() %></td>
									
<!-- 									방법 1 if문으로 비교하기 
<%-- 									<%if(vo.getReg_dt()!=null){%>  --%>
<%-- 									<td><%=sdf.format(vo.getReg_dt()) %></td> --%>
<%-- 									<%}else{%> --%>
<%-- 									<% } %> --%>
								</tr> -->
								
<!-- 								방법 2 : vo 에서 임의로 매소드를 추가하기  -->
									<td><%=vo.getReg_dt_fmt() %></td>
	
								
								<%
									}
								}
								%>
							</table>
						</div>

						<a class="btn btn-default pull-right">사용자 등록</a>

						<div class="text-center">
							<ul class="pagination">
								<li><a href="#">1</a></li>
								<li><a href="#">2</a></li>
								<li><a href="#">3</a></li>
								<li><a href="#">4</a></li>
								<li><a href="#">5</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
