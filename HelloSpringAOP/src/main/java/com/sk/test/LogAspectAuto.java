package com.sk.test;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogAspectAuto {
	@Pointcut("execution(public * com.sk.test..*(..))")
	
	private void publicTarget() {
		
	};
	
	@Before("publicTarget()")
	public void logBefore(JoinPoint jointPoint) {
		System.out.println("before" + 
	jointPoint.getSignature().getName()); 
	}
	
	@Around("publicTarget()")
	public Object log(ProceedingJoinPoint jointPoint) throws Throwable {
		
		long start = System.currentTimeMillis(); 
		String out = (String) jointPoint.proceed(); 
		long finish = System.currentTimeMillis(); 
		
		System.out.println(
				"log:[" + new Date() + "] " + jointPoint.getSignature().getName() + "  " + (finish - start) + "ms");
		return out;
	}
	
}
