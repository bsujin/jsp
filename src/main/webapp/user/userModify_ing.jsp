<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="kr.or.ddit.user.model.UserVo"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>userModify.Jsp</title>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<%@include file="/common/common_lib.jsp"%>
<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath }/css/dashboard.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath }/css/blog.css" rel="stylesheet">

<script>
$(function(){
	$('#addrBtn').on('click', function(){
	    new daum.Postcode({
	        oncomplete: function(data) {
	        	$('#addr1').val(data.roadAddress); //도로주소
				$('#zipcode').val(data.zonecode);  //우편번호
			//사용자 편의성을 위해 상세주소 입력 input 태그로 focus설정
			$('#addr2').focus();
			
	        }
	    }).open();
		
	});
});

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

				<% UserVo userVo = (UserVo) request.getAttribute("user"); %>

   			  <form class="form-horizontal" role="form" 
   			  action="${pageContext.request.contextPath }/userModify" method="POST">
               
               <input type="hidden" name="userid" value="${userVo.getUserid() }"/>
               
               <div class="form-group">
                  <label for="userNm" class="col-sm-2 control-label">사용자 아이디</label>
                  <div class="col-sm-8">
                     <label class="control-label">${userVo.getUserid() }</label>
                  </div>
               </div>

               <div class="form-group">
                  <label for="userNm" class="col-sm-2 control-label">사용자 이름</label>
                  <div class="col-sm-8">
                     <input type="text" class="form-control" id="usernm" name="usernm" placeholder="사용자 이름" value="${userVo.getUsernm() }">
                  </div>
               </div>
                  
               <div class="form-group">
                  <label for="userNm" class="col-sm-2 control-label">별명</label>
                  <div class="col-sm-8">
                     <input type="text" class="form-control" id="alias" name="alias" placeholder="별명" value="${userVo.getAlias() }">
                  </div>
               </div>
                     
               <div class="form-group">
                  <label for="pass" class="col-sm-2 control-label">비밀번호</label>
                  <div class="col-sm-8">
                     <input type="password" class="form-control" id="pass" name="pass" placeholder="비밀번호" value="<%=userVo.getPass() %>">
                  </div>
               </div>
               
               <div class="form-group">
                  <label for="pass" class="col-sm-2 control-label">등록일자</label>
                  <div class="col-sm-8">
                     <input type="text" class="form-control" id="reg_dt" name="reg_dt" placeholder="등록일자" value="<%=userVo.getReg_dt_fmt() %>">
                  </div>
               </div>
               
               <div class="form-group">
                  <label for="pass" class="col-sm-2 control-label">도로주소</label>
                  <div class="col-sm-8">
                     <input type="text" class="form-control" id="addr1" name="addr1" placeholder="도로주소" value="<%=userVo.getAddr1() %>" readonly>
                  </div>
                  <div class="col-sm-2">
                     <button type="button" id="addrBtn"class="btn btn-default">주소검색</button>
                  </div>
               </div>
               
               <div class="form-group">
                  <label for="pass" class="col-sm-2 control-label">상세주소</label>
                  <div class="col-sm-8">
                     <input type="text" class="form-control" id="addr2" name="addr2" placeholder="상세주소" value="<%=userVo.getAddr2() %>">
                  </div>
               </div>
               <div class="form-group">
                  <label for="pass" class="col-sm-2 control-label">우편번호</label>
                  <div class="col-sm-8">
                     <input type="text" class="form-control" id="zipcode" name="zipcode" placeholder="우편번호" value="<%=userVo.getZipcode() %>" readonly>
                  </div>
               </div>

               <div class="form-group">
                  <div class="col-sm-offset-2 col-sm-10">
                     <button type="submit" class="btn btn-default">수정</button>
                  </div>
               </div>
            </form>
         </div>
      </div>
   </div>
</body>
</html>