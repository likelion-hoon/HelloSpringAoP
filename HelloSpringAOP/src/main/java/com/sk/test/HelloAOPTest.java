package com.sk.test;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloAOPTest {

	public static void main(String[] args) {
	
	/*	Message m = new Message(); 
		
		String n1 = m.getNews(); 
		
		System.out.println("1." + n1);
		
		String f1 = m.getFile("aaa.zip"); 
		System.out.println("response " + f1);
		
		n1 = m.getNews(); 
		System.out.println("2." + n1);
		
		f1 = m.getFile("bbb.zip"); 
		System.out.println("response  " + f1);*/
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("aspectauto.xml"); 
		Message svr = (Message)ctx.getBean("svr"); 
		String out = svr.getNews();
		svr.getFile("aaa.zip"); 
		svr.test123(); 
		svr.dummy123(); 
		svr.debug123(); 
		svr.before123();
		
		//System.out.println(svr.debug123());
		
		//System.out.println(out);
	}

}
