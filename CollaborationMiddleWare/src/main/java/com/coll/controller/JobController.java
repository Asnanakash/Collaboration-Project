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

import com.coll.dao.JobDAO;
import com.coll.model.Job;


@RestController
public class JobController
{
	@Autowired
	JobDAO jobDAO;
	
	@PostMapping(value="/addJob")
	public ResponseEntity<String> addJobDetail(@RequestBody Job job)
	{
		
		if(jobDAO.addJob(job))
				{
			return new ResponseEntity<String>("Success",HttpStatus.OK);
				}
		else
		{
			return new ResponseEntity<String>("Failure",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(value="/updateJob")
	public ResponseEntity<String> updateJobDetail(@RequestBody Job job)
	{
		if(jobDAO.updateJob(job))
				{
			return new ResponseEntity<String>("Success",HttpStatus.OK);
				}
		else
		{
			return new ResponseEntity<String>("Failure",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/deleteJob/{jobId}")
	public ResponseEntity<String> deleteJobDetail(@PathVariable("jobId")int jobId)
	{
		Job job=jobDAO.getJob(jobId);
		
		if(jobDAO.deleteJob(job))
		{
			return new ResponseEntity<String>("Success",HttpStatus.OK);
			
		}
		else
		{
			return new ResponseEntity<String>("Failure",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/getJob/{jobId}")
	public ResponseEntity<Job> getAJob(@PathVariable("jobId") int jobId)
	{
		Job job=jobDAO.getJob(jobId);
		
		if(job!=null)
		{
			return new ResponseEntity<Job>(job,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Job>(job,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping(value="/getJobDetails")
	public ResponseEntity<List<Job>> getJobDetails()
	{
		List<Job> listJobs=jobDAO.getJobDetails();
		
		return new ResponseEntity<List<Job>>(listJobs,HttpStatus.OK);
		
	}
}
