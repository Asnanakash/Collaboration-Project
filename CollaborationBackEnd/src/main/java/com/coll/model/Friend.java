package com.coll.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
@SequenceGenerator(name="friendidseq", sequenceName="friendseq",allocationSize=1)
public class Friend
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="friendidseq")
	int friendId;
	String username;
	String friendUserName;
	String status;
	/**
	 * @return the friendId
	 */
	public int getFriendId() {
		return friendId;
	}
	/**
	 * @param friendId the friendId to set
	 */
	public void setFriendId(int friendId) {
		this.friendId = friendId;
	}
	/**
	 * @return the userName
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the friendUserName
	 */
	public String getFriendUserName() {
		return friendUserName;
	}
	/**
	 * @param friendUserName the friendUserName to set
	 */
	public void setFriendUserName(String friendUserName) {
		this.friendUserName = friendUserName;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
		
}
