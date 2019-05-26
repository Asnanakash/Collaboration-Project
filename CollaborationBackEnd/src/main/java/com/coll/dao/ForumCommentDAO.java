package com.coll.dao;

import java.util.List;

import com.coll.model.ForumComment;

public interface ForumCommentDAO 
{
	public ForumComment getForumComment(int Id);
	public boolean addComment(ForumComment forumComment);
	public boolean editComment(ForumComment forumComment);
	public boolean deleteComment(ForumComment forumComment);
	public List<ForumComment> getCommentList();

}
