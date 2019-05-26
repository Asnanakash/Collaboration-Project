package com.coll.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coll.dao.BlogCommentDAO;
import com.coll.model.Blog;
import com.coll.model.BlogComment;

@RestController
public class BlogCommentController 
{
	@Autowired
	BlogCommentDAO blogCommentDAO;
	
	@PostMapping("/addBlogComment")
	public ResponseEntity<String> addBlogComment(@RequestBody BlogComment blogComment)
	{
		blogComment.setCommentdate(new java.util.Date());
		
		if(blogCommentDAO.addBlogComment(blogComment))
		{
			return new ResponseEntity<String>("Success",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Failure",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	@GetMapping(value="/deleteBlogComment/{blogId}")
	public ResponseEntity<String> deleteBlogComment(@PathVariable("blogId")int blogId)
	{
		BlogComment blogComment=blogCommentDAO.getBlogComment(blogId);
		
		if(blogCommentDAO.deleteBlogComment(blogComment))
		{
			return new ResponseEntity<String>("Successful",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getBlogComments/{blogId}")
	public ResponseEntity<List<BlogComment>> listBlogComments(@PathVariable("blogId")int blogId)
	{
		List<BlogComment> listComments=blogCommentDAO.listBlogComment(blogId);
		if(listComments.size()>0)
		{
			return new ResponseEntity<List<BlogComment>>(listComments,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<BlogComment>>(listComments,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	/*@GetMapping(value="/getBlogComments/{blogId}")
	public ResponseEntity<BlogComment> getBlogComments(@PathVariable("blogId")int blogId)
	{
		BlogComment blogComment=blogCommentDAO.getBlogComment(blogId);
		if(blogComment!=null)
		{
			return new ResponseEntity<BlogComment>(blogComment,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<BlogComment>(blogComment,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}*/
}




