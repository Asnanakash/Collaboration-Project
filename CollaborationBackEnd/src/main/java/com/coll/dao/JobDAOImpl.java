package com.coll.dao;

import com.coll.model.Blog;
import com.coll.model.Job;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coll.dao.JobDAO;
@Repository("jobDAO")
@Transactional
public class JobDAOImpl implements JobDAO 
{
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean addJob(Job job)
	{
		try
		{
			sessionFactory.getCurrentSession().save(job);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:addJobDetail");
		return false;
	}
	}
	@Override
	public boolean updateJob(Job job)
	{
		try
		{
			sessionFactory.getCurrentSession().update(job);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:updateJobDetail");
		return false;
	}
	}
	public boolean deleteJob(Job job)
	{
	try
	{
		sessionFactory.getCurrentSession().delete(job);
		return true;
	}
	catch(Exception e)
	{
		System.out.println("Exception Arised:addJobDetail");
	return false;
	}
	}
	
	public Job getJob(int jobId)
	{
		Session session=sessionFactory.openSession();
		Job job=session.get(Job.class,jobId);
		session.close();
		
		return job;
	}
	public List<Job> getJobDetails()
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Job");
		List<Job> listJob=query.list();
		session.close();
		return listJob;
	}


}
