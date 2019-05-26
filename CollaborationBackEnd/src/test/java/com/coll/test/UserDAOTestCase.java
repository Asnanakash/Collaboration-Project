package com.coll.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.dao.UserDAO;
import com.coll.model.UserDetail;

public class UserDAOTestCase
{
	
static UserDAO userDAO;
@BeforeClass
public static void initialize()
{
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	context.scan("com.coll");
	context.refresh();
	
	userDAO=(UserDAO)context.getBean("userDAO");
}
@Ignore
@Test
public void registerUserTestCase()
{
	UserDetail user=new UserDetail();
	
	user.setCustomerName("Asma");
	user.setUsername("user");
	user.setPassword("password");
	user.setEmailId("asma@gmail.com");
	user.setIsOnline("On");
	user.setRole("Student");
    user.setStatus("A");
	
	 assertTrue("Problem in User Registering:",userDAO.registerUser(user));
}
@Ignore
@Test
public void updateUserDetail()
{
	UserDetail user=userDAO.getUser("user");
	user.setEmailId("AsmaRA@gmail.com");
	assertTrue("Problem in Updating",userDAO.updateUserDetail(user));
}
@Ignore
@Test
public void makeOffLineTest()
{
	UserDetail user=userDAO.getUser("user");
	assertTrue("Problem in Updating:",userDAO.makeOffLine(user));
}
@Ignore
@Test
public void makeOnLineTest()
{
	UserDetail user=userDAO.getUser("user");
	assertTrue("Problem in Updating:",userDAO.makeOnLine(user));
}
@Ignore
@Test
public void rejectUserTest()
{
	UserDetail user=userDAO.getUser("user");
	assertTrue("Problem in Rejecting:",userDAO.rejectUser(user));
}

@Test
public void approveUserTest()
{
	UserDetail user=userDAO.getUser("asna");
	assertTrue("Problem in Approving:",userDAO.approveUser(user));
}

}
