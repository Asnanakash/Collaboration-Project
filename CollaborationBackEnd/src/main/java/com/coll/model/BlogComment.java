package com.coll.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table
@SequenceGenerator(name="commentidseq", sequenceName="blogcommentseq",allocationSize=1)
public class BlogComment 
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="commentidseq")
	int id;
	int blogId;
	String blogComment;
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd-MM-yyyy")
	Date commentdate;
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
	 * @return the blogId
	 */
	public int getBlogId() {
		return blogId;
	}
	/**
	 * @param blogId the blogId to set
	 */
	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}
	/**
	 * @return the blogComment
	 */
	public String getBlogComment() {
		return blogComment;
	}
	/**
	 * @param blogComment the blogComment to set
	 */
	public void setBlogComment(String blogComment) {
		this.blogComment = blogComment;
	}
	/**
	 * @return the commentdate
	 */
	public Date getCommentdate() {
		return commentdate;
	}
	/**
	 * @param commentdate the commentdate to set
	 */
	public void setCommentdate(Date commentdate) {
		this.commentdate = commentdate;
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