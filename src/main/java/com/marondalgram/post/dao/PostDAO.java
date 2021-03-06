package com.marondalgram.post.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.marondalgram.post.model.Post;

@Repository
public interface PostDAO {

	public Post selectPost(int postId);

	public List<Post> selectPostList(int userId);

	public int insertPost(@Param("userId") int userId, @Param("userName") String userName,
			@Param("description") String description, @Param("imageURL") String imageURL);

	public void deletePost(int postId);
}
