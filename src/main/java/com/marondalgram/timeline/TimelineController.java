package com.marondalgram.timeline;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.marondalgram.timeline.bo.ContentBO;

@Controller
public class TimelineController {
	
	@Autowired
	private ContentBO contentBO;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping("/timeline/timeline")
	public String timeline( Model model
			 , HttpServletRequest request){
		
		//타임라인에 들어와도 되는 경우인지 검사
		HttpSession session = request.getSession();
		Integer userId = (Integer) session.getAttribute("userId");
		if(userId == null) {
			logger.info("[timeline/timeline] userId is null" + userId);
			return "redirect:/user/sign_in_view";
		}
		
		//타임라인에서 contentView 받아오기
		model.addAttribute("contentList", contentBO.generateContentViewListById(userId));
		model.addAttribute("viewName", "timeline/timeline2");
//		List<Post> postList = postBO.getPostList(userId);
//		model.addAttribute("postList", postList);
		return "template/layout";
	}
	
	
}
