<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

<title>user.Jsp</title>

<%@include file="/common/common_lib.jsp"%>
<link href="${pageContext.request.contextPath }/css/dashboard.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath }/css/blog.css" rel="stylesheet">
<script type="text/javascript">
$(function(){
	$("#modifyBtn").on("click", function(){
		$("#frm").attr("method", "get");
		$("#frm").attr("action", "${pageContext.request.contextPath }/userModify");
		$("#frm").attr("action", "${pageContext.request.contextPath }/userModify");
		$("#frm").submit();
	});
	
	$("#deleteBtn").on("click", function(){
		$("#frm").attr("method", "post");
		$("#frm").attr("action", "${pageContext.request.contextPath }/deleteUser");
		$("#frm").attr("action", "${pageContext.request.contextPath }/deleteUser");
		$("#frm").submit();
	});
})
</script>
</head>

<body>
	<%@include file="/common/header.jsp"%>
	<div class="container-fluid">
		<div class="row">

			<div class="col-sm-3 col-md-2 sidebar">
				<%@include file="/common/left.jsp"%>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

				<form class="form-horizontal" role="form" action="${pageContext.request.contextPath }/userModify">
				
					<input type="hidden" name="userid" value="${user.userid}"/>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 아이디</label>
						<div class="col-sm-10">
							<!-- 							<input type="text" class="form-control" id="userId" name="userId" -->
							<!-- 								placeholder="사용자 아이디"> -->
							<label class="control-label">${user.userid() }</label>
						</div>
					</div>


					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 이름</label>
						<div class="col-sm-10">
							<!-- 	<input type="text" class="form-control" id="userNm" name="userNm"
								placeholder="사용자 이름"> -->
							<label class="control-label">${user.usernm }</label>
						</div>
					</div>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">별명</label>
						<div class="col-sm-10">
							<!-- 							<input type="text" class="form-control" id="userAlias" -->
							<!-- 								name="userAlias" placeholder="별명"> -->
							<label class="control-label">${user.alias }</label>
						</div>
					</div>
					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">Password</label>
						<div class="col-sm-10">
							<!-- 							<input type="password" class="form-control" id="pass" name="pass" -->
							<!-- 								placeholder="Password"> -->
<%-- 							<% --%>
// 							String pass = userVo.getPass();
// 							if (pass != null) {
// 								pass = "******";
// 							}
<%-- 							%> --%>
<!-- 							<label class="control-label"><${user.pass }</label> -->
							<label class="control-label">****</label>
						</div>
					</div>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">등록일시</label>
						<div class="col-sm-10">
							<!-- 							<input type="text" class="form-control" id="userAlias" -->
							<!-- 								name="userAlias" placeholder="별명"> -->
							<label class="control-label"><fmt:formatDate value="${user.reg_dt}" pattern="yyyy.MM.dd"/></label>
						</div>
					</div>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">우편번호</label>
						<div class="col-sm-10">
							<!-- 							<input type="text" class="form-control" id="userAlias" -->
							<!-- 								name="userAlias" placeholder="별명"> -->
							<label class="control-label">${user.zipcode }</label>
						</div>
					</div>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">도로명주소</label>
						<div class="col-sm-10">
							<!-- 							<input type="text" class="form-control" id="userAlias" -->
							<!-- 								name="userAlias" placeholder="별명"> -->
							<label class="control-label">${user.addr1 }</label>
						</div>
					</div>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">상세주소</label>
						<div class="col-sm-10">
							<!-- 							<input type="text" class="form-control" id="userAlias" -->
							<!-- 								name="userAlias" placeholder="별명"> -->
							<label class="control-label">${user.addr2 }</label>
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="button" id="modifyBtn" class="btn btn-default">사용자 수정</button>
						<button type="button" id="deleteBtn"  class="btn btn-default">사용자 삭제</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
