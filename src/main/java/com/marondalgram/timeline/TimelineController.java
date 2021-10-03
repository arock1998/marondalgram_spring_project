package com.marondalgram.timeline;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marondalgram.post.bo.PostBO;
import com.marondalgram.post.model.Post;

@Controller
public class TimelineController {
	
	@Autowired
	private PostBO postBO;
	
	//########################## 일단 get으로 만들고 나중에 session을 추가하자
	@GetMapping("/timeline/timeline")
	public String timeline(
			@RequestParam("userId") Integer userId
			, Model model){
		
		List<Post> postList = postBO.getPostList(userId);
		
		model.addAttribute("viewName", "timeline/timeline");
		model.addAttribute("postList", postList);
		return "template/layout";
	}
	
	
}
