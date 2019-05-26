package com.coll.dao;

import java.util.List;

import com.coll.model.BlogComment;

public interface BlogCommentDAO 
{
	public boolean addBlogComment(BlogComment comment);
	public boolean deleteBlogComment(BlogComment comment);
	public List<BlogComment> listBlogComment(int blogId);
	public BlogComment getBlogComment(int blogId);
}
