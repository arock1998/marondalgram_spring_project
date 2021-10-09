package com.marondalgram.comment;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marondalgram.comment.bo.CommentBO;

@Controller
public class CommentRestController {
	@Autowired
	private CommentBO commentBO;
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	
	@RequestMapping("/comment/create")
	public Map<String, Object> createComment(
			@RequestParam("postId") int postId
			, @RequestParam("comment") String comment 
			, HttpServletRequest request
			){
		HttpSession session = request.getSession();
		Integer userId = (Integer) session.getAttribute("userId");
		if(userId == null) {
			logger.error("[###createComment] createComment userId가 null이다");
		}
		
		Map<String, Object> result = new HashMap<>();
		result.put("result", "error");
		
		
		
		return result;
	}
}
