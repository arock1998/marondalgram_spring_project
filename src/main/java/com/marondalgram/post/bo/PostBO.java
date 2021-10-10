package com.marondalgram.post.bo;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.marondalgram.comment.bo.CommentBO;
import com.marondalgram.common.FileManagerService;
import com.marondalgram.like.bo.LikeBO;
import com.marondalgram.post.dao.PostDAO;
import com.marondalgram.post.model.Post;

@Service
public class PostBO {

	@Autowired 
	private PostDAO postDAO;
	@Autowired
	private CommentBO commentBO;
	@Autowired
	private LikeBO likeBO;
	@Autowired
	private FileManagerService fileManagerService;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public List<Post> getPostList(int userId){
		return postDAO.selectPostList(userId);
	}
	
	public int createPost(int userId, String userName, String description, MultipartFile file){
		String imageURL = null;
		if(file == null) {
			logger.error("[ ### 글 생성]: file is null");
			return 0;
		}  else {
			try {
				imageURL = fileManagerService.saveFile(userId, file);
			} catch (IOException e) {
				e.printStackTrace();
				logger.error(" ###[post BO] 이미지 업로드 실패");
			}
		}
		return postDAO.insertPost(userId, userName, description, imageURL); 
	}
	
	public void deletePost(int postId) {
		postDAO.deletePost(postId);
		commentBO.deleteCommentByPostId(postId);
		likeBO.deleteLikeByPostId(postId);
		
	}
	
	
	
	
}	
