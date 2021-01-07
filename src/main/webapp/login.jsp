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
<!-- 사용하지 않으므로 삭제 <link rel="icon" href="../../favicon.ico"> -->

<title>Signin Template for Bootstrap **</title>

<%@ include file="/common/common_lib.jsp"%>
<%--common_lib.jsp의 내용을 지금 기술되는 부분에 코드를 복사하여 붙여넣기 --%>

<!-- cookies.get 을 사용하기 위한 api를 가져온다  -->
<script src="https://cdn.jsdelivr.net/npm/js-cookie@rc/dist/js.cookie.min.js"></script>




<script type="text/javascript">
	/* 	$(document).ready(function() {
	 }); */

	//자바의 CookieUtil 마이그레이션 : 기존에 있던것을 그대로 가져오는것 
	function getCookieValue(cookieStr, cookieName) {
		//console.log("getCookieValue 진입 확인");
		//String cookies[] = cookieStr.split("; ");
		var cookies = cookieStr.split("; ");
// 		console.log("cookies 값들 :", cookies)

		//for (String cookieString : cookies) {
		for ( var i in cookies) {
			// cookieString : 쿠키이름:쿠키값
			//String[] cookie = cookieString.split("=");
			var cookie = cookies[i].split("=");
// 			console.log("for문 진입 확인 및 cookie[] = cookies[i].split('=')값들 :",	cookie)

			// cookie[0] : 쿠키이름
			// cookie[1] ::쿠키값

			//if (cookie[0].equals(cookieName)) {
			if (cookie[0] == cookieName) {
				console.log("if문 진입 확인 및 cookie[1]값 :", cookie[1]);
				return cookie[1];
			}
		}
		return "";
	}

	//cookie 값 설정 : cookieName : 쿠키명, cookieValue : 쿠키값,expires : 유효기간(일수)
	function addCookie(cookieName, cookieValue, expires) {
		var dt = new Date(); //지금 현재날짜 ==> expires 만큼 미래날짜로 변경 
		dt.setDate(dt.getDate() + parseInt(expires));
		console.log(dt);
		
		document.cookie = cookieName + "=" + cookieValue + "; "
				+ "path=/; expires=" + dt.toGMTString();
	}

	//cookie 값 삭제
	function deleteCookie(cookieName) {
		//날짜 값을 -1로 하여 이전일자로 하면 삭제의 개념이 된다
		addCookie(cookieName, "",-1)
	}
	
	// html문서 로딩이 완료되고나서 실행되는 코드 - $(function()) 사용 
		$(function(){
		//userid, rememberme 쿠키를 확인하여 존재할 경우 값 설정, 체크
			if(Cookies.get("userid" != undefined)){
				$("#userid").val(Cookies.get("userid"));
				$("#rememberme").prop("checked",true);
				
			}
// 				var id = getCookieValue(document.cookie, "userid");
// 				var remember = getCookieValue(document.cookie, "rememberme");
				
// 				console.log(id);
// 				console.log(remember);
// 				Cookies.set("userid",id);
// 			}
		
			//singin 아이디를 select  - 그냥사용하면 실행되지 않는다 
			$("#signin").on("click", function(){
				//rememberme 체크박스가 체크 되어있는지 확인
				
				// 체크 되어있을 경우
				if($("#rememberme").is(":checked") == true){
					
					// userid input에 있는 값을 userid쿠키로 저장
					Cookies.set("userid",$("#userid").val());
					
					// rememberme 쿠키로 Y값을 저장
					Cookies.set("rememberme", "Y");
					
				}
				// 체크 해제 되어 있는 경우 : 삭제 - remove
			    //더이상 사용하지 않는다는 의미 이므로 userid, rememberme 쿠키 삭제 ==> 저장되어있으면 지워준다 
				else{
					Cookies.remove("userid");
					Cookies.remove("rememberme");
				}
				
				// form태그를 이용하여 signin 요청
				$("#frm").submit();
			
			});
		});
		
	//brown
// 	var cookieValue = getCookieValue(document.cookie, "userid");
// 	console.log("cookieValue 값 :", cookieValue);
</script>
</head>

<body>

	<div class="container">

		<form class="form-signin" id="frm"
			action="<%=request.getContextPath()%>/loginController" method="post">
			<h2 class="form-signin-heading">Please sign in</h2>
			<label for="userid" class="sr-only">userid</label>
			 <input type="text" id="userid" class="form-control" 
			 placeholder="사용자 아이디" required autofocus name="userid" value="">
			   <label for="inputPassword" class="sr-only">Password</label>
        		<input type="password" id="inputPassword" class="form-control"
        	   placeholder="Password" required name="pass" value="brownpass">
       	 <div class="checkbox">
				<label> <input type="checkbox" id="rememberme" value="remember-me"> 
				Remember me		</label>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="button"
				id="signin">Sign in</button>
		</form>

	</div>
	<!-- /container -->


	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<!-- <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script> -->
</body>
</html>
