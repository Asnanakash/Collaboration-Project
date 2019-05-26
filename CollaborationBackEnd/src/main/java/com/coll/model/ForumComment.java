package com.coll.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
@SequenceGenerator(name="fcomentidseq", sequenceName="fcommentseq",allocationSize=1)
public class ForumComment 
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="fcomentidseq")
	int id;
	int forumId;
	String coment;
	Date commentDate;
	int userId;
	String userName;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the forumId
	 */
	public int getForumId() {
		return forumId;
	}
	/**
	 * @param forumId the forumId to set
	 */
	public void setForumId(int forumId) {
		this.forumId = forumId;
	}
	/**
	 * @return the coment
	 */
	public String getComent() {
		return coment;
	}
	/**
	 * @param coment the coment to set
	 */
	public void setComent(String coment) {
		this.coment = coment;
	}
	/**
	 * @return the commentDate
	 */
	public Date getCommentDate() {
		return commentDate;
	}
	/**
	 * @param commentDate the commentDate to set
	 */
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	

}
