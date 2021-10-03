<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>




<!--  수평선 윗부분!!! -->
<a href="/post/post_create_view" class="btn btn-purple">글 작성하기!</a> 

<hr>
<!--  수평선 아랫부분!!! -->


<!--  @@@@@@@@@@@@@@@@ 여기서 부터는 리스트를 보여주어야 한다. -->
<table class="table">
	<thead>
		<tr>
			<th>No.</th>
			<th>제목</th>
			<th>작성날짜</th>
			<th>수정날짜</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${postList}" var="post" >
		<tr>
			<td>${post.id }</td>
			<td>${post.userId }</td>
			<td>${post.createdAt }</td>
			<td>${post.description }</td>
		</tr>
		</c:forEach>
	</tbody>
</table>

