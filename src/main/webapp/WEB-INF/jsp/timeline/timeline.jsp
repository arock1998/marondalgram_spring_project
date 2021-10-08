<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div>
<a href="/post/create_view" class="btn btn-secondary">글 작성하기!</a> 
<hr>
<c:forEach items="${postList}" var="post">
	<div class="postBox m-5 bg-secondary">
		<div class="d-flex mt-1">
			<img src="${post.imageURL}" alt=""	height="300px">
			<div class="mt-1 ml-2">
				<span>
					게시글 올린사람 이름
				</span><br>
				<small>${post.description }</small>
			</div>
		</div>
		
	</div>
</c:forEach>
</div>






