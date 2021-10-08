package com.marondalgram.post;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PostController {

	/**
	 * 게시글 작성 화면
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/post/create_view")		
	public String postCreateView(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Integer userId = (Integer) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/user/sign_in_view";
		}
		model.addAttribute("viewName", "post/post_create");
		return "template/layout";
	}
	
}
