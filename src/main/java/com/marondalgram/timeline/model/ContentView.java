package com.marondalgram.timeline.model;

import java.util.List;

import com.marondalgram.comment.model.Comment;
import com.marondalgram.post.model.Post;

public class ContentView {
	
	
    //List<ContentView> 뷰를 위해서 가공되엉 있는 객체
    //Entity: DB랑 1:1 매핑이 되는 객체
	
	private Post post;
	private List<Comment> commentList;
	
	//내가 한 좋아요
	private boolean likeYn;		//true 좋아요, falise, 좋아요 해제
	//isliken자바가 is면 이상한 처리를 한다.
	
	//좋아요 총 개수
	private int likeCount;

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public boolean isLikeYn() {
		return likeYn;
	}

	public void setLikeYn(boolean likeYn) {
		this.likeYn = likeYn;
	}

	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	public List<Comment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}
	
	
	
}
