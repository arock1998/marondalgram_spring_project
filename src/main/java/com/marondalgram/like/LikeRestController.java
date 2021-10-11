package com.marondalgram.like;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.marondalgram.like.bo.LikeBO;

@RestController
public class LikeRestController {
	
	@Autowired
	private LikeBO likeBO;
	
//	@PostMapping("/like/{postId}")
//	public Map<String, Object> postLike(
//			@PathVariable int postId
//			, HttpServletRequest request
//			){
//		
//		//글번호, 유저번호
////		return ; 
//	}
	
	@PostMapping("/like/change")
	public Map<String, Object> postLike(
			@RequestParam("postId") int postId
			, @RequestParam("likeYn") boolean likeYn
			, HttpServletRequest request){
		Map<String, Object> result = new HashMap<>();
		result.put("result", "error");
		
		HttpSession session = request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		if(userId == null) {
			return result;
		}
		if(likeBO.likeChange(userId, postId, likeYn) == true) {
			result.put("result", "success");
		}
		return result;
	}
	
	
	
}
