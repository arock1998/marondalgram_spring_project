package com.marondalgram.comment.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marondalgram.comment.dao.CommentDAO;
import com.marondalgram.comment.model.Comment;

@Service
public class CommentBO {

	@Autowired
	private CommentDAO commentDAO;
	
	public List<Comment> getCommentList(int postId){
		
		return commentDAO.selectCommentList(postId);
	}
	
	public void createComment(int userId, String userName, int postId, String comment) {
		commentDAO.insertComment(userId, userName, postId, comment);
	}
	
}
