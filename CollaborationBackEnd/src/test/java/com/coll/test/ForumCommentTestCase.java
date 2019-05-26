package com.coll.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.dao.ForumCommentDAO;
import com.coll.model.BlogComment;
import com.coll.model.ForumComment;

public class ForumCommentTestCase {

	static ForumCommentDAO forumCommentDAO;
	   
	   @BeforeClass
	   public static void initialize()
	   {
		   AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
			context.scan("com.coll");
			context.refresh();
			forumCommentDAO=(ForumCommentDAO)context.getBean("forumCommentDAO");
			
	   }
	   @Ignore
	   @Test
		public void addForumCommentTest() 
	   {
		   ForumComment forumComment = new ForumComment();
		   forumComment.setForumId(102);
		   forumComment.setUserId(52);
		   forumComment.setComent("first comment");
		   forumComment.setUserName("Asma");
		   forumComment.setCommentDate(new java.util.Date());
			assertTrue("Problem adding forum comment", forumCommentDAO.addComment(forumComment));
		}
		
	   @Ignore
		@Test
		public void deleteForumCommentTest() 
		{
			ForumComment forumComment = forumCommentDAO.getForumComment(0);
			assertTrue("Problem deleting forum comment", forumCommentDAO.deleteComment(forumComment));
		}
	   
	   @Ignore
		@Test
		public void editForumCommentTest() 
	   {
		   ForumComment forumComment = forumCommentDAO.getForumComment(0);
		   forumComment.setComent("Second Forum Comment");
			assertTrue("Problem editing forum comment", forumCommentDAO.editComment(forumComment));
		}
		
		@Ignore
		@Test
		public void listForumCommentsTest() 
		{
			List<ForumComment> forumCommentList = forumCommentDAO.getCommentList();
			for(ForumComment fc : forumCommentList)
			{
				System.out.print("\n"+fc.getId()+"\t");
				System.out.println(fc.getComent());
			}
		}
	
	
}
