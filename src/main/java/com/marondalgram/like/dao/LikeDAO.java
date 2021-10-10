package com.marondalgram.like.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface LikeDAO {

	public void deleteLikeByPostId(int postId);
}
