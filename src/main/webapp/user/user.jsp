<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>user.Jsp</title>
<%@include file="/common/common_lib.jsp"%>
<!-- Custom styles for this template -->
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
  <%@ include file="/common/header.jsp" %>

   <div class="container-fluid">
      <div class="row">
         <div class="col-sm-3 col-md-2 sidebar">
            <%@ include file="/common/left.jsp" %>
         </div>
         
         <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

            <% UserVo user = (UserVo)request.getAttribute("user"); %>
            <form class="form-horizontal" role="form" id="frm">
               <input type="hidden" name="userid" value="<%=user.getUserid() %>"/>
                
			<!-- 사용자 프로필 사진 가져오기  -->
               <div class="form-group">
                  <label for="profile" class="col-sm-2 control-label">사용자 사진</label>
                  <div class="col-sm-10">
                  	<img src="<%=request.getContextPath() %>/profile/<%=user.getUserid() %>.png"/>
                  	<br>
<%--                      <label class="control-label"><%=user.getUserid() %>의 profile</label> --%>
                  </div>
               </div>
               
               
               <div class="form-group">
                  <label for="userNm" class="col-sm-2 control-label">사용자 아이디</label>
                  <div class="col-sm-10">
                     <label class="control-label"><%=user.getUserid() %></label>
                  </div>
               </div>

               <div class="form-group">
                  <label for="userNm" class="col-sm-2 control-label">사용자 이름</label>
                  <div class="col-sm-10">
                     <label class="control-label"><%=user.getUsernm() %></label>
                  </div>
               </div>
                  
               <div class="form-group">
                  <label for="userNm" class="col-sm-2 control-label">별명</label>
                  <div class="col-sm-10">
                     <label class="control-label"><%=user.getAlias() %></label>
                  </div>
               </div>
                     
               <div class="form-group">
                  <label for="pass" class="col-sm-2 control-label">비밀번호</label>
                  <div class="col-sm-10">
                     <label class="control-label">*******</label>
                  </div>
               </div>
               
               <div class="form-group">
                  <label for="pass" class="col-sm-2 control-label">등록일자</label>
                  <div class="col-sm-10">
                     <label class="control-label"><%=user.getReg_dt_fmt() %></label>
                  </div>
               </div>
               
               <div class="form-group">
                  <label for="pass" class="col-sm-2 control-label">도로주소</label>
                  <div class="col-sm-10">
                     <label class="control-label"><%=user.getAddr1() %></label>
                  </div>
               </div>
               
               <div class="form-group">
                  <label for="pass" class="col-sm-2 control-label">상세주소</label>
                  <div class="col-sm-10">
                     <label class="control-label"><%=user.getAddr2() %></label>
                  </div>
               </div>
               <div class="form-group">
                  <label for="pass" class="col-sm-2 control-label">우편번호</label>
                  <div class="col-sm-10">
                     <label class="control-label"><%=user.getZipcode() %></label>
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