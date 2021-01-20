<%@page import="kr.or.ddit.common.model.PageVo"%>
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
<link href="${cp }/css/dashboard.css"
	rel="stylesheet">
<link href="${cp }/css/blog.css" rel="stylesheet">
</head>

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
								List<UserVo> pageList = (List<UserVo>) request.getAttribute("pageList");
								for (int i = 0; i < pageList.size(); i++) {
									UserVo vo = pageList.get(i);
									%>

								<tr>
									<td><%=vo.getUserid() %></td>
									<td><%=vo.getUsernm() %></td>
									<td><%=vo.getAlias() %></td>
<%-- 									<td><%=vo.getReg_dt_fmt() %></td> --%>
									<%
									}
								%>
								
							</table>
						</div>

						<a class="btn btn-default pull-right">사용자 등록</a>

						<div class="text-center">
<%-- 		값이 잘 넘어왔는지 확인 		pagination : <%=request.getAttribute("pagination") %> --%>
					request.getAttribute("pageVo") : <%=((PageVo)request.getAttribute("pageVo")).getPage() %>
<%-- 					page parameter : <%=request.getParameter("page") %> 	 --%>
							<ul class="pagination">
							
							<!-- page파라미터와 링크에 대한 텍스트가 달라져야 한다  
								pagination 값이 4이므로 1부터 4까지 4번 반복된다
								전체 사용자수 :  16명, 페이지 사이즈 : 5, 전체 페이지수 : 4페이지  -->
								<%
								PageVo pageVo = (PageVo)request.getAttribute("pageVo"); 
								int pagination =  (int)request.getAttribute("pagination");
								%>
						<!-- 가장 이전 페이지로  -->
							<li class="prev">
								<a href="${cp }/pagingUser?page=1&pageSize=<%=pageVo.getPageSize()%>">«</a>
							</li>
							<% 
							for(int i = 1; i<=pagination; i++){ 
								
								if(pageVo.getPage() == i){%>
								<li class="action"><%=i %></li> 
								<% }
								else{%>
								<li><a href="${cp }/pagingUser?page=<%=i %>&pageSize=<%=pageVo.getPageSize()%>"><%=i %></a></li>
								<%}
							}%>
							<!--  가장 마지막 페이지로-->
							<li class="next">
								<a href="${cp }/pagingUser?page=<%=pagination%>&pageSize=<%=pageVo.getPageSize()%>">»</a>
							</li>
								
<%-- 								<li><a href="${cp }/pagingUser?page=1&pageSize=5">1</a></li> --%>
<%-- 								<li><a href="${cp }/pagingUser?page=2&pageSize=5">2</a></li> --%>
<%-- 								<li><a href="${cp }/pagingUser?page=3&pageSize=5">3</a></li> --%>
<%-- 								<li><a href="${cp }/pagingUser?page=4&pageSize=5">4</a></li> --%>
<%-- 								<li><a href="${cp }/pagingUser?page=5&pageSize=5">5</a></li> --%>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
