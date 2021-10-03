package com.marondalgram.test;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.marondalgram.test.bo.TestBO;

@Controller
public class TestController {
	
	@RequestMapping("/test01")
	@ResponseBody
	public String test01() {
		return "hello world test2";
	}
	
	@Autowired
	private TestBO testBO;
	
	@RequestMapping("/test02")
	@ResponseBody
	public List<Map<String,Object>> test02() {
		
		return testBO.getUserList();
	}
	
	//jsp 연동 테스트
	@RequestMapping("/test03")
	public String test03() {
		//webapp 반드시 main 밑에 있어야 한다. 
		
		return "test/test";
	}


}
