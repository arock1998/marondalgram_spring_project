package com.marondalgram.timeline.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marondalgram.post.bo.PostBO;
import com.marondalgram.timeline.model.ContentView;

@Service
public class ContentBO {

	@Autowired
	private PostBO postBO;
	
//	@Autowired
//	private CommentBO commentBO;
//	
//	@Autowired
//	private List<ContentView> generateContentViewList(){
		
//	}
	
	
	
//	public List<ContentView> generateContentViewList() {
//		for(Post post: postList)
//		{
//			ContentView content = new ContentView();
//			
//			//글
//			content.setPost(post);
//			
//			//댓글들
//			content.setCommentList();
//			
//			//댓글 목록을 가지고온다. -> 글 id
//			
//			//내가 한 좋아요 여부
//			//좋아요 -> userId, postId
//			content.setLikeYn();
//			
//			//좋아요 개수
//			//좋아요 -> postId
//			content.setLikeCount();
//			
//		}
//	}
	
	
	
}
