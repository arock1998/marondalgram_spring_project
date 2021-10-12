package com.marondalgram.user.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marondalgram.user.dao.UserDAO;
import com.marondalgram.user.model.User;

@Service
public class UserBO {
	
	@Autowired
	private UserDAO userDAO;
	
	public User getUserByLoginIdAndPassword(String loginId, String password) {
		return userDAO.getUserByLoginIdAndPassword(loginId, password);
	}
	
	public void insertUser(String loginId, String password, String name,
			String phoneNumber, String birth, String gender, String email) {
		userDAO.insertUser(loginId, password, name, phoneNumber, birth, gender, email);
	}
	
	public User getUserProfile(int friendId) {
		return userDAO.selectUserProfile(friendId);
	}

}
