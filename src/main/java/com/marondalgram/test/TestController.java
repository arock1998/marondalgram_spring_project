package com.marondalgram.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	
	@RequestMapping("/test2")
	@ResponseBody
	public String test2() {
		return "hello world test2";
	}

}
