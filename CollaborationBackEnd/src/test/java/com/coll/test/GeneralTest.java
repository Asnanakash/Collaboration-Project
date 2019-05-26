package com.coll.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class GeneralTest
{
	public static void main(String arg[])
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.scan("com.coll");
		
		context.refresh();
	}

}
