package com.coll.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



import com.coll.dao.UserDAO;
import com.coll.model.UserDetail;



@RestController
public class UserController
{
	@Autowired
	UserDAO userDAO;
	
	@PostMapping(value="/registerUser")
	public ResponseEntity<String>registerUser(@RequestBody UserDetail user)
	{
		if(userDAO.registerUser(user))
		{
			return new ResponseEntity<String>("Successful",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value = "/deleteUser/{username}")
	public ResponseEntity<String> deleteUser(@PathVariable("username") String username)
	{
		UserDetail user = userDAO.getUser(username);
		if (userDAO.deleteUserDetail(user)) 
		{
			return new ResponseEntity<String>("Successfull", HttpStatus.OK);
		} 
		else 
		{
			return new ResponseEntity<String>("Unsuccessfull", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	@PostMapping(value = "/checkLogin")
	public ResponseEntity<UserDetail> checkLogin(@RequestBody UserDetail user,HttpSession session) 
	{
		UserDetail tempUser = userDAO.getUser(user.getUsername());
		
		if (tempUser != null) 
		{
			if (tempUser.getPassword().equals(user.getPassword()))
			{
				session.setAttribute("UserDetail",tempUser);
				return new ResponseEntity<UserDetail>(tempUser,HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<UserDetail>(tempUser, HttpStatus.INTERNAL_SERVER_ERROR);
		
			}
		}
		
		else
		{
			return new ResponseEntity<UserDetail>(tempUser,HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	
	
	@GetMapping(value = "/getUser/{username}")
	public ResponseEntity<UserDetail> getUser(@PathVariable("username") String username) {
		UserDetail user = userDAO.getUser(username);
		if (user != null)
			return new ResponseEntity<UserDetail>(user, HttpStatus.OK);
		else
			return new ResponseEntity<UserDetail>(user, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PostMapping(value="/updateUser")
	public ResponseEntity<String> updateUser(@RequestBody UserDetail user)
	{
		if(userDAO.updateUserDetail(user))
		{
			return new ResponseEntity<String>("Successful",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@GetMapping(value="/approveUser/{username}")
	public ResponseEntity<String>approveUser(@PathVariable("username")String username)
	{
		UserDetail user=userDAO.getUser(username);
		
		if(userDAO.approveUser(user))
		{
			return new ResponseEntity<String>("Successful",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/rejectUser/{username}")
	public ResponseEntity<String>rejectUser(@PathVariable("username")String username)
	{
		UserDetail user=userDAO.getUser(username);
		
		if(userDAO.rejectUser(user))
		{
			return new ResponseEntity<String>("Successful",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
