/*package com.coll.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import java.util.List;
import com.coll.dao.JobDAO;
import com.coll.model.Job;

public class JobDAOTestCase
{

	static JobDAO jobDAO;
	   
	   @BeforeClass
	   public static void initialize()
	   {
		   AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
			context.scan("com.coll");
			context.refresh();
			jobDAO=(JobDAO)context.getBean("jobDAO");
			
	   }
	   @Ignore
	   @Test
	   public void addJobTest()
	   {
		   Job job=new Job();
		   job.setDesignation("PYTHON Programmer");
		   job.setJobDesc("freshers Recruitment WALK IN");
		   job.setQualification("Btech or any Science Related Dergree");
		   job.setStatus("A");
		   job.setLastDate(new java.util.Date());
		   assertTrue("Problem in Adding the job",jobDAO.addJob(job));
	   }
	   
	 
	 
      @Test
      public void listJobTestCase()
      {
    	  List<Job> listJobs=jobDAO.getJobDetails();
    	  assertTrue("Problem in Listing Job",listJobs.size()>0);
    	  
    	  for(Job job:listJobs)
    	  {
    		  System.out.print(job.getJobId()+"::");
    		  System.out.print(job.getDesignation()+"::");
    		  System.out.print(job.getJobDesc());
    	  }
      }
}
*/