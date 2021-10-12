package com.marondalgram.comment.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.marondalgram.comment.model.Comment;

@Repository
public interface CommentDAO {
	
	public List<Comment> selectCommentList(int postId);

	public void insertComment(
			@Param("userId") int userId
			, @Param("userName") String userName
			, @Param("postId") int postId
			, @Param("comment") String comment);
	
	public void deleteCommentByCommentId(int commentId);
	
	public void deleteCommentByPostId(int postId);
}
