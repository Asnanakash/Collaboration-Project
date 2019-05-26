package com.coll.dao;

import java.util.List;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.coll.model.BlogComment;
import com.coll.dao.BlogCommentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository("blogCommentDAO")
@Transactional
public class BlogCommentImpl implements BlogCommentDAO
{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addBlogComment(BlogComment blogComment) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(blogComment);
			return true;
		} 
		catch (Exception e)
		{
			return false;
		}
	}

/*	@Override
	public boolean editComment(BlogComment blogComment) {
		try {
			sessionFactory.getCurrentSession().update(blogComment);
			return true;
		} catch (Exception e) {
			return false;
		}
	}*/

	@Override
	public boolean deleteBlogComment(BlogComment blogComment)
	{
		try {
			sessionFactory.getCurrentSession().delete(blogComment);
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}

	@Override
	public List<BlogComment> listBlogComment(int blogId)
	{
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from BlogComment where blogId=:myBlogId");
		query.setParameter("myBlogId",blogId);
        List<BlogComment> listComment=(List<BlogComment>)query.list();
		session.close();
		return listComment;
	}

	@Override

	public BlogComment getBlogComment(int blogId) 
	{
		Session session = sessionFactory.openSession();
		BlogComment blogComment = session.get(BlogComment.class, blogId);
		session.close();
		return blogComment;
	}


}

