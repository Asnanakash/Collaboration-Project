package com.coll.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.dao.BlogDAO;
import com.coll.model.Blog;



public class BlogDAOTestCase 
{
   static BlogDAO blogDAO;
   
   @BeforeClass
   public static void initialize()
   {
	   AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.coll");
		context.refresh();
		blogDAO=(BlogDAO)context.getBean("blogDAO");
		
   }
   
  @Ignore
   @Test
   public void addBlogTest()
   {
	   Blog blog=new Blog();
	  
	   blog.setBlogName("Core Java");
	   blog.setBlogContent("Learning  core java Programming");
	   blog.setCreateDate(new java.util.Date());
	   blog.setLikes(0);
	   blog.setDislikes(0);
	   blog.setStatus("NA");
	   blog.setUsername("Izhaan");
	   
	   assertTrue("Problem in Adding the Blog",blogDAO.addBlog(blog));
   }
 @Ignore
   @Test
   public void updateBlogTest()
   {
	   Blog blog=blogDAO.getBlog(1081);
	   blog.setUsername("Izhaan");
	   assertTrue("Problem in Updating the Blog",blogDAO.updateBlog(blog));
   }
 @Ignore
   
   @Test
   public void deleteBlogTest()
   {
	   Blog blog=blogDAO.getBlog(1081);
	   assertTrue("Problem in Deleting the Blog",blogDAO.deleteBlog(blog));
   }
@Ignore
   @Test
   public void listBlogTestCase()
   {
	   List<Blog> listBlogs=blogDAO.getAllBlogs();
	   assertTrue("Problem in Listing Blog",listBlogs.size()>0);
	   for(Blog blog:listBlogs)
	   {
		  
		   System.out.println(blog.getBlogId()+"\t");
		   System.out.println(blog.getBlogName()+"\t");
		   System.out.println(blog.getBlogContent()+"\t");
		   System.out.println(blog.getStatus());
	   }
   }
     
    @Ignore
    @Test
    public void approveBlogTest()
    {
    	Blog blog=blogDAO.getBlog(952);
    	assertTrue("Problem in Approving the Blog",blogDAO.approveBlog(blog));
    }
    @Ignore
    @Test
    public void rejectBlogTest()
    {
    	Blog blog=blogDAO.getBlog(952);
    	assertTrue("Problem in rejecting the Blog",blogDAO.rejectBlog(blog));
    }
   @Ignore
    @Test
    public void incrementLikesTest()
    {
    	Blog blog=blogDAO.getBlog(952);
    	assertTrue("Problem in Increment Likes:",blogDAO.incrimentLikes(blog));
    }
    @Ignore
    @Test
    public void incrementDisLikesTest()
    {
    	Blog blog=blogDAO.getBlog(953);
    	assertTrue("Problem in Increment Likes:",blogDAO.incrimentDisLikes(blog));
    }

   
}
