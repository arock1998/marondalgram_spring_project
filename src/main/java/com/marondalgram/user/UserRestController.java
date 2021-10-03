package com.marondalgram.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.marondalgram.common.EncryptUtils;
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
			, HttpServletRequest request){
		Map<String, Object> result = new HashMap<>();
		
		String encryptPassword = EncryptUtils.md5(password);
		
		User user = userBO.getUserByLoginIdAndPassword(loginId, encryptPassword);
		if(user != null) { 
			result.put("result", "success");
				
			//로그인 처리 - 세션에 저장(로그인 상태 유지)	//controller에서 사용할 수도 있고 jsp에서 사용할 수도 있다.
			HttpSession session = request.getSession();
			session.setAttribute("userId", user.getId());
			session.setAttribute("userName", user.getName());
			session.setAttribute("userLoginId", user.getLoginId());
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
	 * @param email
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
		
		//비밀번호 해싱하기
		String encryptPassword = EncryptUtils.md5(password);
		
		userBO.insertUser(loginId, encryptPassword, name, phoneNumber, birth, gender, email);
		result.put("result", "success");
		
		return result;
	}
	
	//TODO : logout이 필요하다
	

}
