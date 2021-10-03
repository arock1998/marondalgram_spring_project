<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="signUpBox">

	<h2 class="font-weight-bold m-3 text-dark">회원가입</h2>

	<div class="d-flex mb-2">
		<input name ="loginId" type="text" class="form-control" placeholder="아이디">
		<button class="ml-1 btn btn-secondary">중복확인</button>
	</div>
	<input name="password" type="password" class="form-control mb-2" placeholder="비밀번호">
	<input name="confirmPassword" type="password" class="form-control mb-2" placeholder="비밀번호 확인">
	<input name="name" type="text" class="form-control mb-2" placeholder="이름">
	<div class="d-flex mb-2">
		<input name="phoneNumber" type="text" class="form-control" placeholder="전화번호">
		<button class="ml-1 btn btn-secondary">인증번호 전송</button>
	</div>
	<input name="birth" type="text" class="form-control mb-2" placeholder="생년월일">
	<input name="email" type="text" class="form-control mb-3" placeholder="이메일">
	<div class="d-flex justify-content-around mb-3">
	
	<!-- default value가 남자로 선택이 된다 -->
	<label >남자<input id="male" type="radio" name="gender" value="male" class="ml-1"></label>
	<label>여자<input id="female" type="radio" name="gender" value="female" class="ml-1"></label>
		
		
		
	</div>
	<button id="signUpBtn" class="btn btn-secondary w-100">회원가입</button>
</div>

<script>
	$(document).ready(function(e){
		
		//########################### 아이디 중복확인 해야합니다!!!!!!!!!!#############################
		
		
		
		$('#signUpBtn').on('click', function(){
			let loginId = $('input[name=loginId]').val().trim();
			let password = $('input[name=password]').val().trim();
			let confirmPassword = $('input[name=confirmPassword]').val().trim();
			let name = $('input[name=name]').val().trim();
			let phoneNumber = $('input[name=phoneNumber]').val().trim();
			let birth = $('input[name=birth]').val().trim();
			let email = $('input[name=email]').val().trim();
			let gender = $('input[name=gender]:checked').val();
			
			//####### validation ########
			if( loginId == ''){
				alert('아이디를 입력해주세요');
				return;
			}
			if( password == '' || confirmPassword == ''){
				alert('비밀번호를 입력해주세요');
				return;
			} else if (password != confirmPassword){
				alert('비밀번호를 다시 확인해주세요');
				return;
			}
			if( name == ''){
				alert('이름을 입력해주세요');
				return;
			}
			if( phoneNumber == ''){
				alert('전화번호를 입력해주세요');
				return;
			}
			if( birth == ''){
				alert('생년월일을 입력해주세요');
				return;
			}
			if( email == ''){
				alert('이메일을 입력해주세요');
				return;
			}
			if(gender == null ){
				alert('성별을 선택하세요'); 
				return;
			}
			
			
			
 			$.ajax({
				type:'post'
				, url:'/user/sign_up'
				, data: {'loginId': loginId, 'password': password, 'name': name, 'phoneNumber': phoneNumber, 
					'birth': birth, 'gender': gender, 'email': email}
				, success : function(data){
					if(data.result == 'success'){
						alert('회원가입에 성공했습니다.');
							location.href ="/timeline/timeline"
					} else {
						alert('회원가입에 실패했습니다.');
					}
				}
				, error: function(e){
					alert('error' + e.message);
				}
			});
			 
			
			
			
			
		});
		
		
	});



</script>

