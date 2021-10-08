package com.marondalgram.timeline.model;

import com.marondalgram.post.model.Post;

public class ContentView {
	
	
    //List<ContentView> 뷰를 위해서 가공되엉 있는 객체
    //Entity: DB랑 1:1 매핑이 되는 객체
    
//   contentBo를 따로 만든다.
	
	//글 1개
	private Post post;
	
	//댓글 N개
	//private List<Comment> commentList;
	
	//내가 한 좋아요
	private boolean likeYn;		//true 좋아요, falise, 좋아요 해제
	//isliken자바가 is면 이상한 처리를 한다.
	
	//좋아요 총 개수
	private int likeCount;
	
}
