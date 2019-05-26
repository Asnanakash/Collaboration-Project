package com.coll.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coll.model.BlogComment;
import com.coll.model.ForumComment;
@Repository("forumCommentDAO")
@Transactional

public class ForumCommentDAOImpl implements ForumCommentDAO
{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addComment(ForumComment forumComment)
	{
		try
		{
			sessionFactory.getCurrentSession().save(forumComment);
			return true;
		} 
		catch (Exception e)
		{
			return false;
		}
	}
	@Override
	public boolean editComment(ForumComment forumComment)
	{
		try
		{
			sessionFactory.getCurrentSession().update(forumComment);
			return true;
		} 
		catch (Exception e)
		{
			return false;
		}
		
	}
	@Override
	public boolean deleteComment(ForumComment forumComment)
	{
		try
		{
			sessionFactory.getCurrentSession().delete(forumComment);
			return true;
		} 
		catch (Exception e)
		{
			return false;
		}
	}
	@Override
	public List<ForumComment> getCommentList()
	{
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from ForumComment");
		List<ForumComment> forumCommentList = query.list();
		session.close();
		return forumCommentList;
	}
	
	@Override
	public ForumComment getForumComment(int Id)
	{
		Session session = sessionFactory.openSession();
		ForumComment forumComment = session.get(ForumComment.class,Id);
		session.close();
		return forumComment;
	}


}
