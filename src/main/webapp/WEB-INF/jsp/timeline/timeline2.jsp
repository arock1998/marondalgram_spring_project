<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

 <div class="timeline">
 	
<!-- 친구들의 모습을 볼 수 있다. -->
 	<div class="d-flex">
 		<div class="">
 		</div>
 	</div>
<!-- 이미지를 보고 등록하기 버튼이 존재한다. -->
 	<div>
 		<a href="/post/create_view" class="btn btn-secondary">글 작성하기!</a> 
 	</div>
<!--게시글이 존재 하는 부분이다 -->
	<div class="center-block contents">
		<c:forEach items="${contentList}" var="content">
			<div class="postContentBox m-5 p-3 rounded border border-primary">
				<a class="contentMenuBtn" href="#" data-post-id="${content.post.id }" data-toggle="modal" data-target="#exampleModal">
					<img src="/images/icon/menu.png" class="float-right d-block" alt="" width="40px">
				</a>
				<div class="postImageBox text-center mt-2">
					<img src="${content.post.imageURL}" alt="####TODO 유저아이디 정보를 같이 가져오는 것도 괜찮겠다."
					  class="h-100">
					  <!-- ###TODO 이미지가 가운데로 오지 않는다...  -->
				</div>
				<div class="d-flex mt-1">
					<div class="postProfileImage">
						<!-- ###TODO 프로필 이미지를 넣고 싶지만 어떻게 해야할지 감이 안온다... 나중에 하자 session에서 받아오는 방법으로 해야할 것 같다. -->
						<!-- <img src="" alt="" width="60px"> -->
					</div>
					<div class="ml-2">
						<span class="font-weight-bold h5">${content.post.userName}</span><br>
						<small>${content.post.description}</small>
					</div>
					<!-- 좋아요 -->
					<div>
					<a href="#" data-post-id=${content.post.id } data-like-yn="${content.likeYn}" class="likeBtn">
						<c:if test="${content.likeYn eq false}">
							<img src="/images/icon/binheart.png" class="binHeart" width="80px">
						</c:if>
						<c:if test="${content.likeYn eq true}">
							<img src="/images/icon/fillheart.png" class="fillHeart" width="80px">
						</c:if>
					</a>
					</div>
				</div>
			<!-- 댓글 창 -->
				<c:forEach items="${content.commentList }" var="comment">
				<div class="d-flex">
					<div class="col-2">${comment.userName }</div>
					<div>${comment.comment }</div>
				</div>
				</c:forEach>
				<div class="d-flex m-1">
					<input type="text" class="form-control"><input type="button" class="btn btn-secondary postComentSaveBtn" value="게시" data-post-id="${content.post.id}">
				</div>
			</div>
		</c:forEach>
	</div>
 </div>
 
 <!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>
 
 <script>
 	$(document).ready(function(){
 		// 댓글 쓰기
 		$('.postComentSaveBtn').on('click', function(){
 			let postId = $(this).data('post-id');
 			var comment = $(this).siblings('input').val().trim();
 			if(comment == ''){
 				return;
 			}
 			$.ajax({
 				type:'post'
 				, url: '/comment/create'
 				, data: {'postId': postId, 'comment': comment}
 				, success: function(data){
 					if(data.result == 'success'){
 						location.reload();
 					}
 				}
 				, error: function(e){
 					alert('error 관리자에게 문의해주세요' + e);
 				}
 			});
 		});
 		
 	//좋아요 클릭
 		$('.likeBtn').on('click', function(e){
 			e.preventDefault();
 			let postId = $(this).data('post-id');
 			var likeYn = $(this).data('like-yn');
 			$.ajax({
 				type:'post'
 				, url: '/like/change'
 				, data: {'postId':postId, "likeYn": likeYn}
 				, success: function(data){
 					if(data.result == 'success'){
 			 			location.reload();
 					}
 				} 
 				, error: function(e){
 					alert('error:' + e + "관리자에게 문의해주세요" );
 				}
 			});
 		});
 		
 		//게시글 메뉴 삭제
/*  		$('#######').on('click', function(e){
 			e.preventdefault();
 			let postId = $(this).data('post-id');
 			
 			$.ajax({
 				type: 'delete'
 				, url: '/post/delete'
 				, data: {'postId': postId}
 				, success: function(data){
 					if(data.result == 'success'){
 						location.reload();
 					}
 				}
 				, error{
					alert('error 삭제에 실패했습니다. 관리자에게 문의해 주세요' + e); 					
 				}
 			});
 		}); */
 	});
 
 </script>
    
    