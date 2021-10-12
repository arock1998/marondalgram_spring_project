package com.marondalgram.timeline.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marondalgram.relation.bo.RelationBO;
import com.marondalgram.timeline.model.ProfileView;
import com.marondalgram.user.bo.UserBO;
import com.marondalgram.user.model.User;

@Service
public class ProfileBO {
	
	@Autowired
	private RelationBO relationBO;
	@Autowired
	private UserBO userBO; 
	
	public List<ProfileView> generateProfileViewListById(int userId){
	//친구 아이디 리스트를 가지고 왔다.
		List<Integer> friendIdList = relationBO.getFriendUserId(userId);
		List<ProfileView> profileViewList = new ArrayList<>();
		
		for(Integer friendId : friendIdList) {
			ProfileView profileView = new ProfileView();
			
			User userProfile =  userBO.getUserProfile(friendId);
			profileView.setUser(userProfile);
			profileViewList.add(profileView);
		}
		//램던으로 섞어서 다양하게 볼 수 있도록 하자
		return profileViewList;
	}
}
