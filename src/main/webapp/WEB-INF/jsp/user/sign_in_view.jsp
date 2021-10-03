<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div id="loginBox" class="bg-light">
	<h1 class="m-3 ">login</h1>
	<input type="text" name="loginId" class="form-control mb-2" placeholder="아이디"> 
	<input	type="password" name="password" class="form-control mb-2" placeholder="비밀번호">
	<button id="loginBtn" type="button" class="btn btn-secondary w-100 mb-3">로그인</button>
	<div class="d-flex justify-content-center">
		<a href="/user/sign_up_view" class="small text-secondary">회원가입</a>
		<div class="small text-secondary ml-1 mr-1">|</div>
		<a href="#" class="small text-secondary">아이디/비밀번호 찾기</a>
	</div>
</div>

<script>
	$(document).ready(function(){
		$('#loginBtn').on('click', function(){
			
			let loginId = $('input[name=loginId]').val().trim();
			let password = $('input[name=password]').val().trim();
			
			if(loginId != '' && password != ''){
				//ajax 통신으로 로그인 진행!
				$.ajax({
					type :'post'
					, url : '/user/sign_in'
					, data : {'loginId': loginId, 'password': password}
					, success : function(data){
						if(data.result == 'success'){
							alert('ajax통신에 성공 하였습니다.');
						} else {
							alert('아이디와 비밀번호를 확인해주세요.');
						}
					}
					, error : function(e){
						alert("실패:" + e + ", 관리자에게 문의해주세요.");
					}
				});
			}
		});
	});
</script>
