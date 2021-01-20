<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 신규등록</title>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<%@include file="/common/common_lib.jsp"%>
<link href="${cp }/css/dashboard.css" rel="stylesheet">
<link href="${cp }/css/blog.css" rel="stylesheet">
<%-- <% UserVo vo =(UserVo)request.getAttribute("user"); %> --%>
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
// 		initData();
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


     		<form class="form-horizontal" role="form" action="${cp }/registUser"
     		method="post" enctype="multipart/form-data">

             	<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 아이디</label>
						<div class="col-sm-8">
					<!-- null 처리하기  -->
<%-- 						<% String userid = request.getParameter("userid"); --%>
<%-- 								userid = userid == null ? "" : userid; %> --%>
							<input type="text" class="form-control" id="userid" name="userid" placeholder="사용자 아이디"
							value="${userid }">
						<input type="file" class="form-control" name="profile"/>
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 이름</label>
						<div class="col-sm-8">
<%-- 						<% String usernm = request.getParameter("usernm"); --%>
<%-- 								usernm = usernm == null ? "" : usernm; %> --%>
							<input type="text" class="form-control" id="usernm" name="usernm" placeholder="사용자 이름"
							value="${usernm }">
						</div>
					</div>
                  
               <div class="form-group">
                  <label for="userNm" class="col-sm-2 control-label">별명</label>
                  <div class="col-sm-8">
<%--                   <% String alias = request.getParameter("alias"); --%>
<%--                 		  alias = alias == null ? "" : alias; %> --%>
                     <input type="text" class="form-control" id="alias" name="alias" placeholder="별명"
                     value="${alias }" >
                  </div>
               </div>
                     
               <div class="form-group">
                  <label for="pass" class="col-sm-2 control-label">비밀번호</label>
                  <div class="col-sm-8">
<%--                    <% String pass = request.getParameter("pass"); --%>
<%-- 								pass = pass == null ? "" : pass; %> --%>
                     <input type="password" class="form-control" id="pass" name="pass" placeholder="비밀번호"
                     value="${pass }" >
                  </div>
               </div>
               
               <div class="form-group">
                  <label for="pass" class="col-sm-2 control-label">등록일자</label>
                  <div class="col-sm-8">
<%--                     <% String reg_dt = request.getParameter("reg_dt"); --%>
<%-- 								reg_dt = reg_dt == null ? "" : reg_dt; %> --%>
                     <input type="text" class="form-control" id="reg_dt" name="reg_dt" placeholder="등록일자"
                     value="${reg_dt}" >
                  </div>
               </div>
               
               <div class="form-group">
                  <label for="pass" class="col-sm-2 control-label">도로주소</label>
                  <div class="col-sm-8">
<%--                     <% String addr1 = request.getParameter("addr1"); --%>
<%-- 								addr1 = addr1 == null ? "" : addr1; %> --%>
                     <input type="text" class="form-control" id="addr1" name="addr1" placeholder="도로주소" readonly
                      value="${addr1 }">
                  </div>
                  <div class="col-sm-2">
                     <button type="button" id="addrBtn"class="btn btn-default">주소검색</button>
                  </div>
               </div>
               
                  <label for="pass" class="col-sm-2 control-label">상세주소</label>
               <div class="form-group">
                <% String addr2 = request.getParameter("addr2");
								addr2 = addr2 == null ? "" : addr2; %>
                  <div class="col-sm-8">
                     <input type="text" class="form-control" id="addr2" name="addr2" placeholder="상세주소"
                      value="${addr2 }">
                  </div>
               </div>
               <div class="form-group">
                  <label for="pass" class="col-sm-2 control-label">우편번호</label>
                  <div class="col-sm-8">
                  <% String zipcode = request.getParameter("addr2");
                		  zipcode = zipcode == null ? "" : zipcode; %>
                     <input type="text" class="form-control" id="zipcode" name="zipcode" placeholder="우편번호" readonly
                     value="${zipcode }">
                  </div>
               </div>

               <div class="form-group">
                  <div class="col-sm-offset-2 col-sm-10">
                     <button type="submit" class="btn btn-default">등록</button>
                  </div>
               </div>
            </form>
         </div>
      </div>
   </div>
</body>
</html>