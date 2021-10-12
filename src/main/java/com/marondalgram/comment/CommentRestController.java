package com.marondalgram.comment;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.marondalgram.comment.bo.CommentBO;

@RestController
public class CommentRestController {
	@Autowired
	private CommentBO commentBO;
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	
	@PostMapping("/comment/create")
	public Map<String, Object> createComment(
			@RequestParam("postId") int postId
			, @RequestParam("comment") String comment 
			, HttpServletRequest request
			){
		//접근할 수 있는지 확인
		HttpSession session = request.getSession();
		Integer userId = (Integer) session.getAttribute("userId");
		String userName = (String) session.getAttribute("userName");
		if(userId == null) {
			logger.error("[###createComment] createComment userId가 null이다");
		}
		
		Map<String, Object> result = new HashMap<>();
		result.put("result", "error");
		
		commentBO.createComment(userId, userName, postId, comment);
		result.put("result", "success");

		return result;
	}
	
	@PostMapping("/comment/delete")
	public Map<String, Object> deleteComment(@RequestParam("commentId") int commentId){
		
		Map<String, Object> result = new HashMap<>();
		result.put("result", "error");
		commentBO.deleteCommentByCommentId(commentId);
		result.put("result", "success");
		return result;
	}
	
}
