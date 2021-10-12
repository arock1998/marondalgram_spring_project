package com.marondalgram.relation.model;

public class Relation {
	
	private int userId;
	private int friendUserId;
	private String status;
	
	// status는 'friend'와 'request' 두개만 존재한다.  -- 2와 4은 친구이다// 2는 5에게 친구 요청중이다.// 4과 5는 친구가 아니다
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getFriendUserId() {
		return friendUserId;
	}
	public void setFriendUserId(int friendUserId) {
		this.friendUserId = friendUserId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
