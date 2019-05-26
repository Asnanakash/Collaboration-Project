package com.coll.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.dao.BlogCommentDAO;
import com.coll.model.BlogComment;
public class BlogCommentDAOTestCase 
{

	static BlogCommentDAO blogCommentDAO;
	   
	   @BeforeClass
	   public static void initialize()
	   {
		   AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
			context.scan("com.coll");
			context.refresh();
			blogCommentDAO=(BlogCommentDAO)context.getBean("blogCommentDAO");
			
	   }
	   @Ignore
	   @Test
		public void addBlogCommentTest() 
	   {
			BlogComment blogComment = new BlogComment();
			blogComment.setBlogId(1121);
			blogComment.setCommentdate(new java.util.Date());
			blogComment.setBlogComment("Please details");
			blogComment.setUserId(331);
			blogComment.setUserName("asna");
			assertTrue("Problem adding blog comment", blogCommentDAO.addBlogComment(blogComment));
		}
		
	   /*@Ignore
		@Test
		public void deleteBlogCommentTest() 
		{
			BlogComment blogComment = blogCommentDAO.getBlogComment(10003);
			assertTrue("Problem deleting blog comment", blogCommentDAO.deleteComment(blogComment));
		}
		
	   @Ignore
		@Test
		public void editBlogCommentTest() {
			BlogComment blogComment = blogCommentDAO.g(12222);
			blogComment.setBlogComment("Edited comment");
			assertTrue("Problem editing blog comment", blogCommentDAO.editComment(blogComment));
		}*/
		
		@Ignore
		@Test
		public void listBlogCommentsTest() 
		{
			List<BlogComment> listBlogComment = blogCommentDAO.listBlogComment(1110);
			assertTrue("Problem in listing blog",listBlogComment.size()>0);
			for(BlogComment bc : listBlogComment)
			{
				System.out.print("\n"+bc.getId()+"\t");
				System.out.print("\n"+bc.getBlogId()+"\t");
				System.out.print("\n"+bc.getUserName()+"\t");
				System.out.println(bc.getBlogComment());
			}
		}
	}
