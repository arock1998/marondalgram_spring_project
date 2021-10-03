package com.marondalgram.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller	
public class UserController {
	
	/**
	 * 로그인 페이지
	 * @param model
	 * @return
	 */
	@RequestMapping("/user/sign_in_view")
	public String signInView(Model model) {
		model.addAttribute("viewName", "user/sign_in_view");
		
		return "template/layout";
	}
	
	/**
	 * 회원가입 페이지
	 * @param model
	 * @return
	 */
	@RequestMapping("/user/sign_up_view")
	public String signUpView(Model model) {
		model.addAttribute("viewName", "user/sign_up_view");
		return "template/layout";
	}
	
	
	
}
