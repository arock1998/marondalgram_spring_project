package com.marondalgram.like.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marondalgram.like.dao.LikeDAO;

@Service
public class LikeBO {

	@Autowired
	private LikeDAO likeDAO;
	
	public boolean getLike(int userId, int postId) {
		int result =  likeDAO.selectLike(userId, postId);
		return result > 0 ? true : false;
	}
	
	public int countLike(int postId) {
		return likeDAO.countLike(postId);
	}
	
	public boolean likeChange(int userId, int postId, boolean likeYn) {
		int result = 0;
		if(likeYn) {
			result = likeDAO.deleteLikeByUserIdAndPostId(userId, postId);
		} else if (likeYn == false) {
			result = likeDAO.insertLikeByUserIdAndPostID(userId, postId);
		}
		return result > 0 ? true : false;
	}
	
	public void deleteLikeByPostId(int postId) {
		likeDAO.deleteLikeByPostId(postId);
	}
}
