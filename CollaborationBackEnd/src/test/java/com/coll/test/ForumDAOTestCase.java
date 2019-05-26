package com.coll.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.dao.ForumDAO;
import com.coll.model.Forum;

public class ForumDAOTestCase
{

	static ForumDAO forumDAO;
	 @BeforeClass
	   public static void initialize()
	   {
		   AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
			context.scan("com.coll");
			context.refresh();
			forumDAO=(ForumDAO)context.getBean("forumDAO");
			
	   }
	 
	 @Ignore
	@Test
	public void addForumTest()
	{
		Forum forum=new Forum();
		forum.setForumName("Webdevelopers");
		forum.setForumContent("Php Programmer Forum");
		forum.setCreatedate(new java.util.Date());
		forum.setStatus("N");
		forum.setUserId(25);
		assertTrue("Problem in Adding the Forum",forumDAO.addForum(forum));	
	}
	 
	 @Ignore

	 public void deleteTest()
	 {
		 Forum forum=forumDAO.getForum(1002);
		 assertTrue("Problem in Deletig the Forum",forumDAO.deleteForum(forum));
		 
	 }
	 @Ignore
	@Test
	public void updateTest()
	{
		Forum forum=forumDAO.getForum(1003);
		forum.setForumName("Programmer");
		assertTrue("Problem in Updating Forum",forumDAO.updateForum(forum));
	}
	 
	 @Ignore
	 @Test
	 public void approveForumTest()
	 {
		 Forum forum=forumDAO.getForum(1003);
		 forum.setStatus("A");
		 assertTrue("Problem in approviing Forum",forumDAO.approveForum(forum));
	 }
	 @Ignore
	 @Test
	 public void rejectForumTest()
	 {
		 Forum forum=forumDAO.getForum(1003);
		 forum.setStatus("NA");
		 assertTrue("Problem in Rejecting Forum",forumDAO.rejectForum(forum));
		 
	 }
	 @Ignore
	 @Test
	   public void listForumTestCase()
	   {
		   List<Forum> listForums=forumDAO.getAllForums();
		   assertTrue("Problem in Listing Forum",listForums.size()>0);
		   for(Forum forum:listForums)
		   {
			  
			   System.out.println(forum.getForumId()+"\t");
			   System.out.println(forum.getForumName()+"\t");
			   System.out.println(forum.getForumContent()+"\t");
			   System.out.println(forum.getStatus());
		   }
	   }
	 

}
