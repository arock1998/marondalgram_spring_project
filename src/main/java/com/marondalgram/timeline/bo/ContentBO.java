package com.marondalgram.timeline.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marondalgram.comment.bo.CommentBO;
import com.marondalgram.comment.model.Comment;
import com.marondalgram.like.bo.LikeBO;
import com.marondalgram.post.bo.PostBO;
import com.marondalgram.post.model.Post;
import com.marondalgram.timeline.model.ContentView;

@Service
public class ContentBO {
	
	@Autowired
	private PostBO postBO;

	@Autowired
	private LikeBO likeBO;

	@Autowired
	private CommentBO commentBO;

	public List<ContentView> generateContentViewListById(int userId) {

		List<ContentView> contentViewList = new ArrayList<>();
		List<Post> postList = postBO.getPostList(userId);

		for (Post post : postList) {
			ContentView content = new ContentView();
			content.setPost(post);
			int postId = post.getId();

			boolean likeYn = likeBO.getLike(userId, postId);
			content.setLikeYn(likeYn);
			int countLike = likeBO.countLike(postId);
			content.setLikeCount(countLike);
			List<Comment> commentList = commentBO.getCommentList(postId);
			content.setCommentList(commentList);
			
			contentViewList.add(content);
		}
		return contentViewList;
	}
}
