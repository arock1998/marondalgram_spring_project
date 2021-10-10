package com.marondalgram.post;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.marondalgram.post.bo.PostBO;

@RestController
public class PostRestController {
	
	@Autowired
	private PostBO postBO;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * 게시글 작성
	 * @param description
	 * @param file
	 * @param request
	 * @return
	 */
	@RequestMapping("/post/create")
	public Map<String, Object> postCreate(
			@RequestParam( value = "description", required = false) String description
			, @RequestParam("file") MultipartFile file
			, HttpServletRequest request
			){
		//세션에서 user id가져오기
		HttpSession session = request.getSession();
		Integer userId = (Integer) session.getAttribute("userId");
		String userName = (String)session.getAttribute("userName"); 
		
		Map<String, Object> result = new HashMap<>();
		result.put("result", "error");
		
		//DB에 view에서 받아온 정보 보내주기
		int row = postBO.createPost(userId, userName, description, file);
		if(row > 0) {
			result.put("result", "success");
		}
		return result;
	}
	
	//게시글 삭제
	@RequestMapping("/post/delete")
	public Map<String, Object> postDelete( @RequestParam("postId") int postId ){
		Map<String, Object> result =  new HashMap<>();
		
		
		postBO.deletePost(postId);
		result.put("result", "success");
		
		
		return result;
	}
	
	
}
