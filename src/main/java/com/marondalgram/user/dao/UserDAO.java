package com.marondalgram.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.marondalgram.user.model.User;

@Repository
public interface UserDAO {
	
	public User getUserByLoginIdAndPassword(
			@Param("loginId") String loginId
			, @Param("password") String password
			);
	
	public User selectUserProfile(int friendId);
	
	public void insertUser(
			@Param("loginId") String loginId
			, @Param("password") String password
			, @Param("name") String name
			, @Param("phoneNumber") String phoneNumber
			, @Param("birth") String birth
			, @Param("gender") String gender
			, @Param("email") String email);

}
