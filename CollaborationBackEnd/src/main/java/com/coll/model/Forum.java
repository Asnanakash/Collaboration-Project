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
@SequenceGenerator(name="forumidseq", sequenceName="forumseq",allocationSize=1)
public class Forum
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="forumidseq")
	
	int forumId;
	String forumName;
	String forumContent;
	int userId;
	Date createdate;
	String status;
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
	 * @return the forumName
	 */
	public String getForumName() {
		return forumName;
	}
	/**
	 * @param forumName the forumName to set
	 */
	public void setForumName(String forumName) {
		this.forumName = forumName;
	}
	/**
	 * @return the forumContent
	 */
	public String getForumContent() {
		return forumContent;
	}
	/**
	 * @param forumContent the forumContent to set
	 */
	public void setForumContent(String forumContent) {
		this.forumContent = forumContent;
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
	 * @return the createdate
	 */
	public Date getCreatedate() {
		return createdate;
	}
	/**
	 * @param createdate the createdate to set
	 */
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
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
