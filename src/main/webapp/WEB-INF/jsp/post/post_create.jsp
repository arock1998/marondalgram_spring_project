<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div id="postCreateBox" class="">
	<div id="postCreateImageBox" class="m-5 bg-light">
	<!-- <img src="###"> -->
	</div>
	<label for="selectFileBtn">
	<img src="##"> <!--  TODO: 이미지파일으로 올렸을 때 이미지가 바로 보였으면 좋겠다. -->
	<input type="file" id="selectFileBtn" accept=".jpg, .jpeg, .png, .gif">
	</label>
	<input type="text" id="description" >
	<div>
		<button type="button" id="saveBtn" class="btn btn-secondary">저장</button>
	</div>
</div>

<script>
	$(document).ready(function(){
		
		//파일 올리기 버튼 클릭
		$('#selectFileBtn').on('click', function(){
			
			
		});
		//파일 저장 버튼 클릭
		$(document).ready(function(){
			$('#saveBtn').on('click', function(){
				
				var file = $('#selectFileBtn').val();
				if(file == ''){
					alert('파일을 등록해주세요');
				}
					if(file != ''){
					alert('파일이 올라왔다.')
					console.log(file.split('.'));	//파일 명을 . 기준으로 자른다.
					let ext = file.split('.').pop().toLowerCase();
					if($.inArray(ext, ['jpg', 'jpeg', 'png', 'gif']) == -1){
						alert("이미지 파일만 업로드 할 수 있습니다.");
						
						$('#selectFileBtn').val('');	//잪못된 파일을 비운다.
						return;
					}
				}
		
			//폼태그를 자바스크립트에서 만드는 방법이다.
			let description =  $('#description').val().trim();
			let formData = new FormData();
			formData.append('description', description);
			formData.append('file', $('#selectFileBtn')[0].files[0]);
			
			$.ajax({
				type:'post'
				, url: '/post/create'
				, data: formData
				, enctype:'multipart/form-data'
				, processData: false
				, contentType: false
				, success: function(data){
					if(data.result == 'success'){
						alert("메모가 저장되었습니다.");
						location.href="/timeline/timeline";
					}
				}
				, error: function(e){
					alert("업르도에 실패했습니다. 관리자에게 문의해주세요");
				}
			
			});
		});
	});
});


</script>

<!-- https://github.com/marobiana/spring_project_marondalgram/blob/master/src/main/webapp/WEB-INF/jsp/timeline/timeline.jsp 를 참고하도록 -->
	<!--  사용자가 파일 업로드를 했을 때 유효성 확인 및 업로드 된 파일 이름을 노출
	$('#file').on('change', function(e) {
		//변화된 타겟의 이름 가져오기
		var name = e.target.files[0].name;
		
		
		// 확장자 유효성 확인
		var extension = name.split('.');
		if (extension.length < 2 || 
		 	(extension[extension.length - 1] != 'gif' 
		 	&& extension[extension.length - 1] != 'png' 
		 	&& extension[extension.length - 1] != 'jpg'
		 	&& extension[extension.length - 1] != 'jpeg')) {
		 	
		 	alert("이미지 파일만 업로드 할 수 있습니다.");
		 	$(this).val(""); // 이미 올라간 것을 확인한 것이기 때문에 비워주어야 한다.
		 	$('#fileName').text('');	//잘못된 파일 명도 비워준다.
		 	return;
		 }
		 
		 //확장자 유호셩 확인 (2)
		 let fileNameArr = fileName.split('.');
		 if( fileNameArr[fileNameArr.length - 1] != 'png' ){
		 		
		 }
		 
		 $("#fileName").text(name);
	}); -->

    
    
