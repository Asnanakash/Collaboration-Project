package com.coll.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coll.model.UserDetail;
import com.coll.dao.UserDAO;
@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean registerUser(UserDetail user)
	{
		try
		{
			sessionFactory.getCurrentSession().save(user);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:Adding User"+e);
			return false;
		}
	}
	
	@Override
	public boolean deleteUserDetail(UserDetail user)
	{
		try
		{
			sessionFactory.getCurrentSession().delete(user);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:Deleting User"+e);
			return false;
		}
		
	}
	
	@Override
	public boolean updateUserDetail(UserDetail user)
	{
		try
		{
			sessionFactory.getCurrentSession().update(user);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:Updating User"+e);
			return false;
		}
	}
	
	@Override
	public UserDetail getUser(String username)
	{
		Session session=sessionFactory.openSession();
		UserDetail user=session.get(UserDetail.class,username);
		session.close();
		return user;
	}
	
	@Override
	public boolean makeOffLine(UserDetail user)
	{
		try
		{
			user.setIsOnline("Of");
			sessionFactory.getCurrentSession().update(user);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:Make off line:"+e);
			return false;
		}
	}
	
	@Override
	public boolean makeOnLine(UserDetail user)
	{
		try
		{
			user.setIsOnline("On");
			sessionFactory.getCurrentSession().update(user);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:Make Online:"+e);
			return false;
		}
	}
	
	@Override
	public boolean approveUser(UserDetail user)
	{
		try
		{
			user.setStatus("A");
			sessionFactory.getCurrentSession().update(user);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:Approve User:"+e);
			return false;
		}
	}
	
	@Override
	public boolean rejectUser(UserDetail user)
	{
		try
		{
			user.setStatus("R");
			sessionFactory.getCurrentSession().update(user);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:Reject User:"+e);
			return false;
		}
	}
}
