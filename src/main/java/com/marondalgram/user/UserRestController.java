package com.marondalgram.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.marondalgram.user.bo.UserBO;
import com.marondalgram.user.model.User;

@RestController		// 데이터를 돌려주는 어노테이션
public class UserRestController {
	
	@Autowired
	private UserBO userBO;
	
	/**
	 * 로그인
	 * @param loginId
	 * @param password
	 * @return
	 */
	@PostMapping("/user/sign_in")
	public Map<String, Object>  signIn(
			@RequestParam("loginId") String loginId
			, @RequestParam("password") String password
			){
		Map<String, Object> result = new HashMap<>();
		
		// TODO: password 해싱해야 한다
		
		User user = userBO.getUserByLoginIdAndPassword(loginId, password);
		if(user != null) { //################# 이게 되나 ? 
			result.put("result", "success");
		} else {
			result.put("result", "error");
		}
		return result;
	}
	
	/**
	 * 회원가입
	 * @param loginId
	 * @param password
	 * @param name
	 * @param phoneNumber
	 * @param birth
	 * @param gender
	 * @return
	 */
	@PostMapping("/user/sign_up")
	public Map<String, Object> signUp(
			@RequestParam("loginId") String loginId
			, @RequestParam("password") String password
			, @RequestParam("name") String name
			, @RequestParam("phoneNumber") String phoneNumber
			, @RequestParam("birth") String birth
			, @RequestParam("gender") String gender
			, @RequestParam("email") String email
			){
		Map<String, Object> result = new HashMap<>();
		
		//TODO: 비밀번호 해싱 후 저장하기
			
		userBO.insertUser(loginId, password, name, phoneNumber, birth, gender, email);
		result.put("result", "success");
		
		return result;
	}
	

}
