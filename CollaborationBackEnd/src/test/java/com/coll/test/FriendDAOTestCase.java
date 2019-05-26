package com.coll.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.dao.FriendDAO;
import com.coll.model.Blog;
import com.coll.model.Friend;
import com.coll.model.UserDetail;

public class FriendDAOTestCase 
{

	static FriendDAO friendDAO;
	@BeforeClass
	   public static void initialize()
	   {
		   AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
			context.scan("com.coll");
			context.refresh();
			friendDAO=(FriendDAO)context.getBean("friendDAO");
			
	   }
	
	@Ignore
	@Test
	   public void sendFriendRequest()
	   {
		   Friend friend=new Friend();
		  friend.setUsername("asna");
		  friend.setFriendUserName("Achu");
		   assertTrue("Problem in Sending Friend Request",friendDAO.sendFriendRequest(friend));
	   }
	
	@Ignore
	@Test
	public void acceptFriendRequest()
	{
		assertTrue("Problem in Accepting Friend Request:::",friendDAO.acceptFriendRequest(4050));
	}
	
	
	@Test
	public void deleteFriendRequest()
	{
		assertTrue("Problem in Accepting Friend Request:::",friendDAO.deleteFriendRequest(4114));
	}
	@Ignore
	@Test
	public void showFriendListTest()
	{
		List<Friend> friendList=friendDAO.showFriendList("asna");
		assertTrue("Problem in showing Friend List",friendList.size()>0);
		
		System.out.println("==========================Displaying Friend List=========================");
		System.out.println("             USER NAME                        FRIEND NAME                 ");
		System.out.println("=================================================================================");
		
		for(Friend friend:friendList)
		{
			System.out.println("                 "+friend.getUsername()+"                            "+friend.getFriendUserName());
			
		}
	}
	
	@Ignore
	@Test
	public void showPendingFriendRequest()
	{
		List<Friend> friendList=friendDAO.showPendingFriendRequest("asna");
		assertTrue("Problem in showing Friend List",friendList.size()>0);
		
		System.out.println("==========================Displaying Pending Friend List=========================");
		System.out.println("             USER NAME                        FRIEND NAME                 ");
		System.out.println("=================================================================================");
		
		for(Friend friend:friendList)
		{
			System.out.println("                 "+friend.getUsername()+"                            "+friend.getFriendUserName());
			
		}
		
		
	}
	@Ignore
	@Test
	public void ShowFriendSuggestionList()
	{
		List<UserDetail> userDetailList=friendDAO.showSuggestedFriend("Shalu");
		assertTrue("Problem in Showing Suggestion Friend:",userDetailList.size()>0);
		
		System.out.println("=======Displaying Friend Suggestion======");
		
		for(UserDetail userDetail:userDetailList)
		{
			System.out.println(userDetail.getUsername()+"---------");
			System.out.println(userDetail.getCustomerName());
		}
	}
	
	}
