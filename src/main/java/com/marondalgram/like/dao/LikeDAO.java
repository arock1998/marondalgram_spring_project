package com.marondalgram.like.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeDAO {
	
	public int selectLike(
			@Param("userId") int userId
			, @Param("postId") int postId);
		
	public int countLike(int postId);
	
	public int insertLikeByUserIdAndPostID(
			@Param("userId") int userId
			, @Param("postId") int postId);
	
	public int deleteLikeByUserIdAndPostId(
			@Param("userId") int userId
			, @Param("postId") int postId);
	
	public void deleteLikeByPostId(int postId);
}
