package com.marondalgram.relation.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marondalgram.relation.dao.RelationDAO;

@Service
public class RelationBO {
	
	@Autowired
	private RelationDAO relationDAO;
	
	public List<Integer> getFriendUserId(int userId){
		return relationDAO.selectFriendUserId(userId);
	}
}
