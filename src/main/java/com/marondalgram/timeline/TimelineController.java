package com.marondalgram.timeline;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.marondalgram.post.bo.PostBO;
import com.marondalgram.post.model.Post;

@Controller
public class TimelineController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private PostBO postBO;
	
	@RequestMapping("/timeline/timeline")
	public String timeline(
			 Model model
			 , HttpServletRequest request){
		HttpSession session = request.getSession();
		Integer userId = (Integer) session.getAttribute("userId");
		
		if(userId == null) {
			logger.info("[timeline/timeline] userId is null" + userId);
			return "redirect:/user/sign_in_view";
		}
		
		List<Post> postList = postBO.getPostList(userId);
		
		model.addAttribute("viewName", "timeline/timeline");
		model.addAttribute("postList", postList);
		return "template/layout";
	}
	
	
}
