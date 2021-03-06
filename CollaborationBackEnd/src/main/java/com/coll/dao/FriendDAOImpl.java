package com.coll.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coll.dao.FriendDAO;
import com.coll.model.Friend;
import com.coll.model.UserDetail;
@Repository("friendDAO")
@Transactional
public class FriendDAOImpl implements FriendDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Friend> showFriendList(String username)
	{
	Session session=sessionFactory.openSession();
	Query query=session.createQuery("from Friend where (username=:uname or friendUserName=:frndusername) and status='A'");
	query.setParameter("uname", username);
	query.setParameter("frndusername",username);
	List<Friend> listFriends=(List<Friend>)query.list();
	session.close();
	return listFriends;
}
	
	@Override
	public List<Friend> showPendingFriendRequest(String username)
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Friend where (username=:uname or friendUserName=:frndusername) and status='P'");
		query.setParameter("uname", username);
		query.setParameter("frndusername",username);
		List<Friend> listFriends=(List<Friend>)query.list();
		session.close();
		return listFriends;
	}
	
	@Override
	public List<UserDetail> showSuggestedFriend(String username)
	{
		
		Session session=sessionFactory.openSession();
		Query sqlQuery=session.createSQLQuery("select username from UserDetail where username not in(select friendUserName from Friend where username='"+username+"') and username not in(select username from Friend where friendUserName='"+username+"' and status='A') and username!='"+username+"'");
		List<String> listUsers=(List<String>)sqlQuery.list();
	    ArrayList<UserDetail> listUserDetail=new ArrayList<UserDetail>();
	    int i=0;
	    while(i<listUsers.size())
	    {
	    	UserDetail userDetail=session.get(UserDetail.class, listUsers.get(i).toString());
	    	listUserDetail.add(userDetail);
	    	i++;
	    }
	    
	    session.close();
		return listUserDetail;
	}
	
	@Override
	public boolean sendFriendRequest(Friend friend)
	{
		try
		{
			friend.setStatus("P");
		    
			
			sessionFactory.getCurrentSession().save(friend);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	
	
	
	@Override
	public boolean acceptFriendRequest(int friendId)
	{
		try
		{
			Session session=sessionFactory.openSession();
			Friend friend=session.get(Friend.class,friendId);
			friend.setStatus("A");
			sessionFactory.getCurrentSession().update(friend);
			session.close();
			return true;
			
			
		}
		catch(Exception e)
		{
		return false;
		}
	}
	
	
	
	
	
	
	
	@Override
	public boolean deleteFriendRequest(int friendId)
	{
		try
		{
			Session session=sessionFactory.openSession();
			Friend friend=session.get(Friend.class,friendId);
			session.close();
			
			sessionFactory.getCurrentSession().delete(friend);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	
		
	}

