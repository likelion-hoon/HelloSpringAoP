package com.sk.test;

import java.util.Date;
import java.util.HashMap;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class LogAspect {
	
	HashMap<String,String> map = new HahshMap<String,String>(); 
	
	
	// dummy
	public Object logDummy(ProceedingJoinPoint jointPoint) throws Throwable {

		System.out.println("log:[" + new Date() + "] " + jointPoint.getSignature().getName());

		Object o = jointPoint.proceed();

		return o;
	}

	// test
	// 모든 리턴타입을 다 고려
	public Object logOnly(ProceedingJoinPoint jointPoint) throws Throwable {

		System.out.println("log:[" + new Date() + "] " + jointPoint.getSignature().getName());

		// 원래 함수를 실행 시키라는 뜻
		Object o = jointPoint.proceed();
		return o;
	}

	// get
	public Object log(ProceedingJoinPoint jointPoint) throws Throwable {

		long start = System.currentTimeMillis();
		String out = (String) jointPoint.proceed();
		long finish = System.currentTimeMillis();

		System.out.println(
				"log:[" + new Date() + "] " + jointPoint.getSignature().getName() + "  " + (finish - start) + "ms");

		return out;
	}

	public Object logDebug(ProceedingJoinPoint jointPoint) throws Throwable {

		System.out.println("log:[" + new Date() + "] " + jointPoint.getSignature().getName());

		Object o = jointPoint.proceed(); // o에는 현재 시간이 리턴됨

		return "hello";  // 리턴값을 가로챈다.
	}
	
	public void logBefore(JoinPoint jointPoint) {
		
		
		/*
		 * 추가 코딩 힌트!!
		 * 
		 * int i=0; 
		String str = map.get(jointPoint.getSignature().getName());
	    map.put(str,++i);*/
	      
		System.out.println("before " + jointPoint.getSignature().getName());
	}
	
	public long logLong(ProceedingJoinPoint jointPoint) throws Throwable {

		long start = System.currentTimeMillis();
		Long out = (Long) jointPoint.proceed(); // fibo함수와 fiboHash를 호출한다.
		long finish = System.currentTimeMillis();

		System.out.print(
				"log:[" + new Date() + "] " + jointPoint.getSignature().getName() + "  " + (finish - start) + "ms  ");

		return out;
	}
	
	
	
}
