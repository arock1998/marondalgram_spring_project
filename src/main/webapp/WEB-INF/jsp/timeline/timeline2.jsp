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
 	
 	</div>
<!--  -->
	<div class="contents">
		<c:if items="${contents}" var="content">
			<div class="contentBox">
				<div class="imageBox">
					<img src="${content.post.imageURL}" alt="####TODO 유저아이디 정보를 같이 가져오는 것도 괜찮겠다." width="521">
				</div>
				<div class="d-flex">
					<div>
						<img src="" width="60px">
					</div>
					<div>
						<span class="font-weight-bold">content.user.userid</span><br>
						<small>${content.post.description}</small>
					</div>
				</div>
			</div>
		</c:if>
	</div>
 
 
 
 </div>
    
    