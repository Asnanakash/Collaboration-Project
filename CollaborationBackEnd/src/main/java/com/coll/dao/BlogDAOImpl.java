package com.coll.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.coll.dao.BlogDAO;
import com.coll.model.Blog;
@Repository("blogDAO")
@Transactional
public class BlogDAOImpl implements BlogDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean addBlog(Blog blog)
	{
		try
		{
			sessionFactory.getCurrentSession().save(blog);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:Adding Blog"+e);
			return false;
		}
	}

	@Override
	public boolean deleteBlog(Blog blog)
	{
		try
		{
			sessionFactory.getCurrentSession().remove(blog);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:Deleting Blog"+e);
			return false;
		}
	}
	
	
	@Override
	public boolean updateBlog(Blog blog)
	{
	  try
	  {
		  sessionFactory.getCurrentSession().update(blog);
		  return true;
	  }
	  catch(Exception e)
	  {
		  System.out.println("Exception Arised:Updating Blog"+e);
		  return false;
	  }
	}
	
	@Override
	public Blog getBlog(int blogId) 
	{
	 Session session=sessionFactory.openSession();
	 Blog blog=session.get(Blog.class, blogId);
	 session.close();
	 return blog;
	}
	
	
	
	@Override
	public List<Blog> getAllBlogs() 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Blog");
		@SuppressWarnings("unchecked")
		List<Blog> listBlog=(List<Blog>)query.list();
		session.close();
		return listBlog;
	}
	
	
	@Override
	public boolean incrimentLikes(Blog blog) 
	{   
		try
	{
		blog.setLikes(blog.getLikes()+1);
		sessionFactory.getCurrentSession().update(blog);
		return true;
	}
	catch(Exception e)
	{
		System.out.println("Exception Arised:Increment Likes:"+e);
		return false;
	}
	
	}
	@Override
	public boolean incrimentDisLikes(Blog blog)
	{
		try
		{
			blog.setDislikes(blog.getDislikes()+1);
			sessionFactory.getCurrentSession().update(blog);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:Increment DisLike:"+e);
			return false;
		}
	}
	
	@Override
	public boolean approveBlog(Blog blog) 
	{
	   try
	   {
		   blog.setStatus("A");
		   sessionFactory.getCurrentSession().update(blog);
		   return true;
	   }
	   catch(Exception e)
	   {
		   System.out.println("Exception Arised:Approve Blog:"+e);
		   return false;
	   }
	   
	}
	
	
	@Override
	public boolean rejectBlog(Blog blog) 
	{
	  try
	  {
		  blog.setStatus("NA");
		  sessionFactory.getCurrentSession().update(blog);
		  return true;
	  }
	  catch(Exception e)
	  {
		  System.out.println("Exception Arised:Reject Blog:"+e);
		  return false;
	  }
		  
	  }
}


	
	

