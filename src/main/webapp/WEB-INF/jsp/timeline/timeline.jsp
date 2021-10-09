<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div>
<a href="/post/create_view" class="btn btn-secondary">글 작성하기!</a> 
<hr>
<c:forEach items="${postList}" var="post">
	<div class="postBox m-5 bg-light">
		<img src="${post.imageURL}" alt=""	height="300px">
		<div class="d-flex mt-1">
			<div class="postImageBox">
			<img src="https://png.pngtree.com/png-vector/20210129/ourlarge/pngtree-boys-default-avatar-png-image_2854357.jpg" width = "60px">
			</div>
			<div class="mt-1 ml-2">
				<span>
					게시글 올린사람 이름
				</span><br>
				<small>${post.description }</small>
			</div>
		</div>
	</div>
	<div class="d-flex">
	<input type="text" class="form-controller post-comment-text${post.id }" ><input type="button" class="btn btn-light save-comment" value="등록" data-post-id="${post.id }">
	</div>
</c:forEach>
</div>

<script>
	$(document).ready(function(){
		$('.save-comment').on('click', function(){
			alert('버튼이 눌렸습니다.');
			
			//게시글 번호
			let postId = $(this).data('post-id');
			
			// #post-comment-text글번호
			var comment = $('.post-comment-text' + postId).val().trim();
			// let comment = $(this).siblins('input').val();
			
			if(comment == ''){
				alert('댓글을 입력하세요');
				return;
			}
			
			
			$.ajax({
				type:'POST'
				, url:'/comment/create'
				, data: {"postId":postId, "comment": comment}
				, success: function(data){
						if(data.result == 'success'){
							location.reload();
						}
				}
				, error: function(e){
					alert('error:' + e + '관리자이게 문의해주세요');
				}				
				
			})
			
			
		});
		
		
	});
</script>






