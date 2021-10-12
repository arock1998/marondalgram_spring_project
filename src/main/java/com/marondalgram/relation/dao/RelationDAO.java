package com.marondalgram.relation.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface RelationDAO {

	public List<Integer> selectFriendUserId(int userId);
	
}
