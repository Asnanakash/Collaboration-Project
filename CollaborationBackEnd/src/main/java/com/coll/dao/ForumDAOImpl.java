/*package com.coll.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.coll.dao.ForumDAO;
import com.coll.model.Forum;
@Repository("forumDAO")
@Transactional
public class ForumDAOImpl implements ForumDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	@Override

	public boolean addForum(Forum forum)
	{
		try
		{
			sessionFactory.getCurrentSession().save(forum);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:Adding Forum"+e);
			return false;
		}
	}
	public boolean deleteForum(Forum forum)
	{
		try
		{
			sessionFactory.getCurrentSession().remove(forum);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:Deleting Forum"+e);
			return false;
		}
	}
	public boolean updateForum(Forum forum)
	{
		try
		  {
			  sessionFactory.getCurrentSession().update(forum);
			  return true;
		  }
		  catch(Exception e)
		  {
			  System.out.println("Exception Arised:Updating Forum"+e);
			  return false;
		  }
		
	}
	public Forum getForum(int forumId)
	{
		Session session=sessionFactory.openSession();
		 Forum forum=session.get(Forum.class, forumId);
		 session.close();
		 return forum;
	}
	public List<Forum> getAllForums()
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Forum");
		@SuppressWarnings("unchecked")
		List<Forum> listBlog=(List<Forum>)query.list();
		session.close();
		return listBlog;
	}
	
	public boolean approveForum(Forum forum)
	{
		try
		   {
			forum.setStatus("A");
			   sessionFactory.getCurrentSession().update(forum);
			   return true;
		   }
		   catch(Exception e)
		   {
			   System.out.println("Exception Arised:Approve Forum:"+e);
			   return false;
		   }
		
	}
	
	public boolean rejectForum(Forum forum)
	{
		try
		  {
			forum.setStatus("NA");
			  sessionFactory.getCurrentSession().update(forum);
			  return true;
		  }
		  catch(Exception e)
		  {
			  System.out.println("Exception Arised:Reject Forum:"+e);
			  return false;
		  }
			  
		  }
	}


*/